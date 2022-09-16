import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality; 
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.application.Application;

public class ChangeMessage {
	public static Stage changeWindow;
	public static Button continueOrder, cancelOrder;
	public static Label message;
	public static int totalNumDrinks, fantaNumDrinks, cokeNumDrinks, spriteNumDrinks, lucozadeNumDrinks;
	public static float change, totalChange, 
						totalAmount, totalNoChange;
	
	public static void noChange() {
		changeWindow = new Stage();
		changeWindow.setTitle("Information about change");
		
		message = new Label("The machine dont give change, click continue to proceed or cancel to go back");
		message.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		message.setTextFill(Color.DARKBLUE);
		
		continueOrder = new Button("Continue");
		continueOrder.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		continueOrder.setTextFill(Color.DARKBLUE);
		continueOrder.setOnAction(e -> {
			
			if(CustomerTable.fanta.isSelected()) {
				CustomerTable.fantaQuantity -= CustomerTable.inputDrinks;
				fantaNumDrinks += CustomerTable.inputDrinks;
			}
			
			if(CustomerTable.coke.isSelected()) {
				CustomerTable.cokeQuantity -= CustomerTable.inputDrinks;
				cokeNumDrinks += CustomerTable.inputDrinks;
			}
			
			if(CustomerTable.sprite.isSelected()) {
				CustomerTable.spriteQuantity -= CustomerTable.inputDrinks;
				spriteNumDrinks += CustomerTable.inputDrinks;
			}
			
			if(CustomerTable.lucozade.isSelected()) {
				CustomerTable.lucozadeQuantity -= CustomerTable.inputDrinks;
				lucozadeNumDrinks += CustomerTable.inputDrinks;
			}
			
			change = CustomerTable.input - (1.20f * CustomerTable.inputDrinks);
			totalChange += change;
        	//System.out.println("Change: " + change);
        	System.out.println("total change: " + totalChange);
        	change = 0;
   
        	totalNumDrinks = fantaNumDrinks + cokeNumDrinks + spriteNumDrinks + lucozadeNumDrinks;
        	System.out.println("totalnumber of drinks: " + totalNumDrinks);      	
        	
        	totalAmount += CustomerTable.input;
        	
        	totalNoChange = totalAmount - totalChange;
        	
        	System.out.println("total amount: " + totalAmount + "\n");
        	
        	getThankYouCash();
        	
        	changeWindow.close();
        	CustomerTable.customerTable();
        	
        	//clear text boxes
        	CustomerTable.fantaText.clear();
        	CustomerTable.numberOfFantaText.clear();
        	
        	CustomerTable.cokeText.clear();
        	CustomerTable.numberOfCokeText.clear();
        	
        	CustomerTable.spriteText.clear();
        	CustomerTable.numberOfSpriteText.clear();
        	
        	CustomerTable.lucozadeText.clear();
        	CustomerTable.numberOfLucozadeText.clear();
        	
    		//Disable textboxes and buttons
        	CustomerTable.fanta.setDisable(false);
        	CustomerTable.fantaText.setDisable(true);
        	CustomerTable.numberOfFantaText.setDisable(true);
        	CustomerTable.buy1.setDisable(true);
        	
        	CustomerTable.sprite.setDisable(false);
        	CustomerTable.spriteText.setDisable(true);
        	CustomerTable.numberOfSpriteText.setDisable(true);
        	CustomerTable.buy2.setDisable(true);
        	
        	CustomerTable.coke.setDisable(false);
        	CustomerTable.cokeText.setDisable(true);
        	CustomerTable.numberOfCokeText.setDisable(true);
        	CustomerTable.buy3.setDisable(true);
        	
        	CustomerTable.lucozade.setDisable(false);
        	CustomerTable.lucozadeText.setDisable(true);
        	CustomerTable.numberOfLucozadeText.setDisable(true);
        	CustomerTable.buy4.setDisable(true);
		});
		
		
		cancelOrder = new Button("Cancel");
		cancelOrder.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		cancelOrder.setTextFill(Color.DARKBLUE);
		cancelOrder.setOnAction(e -> {changeWindow.close();
		
							CustomerTable.customerTable();
							//Disable textboxes and buttons
				        	CustomerTable.fanta.setDisable(false);
				        	CustomerTable.fantaText.setDisable(true);
				        	CustomerTable.numberOfFantaText.setDisable(true);
				        	CustomerTable.buy1.setDisable(true);
				        	
				        	CustomerTable.sprite.setDisable(false);
				        	CustomerTable.spriteText.setDisable(true);
				        	CustomerTable.numberOfSpriteText.setDisable(true);
				        	CustomerTable.buy2.setDisable(true);
				        	
				        	CustomerTable.coke.setDisable(false);
				        	CustomerTable.cokeText.setDisable(true);
				        	CustomerTable.numberOfCokeText.setDisable(true);
				        	CustomerTable.buy3.setDisable(true);
				        	
				        	CustomerTable.lucozade.setDisable(false);
				        	CustomerTable.lucozadeText.setDisable(true);
				        	CustomerTable.numberOfLucozadeText.setDisable(true);
				        	CustomerTable.buy4.setDisable(true);
		});
		
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(message,continueOrder,cancelOrder); 
		
		Scene scene = new Scene(vb, 400, 200);
		changeWindow.setScene(scene);
		changeWindow.showAndWait();
		
		
	}
	
	public static Alert getThankYouCash() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank You");
		alert.setHeaderText("Thank You Note");	
		alert.setContentText("Thank You for your purchase");
		alert.showAndWait();
		
		return alert;
		
	}

}
