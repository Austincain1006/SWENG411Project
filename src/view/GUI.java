package view;
import Model.Database;
import javafx.stage.Stage;
import javafx.application.Application;

import javax.swing.text.View;

/**
 * view.GUI.java
 * Handles Overall GUI of program.
 * @authors Austin Cain
 */
public class GUI extends Application {
    private static Stage stage;
    private static LogInScene logInScene;
    private static RegisterUserScene registerUserScene;
    private static Database DB;
    private static ViewAccount ViewAccountScene;
    private static StudentHomeScreen studentHomeScreen;

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
        DB = new Database();
        logInScene = new LogInScene();
        registerUserScene = new RegisterUserScene();
        ViewAccountScene = new ViewAccount();
        studentHomeScreen = new StudentHomeScreen();
    }

    /**
     * Changes the Displayed Scene on GUI
     * @param newScene Scene to be Displayed
     */
    public static void setScene(AppScene newScene) {
        stage.setScene( newScene.makeScene() );
    }

    /**
     * Gets Register User Scene
     * @return scene abject
     */
    public static RegisterUserScene getRegisterUserScene() {
        return registerUserScene;
    }

    /**
     * Gets Register User Scene
     * @return scene abject
     */
    public static LogInScene getLogInScene() {
        return logInScene;
    }

    public static void popupError( Exception e ) {
        ExceptionStage eStage = new ExceptionStage();
        eStage.makeScene( e );
    }

    public static ViewAccount getViewAccountScene(){
        return ViewAccountScene;
    }

    public static Database getDB() {
        return DB;
    }

    public static StudentHomeScreen getStudentHomeScreen() {
        return studentHomeScreen;
    }



}
