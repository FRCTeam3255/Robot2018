// ===========================================================
// NURDVision - FRC Team 3255 SuperNURD 2018 Cube Detection
// written by Mike and Tayler
// ===========================================================
#include <iostream>
#include <opencv2/opencv.hpp>
#include <networktables/NetworkTable.h>
#include <ntcore.h>
#include <cscore.h>
#include "config.h"
#include <stdio.h>
using namespace cs;

// ============== GLOBAL VARIABLES ============== //
// Initalizes cubeDistance, cubeOffset, and Target Found
double cubeDistance = 0.0;
double cubeOffset = 0.0;
bool targetFound = false;

// Initalizes local, debug, and showRaw
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

// Filters image into HSL filter
void cubeHslThreshold(Mat &input, Mat &output) {
	cvtColor(input, output, COLOR_BGR2HLS);
	inRange(output, Scalar(cubeHue[0], cubeLuminance[0], cubeSaturation[0]), Scalar(cubeHue[1], cubeLuminance[1], cubeSaturation[1]), output);
}

// Masks the HSL Filter, getting rid of non Cube-Hue'd objects
void cubeCreateMask(Mat &input, Mat &mask, Mat &output) {
	mask.convertTo(mask, CV_8UC1);
	bitwise_xor(output, output, output);
	input.copyTo(output, mask);
}

//Filters Contours found by cubeCreateContours, currently not called
void cubeFilterContours(vector<vector<Point> > &input, vector<vector<Point> > &output) {
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

//Finds all current Contours in the image
vector<vector<Point> > cubeCreateContours(Mat &input){
	// Create new vectors for storing contour values
	vector<vector<Point> > cubeContoursInput, cubeContoursOutput;
	// Converts our hsl filter into black and white, because findContours requires you to be using black and white, not RGB or HSL	
	cvtColor(input, input, CV_RGB2GRAY);
	// Finds the contours of the image
	findContours(input, cubeContoursInput, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE);
	// Filters out contours based on width, height, and area.
	//cubeFilterContours(cubeContoursInput, cubeContoursOutput);
	cubeFilterContours(cubeContoursInput, cubeContoursOutput);
	return cubeContoursOutput;
}


// Draws Crosshairs onto the final image shown
void showCrosshairs(Mat &input){
	line(input, Point(input.cols / 2, 0), Point(input.cols / 2, input.rows), WHITE, 1);
	line(input, Point(0, input.rows / 2), Point(input.cols, input.rows / 2), WHITE, 1);
}

Point2f centerPoint(Rect rect) {
	return Point2f(rect.x + (rect.width / 2), rect.y + (rect.height / 2));
}


// Finds our cube in the contours
void cubeFindTargets(Mat &imageInput, vector<vector<Point> > &input, Mat &output){	
	// Readys Output mat for contour use
	output = Mat::zeros(imageInput.size(), CV_8UC3);
	// Creates Vector of Bounding Boxes
	vector<Rect> boundingBoxes(input.size());
	
	// Finds all the targets
	for (int i = 0; i< input.size(); i++) {
		// Makes contours rectanges and stores rectangles into bounding box vector.
		boundingBoxes[i] = boundingRect(input[i]);
		// Draws contours onto output
		drawContours(output, input, i, SKY_BLUE, 2);
	}
	
	// If there are 1 or more targets found
	if (boundingBoxes.size() >= 1) {
		// Sort rectangles in descending order based on their area.
		sort(boundingBoxes.begin(), boundingBoxes.end(), boundingBoxSortDescending); 

		// Pick out the biggest target found.
		Rect cube = boundingBoxes[0];
		
		//Draws rectangle onto output
		rectangle(output, cube, PURPLE, 2);
		
    cubeDistance = 13*620/cube.width;







		Point2f centerPoint1 = centerPoint(cube);	
		// Distance, angle, and offset calculation
		double cubeWidth = cube.width;
		double cubeB = (centerPoint1.x - (imageInput.cols/2)) * 1/(cubeWidth/1);
		double cubeC = cubeDistance;
		double cubeA = sqrt(abs(pow(cubeC,2)-pow(cubeB,2)));
		double cubeRads = atan(cubeB/cubeA);
		cubeOffset = 57.3 * cubeRads;
		if ((imageInput.cols/2)>centerPoint1.x){
			cubeOffset = -cubeOffset;

		}

		putText(output, "Offset: "+ to_string(cubeOffset), Point2f(30,2*15), cv::FONT_HERSHEY_PLAIN, 0.8, WHITE, 1);
		putText(output, "Distance: "+ to_string(cubeDistance), Point2f(30,3*15), FONT_HERSHEY_PLAIN, 0.8, WHITE, 1);
		
		}
	else {
		targetFound = false;
	}
}

// ================================

// Function to pull all functions together
Mat cubeProcessImage(Mat &input){
  Mat cubeHslOutput, cubeMaskOutput, cubeTargetsOutput;

  cubeHslThreshold(input, cubeHslOutput);
  cubeCreateMask(input, cubeHslOutput, cubeMaskOutput);
  auto cubeContoursValueOutput = cubeCreateContours(cubeMaskOutput);

  cubeFindTargets(cubeMaskOutput, cubeContoursValueOutput, cubeTargetsOutput);

  showCrosshairs(cubeTargetsOutput);
  return cubeTargetsOutput;
}

// Publish Network Tables to table in use
void PublishNetworkTables(shared_ptr<NetworkTable> table) {
	table->PutNumber("CubeDistance", cubeDistance);
	table->PutNumber("CubeOffset", cubeOffset);
	table->PutBoolean("TargetFound", targetFound);
}

// Get values for configurable values from NetworkTables
void GetHSLValues(shared_ptr<NetworkTable> prefTable) {
	cubeHue = prefTable->GetNumberArray("Cube Hue", cubeHue);
	cubeSaturation = prefTable->GetNumberArray("Cube Saturation", cubeSaturation);
	cubeLuminance = prefTable->GetNumberArray("Cube Luminance", cubeLuminance);
	
	showRaw = prefTable->GetBoolean("showRaw", showRawStream);
}

// Returns true to quit when "ESC" is pressed
bool quit(){
	char key = (char)waitKey(5);
	return( key == 27 || key == 'q' || key == 'Q' ); // key 27 = 'ESC'
}

// Displays welcome messages and debug info
void greetings(){
	cout << "\e[1mRunning \e[34mNURD\e[31mVision\e[0m \tFRCTeam 3255 SuperNURD 2017 Vision Processing\n" << 
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

// MAIN
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

	// Starts video capture of camera 
	VideoCapture capture(cameraInput);
	if (!capture.isOpened()) {
		cerr << "\n\e[31mERROR! Unable to open camera\nERROR! Is the camera connected?\e[0m\n";
		NetworkTable::Shutdown();
		return 1;
	}
	

	// While the quit function does not return true run image functions
	while (!quit()) {
		// Stores capture to raw mat
		capture.read(raw);
		// Runs image processing and stores to processed
		processed = cubeProcessImage(raw);
		// Publishes Data to NetworkTable - Vision
		PublishNetworkTables(visionTable);
		// Gets array values for Hue Saturation and Luminance from NURDVision table
		GetHSLValues(visionTable);
		// Publishes processed image to stream (checks to see if asking for raw)
		(showRaw ? stream.PutFrame(processed) : stream.PutFrame(processed));
		// Runs if debug is true
		if(debug){
			// Display processed image
			imshow("Processed image", processed);
			// Display raw image
			imshow("Raw Image", raw);
			// Output data to console
			cout << "Distance: "<< cubeDistance << "\tOffset: " << cubeOffset <<  endl;
		}
	}
	NetworkTable::Shutdown();
	cout << "\nNURDVision stopped successfully\n";
	return 0;
}