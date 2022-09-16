import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

//import java.awt.Font;
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

public class CustomerTable {
	
	public static Label stockLabel,
						drinks, price, quantity,menuLabel,
						fantaLabel, spriteLabel, cokeLabel, lucozadeLabel,
						priceCokeLabel, priceFantaLabel, priceSpriteLabel, priceLucozadeLabel,
						quantityFantaLabel, quantitySpriteLabel, quantityCokeLabel, quantityLucozadeLabel;
	
	public static int fantaQuantity = 20, spriteQuantity = 20, cokeQuantity = 20, lucozadeQuantity = 20;
	
	public static RadioButton fanta, coke, sprite, lucozade;
	
	public static TextField fantaText, cokeText, spriteText, lucozadeText, 
				numberOfFantaText, numberOfCokeText, numberOfSpriteText, numberOfLucozadeText,reportText;
	
	public static Button buy1, buy2, buy3, buy4, cancel, back, addReport;
	
	public static float input;
	
	public static int inputDrinks;
	
	public static Stage window2;
	
	public static String complaint;
	
	public static void customerTable() {
		
		window2 = new Stage();
		window2.setTitle("Cash Customer Drinks Menu");
		window2.initModality(Modality.APPLICATION_MODAL);
		ToggleGroup radioButtonGroup = new ToggleGroup();
		
		
		//detailsLabel.setText(message); 
		//detailsLabel.setStyle("-fx-text-fill: yellow");
		GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);  //displays grid lines
        grid.setPadding( new Insets(10,10,10,10));
        grid.setStyle("-fx-background-color: lightblue");
//margins around the whole grid, top/right/bottom/left
//around each edge

        grid.setVgap(10);
//vertical gap in pixels

        grid.setHgap(10);
//horizontal gap in pixels
        
        stockLabel = new Label("Drinks in Stock");
        stockLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        //stockLabel.setAlignment(Pos.CENTER_RIGHT);
        stockLabel.setTextFill(Color.DARKBLUE);
        GridPane.setConstraints(stockLabel,0,0); //column 0, row 0
//A child's placement within the grid is defined by it's layout constraints
        
        drinks = new Label("Drinks");
        drinks.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
        drinks.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(drinks,0,1);
        
        price = new Label("Price");
        price.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
        price.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(price,1,1);
        
        quantity = new Label("Quantity");
        quantity.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
        quantity.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(quantity, 2,1);
        
        //drinks in stock
        //creating labels to display drinks in stock
        fantaLabel = new Label("Fanta");
        fantaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        fantaLabel.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(fantaLabel, 0,2);
        priceFantaLabel = new Label("€1.20");
        priceFantaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        priceFantaLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(priceFantaLabel, 1, 2);
        quantityFantaLabel = new Label(" " + fantaQuantity);
        quantityFantaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        quantityFantaLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(quantityFantaLabel,2,2);
        
        cokeLabel = new Label("Coke");
        cokeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        cokeLabel.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(cokeLabel, 0, 3);
        priceCokeLabel = new Label("€1.20");
        priceCokeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        priceCokeLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(priceCokeLabel, 1, 3);
        quantityCokeLabel = new Label(" " + cokeQuantity);
        quantityCokeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        quantityCokeLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(quantityCokeLabel,2,3);
        
        spriteLabel = new Label("Sprite");
        spriteLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        spriteLabel.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(spriteLabel, 0, 4);
        priceSpriteLabel = new Label("€1.20");
        priceSpriteLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        priceSpriteLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(priceSpriteLabel, 1, 4);
        quantitySpriteLabel = new Label(" " + spriteQuantity);
        quantitySpriteLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        quantitySpriteLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(quantitySpriteLabel,2,4);
        
        lucozadeLabel = new Label("Lucozade");
        lucozadeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        lucozadeLabel.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(lucozadeLabel, 0, 5);
        priceLucozadeLabel = new Label("€1.20");
        priceLucozadeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        priceLucozadeLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(priceLucozadeLabel, 1, 5);
        quantityLucozadeLabel = new Label(" " + lucozadeQuantity);
        quantityLucozadeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        quantityLucozadeLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(quantityLucozadeLabel,2,5);
        
        
        
       // Stage windowMenu = new Stage();
	//	windowMenu.setTitle("Drinks Menu");
		GridPane gridMenu = new GridPane();
		GridPane.setConstraints(gridMenu, 3, 8);
        gridMenu.setGridLinesVisible(false);  //not displays grid lines
        gridMenu.setPadding( new Insets(10,10,10,10));
        gridMenu.setStyle("-fx-background-color: lightblue");
//margins around the whole grid, top/right/bottom/left
//around each edge
        gridMenu.setVgap(10);
//vertical gap in pixels
        gridMenu.setHgap(10);
//horizontal gap in pixels
        menuLabel = new Label("Select a drink");
        menuLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        menuLabel.setTextFill(Color.DARKBLUE);
        GridPane.setConstraints(menuLabel,0,0); //column 0, row 0
//A child's placement within the grid is defined by it's layout constraints
        
        fanta = new RadioButton("Fanta");
        fanta.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        fanta.setTooltip(new Tooltip("Select Fanta"));
        fanta.setTextFill(Color.BLUEVIOLET);
        fanta.setToggleGroup(radioButtonGroup);
        fanta.setOnAction(e -> {System.out.println("fanta selected");
      //enable and disable textfields, radiobuttons and buttons	
        	fantaText.setDisable(false);
        	numberOfFantaText.setDisable(false);
        	buy1.setDisable(false);
        
        	sprite.setDisable(true);
        	spriteText.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	buy2.setDisable(true);
        	
        	coke.setDisable(true);
        	cokeText.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	buy3.setDisable(true);
        	
        	lucozade.setDisable(true);
        	lucozadeText.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
        	buy4.setDisable(true);
        	});
        GridPane.setConstraints(fanta,0,1);
        
        numberOfFantaText = new TextField();//textfield for number of drinks
        numberOfFantaText.setPromptText("Enter number of drinks");
        numberOfFantaText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfFantaText, 1, 1);
        
        fantaText = new TextField();//textfield for cash
        fantaText.setPromptText("Enter Cash");
        fantaText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(fantaText,2,1);
        
        buy1 = new Button("Buy"); //button to buy fanta
        buy1.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy1.setTextFill(Color.BLUEVIOLET);
        buy1.setOnAction(e -> {
        	
        	
        	
        	valids(numberOfFantaText);//validate input
        	System.out.println(inputDrinks);        	
        	valid(fantaText);//validate input
        	System.out.println(input);
        	//validation before calculations
        	if(fantaQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	else if(fantaQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}
        	
        	
        	else if(input < (1.20*inputDrinks)) {
        		getAmountError();
        		fantaText.clear();
        		System.out.println(input);
        	}
        	
        	else if(!(isInt(numberOfFantaText, numberOfFantaText.getText()))) {
        		inputDrinks = 0;
        		numberOfFantaText.clear();
        		fantaText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	
        	else if(!(isFloat(fantaText, fantaText.getText()))) {
        		input = 0;
        		fantaText.clear();
        		numberOfFantaText.clear();        		
        		System.out.println(input);
        	}
        		
        	else {
        		window2.close();
        		ChangeMessage.noChange();
        	}	
        	
        });
        GridPane.setConstraints(buy1,3,1);
        ///END OF FANTA
        
        coke = new RadioButton("Coke");//radio button for coke 
        coke.setTooltip(new Tooltip("Select Coke"));
        coke.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        coke.setTextFill(Color.BLUE);
        coke.setToggleGroup(radioButtonGroup);
        coke.setOnAction(e -> {System.out.println("coke selected");
      //enable and disable textfields, radiobuttons and buttons	
        	cokeText.setDisable(false);
        	numberOfCokeText.setDisable(false);
        	buy2.setDisable(false);
        
	        sprite.setDisable(true);
	    	spriteText.setDisable(true);
	    	numberOfSpriteText.setDisable(true);
	    	buy3.setDisable(true);
	    	
	    	fanta.setDisable(true);
	    	fantaText.setDisable(true);
	    	numberOfFantaText.setDisable(true);
	    	buy1.setDisable(true);
	    	
	    	lucozade.setDisable(true);
	    	lucozadeText.setDisable(true);
	    	numberOfLucozadeText.setDisable(true);
	    	buy4.setDisable(true);
	    	
        	});
        GridPane.setConstraints(coke,0,2);
        
        numberOfCokeText = new TextField();//textfield for number of drinks
        numberOfCokeText.setPromptText("Enter number of drinks");
        GridPane.setConstraints(numberOfCokeText, 1, 2);
        
        cokeText = new TextField();//textfield for cash
        cokeText.setPromptText("Enter Cash");
        GridPane.setConstraints(cokeText,2,2);
        
        buy2 = new Button("Buy"); //button to buy coke
        buy2.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy2.setTextFill(Color.BLUE);
        buy2.setOnAction(e -> {
        	
        	valids(numberOfCokeText);//validate input
        	System.out.println(inputDrinks);
        	valid(cokeText);//validate input
        	System.out.println(input);
        	//validations before calculations
        	if(cokeQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	else if(cokeQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}
        	
        	
        	else if(input < (1.20*inputDrinks)) {
        		getAmountError();
        		cokeText.clear();
        	}
        	
        	else if(!(isInt(numberOfCokeText, numberOfCokeText.getText()))) {
        		inputDrinks = 0;
        		numberOfCokeText.clear();
        		cokeText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	else if(!(isFloat(cokeText, cokeText.getText()))) {
        		input = 0;
        		cokeText.clear();
        		numberOfCokeText.clear();        		
        		System.out.println(input);
        	}
        	
        	else {
        		window2.close();
        		ChangeMessage.noChange();
        	}
        });
        GridPane.setConstraints(buy2,3,2);
        //end of coke
        
        sprite = new RadioButton("Sprite");
        sprite.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        sprite.setTooltip(new Tooltip("Select Sprite"));
        sprite.setTextFill(Color.BLUEVIOLET);
        sprite.setToggleGroup(radioButtonGroup);
        sprite.setOnAction(e -> {System.out.println("sprite selected");
      //enable and disable textfields, radiobuttons and buttons
        	spriteText.setDisable(false);
        	numberOfSpriteText.setDisable(false);
        	buy3.setDisable(false);
        
	        fanta.setDisable(true);
	    	fantaText.setDisable(true);
	    	numberOfFantaText.setDisable(true);
	    	buy1.setDisable(true);
	    	
	    	coke.setDisable(true);
	    	cokeText.setDisable(true);
	    	numberOfCokeText.setDisable(true);
	    	buy2.setDisable(true);
	    	
	    	lucozade.setDisable(true);
	    	lucozadeText.setDisable(true);
	    	numberOfLucozadeText.setDisable(true);
	    	buy4.setDisable(true);
	    	
        	});
        GridPane.setConstraints(sprite,0,3);
        
        numberOfSpriteText = new TextField();
        numberOfSpriteText.setPromptText("Enter number of drinks");
        GridPane.setConstraints(numberOfSpriteText, 1, 3);
        
        spriteText = new TextField();
        spriteText.setPromptText("Enter Cash");
        GridPane.setConstraints(spriteText,2,3);
        buy3 = new Button("Buy");
        buy3.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy3.setTextFill(Color.BLUEVIOLET);
        buy3.setOnAction(e -> {
        	
        	valids(numberOfSpriteText);
        	System.out.println(inputDrinks);
        	valid(spriteText);
        	System.out.println(input);
        	
        	if(spriteQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	else if(spriteQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}
        	
        	
        	else if(input < (1.20*inputDrinks)) {
        		getAmountError();
        		spriteText.clear();
        	}
        	
        	else if(!(isInt(numberOfSpriteText, numberOfSpriteText.getText()))) {
        		inputDrinks = 0;
        		numberOfSpriteText.clear();
        		spriteText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	else if(!(isFloat(spriteText, spriteText.getText()))) {
        		input = 0;
        		spriteText.clear();
        		numberOfSpriteText.clear();        		
        		System.out.println(input);
        	}
        	
        	else {
        		window2.close();
        		ChangeMessage.noChange();
        	}
        	
        });
        GridPane.setConstraints(buy3,3,3);
        //end of sprite
        
        lucozade = new RadioButton("Lucozade");
        lucozade.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        lucozade.setTooltip(new Tooltip("Select Lucozade"));
        lucozade.setTextFill(Color.BLUE);
        lucozade.setToggleGroup(radioButtonGroup);
        lucozade.setOnAction(e -> {System.out.println("lucozade selected");
      //enable and disable textfields, radiobuttons and buttons
        	lucozadeText.setDisable(false);
        	numberOfLucozadeText.setDisable(false);
        	buy4.setDisable(false);
        
	        sprite.setDisable(true);
	    	spriteText.setDisable(true);
	    	numberOfSpriteText.setDisable(true);
	    	buy3.setDisable(true);
	    	
	    	coke.setDisable(true);
	    	cokeText.setDisable(true);
	    	numberOfCokeText.setDisable(true);
	    	buy2.setDisable(true);
	    	
	    	fanta.setDisable(true);
	    	fantaText.setDisable(true);
	    	numberOfFantaText.setDisable(true);
	    	buy1.setDisable(true);
	    	
        	});
        GridPane.setConstraints(lucozade,0,4);
        
        numberOfLucozadeText = new TextField();//textfield to enter number of drinks
        numberOfLucozadeText.setPromptText("Enter number of drinks");
        GridPane.setConstraints(numberOfLucozadeText, 1, 4);
        
        lucozadeText = new TextField();//textfield to enter cash amount
        lucozadeText.setPromptText("Enter Cash");
        GridPane.setConstraints(lucozadeText,2,4);
        buy4 = new Button("Buy");//button to buy drinks
        buy4.setTextFill(Color.BLUE);
        buy4.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy4.setOnAction(e -> {
        	        	        	
        	valids(numberOfLucozadeText);//validate number of drinks
        	System.out.println(inputDrinks);
        	valid(lucozadeText);//validate cash
        	System.out.println(input);
        	//validate before calculations
        	if(lucozadeQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	else if(lucozadeQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}
        	
        	
        	else if(input < (1.20*inputDrinks)) {
        		getAmountError();
        		lucozadeText.clear();
        	}
        	
        	else if(!(isInt(numberOfLucozadeText, numberOfLucozadeText.getText()))) {
        		inputDrinks = 0;
        		numberOfLucozadeText.clear();
        		lucozadeText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	else if(!(isFloat(lucozadeText, lucozadeText.getText()))) {
        		input = 0;
        		lucozadeText.clear();
        		numberOfLucozadeText.clear();        		
        		System.out.println(input);
        	}
        	
        	else {
        		window2.close();
        		ChangeMessage.noChange();
        	}
        	
        });
        GridPane.setConstraints(buy4,3,4);
        //END OF LUCOZADE
        
        back = new Button("Back");//button to go back login
        back.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        back.setTextFill(Color.DARKBLUE);
        back.setOnAction(e -> window2.close());
        GridPane.setConstraints(back,0,5);
        //END OF BACK
        
        cancel = new Button("Cancel");//cancel the order
        cancel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        cancel.setTextFill(Color.DARKBLUE);
        cancel.setOnAction(e -> {
        	//enable and disable textfields, radiobuttons and buttons
        	fantaText.clear();
        	numberOfFantaText.clear();
        	fanta.setDisable(false);
        	buy1.setDisable(true);
        	fantaText.setDisable(true);
        	numberOfFantaText.setDisable(true);
        	
        	spriteText.clear();
        	numberOfSpriteText.clear();
        	sprite.setDisable(false);
        	spriteText.setDisable(true);
        	buy2.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	
        	
        	cokeText.clear();
        	numberOfCokeText.clear();
        	coke.setDisable(false);
        	cokeText.setDisable(true);
        	buy3.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	
        	lucozadeText.clear();
        	numberOfLucozadeText.clear();
        	lucozade.setDisable(false);
        	lucozadeText.setDisable(true);
        	buy4.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
        	
        });
        
        GridPane.setConstraints(cancel,1,5);
        //END OF CANCEL
        
      
        //set up vbox for textfield and button for complaints
        VBox vb = new VBox(10);
        reportText = new TextField();//textfield to write a complaint 
        reportText.setPromptText("Write a Complaint");
        reportText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        reportText.setMinWidth(200);
        reportText.setMinHeight(50);
        
        addReport = new Button("Add Complaint");//button to add complaint
        addReport.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        addReport.setTextFill(Color.DARKBLUE);
        addReport.setOnAction(e -> {
        				complaint = reportText.getText();
        				reportText.clear();     				
        				submitComplaint();
        				
        				;});
        
        GridPane.setConstraints(vb, 0, 6);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(reportText, addReport); 
        
        
       
        
        HBox help1 = new HBox();
		Button help = new Button("Help");
		GridPane.setConstraints(help, 3, 6);
		help.setStyle("-fx-background-color: red");
		help.setOnAction(e -> { //If the button is clicked, you will get help window with small description
			getHelp(); 
		});
		help1.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		help1.getChildren().addAll(help);
		//add all the children
        gridMenu.getChildren().addAll(menuLabel, fanta,numberOfFantaText, fantaText, buy1, coke,numberOfCokeText, cokeText, buy2, sprite, 
        		numberOfSpriteText,spriteText, buy3, lucozade, numberOfLucozadeText,lucozadeText, buy4, back, cancel, vb, help);
        
        grid.getChildren().addAll(stockLabel,drinks,price,quantity,fantaLabel,cokeLabel,spriteLabel,lucozadeLabel, 
        		priceFantaLabel,priceCokeLabel,priceSpriteLabel,priceLucozadeLabel,
        		quantityFantaLabel,quantityCokeLabel,quantitySpriteLabel,quantityLucozadeLabel, gridMenu);
        
        Scene scene = new Scene(grid, 400, 600);
        window2.setScene(scene);
        window2.show();
		
       
	}
	
	public static boolean isFloat(TextField drinkInput, String message) {//check if the input is a float
		try {
			input = Float.parseFloat(drinkInput.getText());
			System.out.println("Correct input: " + input);
			return true;
		}catch(NumberFormatException e) {
			System.out.println(message + "is in correct");
			input = 0;
			return false;
		}
	}
	
	
	public static boolean isInt(TextField drinkInput, String message) {//check if the input is an int
		try {
			inputDrinks = Integer.parseInt(drinkInput.getText());
			System.out.println("Correct input: " + inputDrinks);
			return true;
		}catch(NumberFormatException e) {
			System.out.println(message + "is in correct");
			return false;
		}
	}
	
	
	
	public static void getInputError() { //Method what will give you alert box(confirmation)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error");
		alert1.setHeaderText("Error in input!");
		alert1.setContentText("Please enter a number! ");
		input = 0;
		alert1.showAndWait();
		
		
	}
	
	public static Alert submitComplaint() {//Method that has an alert box with information for the user

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Complaints");
		alert.setHeaderText(reportText.getText());	
		alert.setContentText("Complaint submitted");
		alert.showAndWait();
		return alert;
		
	}
	
	public static Alert getHelp() {//Method that has an alert box with information for the user

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help Box");
		alert.setHeaderText("Hints and Tips");	
		alert.setContentText("Steps to buy a drink\n"
				+ "1. Select a drink\n"
				+ "2. Enter number of drinks\n"
				+ "3. Enter Cash\n"
				+ "4. Click Buy to finish the process\n"
				+ "5. Click Back to go to Login screen\n"
				+ "6. Click Cancel to cancel order\n"
				+ "7. Write a complaint and click Add Complaint\n"
				+ "8. Your complaint will be saved on our system\n"
				);
				
		alert.showAndWait();
		
		return alert;
		
	}
		
	
	public static Alert getThankYou() {//Method that has an alert box with information for the user

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Thank You");
		alert.setHeaderText("Thank You Note");	
		alert.setContentText("Thank You for your purchase");
		alert.showAndWait();
		
		return alert;
		
	}
		
	
	public static Alert getChange() {//Method that has an alert box with information for the user

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Change Information");
		alert.setHeaderText("Hints and Tips");	
		alert.setContentText("The machine dont give change, click continue to proceed or cancel order to go back");
		alert.showAndWait();
		
		return alert;
		
	}
	
	public static Alert getOutOfStock() {//Method that has an alert box with information for the user

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Drinks out of stock");
		alert.setHeaderText("Out Of Stock");	
		alert.setContentText("The drink you selected is out of stock," + 
							"Please select a different drink.");
		alert.showAndWait();
		
		return alert;
		
	}
	
	public static Alert getQuantityError() {//Method that has an alert box with information for the user

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("We dont have enough in stock!");	
		alert.setContentText("Please enter a lesser number of drinks," + 
							"or select a different drink.");
		alert.showAndWait();
		
		return alert;
		
	}
	
	
	
	public static void getAmountError() { //Method that has an alert box with information for the user
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error Amount");
		alert1.setHeaderText("Error in the amount!");
		alert1.setContentText("The amount entered is less than the amount required, "
				+ "Please enter a different amount! ");
		
		alert1.showAndWait();
		
	}
	
	public static void valid(TextField test) {//turn input string to float
        try {
        	
            input = Float.parseFloat(test.getText());
            
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, you did not enter a number");
            window2.close();
            getInputError();
            customerTable();
            //clear textboxes enable and disable radio button, textfields and buttons
            fantaText.clear();
        	numberOfFantaText.clear();
        	fanta.setDisable(false);
        	buy1.setDisable(true);
        	fantaText.setDisable(true);
        	numberOfFantaText.setDisable(true);
        	
        	spriteText.clear();
        	numberOfSpriteText.clear();
        	sprite.setDisable(false);
        	spriteText.setDisable(true);
        	buy2.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	
        	
        	cokeText.clear();
        	numberOfCokeText.clear();
        	coke.setDisable(false);
        	cokeText.setDisable(true);
        	buy3.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	
        	lucozadeText.clear();
        	numberOfLucozadeText.clear();
        	lucozade.setDisable(false);
        	lucozadeText.setDisable(true);
        	buy4.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
            input = 0;
            
        }

    }
	
	public static void valids(TextField tests) {//turn string to integer
        try {
        	
            inputDrinks = Integer.parseInt(tests.getText());
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Invalid input, you did not enter a number");
            window2.close();
            getInputError();
            customerTable();
            //clear textboxes enable and disable radio button, textfields and buttons
            fantaText.clear();
        	numberOfFantaText.clear();
        	fanta.setDisable(false);
        	buy1.setDisable(true);
        	fantaText.setDisable(true);
        	numberOfFantaText.setDisable(true);
        	
        	spriteText.clear();
        	numberOfSpriteText.clear();
        	sprite.setDisable(false);
        	spriteText.setDisable(true);
        	buy2.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	
        	
        	cokeText.clear();
        	numberOfCokeText.clear();
        	coke.setDisable(false);
        	cokeText.setDisable(true);
        	buy3.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	
        	lucozadeText.clear();
        	numberOfLucozadeText.clear();
        	lucozade.setDisable(false);
        	lucozadeText.setDisable(true);
        	buy4.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
            inputDrinks = 0;
        }

    }

}
