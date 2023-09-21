package view;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * LogInScene.java
 * Page for Logging into Accounts and Registering New Ones
 * @author Austin
 */
public class LogInScene implements AppScene {
   private VBox root;
   private HBox line;
   private Text text;

    /**
     * Default Contructor for LogInScene
     */
   LogInScene(){
       text = new Text( "Please Log In: ");
   }

    /**
     * Builds and Returns the LogInScene
     * @return Scene to be Displayed
     */
    @Override
    public Scene makeScene() {
        root = new VBox();
        line = new HBox();

        root.setAlignment( Pos.CENTER );
        line.setAlignment( Pos.CENTER );

        line.getChildren().add( text );
        root.getChildren().add( line );
        return new Scene( root, 400, 300 );
    }
}
