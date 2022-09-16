

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

public class RepairedLog {
	
	public static Label reportLabel, reportLabelCredit, titleLabel, todayDate, todayTime;
	
	public static Button fixIssues, back;
	
	public static Stage windowRepaired;
	
	public static Date currentDate;
	
	public static SimpleDateFormat timeFormat, dateFormat,
				dayOfTheWeekFormat, clockFormat;
	
	public static DatePicker date;
	
	public static void repairedLog() {
		
		windowRepaired = new Stage();
		windowRepaired.setTitle("Repair Report");
		windowRepaired.initModality(Modality.APPLICATION_MODAL);
		//title label for the window
		titleLabel = new Label("Repaired Issues");
		titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
		titleLabel.setTextFill(Color.DARKBLUE);
        titleLabel.setAlignment(Pos.CENTER_LEFT);
       
        
       
        //Creating labels to display information
        reportLabel = new Label("Cash customer Complaint: " + MaintenanceLog.repairedComplaint);
        reportLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
       
        
        reportLabelCredit = new Label("Credit customer Complaint: " + MaintenanceLog.repairedComplaintCredit);
        reportLabelCredit.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        todayDate = new Label("Date fixed: " + MaintenanceLog.repairedDate);
        todayDate.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        todayTime = new Label("Time fixed: " + MaintenanceLog.repairedTime);
        todayTime.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        
        back = new Button("Back");//back button to go back to managers table
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        back.setTextFill(Color.DARKBLUE);
        back.setOnAction(e ->{
        	windowRepaired.close();
        	TableManager.tableManager();
        	});
        //setting a vbox
        VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(titleLabel,todayDate,todayTime,reportLabel,reportLabelCredit,back); 
		
		Scene scene = new Scene(vb, 500, 300);
		windowRepaired.setScene(scene);
		windowRepaired.show();
	}
	
	

}
