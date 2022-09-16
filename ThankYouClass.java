import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ThankYouClass {
	
	public static Stage thanks;
	public static Button thankYou;
	public static Label noteDisplay, titleLabel, displayCredit;
	
	public static void thankYou() {
		//setting up the stage
		thanks = new Stage();
		thanks.setTitle("Thank You Note");
		thanks.initModality(Modality.APPLICATION_MODAL);
		
		titleLabel = new Label("Thank You Note");
		titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
		titleLabel.setTextFill(Color.DARKBLUE);
        titleLabel.setAlignment(Pos.CENTER_LEFT);
        
		//label to display information
		noteDisplay = new Label("Credit balance: " + BankDetails.toppedUpCredit + "\n"
					+ " You got 5 cent discout for each drink you purchased\n" 
					+ " Thank You\n");
		
		noteDisplay.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		
		thankYou = new Button("Ok");//ok button to go back
		thankYou.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		thankYou.setTextFill(Color.DARKBLUE);
	        thankYou.setOnAction(e ->{
	        	thanks.close();
	        	CreditClass.creditCustomer();
	        	});
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(titleLabel, noteDisplay, thankYou); 
		
		Scene scene = new Scene(vb, 500, 300);
		thanks.setScene(scene);
		thanks.show();
	}

}
