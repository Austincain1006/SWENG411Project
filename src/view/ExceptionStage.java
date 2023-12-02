package view;

import Model.Exceptions.InvalidLoginException;
import Model.Exceptions.MissingFieldException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    public void setExceptionLabel( Exception e) {
        if (e instanceof MissingFieldException){
            exceptionLabel = new Label("Empty input field. Please fill in all fields.");
        } if (e instanceof InvalidLoginException) {
            exceptionLabel = new Label("Account not found. Please check your username and password.");
        } else {
            exceptionLabel = new Label( "Unknown error.");
            System.out.println( e.getCause() );
            System.out.println( e.getMessage() );
            System.out.println( e.toString() );
        }
    }
}
