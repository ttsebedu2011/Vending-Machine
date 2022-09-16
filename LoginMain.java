

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
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class LoginMain extends Application {
	public static Stage window;
	public static Scene scene;
	public static Label login, username, pinNumber;
	public static TextField userNameText;
	public static PasswordField pinText;
	public static Button loginButton, registerButton, guestButton;
			

    public static void main(String[] args) {
    	
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	window = primaryStage;
    	
    	
    	window.setTitle("Vending Machine"); //setting title of the window
    	
    
		login = new Label();//creating label for the scene
		login.setText("Enter your Username and Pin"); 
		login.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		login.setTextFill(Color.DARKBLUE);
        
		username = new Label(); //creating username label
		username.setText("User Name: "); 
		username.setFont(Font.font("Times New Roman", FontWeight.BOLD,14)); 
		username.setTextFill(Color.BLUE);
		
		userNameText = new TextField(); // creating textfield for input
		userNameText.setPrefWidth(200);
		userNameText.setMaxWidth(200); //setting size of the textfield
		userNameText.setPromptText("User Name"); 
		userNameText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		userNameText.setTooltip(new Tooltip("Enter your username"));
		
		pinNumber = new Label(); //Creating password label
		pinNumber.setText("Pin: "); 
		pinNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD,14)); 
		pinNumber.setTextFill(Color.BLUE);
		
		pinText = new PasswordField(); // creating password field with hidden text
		pinText.setMaxWidth(200);
		pinText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		pinText.setTooltip(new Tooltip("Enter your pin number"));
		
		loginButton = new Button("Login"); //creating login button
		loginButton.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		loginButton.setTextFill(Color.DARKBLUE);
		loginButton.setOnAction(e -> {
			
		//WriteToFile.writeTofile();	
		
		
			
		ReadFromFile.readTheFile("Registration.txt");
					
					String checkUserName = ReadFromFile.userName;
					String checkPin = ReadFromFile.pin;
					
					String checkUserCustomer = ReadFromFile.userCustomer;
					String checkPinCustomer = ReadFromFile.pinCustomer;
					
					//System.out.println(checkUserName);
					System.out.println("username: " + checkUserName);
					System.out.println("pin: " + checkPin);
					
					//Check the pin and password if they are correct for manager
					if(userNameText.getText().equals(checkUserName) && pinText.getText().equals(checkPin)) {
						Register.getLoginConfirmation();
						System.out.println("Logged in successfully" + checkUserName + checkPin);
						pinText.clear();
						userNameText.clear();
						TableManager.tableManager();
					}
					
					//Check the pin and password for registered customer
					else if(userNameText.getText().equals(checkUserCustomer) && pinText.getText().equals(checkPinCustomer)) {
						Register.getLoginConfirmation();
						System.out.println("Logged in successfully" + checkUserCustomer + checkPinCustomer);
						pinText.clear();
						userNameText.clear();
						//CreditClass.creditCustomer();
								if(BankDetails.toppedUpCredit < 2) {
									getCustomerCredit();
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
								}
								else {
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
								}
								
								
					
					
					}else {
						Register.getLoginError();
					}
					
					System.out.println(checkUserName);
					System.out.println(checkPin);
					System.out.println(checkUserCustomer);
					System.out.println(checkPinCustomer);
					//END OF CUSTOMER				
					
			
					
		});
		
		
		registerButton = new Button("Register"); //creating register button
		registerButton.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		registerButton.setTextFill(Color.DARKBLUE);
		registerButton.setOnAction(e -> {Register.registerDetails();});
		
		guestButton = new Button("Guest");
		guestButton.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
		guestButton.setTextFill(Color.DARKBLUE);
		guestButton.setOnAction(e -> {
			CustomerTable.customerTable();
			CustomerTable.fantaText.setDisable(true);
			CustomerTable.numberOfFantaText.setDisable(true);
			CustomerTable.buy1.setDisable(true);
			
			CustomerTable.cokeText.setDisable(true);
			CustomerTable.numberOfCokeText.setDisable(true);
			CustomerTable.buy2.setDisable(true);
			
			CustomerTable.spriteText.setDisable(true);
			CustomerTable.numberOfSpriteText.setDisable(true);
			CustomerTable.buy3.setDisable(true);
			
			CustomerTable.lucozadeText.setDisable(true);
			CustomerTable.numberOfLucozadeText.setDisable(true);
			CustomerTable.buy4.setDisable(true);
			
						});
		
		HBox help1 = new HBox();
		Button help = new Button("Help");
		GridPane.setConstraints(help, 3, 15);
		help.setStyle("-fx-background-color: red");
		help.setOnAction(e -> { //If the button is clicked, you will get help window with small description
			getHelpLogin(); 
		});
		help1.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		help1.getChildren().addAll(help);
		
		HBox hb = new HBox();
        hb.setPadding(new Insets(10,10,10,10));
        hb.setAlignment(Pos.CENTER); // Align to center
        hb.setSpacing(10);
        hb.getChildren().addAll(loginButton, registerButton, guestButton);
        
		
		VBox vb = new VBox(10);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(login, username, userNameText, pinNumber, pinText, hb,help); 
		
		scene = new Scene(vb, 500, 300);
		window.setScene(scene);
		window.show();
		
										
    }
    
    public static Alert getHelpLogin() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");	
		alert.setContentText("1. Enter your user name and pin to Login\n " 
							+ "2. If you dont have Username and Pin you can register\n " 
							+ "or you can enter as a guest");
		alert.showAndWait();
		
		return alert;
		
	}
    
    public static Alert getCustomerCredit() { //Method what will give you alert box(information)
		Alert alert1 = new Alert(AlertType.INFORMATION);
		alert1.setTitle("Credit Amount");
		alert1.setHeaderText("Balance Information");
		alert1.setContentText("Your Balance is less than €2!");
		alert1.showAndWait();
		
		return alert1;
	}

   
}