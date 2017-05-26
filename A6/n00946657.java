/*
 * Author: Allan Lim
 * N#: N00946657
 * Course: COP3503
 * Assignment #: 6
 * Due Date: 4/4/2017
 */
 
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.Calendar;
import java.util.GregorianCalendar; 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.beans.binding.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * The main class of our program that handles launching the application to create the figures
 */
 
public class n00946657 extends Application{
    
   final static int RADIUS = 75;
   final static int GAP = 10;

/**
 * Main method that launches the application to create the figures
 */
   public static void main(String[] args) throws Exception {
      Application.launch(args);
   }

/**
 * Creates all the figures and puts them on the gridpane
 */
   @Override
   public void start(Stage primaryStage) {
      BorderPane borderClockPane = new BorderPane();     
      Pane hangmanPane = new Pane(); 
      hangmanPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      Pane fanPane = new Pane(); 
      fanPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      GridPane gridPane = new GridPane();      
      gridPane.setMaxSize(750, 330);
      gridPane.setMinSize(750, 330);
      
      StackPane root = new StackPane(gridPane);
      NumberBinding maxScale = Bindings.min(root.widthProperty().divide(800),
      root.heightProperty().divide(330));
      gridPane.scaleXProperty().bind(maxScale);
      gridPane.scaleYProperty().bind(maxScale);

// Location of each figure on the gridpane
      gridPane.add(borderClockPane, 0, 0);
      gridPane.add(hangmanPane, 1, 0);
      gridPane.add(fanPane, 2, 0);

// Creates a scene and places it in the stage
      Scene scene = new Scene(root, 750, 330);
      primaryStage.setTitle("Allan Lim | N00946657 | Project 6");
      primaryStage.setScene(scene); 
      primaryStage.show(); 

// Clock
      int hour = (int)(Math.random()* 10);
      int minute = (int)(Math.random()* 21);
      int second = (int)(Math.random()* 32);

      ClockPane clock = new ClockPane(hour, minute, second);
      String timeString = "                      " + clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
      Label lblCurrentTime = new Label(timeString);
      borderClockPane.setCenter(clock);
      borderClockPane.setBottom(lblCurrentTime);
      borderClockPane.setAlignment(lblCurrentTime, Pos.CENTER);

// Hangman
      Circle head = new Circle(20);
      head.setCenterX(130.0f);
      head.setCenterY(70.0f);
      head.setFill(Color.TRANSPARENT);
      head.setStroke(Color.BLACK);
      head.setStrokeWidth(4.0);
      
// Long vertical pole for hangman
      Line longVertPole = new Line();
      longVertPole.setStartX(70.0f);
      longVertPole.setStartY(258.0f);
      longVertPole.setEndX(70.0f);
      longVertPole.setEndY(40.0f);
      longVertPole.setStrokeWidth(4.0);

// Horizontal pole for hangman
      Line horizontalPole = new Line();
      horizontalPole.setStartX(70.0f);
      horizontalPole.setStartY(40.0f);
      horizontalPole.setEndX(130.0f);
      horizontalPole.setEndY(40.0f);
      horizontalPole.setStrokeWidth(4.0);

// Short vertical pole for hangman
      Line shortVertPole = new Line();
      shortVertPole.setStartX(130.0f);
      shortVertPole.setStartY(50.0f);
      shortVertPole.setEndX(130.0f);
      shortVertPole.setEndY(40.0f);
      shortVertPole.setStrokeWidth(4.0);

// Body for hangman
      Line body = new Line();
      body.setStartX(130.0f);
      body.setStartY(90.0f);
      body.setEndX(130.0f);
      body.setEndY(170.0f);
      body.setStrokeWidth(4.0);

// Right leg for hangman
      Line rightLeg = new Line();
      rightLeg.setStartX(130.0f);
      rightLeg.setStartY(170.0f);
      rightLeg.setEndX(100.0f);
      rightLeg.setEndY(210.0f);
      rightLeg.setStrokeWidth(4.0);

// Left leg for hangman
      Line leftLeg = new Line();
      leftLeg.setStartX(130.0f);
      leftLeg.setStartY(170.0f);
      leftLeg.setEndX(160.0f);
      leftLeg.setEndY(210.0f);
      leftLeg.setStrokeWidth(4.0);

// Right arm for hangman
      Line rightArm = new Line();
      rightArm.setStartX(112.0f);
      rightArm.setStartY(80.0f);
      rightArm.setEndX(83.0f);
      rightArm.setEndY(120.0f);
      rightArm.setStrokeWidth(4.0);

// Left arm for hangman
      Line leftArm = new Line();
      leftArm.setStartX(148.0f);
      leftArm.setStartY(80.0f);
      leftArm.setEndX(177.0f);
      leftArm.setEndY(120.0f);
      leftArm.setStrokeWidth(4.0);

// Arc for pole
      Arc arcBase = new Arc();
      arcBase.setCenterX(70.0f);
      arcBase.setCenterY(285.0f);
      arcBase.setRadiusX(25.0f);
      arcBase.setRadiusY(25.0f);
      arcBase.setStartAngle(0.0f);
      arcBase.setLength(180.0f);
      arcBase.setFill(Color.TRANSPARENT);
      arcBase.setStroke(Color.BLACK);
      arcBase.setType(ArcType.OPEN);
      arcBase.setStrokeWidth(4.0);

// Combines all parts of the hangman
      hangmanPane.getChildren().addAll(head, longVertPole, horizontalPole, shortVertPole, body, rightLeg, leftLeg, rightArm, leftArm, arcBase);

// Fans
      int x = RADIUS + GAP;
      int y = RADIUS + GAP;

      for (int i=0; i < 2; i++){
      for (int j = 0; j < 2; j++){
      Circle fan = new Circle();
      fan.setCenterX(x);
      fan.setCenterY(y);
      fan.setRadius(RADIUS);
      fan.setStroke(Color.BLACK);
      fan.setFill(Color.WHITE);
      fan.setStrokeWidth(4.0);
      fanPane.getChildren().add(fan);

      for (int k =30; k < 360; k+= 90) {
      Arc arc = new Arc(x, y, RADIUS - 15, RADIUS - 15, k, 30);
      arc.setStroke(Color.BLACK);
      arc.setFill(Color.BLACK);
      arc.setType(ArcType.ROUND);
      fanPane.getChildren().add(arc);
         }
      x += RADIUS * 2 + GAP;
      }
      x = RADIUS + GAP;
      y += RADIUS * 2 + GAP;
   }      
   }
}

/**
 * This is the class that's used to create the clock
 */
class ClockPane extends Pane {

   private int hour;
   private int minute;
   private int second;   

//Clock pane's width and height
   private double w = 330, h = 330;
   
/**
 * Construct a default clock with the current time
 */
   public ClockPane() {
      setCurrentTime();
   }
/**
 * Construct a clock with specified hour, minute, and second
 */
   public ClockPane(int hour, int minute, int second) {
      this.hour = hour;
      this.minute = minute;
      this.second = second;
      paintClock();
   }
/**
 * Return hour
 */
   public int getHour() {
      return hour;
   }
/**
 * Set a new hour
 */
   public void setHour(int hour) {
      this.hour = hour;
      paintClock();
   }
/**
 * Return minute
 */
   public int getMinute() {
      return minute;
   }
/**
 * Set a new minute
 */
   public void setMinute(int minute) {
      this.minute = minute;
      paintClock();
   }
/**
 * Return second
 */
   public int getSecond() {
      return second;
   }
/**
 * Set a new second
 */
   public void setSecond(int second) {
      this.second = second;
      paintClock();
   }
/**
 * Return clock pane's width
 */
   public double getW() {
      return w;
   }
/**
 * Set clock pane's width
 */
   public void setW(double w) {
    this.w = w;
    paintClock();
  }
/**
 * Return clock pane's height
 */
  public double getH(){
    return h;
  }
/**
 * Set clock pane's height
 */
  public void setH(double h){
    this.h = h;
    paintClock();
  }
/**
 * Set the current time for the clock
 */
  public void setCurrentTime (){
// Construct a calendar for the current date and time
    Calendar calendar = new GregorianCalendar();
// Set current hour, minute, and second
    this.hour = calendar.get(Calendar.HOUR_OF_DAY);
    this.minute = calendar.get(Calendar.MINUTE);
    this.second = calendar.get(Calendar.SECOND);
// Repaint the clock
    paintClock();

  }
/**
 * Paint the clock
 */
  protected void paintClock() {
// Initialize clock parameters    
    double clockRadius = Math.min(w,h) * 0.8 * 0.5;
    double centerX = w / 2;
    double centerY = h / 2;

// Draw Circle
    Circle head = new Circle(centerX, centerY, clockRadius);
    head.setFill(Color.WHITE);
    head.setStroke(Color.BLACK);
    head.setStrokeWidth(4.0);
    Text t1 = new Text (centerX - 5, centerY - clockRadius + 12, "12");
    Text t2 = new Text (centerX - clockRadius + 3, centerY + 3, "9");
    Text t3 = new Text (centerX + clockRadius - 10, centerY + 3, "3");
    Text t4 = new Text (centerX - 3, centerY + clockRadius - 3, "6");
    Text name = new Text (centerX - 22, centerY+2, "Allan Lim");

// Draw minute hand
    double mLength = clockRadius * 0.65;
    double minuteX = centerX + mLength *
    Math.sin(minute *(2 * Math.PI / 60));
    double minuteY = centerY - mLength *
    Math.cos(minute * (2 * Math.PI / 60));
    Line mLine =  new Line (centerX, centerY, minuteX, minuteY);
    mLine.setStroke(Color.BLUE);
    mLine.setStrokeWidth(3.0);

// Draw hour hand
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength *
    Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *
    Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine =  new Line (centerX, centerY, hourX, hourY);
    hLine.setStroke(Color.GREEN);
    hLine.setStrokeWidth(3.0);

    getChildren().clear();
    getChildren().addAll(head, t1, t2,t3,t4, name, mLine, hLine);
   }
}