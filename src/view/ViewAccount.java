package view;

import Model.Database;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ViewAccount implements AppScene{
    private Label accountName;
    private Label accountPassword;
    private VBox root;
    private HBox line1;
    private HBox line2;

    @Override
    public Scene makeScene() {
        root = new VBox();
        line1 = new HBox();
        line2 = new HBox();

        root.setAlignment( Pos.CENTER );
        line1.setAlignment( Pos.CENTER );
        line2.setAlignment( Pos.CENTER );

        accountName = new Label();
        accountPassword = new Label();
        accountName.setText( GUI.getLogInScene().getUsernameField().getText() );
        accountPassword.setText( GUI.getLogInScene().getPasswordField().getText() );

        line1.getChildren().add(accountName);
        line2.getChildren().add(accountPassword);

        root.getChildren().add(line1);
        root.getChildren().add(line2);

        return new Scene(root, 400, 300 );
    }


}
