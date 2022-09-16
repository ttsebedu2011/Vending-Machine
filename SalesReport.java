
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

public class SalesReport {
	
	public static Label totalCreditRepo, totalCashRepo,
						totalNumDrinksCreditRepo, totalNumDrinksCashRepo,
						changeRepo, salesRepo;
	
	public static Button  back;
	
	public static float changeSales, totalCashSale, totalCreditSale, totalNumCredit, totalNumCash ;
	
	public static void salesReport() {
		
		//Setup the stage
		Stage windowSales = new Stage();
		windowSales.setTitle("Sales Report");
		windowSales.initModality(Modality.APPLICATION_MODAL);
		
		//Create labels to display the information
		salesRepo = new Label("Sales Report");
		salesRepo.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        salesRepo.setAlignment(Pos.CENTER_LEFT);
        salesRepo.setTextFill(Color.DARKBLUE);
         
        //Labels to display sales report
	        totalCreditRepo = new Label("Cash generated on credit sales: " + ManagerLog.reportCredit);
	        totalCreditRepo.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
	        
	        totalNumDrinksCreditRepo = new Label("Total number of drinks bought on credit: " + ManagerLog.reportDrinksCredit);
	        totalNumDrinksCreditRepo.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
	        
	        totalCashRepo = new Label("Cash generated on cash sales including change: " + ManagerLog.reportCash);
	        totalCashRepo.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
	        
	        totalNumDrinksCashRepo = new Label("Total number of drinks bought cash: " + ManagerLog.reportDrinksCash);
	        totalNumDrinksCashRepo.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
	        
	        changeRepo = new Label("Cash generated on change: " + ManagerLog.reportChange);
	        changeRepo.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
	        
      
        //Button to go back to managers table
        back = new Button("Back");
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        back.setTextFill(Color.DARKBLUE);
        back.setOnAction(e ->{
        	windowSales.close();
        	TableManager.tableManager();
        	});
        
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(salesRepo, totalCreditRepo, totalCashRepo, totalNumDrinksCreditRepo,totalNumDrinksCashRepo,changeRepo,back); 
		
		Scene scene = new Scene(vb, 500, 300);
		windowSales.setScene(scene);
		windowSales.show();
	}

}
