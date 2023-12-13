package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class templateScreen implements AppScene{
    private VBox root;
    private HBox line1, line2, line3, line4;
    private Button backButton;

    @Override
    public Scene makeScene() {
        root = new VBox();
        line1 = new HBox();
        line2 = new HBox();
        line3 = new HBox();
        line4 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );
        line3.setAlignment( Pos.CENTER );
        line4.setAlignment( Pos.CENTER );

        backButton = new Button("Back");
        backButton.setOnAction( event -> GUI.setScene( GUI.getStudentHomeScreen() ));

        /*
        line1.getChildren().add();
        line1.getChildren().add();
        line2.getChildren().add();
        line3.getChildren().add();
        line4.getChildren().add();
        */

        root.getChildren().add(line1);
        root.getChildren().add(line2);
        root.getChildren().add(line3);
        root.getChildren().add(line4);

        return new Scene(root, 400, 300 );
    }



}
