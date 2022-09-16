
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
import javafx.scene.control.DatePicker;
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
import java.text.SimpleDateFormat;

public class MaintenanceLog {
	
	public static Label reportLabel,reportLabelCredit, titleLabel, todayDate, todayTime;
	
	public static Button fixIssues, back;
	
	public static Stage windowReport;
	
	public static Date currentDate;
	
	public static SimpleDateFormat timeFormat, dateFormat,
				dayOfTheWeekFormat, clockFormat;
	
	public static DatePicker date;
	
	public static String repairedDate, repairedTime, repairedComplaint, repairedComplaintCredit;
	
	public static void maintenanceLog() {
		
		//Setting the stage
		windowReport = new Stage();
		windowReport.setTitle("Maintenance");
		windowReport.initModality(Modality.APPLICATION_MODAL);
		
		//Setting the date and time
		currentDate = new Date();
		System.out.println(currentDate);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss");
		System.out.println(timeFormat.format(currentDate));
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateFormat.format(currentDate));
	
			
		//Creating the labels to display information
		titleLabel = new Label("Customer Complaints");
		titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
		titleLabel.setTextFill(Color.DARKBLUE);
        titleLabel.setAlignment(Pos.CENTER_LEFT);
        
        reportLabel = new Label("Cash customer Complaint: " + CustomerTable.complaint);
        reportLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        reportLabelCredit = new Label("Credit customer Complaint: " + CreditClass.complaints);
        reportLabelCredit.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        todayDate = new Label("Todays date: " + dateFormat.format(currentDate));
        todayDate.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        todayTime = new Label("Current time: " + timeFormat.format(currentDate));
        todayTime.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        fixIssues = new Button("Fix Issues");
        fixIssues.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        fixIssues.setTextFill(Color.DARKBLUE);
        fixIssues.setOnAction(e -> {
        	
        	repairedComplaint = CustomerTable.complaint;
        	repairedComplaintCredit = CreditClass.complaints;
        	
        	getReport();
        	
        	if(CustomerTable.complaint != null)//Checking if theres any complaints
        		CustomerTable.complaint = ""; //Clear the complaint
        	else if(CreditClass.complaints != null)
        		CreditClass.complaints = "";
        	
        	repairedDate = dateFormat.format(currentDate); //Transfer date and time to repaired log table
        	repairedTime = timeFormat.format(currentDate);
        	
        	windowReport.close();	//Close window
        	TableManager.tableManager();//Call the managers table
        	
        });
        
        //Back button to go back to managers table
        back = new Button("Back");
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        back.setTextFill(Color.DARKBLUE);
        back.setOnAction(e ->{
        	windowReport.close();
        	TableManager.tableManager();
        	});
        
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(titleLabel,todayDate,todayTime,reportLabel,reportLabelCredit,fixIssues,back); 
		
		Scene scene = new Scene(vb, 500, 300);
		windowReport.setScene(scene);
		windowReport.show();
	}
	
	public static Alert getReport() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Report Log");
		alert.setHeaderText("Fix Issues");	
		alert.setContentText("Added to repaired log");
		alert.showAndWait();
		
		return alert;
		
	}

}
