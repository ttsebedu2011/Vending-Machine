import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
	
	public static TextField firstNameText, lastNameText, dobYearText, dobMonthText, dobDayText, emailText,
		pinNumberText, mobileNumberText, address1Text, address2Text, address3Text;
	
	private static ComboBox<String> genderCombo, countyCombo, countryCombo;
	
	private static Button proceed, cancel;
	
	private static Label detailsLabel, firstName, lastName, dob, gender, email, 
		pinNumber, mobileNumber, address1, address2, address3, county, country;
	
	public static Stage window2;
	
	public static int y, m, d, years;
	
	public static String validFirstName, validLastName,validEmail, validDOB, validPin, validPhone,
								validDay,validMonth, validYear, validAddress1;
	
	public static void registerDetails() {
		window2 = new Stage();
		window2.setTitle("Registration");
		window2.initModality(Modality.APPLICATION_MODAL);
		
		GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);  //not displays grid lines
        grid.setPadding( new Insets(10,10,10,10));
        grid.setStyle("-fx-background-color: lightblue");
//margins around the whole grid, top/right/bottom/left
//around each edge

        grid.setVgap(10);
//vertical gap in pixels

        grid.setHgap(10);
//horizontal gap in pixels

        detailsLabel = new Label("Enter your details");
        detailsLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        detailsLabel.setTextFill(Color.DARKBLUE);
        GridPane.setConstraints(detailsLabel,0,0); //column 0, row 0
//A child's placement within the grid is defined by it's layout constraints
       
        firstName = new Label("First Name:");
        firstName.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        firstName.setTextFill(Color.BLUE);
        GridPane.setConstraints(firstName,0,1);
        firstNameText  = new TextField();
        firstNameText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(firstNameText,1,1);  //child, column, row
        
        lastName = new Label("Last Name:");
        lastName.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        lastName.setTextFill(Color.BLUE);
        GridPane.setConstraints(lastName,0,2);
        lastNameText = new TextField();
        lastNameText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(lastNameText,1,2);
        
        dob = new Label("Date of Birth:");
        dob.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        dob.setTextFill(Color.BLUE);
        GridPane.setConstraints(dob,0,3);
        
        //Year textfield
        dobYearText = new TextField();
        dobYearText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        dobYearText.setPromptText("yyyy");
        dobYearText.setMaxWidth(50);
       // Month textfield
        dobMonthText = new TextField();
        dobMonthText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        dobMonthText.setPromptText("MM");
        dobMonthText.setMaxWidth(50);
      //  day textfield
        dobDayText = new TextField();
        dobDayText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        dobDayText.setPromptText("dd");
        dobDayText.setMaxWidth(50);
      
        //gender label and combo box
        gender = new Label("Gender:");
        gender.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        gender.setTextFill(Color.BLUE);
        GridPane.setConstraints(gender, 0, 4);
        genderCombo = new ComboBox<>();
        genderCombo.getItems().addAll("M", "F");
        GridPane.setConstraints(genderCombo,1,4);
        
        //email label and textfield
        email = new Label("E-Mail:");
        email.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        email.setTextFill(Color.BLUE);
        GridPane.setConstraints(email,0,5);
        emailText = new TextField();
        emailText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        emailText.setPromptText("example@gmail.com");
        GridPane.setConstraints(emailText,1,5);
        
        //pin number label and textfield
        pinNumber = new Label("Pin Number:");
        pinNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        pinNumber.setTextFill(Color.BLUE);
        GridPane.setConstraints(pinNumber,0,6);
        pinNumberText  =new TextField();
        pinNumberText.setPromptText("4-digit pin"); 
        pinNumberText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(pinNumberText,1,6);
        
        //mobile number label and textfield
        mobileNumber = new Label("Mobile Number:");
        mobileNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        mobileNumber.setTextFill(Color.BLUE);
        GridPane.setConstraints(mobileNumber,0,7);
        mobileNumberText = new TextField();
        mobileNumberText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(mobileNumberText,1,7);
        
        //address1 label and textfield
        address1 = new Label("Address Line 1:");
        address1.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        address1.setTextFill(Color.BLUE);
        GridPane.setConstraints(address1,0,8);
        address1Text = new TextField();
        address1Text.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(address1Text,1,8);
        
      //address2 label and textfield
        address2 = new Label("Address Line 2:");
        address2.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        address2.setTextFill(Color.BLUE);
        GridPane.setConstraints(address2,0,9);
        address2Text = new TextField();
        address2Text.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(address2Text,1,9);
        
      //address3 label and textfield
        address3 = new Label("Address Line 3:");
        address3.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        address3.setTextFill(Color.BLUE);
        GridPane.setConstraints(address3,0,10);
        address3Text = new TextField();
        address3Text.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(address3Text,1,10);
        
        //County label and combobox for counties
        county = new Label("County:");
        county.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        county.setTextFill(Color.BLUE);
        GridPane.setConstraints(county,0,11);
        countyCombo = new ComboBox<>();
        countyCombo.getItems().addAll("Cork", "Dublin", "Kerry", "Donegal","Limerick",
        		"Galway", "Mayo","Sligo", "Cavan", "Clare");
        countyCombo.setOnAction(e -> countryCombo.setDisable(true));
        GridPane.setConstraints(countyCombo,1,11);
        
        //country label and combobox
        country = new Label("Country:");
        country.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        country.setTextFill(Color.BLUE);
        GridPane.setConstraints(country,0,12);
        countryCombo = new ComboBox<>();
        countryCombo.getItems().addAll("South Africa", "Canada", "China", "USA", 
        		"Poland","England", "Scotland", "Australia", "Scotland", "Vietnam","Thailand");
        countryCombo.setOnAction(e -> countyCombo.setDisable(true));
        GridPane.setConstraints(countryCombo,1,12);
        
        //proceed button to continue with the registration
        proceed = new Button("Continue");
        proceed.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        proceed.setTextFill(Color.DARKBLUE);
        proceed.setOnAction(e -> {window2.close();
        	
        	validAddress1 = address1Text.getText();
        	//Call methods to validate input
        	validateFirstName();
        	validateLastName();
        	validatePinNumber();
        	validatePhoneNumber();
        	validateEmail();
        	validateYear();
        	validateMonth();
        	validateDay();
        	validateDate();
        	//check conditions
        	if(!validFirstName.matches("[a-zA-Z\\s']+")){
    			System.out.println("Incorrect input");
    			firstNameError();
    			firstNameText.clear();
    			window2.show();
        	}
        	
    		else if(!validLastName.matches("[a-zA-Z\\s']+")){
    			System.out.println("Incorrect input");
    			lastNameError();
    			lastNameText.clear();
    			window2.show(); 
        	}
        	
    		else if(validPin.length() < 4 || validPin.length() > 4) {
        		pinNumberError();
        		pinNumberText.clear();
        		window2.show();
        		
        	}
        	
    		else if(!validPhone.matches("[0-9]+" )) {
    			phoneNumberError();
    			mobileNumberText.clear();
    			window2.show();
    		}
        	
    		else if(!validEmail.matches("[a-zA-z0-9][a-zA-z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+")) {
    			emailError();
    			emailText.clear();
    			window2.show();
    		}
        	
    		else if (validYear.length() < 4 || validYear.length() > 4) {
    			yearError();
    			dobYearText.clear();
    			window2.show();
    			
    		}
        	
    		else if (validMonth.length() < 2 || validMonth.length() > 2) {
    			monthError();
    			dobMonthText.clear();
    			window2.show();
    			
    		}
        	
    		else if (validDay.length() < 2 || validDay.length() > 2) {
    			dayError();
    			dobDayText.clear();
    			window2.show();
    			
    		}
        	
        	
    		else if(years < 18) {
    			dobError();
    			dobYearText.clear();
    			dobMonthText.clear();
    			dobDayText.clear();
    			window2.show();
        		
    		}
        	
    		else if(validAddress1 == "") {
    			address1Error();
    			address1Text.clear();
    			window2.show();
    			
    		}
        	else { //conditions all ok proceed to next window
	            BankDetails.bankDetails();
	            BankDetails.back.setDisable(true);
	            BankDetails.confirmTopup.setDisable(true);
        	}
        });    
        
        
        GridPane.setConstraints(proceed,1,13);
       
        
        cancel = new Button("Cancel");//cancel button to cancel registration
        cancel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        cancel.setTextFill(Color.DARKBLUE);
        cancel.setOnAction(e -> window2.close());
        GridPane.setConstraints(cancel,1,14);
        
        HBox hb = new HBox();
        hb.setPadding(new Insets(10,10,10,10));
        hb.setAlignment(Pos.CENTER); // Align to center
        hb.setSpacing(10);
        hb.getChildren().addAll(dobYearText, dobMonthText, dobDayText);
        GridPane.setConstraints(hb, 1, 3);
        
        //creating the help button
        HBox help1 = new HBox();
		Button help = new Button("Help");
		GridPane.setConstraints(help, 3, 15);
		help.setStyle("-fx-background-color: red");
		help.setOnAction(e -> { //If the button is clicked, you will get help window with small description
			getHelp(); 
		});
		help1.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		help1.getChildren().addAll(help);

        grid.getChildren().addAll(detailsLabel, firstName, firstNameText, lastName, lastNameText, dob, hb, 
        		gender, genderCombo, email, emailText, pinNumber, pinNumberText, mobileNumber, mobileNumberText, address1, address1Text,
        		address2, address2Text, address3, address3Text, county, countyCombo, country, countryCombo, cancel, proceed, help);
        Scene scene = new Scene(grid, 400, 600);
        window2.setScene(scene);
        window2.show();
		
		
	}
	
	public static Alert address1Error() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Address line 1");
		alert1.setContentText("Enter your address!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	public static boolean validateDay() {//validate day
		validDay = dobDayText.getText();
		if(!validDay.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert dayError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Digits only");
		alert1.setContentText("Enter 2 numbers for day!");
		alert1.showAndWait();
		
		return alert1;
	}
	//END DAY
	
	public static boolean validateMonth() {//validate the month
		validMonth = dobMonthText.getText();
		if(!validMonth.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert monthError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Digits only");
		alert1.setContentText("Enter 2 numbers for month!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	//END MONTH
	
	public static boolean validateYear() {//validate the year
		validYear = dobYearText.getText();
		if(!validYear.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert yearError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Digits only");
		alert1.setContentText("Enter 4 numbers for year!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	//END YEAR
	
	public static void validateDate() {//calculating the age
		
		 validYear(dobYearText);
		 validMonth(dobMonthText);
		 validDay(dobDayText);
		 
		  if(y > 2020 || y < 1) {
 			yearError();
 			dobYearText.clear();
 			window2.show();
 		}
     	
 		else if(m > 12 || m < 1) {
 			monthError();
 			dobMonthText.clear();
 			window2.show();
 		}
     	
 		else if(d > 31 || d < 1) {
 			dayError();
 			dobDayText.clear();
 			window2.show();
 		}
		 
 		else {
				
			LocalDate today = LocalDate.now();
			LocalDate birthdate = LocalDate.of(y, m, d);
			 years = Period.between(birthdate, today).getYears();
			
			System.out.println(years);
 		}
	}
	
	//END OF VALIDATE DATE
	
	public static boolean validateEmail() {//validate text
		validEmail = emailText.getText();
		
		if(!validEmail.matches("[a-zA-z0-9][a-zA-z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+")){
			System.out.println("Incorrect input");
			return false;
			
		}else {
			System.out.println("Correct input");
			return true;
		}
	}
	
	//END OF EMAIL METHOD
	
	public static Alert dobError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Your under age");
		alert1.setContentText("You must be 18 or older to register!");
		alert1.showAndWait();
		
		return alert1;
	}
	//END OF DOB ERROR
	
	public static Alert emailError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Invalid email");
		alert1.setContentText("Please enter a valid email address!");
		alert1.showAndWait();
		
		return alert1;
	}
	//END OF EMAIL ERROR
	
	
	public static boolean validatePhoneNumber() {//valifate phone for digits
		validPhone = mobileNumberText.getText();
		if(!validPhone.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert phoneNumberError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Digits only");
		alert1.setContentText("Please enter a valid phone number!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	//END OF PHONE METHODS
	
	public static boolean validatePinNumber() {//validate pin number
		validPin = pinNumberText.getText();
		if(!validPin.matches("[0-9]+" )){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert pinNumberError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Digits only");
		alert1.setContentText("Please enter 4 digit pin!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	//END PIN NUMBER METHODS
	
	public static boolean validateFirstName() {//validate firstname
		validFirstName = firstNameText.getText();
		if(!validFirstName.matches("[a-zA-Z\\s']+")){
			System.out.println("Incorrect input");
			
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert firstNameError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Letters Only");
		alert1.setContentText("Please enter your Firstname!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	//END FIRST NAME METHODS
	
	public static boolean validateLastName() {//validate lastname
		validLastName = lastNameText.getText();
		if(!validLastName.matches("[a-zA-Z\\s']+")){
			System.out.println("Incorrect input");
			return false;
			
		}else
			
			System.out.println("Correct Input!");
			return true;
		
	}
	
	public static Alert lastNameError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Letters Only");
		alert1.setContentText("Please enter your Lastname!");
		alert1.showAndWait();
		
		return alert1;
	}
	//END LASTNAME METHODS
	
	
	
	public static void getFirstNameError() { //Method what will give you alert box(confirmation)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Error in First Name!");
		alert1.setContentText("Please enter letters only! ");
		
		alert1.showAndWait();
	}
	
	public static void getLastNameError() { //Method what will give you alert box(confirmation)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Error in Last Name!");
		alert1.setContentText("Please enter letters only! ");
		
		alert1.showAndWait();
	}
	
	public static void getConfirmationBox() { //Method what will give you alert box(error)
		
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setTitle("Validation Box");
		alert1.setHeaderText("Validation result!");
		alert1.setContentText("Validation is correct!");
		alert1.showAndWait();
		
	}
			
	public static Alert getLoginConfirmation() { //Method what will give you alert box(information)
		Alert alert1 = new Alert(AlertType.INFORMATION);
		alert1.setTitle("Login Details");
		alert1.setHeaderText("Login Information");
		alert1.setContentText("Username and Pin are correct!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	public static Alert getLoginError() { //Method what will give you alert box(error)
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Login Details");
		alert1.setHeaderText("Login Information");
		alert1.setContentText("Username and Password are not correct!");
		alert1.showAndWait();
		
		return alert1;
	}
	
	public static Alert getHelp() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");	
		alert.setContentText("Step by step registration:\n"
				+ "1. Enter your first name: Letters Only\n"
				+ "2. Enter your second name: Letters Only\n"
				+ "3. Date of Birth: yyyy/MM/dd\n"
				+ "4. Select Gender\n"
				+ "5. Enter your Email\n"
				+ "6. Enter 4 digit pin\n"
				+ "7. Mobile Number: Digits Only\n"
				+ "8. Enter Address line 1, 2 and 3\n"
				+ "9. Select County if you live in Ireland\n"
				+ "10. Select Country if you dont live in Ireland\n"
				+ "11. Click Continue to proceed or Cancel to stop");
				
		alert.showAndWait();
		
		return alert;
		
	}
	
	public static void validYear(TextField tests) {//change from string to integer
        try {
        	
            y = Integer.parseInt(tests.getText());
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Invalid input, you did not enter a number");
            window2.close();
            
        }

    }
	
	public static void validMonth(TextField tests) {//change from string to integer
        try {
        	
            m = Integer.parseInt(tests.getText());
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Invalid input, you did not enter a number");
            window2.close();
            
        }

    }
	
	public static void validDay(TextField tests) {//change from string to integer
        try {
        	
            d = Integer.parseInt(tests.getText());
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Invalid input, you did not enter a number");
            window2.close();
            
        }

    }
	

	
}