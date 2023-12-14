package view;
import DB.MySqlDB;
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
    private static MySqlDB DB;
    private static StudentHomeScreen studentHomeScreen;
    private static FacultyHomeScreen facultyHomeScreen;
    private static CreateAppointmentScreen createAppointmentScreen;
    private static ViewAppointmentsScreen viewAppointmentsScreen;
    private static TutorHomeScreen tutorHomeScreen;
    private static SetAvailabilityScreen setAvailabilityScreen;
    private static SetSubjectsScreen setSubjectsScreen;


    // Starts the Program and Launches JavaFX Stage. Default Scene is LogInScene.
    @Override
    public void start(Stage primaryStage) throws Exception {
        initialize();
        stage = primaryStage;
        stage.setScene( logInScene.makeScene() );
        //stage.setScene( tutorHomeScreen.makeScene() ); // Manually Set Scene for Debugging
        stage.setTitle("TutorHelper");
        stage.show();
    }

    //Initializes all Scenes to be Used in GUI
    public void initialize(){
        System.out.println("Initializing GUI");
        DB = new MySqlDB();
        //Database.addAccount( getDefaultFaculty() );
        logInScene = new LogInScene();
        registerUserScene = new RegisterUserScene();
        studentHomeScreen = new StudentHomeScreen();
        facultyHomeScreen = new FacultyHomeScreen();
        createAppointmentScreen = new CreateAppointmentScreen();
        viewAppointmentsScreen = new ViewAppointmentsScreen();
        tutorHomeScreen = new TutorHomeScreen();
        setAvailabilityScreen = new SetAvailabilityScreen();
        setSubjectsScreen = new SetSubjectsScreen();
    }

    // Gets Default Faculty Member to manage Tutoring
    private Faculty getDefaultFaculty() {
        Faculty f = new Faculty();
        f.setUsername("ruth");
        f.setPassword("1234");
        return f;
    }

    // Changes the Displayed Scene on GUI
    public static void setScene(AppScene newScene) {
        stage.setScene( newScene.makeScene() );
    }

    // Display a Pop-Up Error to Screen
    public static void popupError( Exception e ) {
        ExceptionStage eStage = new ExceptionStage();
        eStage.makeScene( e );
    }
    public static RegisterUserScene getRegisterUserScene() {
        return registerUserScene;
    }

    public static LogInScene getLogInScene() {
        //logInScene.clearTextFields(); // for some reason this line just breaks everything IDK why
        return logInScene;
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

    public static SetAvailabilityScreen getSetAvailabilityScreen() {
        return setAvailabilityScreen;
    }

    public static SetSubjectsScreen getSetSubjectsScreen(){
        return setSubjectsScreen;
    }
}
