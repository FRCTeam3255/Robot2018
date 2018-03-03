// ===========================================================
// NURDVision Configuration File
// Use this file to modify settings that can change team to
// team or season to season
// ============== DO NOT MODIFY THIS SECTION =================
	using namespace std;
	using namespace cv;
// ===========================================================

// ============== Basic Settings ============== //
const int teamNumber = 3255;	// FIRST Robotics Competition team number
const int cameraInput = 0;		// Camera input (default is 0 for jetson use)
const int streamPort = 1180;	// Port number of the video stream
								// 	(on jetson available at tegra-ubuntu.local:"streamPort" being the port below)
								// 	should be on the ip address of the device thats doing the processing, in our case the Jetson.
// ============================================ //
								
// ============== Stream Settings ============= //
const int resolutionWidth = 640;		// Horizontal Resolution for the camera stream
const int resolutionHeight = 480;		// Vertical Resolution for the camera stream
const int maxFrameRate = 30;			// Maximum frame rate for the camera strea
// Please note: The FRC Field allows only limited bandwith per robot, rasing these values may go past that bandwith

const bool showRawStream = false;				// By default (yes or no) show the raw, unprocessed camera stream over the network
// This can be changed live and overriden using RobotPreferences or NetworkTables. 
// ============================================ //

// ======== Tracking Tape Caliberation ======== //
const double OBJECT_WIDTH = 2; 	// Width (inches) of the tracking tape in real life
const double BASE_DISTANCE = 36;// Distance (inches) from camera to use as base for calucation
const double PIXEL_WIDTH = 40; 	// Width (inches) of the pixels at base distance
	
// ========= Contour Filter Threshold ========= //
// Lower and upper bound (in that respective order) threshold for contour filtering
int contourWidth[] = {6, 1000000};
int contourHieght[] = {6, 1000000};

int minContourArea = 50;
int minContourArcLength = 100;
// ============================================ //

// ============ Default HSV Values ============ //
// Use these if you would like to code the values on the image processor rather than receive them from the RoboRIO
// Store a double vector for both lower and upper bounds (in that respective order) of the hsl filter
//	decides what color you're looking for in the first mask
vector<double> hue = {47, 75};
vector<double> saturation = {112, 255};
vector<double> luminance = {21, 112};
// ============================================ //



// ============= Color Constants ============== //
// You don't need to touch these 
//	unless you want additional colors.
// Scalars writen in BGR format
const Scalar SKY_BLUE = Scalar(250, 206, 135);
const Scalar RED = Scalar(0, 0, 255);
const Scalar GREEN = Scalar(0, 255, 0);
const Scalar BLUE = Scalar(255, 0, 0);
const Scalar YELLOW = Scalar(0, 255, 255);
const Scalar WHITE = Scalar(255, 255, 255);
const Scalar PURPLE = Scalar(255, 0, 233);
// =========================================== //