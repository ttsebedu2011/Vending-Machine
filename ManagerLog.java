import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality; 
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.application.Application;

public class ManagerLog {
	
	public static Label totalCredit, totalCash,
						totalNumDrinksCredit, totalNumDrinksCash,
						change, sales;
	
	public static Button collect, back;
	
	public static float reportCredit, reportCash, reportChange; 
	
	public static int reportDrinksCredit, reportDrinksCash;
	
	public static void managerLog() {
		
		Stage windowManager = new Stage();
		windowManager.setTitle("Sales Generated");
		windowManager.initModality(Modality.APPLICATION_MODAL);
		
		
		sales = new Label("Money Generated on Sales");
		sales.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        sales.setAlignment(Pos.CENTER_LEFT);
        sales.setTextFill(Color.DARKBLUE);
        
        totalCredit = new Label("Cash generated on credit sales: " + CreditClass.grandTotal);
        totalCredit.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        totalNumDrinksCredit = new Label("Total number of drinks bought on credit: " + CreditClass.totalNumDrinksCredit);
        totalNumDrinksCredit.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        totalCash = new Label("Cash generated on cash sales: " + ChangeMessage.totalNoChange);
        totalCash.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        totalNumDrinksCash = new Label("Total number of drinks bought cash: " + ChangeMessage.totalNumDrinks);
        totalNumDrinksCash.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        change = new Label("Cash generated on change: " + ChangeMessage.totalChange);
        change.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        collect = new Button("Collect");
        collect.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        collect.setTextFill(Color.DARKBLUE);
        collect.setOnAction(e -> {
        	reportCredit = CreditClass.grandTotal;
        	reportDrinksCredit = CreditClass.totalNumDrinksCredit;
        	reportCash = ChangeMessage.totalNoChange;
        	reportDrinksCash = ChangeMessage.totalNumDrinks;
        	reportChange = ChangeMessage.totalChange;
        	getMoneyCollected();
        	
        	CreditClass.grandTotal = 0;
        	CreditClass.totalNumDrinksCredit = 0;
        	ChangeMessage.totalNoChange = 0;
        	ChangeMessage.totalNumDrinks = 0;
        	ChangeMessage.totalChange = 0;
        	windowManager.close();	
        	TableManager.tableManager();
        	
        });
        
        back = new Button("Back");
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        back.setTextFill(Color.DARKBLUE);
        back.setOnAction(e ->{
        	windowManager.close();
        	TableManager.tableManager();
        	});
        
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(sales, totalCredit, totalCash, totalNumDrinksCredit,totalNumDrinksCash,change,collect,back); 
		
		Scene scene = new Scene(vb, 500, 300);
		windowManager.setScene(scene);
		windowManager.show();
	}
	
	public static Alert getMoneyCollected() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Collect Cash");
		alert.setHeaderText("Cash is collected");	
		alert.setContentText("Collected cash saved in Sales Report");
		alert.showAndWait();
		
		return alert;
		
	}

}
