/*
 * Author: Allan Lim
 * N#: N00946657
 * Course: COP3503
 * Assignment #: 7
 * Due Date: 4/18/2017 @ 11 PM
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.beans.binding.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority; 
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

/**
 * The main class of our program that handles launching the application to create the video player, bouncing rectangle, and our name to be moved up & down
 */
public class n00946657 extends BounceBallSlider {
/**
 * The main method that launches the application
 */
   public static void main(String[] args) throws Exception {
      Application.launch(args);
   }
}

/**
 * A child class of the Application class that creates the video player & buttons for the program: 
 * play button, rewind button, option to change the volume of the sound, & the up & down buttons for the name
 */
class ButtonDemo extends Application {
   private static final String MEDIA_URL = "http://www.unf.edu/~n00946657/video.mp4";
   protected Text text = new Text(100, 200, "Allan Lim");
   boolean paused = true;
   
/**
 * Creates the pane for the video and all the buttons for the program
 */
   protected BorderPane getPane() {
   BorderPane pane =  new BorderPane();

// Contains the up and down buttons and sets them on the bottom
   HBox paneForButtons = new HBox(20);
   Button btUp = new Button("Up", new ImageView("http://www.unf.edu/~n00946657/upbutton.png"));
   Button btDown = new Button("Down", new ImageView("http://www.unf.edu/~n00946657/downbutton.png"));
   paneForButtons.getChildren().addAll(btUp, btDown);
   paneForButtons.setAlignment(Pos.CENTER);
   paneForButtons.setStyle("-fx-border-width: 1px; -fx-border-color: gray");
   pane.setBottom(paneForButtons);

// Sets up the actions for the up and down buttons which makes the text "Allan Lim" move by a certain amount
   btUp.setOnAction(e -> text.setY(text.getY() - 10));
   btDown.setOnAction(e -> text.setY(text.getY() + 10));
   Pane paneForText = new Pane();
   paneForText.getChildren().add(text);
   String topStringTest = "                                 ";
   Label lblTop = new Label (topStringTest);

// Creates the media objects for the mp4 video
   Media media = new Media(MEDIA_URL);
   MediaPlayer mediaPlayer = new MediaPlayer(media);
   MediaView mediaView = new MediaView(mediaPlayer);

// Links for the play, pause, and rewind buttons. Also calls the ImageView class to make the pictures viewable
   String playString = "http://www.unf.edu/~n00946657/playbutton.png";
   String pauseString = "http://www.unf.edu/~n00946657/pausebutton.png";
   String rewindString = "http://www.unf.edu/~n00946657/rewindbutton.png";
   ImageView imgPlayButton = new ImageView(playString);
   ImageView imgPauseButton = new ImageView(pauseString);
   ImageView imgRewindButton = new ImageView(rewindString);

// Generates a play & pause button that will determine its actions
   Button playButton = new Button("", imgPlayButton);
   playButton.setOnAction(e -> {
      if(paused){
         mediaPlayer.play();
         playButton.setGraphic(imgPauseButton);
      }
      else {
         mediaPlayer.pause();
         playButton.setGraphic(imgPlayButton);
      }
      paused = !paused;
});

// Generates a rewind button that will determine its actions
   Button rewindButton = new Button("", imgRewindButton);
   rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

// Generates a slider button that will determine the volume of the video
   Slider slVolume = new Slider();
   slVolume.setPrefWidth(150);
   slVolume.setMaxWidth(Region.USE_PREF_SIZE);
   slVolume.setMinWidth(30);
   slVolume.setValue(50);
   mediaPlayer.volumeProperty().bind(
   slVolume.valueProperty().divide(100));

// Adds all the buttons together to put them into place
   HBox hBox = new HBox(10);
   hBox.setAlignment(Pos.CENTER);
   hBox.getChildren().addAll(playButton, rewindButton, new Label("Volume"), slVolume);

// Places the video & the buttons in a separate pane and sets the width and height
   BorderPane pane2 = new BorderPane();
   pane2.setCenter(mediaView);
   pane2.setBottom(hBox);
   mediaView.setFitWidth(600);
   mediaView.setFitHeight(300);

// Puts the pane inside a normal pane & adds all the other pains to the central grid pane
   Pane paneForMedia = new Pane(pane2);
   GridPane gridPaneCenter = new GridPane();
   gridPaneCenter.add(paneForText, 0, 0);
   gridPaneCenter.add(lblTop, 1, 0);
   gridPaneCenter.add(paneForMedia, 2, 0);

// Fits the grid pane into place
   RowConstraints row = new RowConstraints();
   row.setVgrow(Priority.ALWAYS);
   gridPaneCenter.getRowConstraints().add(row);
   ColumnConstraints col = new ColumnConstraints();
   col.setHgrow(Priority.ALWAYS);
   gridPaneCenter.getColumnConstraints().add(col);

// Adds the grid pane with all the stuff into the main pane
   pane.setCenter(gridPaneCenter);
   return pane;
   }

/**
 * The main grid pane where all of the other panes will be added to
 */
   @Override
   public void start(Stage primaryStage) {

// Creates the main pane & sets the size of it
   GridPane gridPaneMain = new GridPane();
   gridPaneMain.setMaxSize(1000,500);
   gridPaneMain.setMinSize(1000,500);
   StackPane root = new StackPane(gridPaneMain);
   NumberBinding maxScale = Bindings.min(root.widthProperty().divide(1000),
   root.heightProperty().divide(500));
   gridPaneMain.scaleXProperty().bind(maxScale);
   gridPaneMain.scaleYProperty().bind(maxScale);

// Puts the border pane inside a grid
   gridPaneMain.add(getPane(), 0,0);
   RowConstraints row = new RowConstraints();
   row.setVgrow(Priority.ALWAYS);
   gridPaneMain.getRowConstraints().add(row);
   ColumnConstraints col = new ColumnConstraints();
   col.setHgrow(Priority.ALWAYS);
   col.setPercentWidth(100.0);
   gridPaneMain.getColumnConstraints().add(col);

// Creates a scene and places it on the stage
   Scene scene = new Scene(root, 1000, 500);
   primaryStage.setTitle("Project 7 | Allan Lim | N00946657"); 
   primaryStage.setScene(scene); 
   primaryStage.show(); 
   }
}

/**
 * The child class of the ButtonDemo class that creates the options to change the text "Allan Lim" in different ways
 */
class CheckBoxDemo extends ButtonDemo {

/**
 * Overrides the getPane() method in the super class to create the options to change the text "Allan Lim"
 */
   @Override 
   protected BorderPane getPane() {
      BorderPane pane = super.getPane();

// Sets text to italic, bold, or both options
      Font fontBoldItalic = Font.font("Calibri",
      FontWeight.BOLD, FontPosture.ITALIC, 20);
      Font fontBold = Font.font("Calibri",
      FontWeight.BOLD, FontPosture.REGULAR, 20);
      Font fontItalic = Font.font("Calibri",
      FontWeight.NORMAL, FontPosture.ITALIC, 20);
      Font fontNormal = Font.font("Calibri",
      FontWeight.NORMAL, FontPosture.REGULAR, 20);
      text.setFont(fontNormal);

// Creates the check boxes for the bold and italic options
      VBox paneForCheckBoxes = new VBox(10);
      paneForCheckBoxes.setPadding(new Insets(250, 5, 5, 5));
      paneForCheckBoxes.setStyle("-fx-border-width: 1px; -fx-border-color: gray");
      CheckBox chkBold = new CheckBox("Bold");
      CheckBox chkItalic = new CheckBox("Italic");
      paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
      pane.setLeft(paneForCheckBoxes);

// Determines the actions for the buttons when checked
      EventHandler<ActionEvent> handler = e -> {
      if (chkBold.isSelected() && chkItalic.isSelected()) {
         text.setFont(fontBoldItalic); 
      }
      else if (chkBold.isSelected()) {
         text.setFont(fontBold); 
      }
      else if (chkItalic.isSelected()) {
         text.setFont(fontItalic); 
      }
      else {
         text.setFont(fontNormal); 
      }
   };

      chkBold.setOnAction(handler);
      chkItalic.setOnAction(handler);
      return pane;
   }
}

/**
 * The child class of the CheckBoxDemo class that changes the color of the text "Allan Lim"
 */
class RadioButtonDemo extends CheckBoxDemo {
   
/**
 * Overrides the getPane() method in the super class to create the options to change the text "Allan Lim"
 */   
   @Override 
   protected BorderPane getPane() {
      BorderPane pane = super.getPane();

// Creates the button options to change the color of the text to cyan, yellow, & magenta
      VBox paneForRadioButtons = new VBox(10);
      paneForRadioButtons.setPadding(new Insets(250, 5, 5, 5));
      paneForRadioButtons.setStyle("-fx-border-width: 1px; -fx-border-color: gray");
      RadioButton rbCyan = new RadioButton("Cyan");
      RadioButton rbYellow = new RadioButton("Yellow");
      RadioButton rbMagenta = new RadioButton("Magenta");
      paneForRadioButtons.getChildren().addAll(rbCyan, rbYellow, rbMagenta);
      pane.setRight(paneForRadioButtons);

// Determines the actions of the buttons for each color
      ToggleGroup group = new ToggleGroup();
      rbCyan.setToggleGroup(group);
      rbYellow.setToggleGroup(group);
      rbMagenta.setToggleGroup(group);
      rbCyan.setOnAction(e -> {
      if (rbCyan.isSelected()) {
         text.setFill(Color.CYAN);
      }
   });

      rbYellow.setOnAction(e -> {
      if (rbYellow.isSelected()) {
         text.setFill(Color.YELLOW);
      }
   });

      rbMagenta.setOnAction(e -> {
      if (rbMagenta.isSelected()) {
         text.setFill(Color.MAGENTA);
      }
   });
      return pane;
   }
}

/**
 * The child class of the RadioButtonDemo class that creates the slider for the rectangle that bounces at different speeds
 */
class BounceBallSlider extends RadioButtonDemo {

/**
 * Overrides the getPane() method in the super class to create the rectangle that bounces with different speeds
 */
   @Override 
   protected BorderPane getPane() {
      BorderPane pane = super.getPane();

// Gets the rectangle properties and creates the slider for the speed
      RectanglePane rectanglePane = new RectanglePane();
      Slider slSpeed = new Slider();
      slSpeed.setMax(20);
      rectanglePane.rateProperty().bind(slSpeed.valueProperty());
      BorderPane pane1 = new BorderPane();
      pane1.setCenter(rectanglePane);
      pane1.setBottom(slSpeed);
      pane1.setStyle("-fx-border-width: 1px; -fx-border-color: gray");
      pane1.setPrefSize(200,100);
      pane.setTop(pane1);
      return pane;
}

/**
 * The child class of the Pane class that creates the rectangle that bounces
 */
class RectanglePane extends Pane {
   public final double width = 40;
   public final double height = 20;
   private double x = width, y = height;
   private double dx = 1, dy = 1;
   private Rectangle rectangle = new Rectangle(x,y);
   private Timeline animation;

/**
 * Makes a red rectangle with a bouncing action
 */
   public RectanglePane() {
      rectangle.setFill(Color.RED);
      getChildren().add(rectangle);
      animation = new Timeline(
      new KeyFrame(Duration.millis(50), e -> moveRectangle()));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play();
   }

/**
 * Method that plays the animation
 */
   public void play() {
      animation.play();
   }

/**
 * Method that pauses the animation
 */
   public void pause(){
      animation.pause();
   }

/**
 * Method that increases the speed of the animation
 */
   public void increaseSpeed(){
      animation.setRate(animation.getRate()+ 0.1);
   }

/**
 * Method that decreases the speed of the animation
 */
   public void decreaseSpeed(){
      animation.setRate(animation.getRate() > 0? animation.getRate()-0.1: 0);
   }

/**
 * Method that returns the rate of animation
 */
   public DoubleProperty rateProperty(){
      return animation.rateProperty();
   }

/**
 * Method that moves the rectangle depending on location
 */
   protected void moveRectangle(){
      if (x < width || x > getWidth()-width){
         dx *= -1;
      }
      if (y < height || y > getHeight()-height){
         dy *= -1;
      }
      x += dx;
      y += dy;
      rectangle.setX(x);
      rectangle.setY(y);
      }
   }
}