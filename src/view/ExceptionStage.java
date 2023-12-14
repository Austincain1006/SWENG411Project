package view;

import Model.Exceptions.AccountNotFoundException;
import Model.Exceptions.InvalidLoginException;
import Model.Exceptions.MissingFieldException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * ExceptionStage.java
 * Displays a Pop-Up Window to Display Errors
 * @author Austin Cain
 */
public class ExceptionStage {
    private Stage exceptionStage;
    private Label exceptionLabel;

    public void makeScene(Exception e) {
        this.exceptionStage = new Stage( );
        exceptionStage.setMinWidth( 400 );
        exceptionStage.setMinHeight( 250 );
        exceptionStage.setResizable( false );
        exceptionStage.setTitle( "Tutortrac 2.0" );
        exceptionStage.initModality( Modality.APPLICATION_MODAL );

        setExceptionLabel( e );

        this.exceptionLabel.setAlignment( Pos.CENTER );
        this.exceptionLabel.setTextAlignment( TextAlignment.CENTER );

        VBox vBox = new VBox( 20, this.exceptionLabel);
        vBox.setAlignment( Pos.CENTER );

        exceptionStage.setScene( new Scene( vBox ) );
        exceptionStage.show( );
    }

    // Display Text Appropriate for Error Type
    public void setExceptionLabel( Exception e) {
        System.out.println(e);
        if (e instanceof MissingFieldException)
            exceptionLabel = new Label("Empty input field. Please fill in all fields.");
        if (e instanceof InvalidLoginException)
            exceptionLabel = new Label("Incorrect password or username. Please check your username and password.");
        if (e instanceof AccountNotFoundException)
            exceptionLabel = new Label("No Account Found");
        else
            exceptionLabel = new Label( "Unknown error.");

        System.out.println(e);
    }
}
