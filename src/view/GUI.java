package view;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 * view.GUI.java
 * Handles GUI of program.
 * @authors Austin Cain
 */
public class GUI extends Application {
    private static Stage stage;
    private static LogInScene logInScene;

    /**
     * Starts the Program and Launches JavaFX Stage.
     * Default Scene is LogInScene
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize();
        stage = primaryStage;
        stage.setScene( logInScene.makeScene() );
        stage.setTitle("TutorHelper");
        stage.show();
    }

    /**
     * Initializes all Scenes to be Used in GUI
     */
    public void initialize(){
        logInScene = new LogInScene();
    }

}
