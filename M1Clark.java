//// Midterm M1 code for 59CST112

/***************************************************************
    MY FIRST NAME IS:  Christopher
    MY MIDDLE NAME IS: Tyler
    MY LAST NAME IS:   Clark
    
PICK 3 WORDS THAT START WITH YOUR INITIALS, using lower case letters:
    first word............car
    second word...........tiger
    third word............cat
    
USE THESE 3 WORDS TO NAME ALL VARIABLES FOR 3 POOL BALLS.
(You may abbreviate any words, but start with same letter.)
***************************************************************/


//// GLOBALS FOR 3 colored balls ////
//// (Assume ball diameter is 30.) ////
float carX,  carY,  carDX,  carDY;
float tigerX,  tigerY,  tigerDX,  tigerDY;
float catX,  catY,  catDX,  catDY;
float left, right, top, bottom;
float middle;

//// OTHER GLOBALS:  strings, pool table, etc ////

String title=  "CST112 MIDTERM EXAM";
String news=   "Click any ball to reset it to right half of table.  (r resets all.)";
String author=  "Christopher Tyler Clark";

//float left=50, right=450, top=100, bottom=250;        // Table boundaries
float w=640, h=480;       // Table boundaries
boolean wall=true;

int tableRed=150, tableGreen=250, tableBlue=150;      // green pool table
int score=0,m=0,k=0;

    // ADD YOUR OWN DECLARATIONS HERE. ++++


//// SETUP:  size and table
void setup() {
    size( 640, 480 );
    left=   118;
    right=  width-155;
    top=    138;
    bottom= height-175;
    middle= left + (right-left) / 2;
    reset();
 }
void reset() {
   // Random positions.
   carX=  random( middle,right );   carY=  random( top, bottom );
   tigerX=  random( middle,right );   tigerY=  random( top, bottom );
   catX=  random( middle,right );   catY=  random( top, bottom );
   // Random speeds
   carDX=  random( 1,3 );   carDY=  random( 1,3 );
   tigerDX=  random( 1,3 );   tigerDY=  random( 1,3 );
   catDX=  random( 1,3 );   catDY=  random( 1,3 );
 }

//// NEXT FRAME:  table, bounce off walls, collisions, show all
void draw() {
  background( 250,250,200 );
  rectMode( CENTER );
  table( w/2,h/2, 400, 200 );
  buttons();
  bounce();
  collisions();
  show();
  messages();
  //Mouse X Coordinate on screen
  line(mouseX, 0, mouseX, 480); 
  //Mouse Y Coordinate on screen
  line(0,mouseY,640,mouseY); 

  text(mouseX, 50,50);// Mouse X coordinate
  text(mouseY, 50,70);// Mouse Y coordinate
}


//// HANDLERS:  keys, click
void keyPressed() {
  if (key == 'q') { exit(); }
  if (key == 'r') { reset(); }

}


//// SCENE:  draw the table with wall down the middle
void table( float east, float north, float west, float south ) {
  fill( tableRed, tableGreen, tableBlue );    // pool table
  strokeWeight(20);
  stroke( 127, 0, 0 );      // Brown walls
  rect( east-20, north-20, west+20, south+20 );

            //++++ MODIFY THIS CODE, as necessary. ++++

  // Start with a WALL down the middle of the table! 
  if (wall) {
    float middle=  (east+west)/2;    
    stroke( 0, 127, 0 );
    line( middle,north+10, middle,south-10 );
  }
  stroke(0);
  strokeWeight(1);
}

//// ACTION:  bounce off walls, collisions
void bounce() {
  carX += carDX;  if ( carX<left || carX>right ) carDX *= -1;
  carY += carDY;  if ( carY<top  || carY>bottom ) carDY *=  -1;
  tigerX += tigerDX;  if ( tigerX<left || tigerX>right ) tigerDX *= -1;
  tigerY += tigerDY;  if ( tigerY<top  || tigerY>bottom ) tigerDY *=  -1;
  catX += catDX;  if ( catX<left || catX>right ) catDX *= -1;
  catY += catDY;  if ( catY<top  || catY>bottom ) catDY *=  -1;
}

void collisions() {
  float tmp;
  // Velocities
  if ( dist( carX,carY, tigerX,tigerY ) < 30 ) {
    tmp=carDX;  carDX=tigerDX;  tigerDX=tmp;
    tmp=carDY;  carDY=tigerDY;  tigerDY=tmp;
  }
  if ( dist( catX,catY, tigerX,tigerY ) < 30 ){
    tmp=tigerDX;  tigerDX=catDX;  catDX=tmp;
    tmp=tigerDY;  tigerDY=catDY;  catDY=tmp;
  }
  if ( dist( catX,catY, carX,carY ) < 30 ){
    tmp=carDX;  carDX=catDX;  catDX=tmp;
    tmp=carDY;  carDY=catDY;  catDY=tmp;
  }
}


//// SHOW:  balls, messages, etc.
void show() {
  fill( 255, 193, 37 );    ellipse( carX,carY, 30,30 );
  fill( 255,0,0 );    ellipse( carX,carY, 30,30 );
  fill( 205, 102, 0 );  ellipse( tigerX,tigerY, 30,30 );
  fill( 128, 128 ,128 );    ellipse( catX,catY, 30,30 );
}
void buttons() {
    //++++ ADD YOUR OWN CODE HERE. ++++
}
void messages() {
  fill(0);
  text( title, width/3, 15 );
  text( news, width/9, 30 );
  text( author, 10, height-5 );

  // Also, display the number of collisions.

    //++++ ADD YOUR OWN CODE HERE. ++++

}
