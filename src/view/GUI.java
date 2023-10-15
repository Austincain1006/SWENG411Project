package view;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 * view.GUI.java
 * Handles Overall GUI of program.
 * @authors Austin Cain
 */
public class GUI extends Application {
    private static Stage stage;
    private static LogInScene logInScene;
    private static RegisterUserScene registerUserScene;

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
        registerUserScene = new RegisterUserScene();
    }

    /**
     * Changes the Displayed Scene on GUI
     * @param newScene Scene to be Displayed
     */
    public static void setScene(AppScene newScene) {
        stage.setScene( newScene.makeScene() );
    }

    /**
     * Gets Scene from String Name
     * @param name name of scene to get
     * @return scene as appscene object
     */
    public static AppScene getScene(String name) {     // this is probably terrible design IDK
        switch (name) {
            case "registerUserScene":
                return registerUserScene;
            default:
                return logInScene;
        }
    }


}
