// ===========================================================
// NURDVision - FRC Team 3255 SuperNURD 2018 Vision Processing
// written by Mike and Tayler
// ===========================================================

#include <iostream>
#include <opencv2/opencv.hpp>
#include <networktables/NetworkTable.h>
#include <ntcore.h>
#include <cscore.h>
#include "config.h"
#include <stdio.h>
#include <cmath>

using namespace cs;

// ============== GLOBAL VARIABLES ============== //
// Initalizes targetDistance, targetAngle, and targetOffset to 0.0;
double targetDistance = 0.0;
double targetAngle = 0.0;
double widthAvg = 0.0;
double targetOffset = 0.0;
bool targetFound = false;
// Initalizes local, debug, and showRaw to false
bool local = false;
bool debug = false;
bool showRaw = false;
// ============================================== //

// Checks the parameters passed by the command line execution
void checkRunParameters(int argc, char *argv[]){
	if(argc >= 2){
		if(string(argv[1]) == "-local") local=true;
		if(string(argv[1]) == "-debug") debug=true;
	}
	if(argc >= 3){
		if(string(argv[2]) == "-local") local=true;
		if(string(argv[2]) == "-debug") debug=true;
	}
}

// ============== Filtering ============== //
// Structure for sorting bounding boxes in descending size order
struct {
	bool operator() (cv::Rect a, cv::Rect b) {
		return b.area() < a.area();
	}
} boundingBoxSortDescending;

// Converts image to hsl filter, filtering out any color besides green on the retroreflective tapes
void hslThreshold(Mat &input, Mat &output) {
  input.convertTo(input, -1, 1, -25);
	cvtColor(input, output, COLOR_BGR2HLS);
	inRange(output, Scalar(hue[0], luminance[0], saturation[0]), Scalar(hue[1], luminance[1], saturation[1]), output);
}

// Creates a workable mask to a mat, so we can process the hsl filter
void createMask(Mat &input, Mat &mask, Mat &output) {
	mask.convertTo(mask, CV_8UC1);
	bitwise_xor(output, output, output);
	input.copyTo(output, mask);
}

// Filters out contours 
void filterContours(vector<vector<Point> > &input, vector<vector<Point> > &output) {
	output.clear();
	for (vector<Point> contour : input) {
		Rect contourBounding = boundingRect(contour);
		if (contourBounding.width < contourWidth[0] || contourBounding.width > contourWidth[1]) continue;
		if (contourBounding.height < contourHieght[0] || contourBounding.height > contourHieght[1]) continue;
		if (contourArea(contour) < minContourArea) continue;
		if (arcLength(contour, true) < minContourArcLength) continue;
		output.push_back(contour);
 	}
}

// Creates contours and returns a vector of contour points
vector<vector<Point> > createContours(Mat &input){
	// Create new vectors for storing contour values
	vector<vector<Point> > contoursInput, contoursOutput;
	// Converts our hsl filter into black and white, because findContours requires you to be using black and white, not RGB or HSL	
	cvtColor(input, input, CV_RGB2GRAY);
	// Finds the contours of the image
	findContours(input, contoursInput, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE);
	// Filters out contours based on width, height, and area.
	filterContours(contoursInput, contoursOutput);
	return contoursOutput;
}


// ============== Filtering END ============== //


// ============== Targeting ============== //
// Finds Center point
Point2f centerPoint(Rect rect) {
	return Point2f(rect.x + (rect.width / 2), rect.y + (rect.height / 2));
}

// Shows crosshairs
void showCrosshairs(Mat &input){
	line(input, Point(input.cols / 2, 0), Point(input.cols / 2, input.rows), WHITE, 1);
	line(input, Point(0, input.rows / 2), Point(input.cols, input.rows / 2), WHITE, 1);
}

// Finds targets
void findTargets(Mat &imageInput, vector<vector<Point> > &input, Mat &joinedOutput){	
	// Readys Output mat for contour use
	joinedOutput = Mat::zeros(imageInput.size(), CV_8UC3);
	// Creates Vector of Bounding Boxes
	vector<Rect> boundingBoxes(input.size());
	
	// Finds all the targets
	for (int i = 0; i< input.size(); i++) {
		// Makes contours rectanges and stores rectangles into bounding box vector.
		boundingBoxes[i] = boundingRect(input[i]);
		// Draws contours onto output
		drawContours(joinedOutput, input, i, SKY_BLUE, 2);
	}	
	// If there are 2 or more targets found
	if (boundingBoxes.size() >= 2) {
		// Sort rectangles in descending order based on their area.
		sort(boundingBoxes.begin(), boundingBoxes.end(), boundingBoxSortDescending); 

		// Pick out two largest targets - these will most likely be what we're looking for.
		Rect target1 = boundingBoxes[0];
		Rect target2 = boundingBoxes[1];
		
		//Draws two rectanges onto output
		rectangle(joinedOutput, target1, GREEN, 2);
		rectangle(joinedOutput, target2, GREEN, 2);
		
		// Calculate center point of both targets
		Point2f centerPoint1 = centerPoint(target1);	
		Point2f centerPoint2 = centerPoint(target2);
		
		// Calculate mid points between centers of boundingBoxes
		Point2f midPoint((centerPoint1.x + centerPoint2.x) / 2, (centerPoint1.y + centerPoint2.y) / 2); 
		Point2f tl(midPoint.x - 2, midPoint.y - 2);	// Calculate top-left point of center dot
		Point2f tr(midPoint.x + 2, midPoint.y + 2); // Calculate bottom right point of center dot
		
		// Draw a line between center point of vision targets
		line(joinedOutput, centerPoint1, centerPoint2, RED, 1); 
		// Draw a point at center of line drawn above
		rectangle(joinedOutput, tl, tr, BLUE, 3);
		
		// Distance, angle, and offset calculation
		double target1Width = target1.width;
		double target2Width = target2.width;
		double target1Height = target1.height;
		double target2Height = target2.height;
		double target1Distance = 2*712/target1Width;
		double target2Distance = 2*712/target2Width;
		targetDistance = 2*712/((target1Width+target2Width)/2);
		double target1B = (centerPoint1.x - (imageInput.cols/2)) * 1/(target1Width/1);
		double target1C = target1Distance;
		double target1A = sqrt(abs(pow(target1C,2)-pow(target1B,2)));
		double target1Rads = atan(target1B/target1A);
		double target1Offset = 57.3 * target1Rads;
		if ((imageInput.cols/2)>centerPoint1.x){
			target1Offset = -target1Offset;

		}

        widthAvg = (target1Width+target2Width)/2;
        

		double target2B = (centerPoint1.x - (imageInput.cols/2)) * 1/(target1Width/1);
		double target2C = target2Distance;
		double target2A = sqrt(abs( pow(target2C,2) - pow(target2B,2) ));

		double target2Rads = atan(target2B/target2A);
		double target2Offset = 57.3 * target2Rads;
		if ((imageInput.cols/2)>centerPoint2.x){
			target2Offset = -target2Offset;

		}
		targetOffset = (target1Offset+target2Offset)/2;


		targetFound = true;
		cout << targetDistance << endl;
		if (centerPoint1.x > midPoint.x){
			targetAngle = target1Height - target2Height;	
	    }
		else{
			targetAngle = target2Height - target1Height;
		}

		// Put text on image (used for debugging)
		putText(joinedOutput, "Offset: "+ to_string(targetOffset), Point2f(30,2*15), cv::FONT_HERSHEY_PLAIN, 0.8, WHITE, 1);
		putText(joinedOutput, "Distance: "+ to_string(targetDistance), Point2f(30,3*15), FONT_HERSHEY_PLAIN, 0.8, WHITE, 1);
		
	}
	else {
		targetFound = false;
	}
}

// ============== Targeting END ============== //

// Processes the image and returns a processed image
Mat processImage(Mat &input){
	// Mats for processed outputs
	Mat hslOutput, maskOutput, targetsOutput;
  Mat joinedOutput;
	// Create a HSL Mask
	hslThreshold(input, hslOutput);

	createMask(input, hslOutput, maskOutput);


	auto contoursValueOutput = createContours(maskOutput);
	
  //cubeFindTargets(cubeMaskOutput, cubeContoursValueOutput, joinedOutput);
	findTargets(maskOutput, contoursValueOutput, joinedOutput);
	
	showCrosshairs(joinedOutput);
  
  return joinedOutput;
  }

// Publish Network Tables to table in use
void PublishNetworkTables(shared_ptr<NetworkTable> table) {
	table->PutNumber("Distance", targetDistance);
	table->PutNumber("Offset", targetOffset);
	table->PutBoolean("TargetFound", targetFound);
}

// Get values for configurable values from NetworkTables
void GetHSLValues(shared_ptr<NetworkTable> prefTable) {
	// HSL
	hue = prefTable->GetNumberArray("Hue", hue);
	saturation = prefTable->GetNumberArray("Saturation", saturation);
	luminance = prefTable->GetNumberArray("Luminance", luminance);
	
	showRaw = prefTable->GetBoolean("showRaw", showRawStream);
}

// Returns true to quit when "ESC" is pressed
bool quit(){
	char key = (char)waitKey(5);
	return( key == 27 || key == 'q' || key == 'Q' ); // key 27 = 'ESC'
}

// Displays welcome messages and debug info
void greetings(){
	cout << "\e[1mRunning \e[34mNURD\e[31mVision\e[0m \tFRCTeam 3255 SuperNURD 2018 Vision Processing\n" << 
		"\t\t\tCreated by Mike Smith & Tayler Uva\n\n";
	
	cout << "Debug: " << (debug ? "\e[32mtrue\e[0m" : "\e[31mfalse\e[0m") << endl;
	cout << "localhost: " << (local ? "\e[32mtrue\e[0m" : "\e[31mfalse\e[0m") << endl;
	cout << "Team Number: " << "\e[34m" << teamNumber << "\e[0m" << endl;
	cout << endl;
	
	cout << "\nSTARTING IMAGE PROCESSING\n" << endl;
		
	cout << "MJpeg stream available at port " << (streamPort) << endl;
		
	if(debug){
	cout << "\nVIEWER OPENED" << endl
		 << "Press ESC or Q to terminate\n" << endl;		
	}
}


int main(int argc, char *argv[]) {
						
	// Checks run arguments
	checkRunParameters(argc, argv);

	// Displays welcome messages and debug info
	greetings();
		
	// Initalizes camera stream
	CvSource stream = CvSource("stream", VideoMode::PixelFormat::kMJPEG, resolutionWidth, resolutionHeight, maxFrameRate);
	MjpegServer streamServer = MjpegServer("server", streamPort);
	streamServer.SetSource(stream);
	
	//Initalizes NetworkTables
	NetworkTable::SetClientMode();
	NetworkTable::SetTeam(teamNumber);
	NetworkTable::Initialize();
	auto visionTable = NetworkTable::GetTable("NURDVision");
		// If run argument -local is present, set ip address to localhost
		if(local) NetworkTable::SetIPAddress("localhost");

	// Creates mats for storing image
	Mat raw, processed;
	// Starts video capture of camera 0;
	VideoCapture capture(cameraInput);
	if (!capture.isOpened()) {
		cerr << "\n\e[31mERROR! Unable to open camera\nERROR! Is the camera connected?\e[0m\n";
		NetworkTable::Shutdown();
		return 1;
	}
	

	// numLoops = 0;
	// avgTime = 0;
	// While the quit function does not return true run image functions
	while (!quit()) {
		// priorTime = getTime()
		
		struct timespec start, finish;
		double elapsedTotal, elapsedCapture, elapsedProcessed, elapsedPutFrame;

		// TIME THE CAPTURE
		clock_gettime(CLOCK_MONOTONIC, &start);

		// Stores capture to raw mat
        capture >> raw;

		clock_gettime(CLOCK_MONOTONIC, &finish);

		elapsedCapture = (finish.tv_sec - start.tv_sec);
		elapsedCapture += (finish.tv_nsec - start.tv_nsec) / 1000000000.0;
		

		clock_gettime(CLOCK_MONOTONIC, &start);	

		// Runs image processing and stores to processed
		Mat hslOutput, maskOutput, targetsOutput;
	  	Mat joinedOutput;
		// Create a HSL Mask



		hslThreshold(raw, hslOutput);

		createMask(raw, hslOutput, maskOutput);


		auto contoursValueOutput = createContours(maskOutput);

		
	  //cubeFindTargets(cubeMaskOutput, cubeContoursValueOutput, joinedOutput);
		findTargets(maskOutput, contoursValueOutput, processed);
		
		showCrosshairs(processed);
		
		clock_gettime(CLOCK_MONOTONIC, &finish);
		elapsedProcessed = (finish.tv_sec - start.tv_sec);
		elapsedProcessed += (finish.tv_nsec - start.tv_nsec) / 1000000000.0;



		clock_gettime(CLOCK_MONOTONIC, &start);

		// Publishes Data to NetworkTable - Vision
		PublishNetworkTables(visionTable);
		
		// Gets array values for Hue Saturation and Luminance from NURDVision table
		GetHSLValues(visionTable);
		// Publishes processed image to stream (checks to see if asking for raw)
		(showRaw ? stream.PutFrame(raw) : stream.PutFrame(processed));

	
		// Runs if debug is true
		if(debug){
			// Display processed image
			// Output data to console
			cout << "Distance: "<< targetDistance << "\tAngle: " << targetAngle << "\tOffset: " << targetOffset <<  endl;
		}


		clock_gettime(CLOCK_MONOTONIC, &finish);
		elapsedPutFrame = (finish.tv_sec - start.tv_sec);
		elapsedPutFrame += (finish.tv_nsec - start.tv_nsec) / 1000000000.0;		

		elapsedTotal = elapsedCapture + elapsedProcessed + elapsedPutFrame;

		cout << "DISTANCE: " << targetDistance << " Total: " << elapsedTotal << " Elapsed Processed: " << elapsedProcessed << " elapsed capture: " << elapsedCapture << " elapsedPutFrame: " << elapsedPutFrame << endl;
	}
	NetworkTable::Shutdown();
	cout << "\nNURDVision stopped successfully\n";
	return 0;
}