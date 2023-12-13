package view;
import Model.Database;
import Model.Faculty;
import Model.Student;
import javafx.scene.Scene;
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
    private static Database DB;
    private static ViewAccount ViewAccountScene;
    private static StudentHomeScreen studentHomeScreen;
    private static FacultyHomeScreen facultyHomeScreen;
    private static CreateAppointmentScreen createAppointmentScreen;
    private static ViewAppointmentsScreen viewAppointmentsScreen;
    private static TutorHomeScreen tutorHomeScreen;


    /**
     * Starts the Program and Launches JavaFX Stage.
     * Default Scene is LogInScene
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize();
        stage = primaryStage;
        stage.setScene( logInScene.makeScene() );
        stage.setScene( tutorHomeScreen.makeScene() ); // Manually Set Scene for Debugging
        stage.setTitle("TutorHelper");
        stage.show();
    }

    /**
     * Initializes all Scenes to be Used in GUI
     */
    public void initialize(){
        DB = new Database();
        Database.addAccount( getDefaultFaculty() );
        Database.addAccount( getDefaultStudent() );

        logInScene = new LogInScene();
        registerUserScene = new RegisterUserScene();
        ViewAccountScene = new ViewAccount();
        studentHomeScreen = new StudentHomeScreen();
        facultyHomeScreen = new FacultyHomeScreen();
        createAppointmentScreen = new CreateAppointmentScreen();
        viewAppointmentsScreen = new ViewAppointmentsScreen();
        tutorHomeScreen = new TutorHomeScreen();
    }

    /**
     * Gets Default Faculty Member to manage Tutoring
     * @return Faculty Object
     */
    private Faculty getDefaultFaculty() {
        Faculty f = new Faculty();
        f.setUsername("ruth");
        f.setPassword("1234");
        return f;
    }

    /**
     * Gets Default Student for debugging
     * @return Faculty Object
     */
    private Student getDefaultStudent() {
        Student s = new Student();
        s.setUsername("austin");
        s.setPassword("1234");
        return s;
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
        //logInScene.clearTextFields(); // for some reason this line just breaks everything IDK why
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

    public static FacultyHomeScreen getFacultyHomeScreen() {
        return facultyHomeScreen;
    }

    public static CreateAppointmentScreen getCreateAppointmentScreen() {
        return createAppointmentScreen;
    }

    public static ViewAppointmentsScreen getViewAppointmentsScreen() {
        return viewAppointmentsScreen;
    }

    public static TutorHomeScreen getTutorHomeScreen() {
        return tutorHomeScreen;
    }
}
