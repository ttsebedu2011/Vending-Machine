import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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

public class BankDetails {
	
	private static Label bankDetails, cardNumber, expiryDate, securityCode, creditAmount;
	
	public static TextField cardNumberText, expiryDateText, securityCodeText, creditAmountText;
	
	public static Button finish, cancel, back, confirmTopup;
	
	public static float inputCredit, toppedUpCredit;
	
	public static Stage window3;
	
	public static String creditCardNumber, expDate, secCode;
	
	public static char array[] = new char[16];
	
	public static void bankDetails() {
		
		window3 = new Stage();
		window3.setTitle("Bank Details");
		window3.initModality(Modality.APPLICATION_MODAL);
		
		GridPane grid =new GridPane();
        grid.setGridLinesVisible(false);  //not displays grid lines
        grid.setPadding( new Insets(10,10,10,10));
        grid.setStyle("-fx-background-color: lightblue");
//margins around the whole grid, top/right/bottom/left
//around each edge
        
        grid.setVgap(10);
//vertical gap in pixels

        grid.setHgap(10);
//horizontal gap in pixels
        
        bankDetails = new Label("Enter your bank details");
        bankDetails.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        bankDetails.setTextFill(Color.DARKBLUE);
        GridPane.setConstraints(bankDetails,0,0);
        
        cardNumber = new Label("Card Number");
        cardNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        cardNumber.setTextFill(Color.BLUE);
        GridPane.setConstraints(cardNumber,0,1);
        cardNumberText = new TextField();
        GridPane.setConstraints(cardNumberText, 1, 1);
        
        expiryDate = new Label("Expiry Date");
        expiryDate.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        expiryDate.setTextFill(Color.BLUE);
        GridPane.setConstraints(expiryDate,0,2);
        expiryDateText = new TextField();
        expiryDateText.setPromptText("MMyy");
        GridPane.setConstraints(expiryDateText,1,2);
        
        
        securityCode = new Label("Security Code");
        securityCode.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        securityCode.setTextFill(Color.BLUE);
        GridPane.setConstraints(securityCode,0,3);
        securityCodeText = new TextField();
        GridPane.setConstraints(securityCodeText,1,3);
        
        creditAmount = new Label("Credit Amount");
        creditAmount.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        creditAmount.setTextFill(Color.BLUE);
        GridPane.setConstraints(creditAmount,0,4);
        creditAmountText = new TextField();
        GridPane.setConstraints(creditAmountText,1,4);
        
        confirmTopup = new Button("Confirm TopUp");
        confirmTopup.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        confirmTopup.setTextFill(Color.DARKBLUE);
        confirmTopup.setOnAction(e -> {
        	
        	valid(creditAmountText);
        		
	        	System.out.println("Credit before topup" + toppedUpCredit);
	        	
	        	
	        	System.out.println("Top Up" + inputCredit);
	        	System.out.println("Topped up credit: " + toppedUpCredit);
	        	
	        	validateNumber();
	        	validateExpiryDate();
	        	validateSecurityNumber();
	        	valid(creditAmountText);
	        	
	        	// Validate Credit card number
	        	if(creditCardNumber.length() < 16 || creditCardNumber.length() > 16) {
	        		getCreditNumber();
	        		window3.show();
	        		cardNumberText.clear();
	        	}
	        	
	        	//Validate expiry Date
	        	else if(expDate.length() < 4 || expDate.length() > 4) {
	        		getExpiryDate();
	        		window3.show();
	        		expiryDateText.clear();
	        		
	        	}
	        	
	        	else if(secCode.length() <= 2 || secCode.length() >= 4) {
	        		getSecurityNumber();
	        		window3.show();
	        		securityCodeText.clear();
	        		
	        	}
	        		
	        	//Validate cash amount        	
	        	else if(inputCredit < 10) {
	        		getErrorCredit();
	        		window3.show();
	        		creditAmountText.clear();
	        		}
	        	
	        	else {
		        	getConfirmTopUp();
		        	
		        	window3.close();
		        	CreditClass.creditCustomer();
		        	CreditClass.numberOfFantaText.clear();
					CreditClass.fanta.setDisable(false);
					CreditClass.buy1.setDisable(true);
					CreditClass.numberOfFantaText.setDisable(true);
		        	        	
					CreditClass.numberOfSpriteText.clear();
					CreditClass.sprite.setDisable(false);
					CreditClass.buy2.setDisable(true);
					CreditClass.numberOfSpriteText.setDisable(true);
		        	
					CreditClass.numberOfCokeText.clear();
					CreditClass.coke.setDisable(false);      	
					CreditClass.buy3.setDisable(true);
					CreditClass.numberOfCokeText.setDisable(true);
		        	        	
					CreditClass.numberOfLucozadeText.clear();
					CreditClass.lucozade.setDisable(false);
					CreditClass.buy4.setDisable(true);
					CreditClass.numberOfLucozadeText.setDisable(true);
				
					WriteToFile.writeTofile();
		        	creditAmountText.clear();
	        	}
        	});
        GridPane.setConstraints(confirmTopup, 0, 5);
        //END OF CONFIRM TOPUP BUTTON
        
        back = new Button("Back");
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        back.setTextFill(Color.DARKBLUE);
        back.setOnAction(e -> {window3.close();
        		CreditClass.creditCustomer();
        		
        		CreditClass.numberOfFantaText.clear();
				CreditClass.fanta.setDisable(false);
				CreditClass.buy1.setDisable(true);
				CreditClass.numberOfFantaText.setDisable(true);
	        	        	
				CreditClass.numberOfSpriteText.clear();
				CreditClass.sprite.setDisable(false);
				CreditClass.buy2.setDisable(true);
				CreditClass.numberOfSpriteText.setDisable(true);
	        	
				CreditClass.numberOfCokeText.clear();
				CreditClass.coke.setDisable(false);      	
				CreditClass.buy3.setDisable(true);
				CreditClass.numberOfCokeText.setDisable(true);
	        	        	
				CreditClass.numberOfLucozadeText.clear();
				CreditClass.lucozade.setDisable(false);
				CreditClass.buy4.setDisable(true);
				CreditClass.numberOfLucozadeText.setDisable(true);
        		});
        GridPane.setConstraints(back, 1, 5);
        //END OF BACK BUTTON
        
        cancel = new Button("Cancel");//Cancel registration
        cancel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        cancel.setTextFill(Color.DARKBLUE);
        cancel.setOnAction(e -> window3.close());
        GridPane.setConstraints(cancel,2,5);
        //END OF CANCEL BUTTON
        
        finish = new Button("Finish");//Button to finish registration
        finish.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        finish.setTextFill(Color.DARKBLUE);
        finish.setOnAction(e -> {window3.close();
             
        	validateNumber();
        	validateExpiryDate();
        	validateSecurityNumber();
        	valid(creditAmountText);
        	
        	// Validate Credit card number
        	if(creditCardNumber.length() < 16 || creditCardNumber.length() > 16) {
        		getCreditNumber();
        		window3.show();
        		cardNumberText.clear();
        	}
        	
        	//Validate expiry Date
        	else if(expDate.length() < 4 || expDate.length() > 4) {
        		getExpiryDate();
        		window3.show();
        		expiryDateText.clear();
        		
        	}
        	
        	else if(secCode.length() <= 2 || secCode.length() >= 4) {
        		getSecurityNumber();
        		window3.show();
        		securityCodeText.clear();
        		
        	}
        		
        	//Validate cash amount        	
        	else if(inputCredit < 10) {
        		getErrorCredit();
        		window3.show();
        		creditAmountText.clear();
        		}
        	else {
	        	getConfirmationBox();
	        	WriteToFile.writeTofile();
	        	creditAmountText.clear();
	        	}
        });
        GridPane.setConstraints(finish,3,5);
        //END OF FINISH BUTTON
        
        HBox help1 = new HBox();
		Button help = new Button("Help");
		GridPane.setConstraints(help, 3, 15);
		help.setStyle("-fx-background-color: red");
		help.setOnAction(e -> { //If the button is clicked, you will get help window with small description
			getHelp(); 
		});
		help1.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		help1.getChildren().addAll(help);
        
		
        grid.getChildren().addAll(bankDetails, cardNumber, cardNumberText, expiryDate, expiryDateText,
        		securityCode, securityCodeText, creditAmount, creditAmountText, confirmTopup,back, cancel, finish, help);
        
        Scene scene = new Scene(grid, 400, 400);
        window3.setScene(scene);
        window3.show();  
        
	}
	
	
	
	public static boolean validateSecurityNumber() {
		secCode = securityCodeText.getText();
		if(!secCode.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static boolean validateExpiryDate() {
		expDate = expiryDateText.getText();
		if(!expDate.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	
	public static boolean validateNumber() {
		creditCardNumber = cardNumberText.getText();
		if(!creditCardNumber.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	
	public static boolean isFloat() {
		try {
			inputCredit = Float.parseFloat(creditAmountText.getText());
			System.out.println("Correct input: " + inputCredit);
			toppedUpCredit += inputCredit;
			return true;
		}catch(NumberFormatException e) {
			toppedUpCredit -= CreditClass.total;
			System.out.println( "Input is incorrect");
			return false;
		}
	}
	
	public static void getExpiryDate() { //Method what will give you alert box(error)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("ERROR");
		alert1.setHeaderText("Error in input");
		alert1.setContentText("Please enter expiry date, format MMyy!");
		alert1.showAndWait();
		
	}
	
	public static void getSecurityNumber() { //Method what will give you alert box(error)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("ERROR");
		alert1.setHeaderText("Error in input");
		alert1.setContentText("Please enter 3 digits!");
		alert1.showAndWait();
		
	}
	
	public static void getCreditNumber() { //Method what will give you alert box(error)
			
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("ERROR");
			alert1.setHeaderText("Error in input");
			alert1.setContentText("Please enter 16 digits!");
			alert1.showAndWait();
			
		}
	
	
	
	public static void getConfirmationBox() { //Method what will give you alert box(error)
		
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Registered Customer");
		alert1.setHeaderText("You are now a registered customer!");
		alert1.setContentText("You can use your e-mail as your username and your 4 digit pin to Login!");
		alert1.showAndWait();
		
	}
	
	public static void getConfirmTopUp() { //Method what will give you alert box(error)
		
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Topped Up");
		alert1.setHeaderText("You have topped up by €" + inputCredit);
		alert1.setContentText("Your top up has been confirmed!");
		alert1.showAndWait();
		
	}
	
	public static void getErrorCredit() { //Method what will give you alert box(error)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("ERROR");
		alert1.setHeaderText("Error in input");
		alert1.setContentText("Please enter €10 or more!");
		alert1.showAndWait();
		
	}
	
	public static void valid(TextField test) {
        try {
        	
            inputCredit = Float.parseFloat(test.getText());
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, you did not enter a number");
           // getErrorCredit();
            inputCredit = 0;
        }

    }
	
	 public static Alert getHelp() {//Method what will give you alert box with explanation what the user needs to do in the window

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Help Box");
			alert.setHeaderText("Hints and Tips");	
			alert.setContentText("1. Enter card number 16 digits only\n " 
								+ "2. Enter expiry date MMyy\n " 
								+ "3. Enter 3 digit security code\n " 
								+ "4. Enter credit amount\n " 
								+ "5. Click Finish to become a registered customer\n "
								+ "6. Click Cancel to cancel the registration");
			alert.showAndWait();
			
			return alert;
			
		}

}

