
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

public class CreditClass {
	
	public static Label stockLabel,
						drinks, price, quantity,menuLabel,
						fantaLabel, spriteLabel, cokeLabel, lucozadeLabel,
						priceCokeLabel, priceFantaLabel, priceSpriteLabel, priceLucozadeLabel,
						quantityFantaLabel, quantitySpriteLabel, quantityCokeLabel, quantityLucozadeLabel;
	
	public static RadioButton fanta, coke, sprite, lucozade;
	
	public static TextField numberOfFantaText, numberOfCokeText, numberOfSpriteText, numberOfLucozadeText, reportsText;
	
	public static Button buy1, buy2, buy3, buy4, cancel, logOut, topUp, addReports;
	
	public static int fantaTotalCredit , spriteTotalCredit, cokeTotalCredit, lucozadeTotalCredit, totalNumDrinksCredit;
	
	public static int inputDrinks;
	
	public static float total, grandTotal,
						totalAmountFanta,totalAmountCoke, totalAmountSprite, totalAmountLucozade;
	
	public static String complaints;
	
	public static Stage windowCredit;
	
	public static void creditCustomer() {
		
		windowCredit = new Stage();
		windowCredit.setTitle("Credit Customer Drinks Menu");
		windowCredit.initModality(Modality.APPLICATION_MODAL);
		ToggleGroup radioButtonGroup = new ToggleGroup();		
		
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
        
        //Setting up Labels to display menu
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
        
        fantaLabel = new Label("Fanta");
        fantaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        fantaLabel.setTextFill(Color.BLUEVIOLET);
        GridPane.setConstraints(fantaLabel, 0,2);
        priceFantaLabel = new Label("€1.20");
        priceFantaLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        priceFantaLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(priceFantaLabel, 1, 2);
        quantityFantaLabel = new Label(" " + CustomerTable.fantaQuantity);
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
        quantityCokeLabel = new Label(" " + CustomerTable.cokeQuantity);
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
        quantitySpriteLabel = new Label(" " + CustomerTable.spriteQuantity);
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
        quantityLucozadeLabel = new Label(" " + CustomerTable.lucozadeQuantity);
        quantityLucozadeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        quantityLucozadeLabel.setTextFill(Color.BLUE);
        GridPane.setConstraints(quantityLucozadeLabel,2,5);
        
        
        
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
//Setting up constraints
        
        //Creating radio button for fanta
        fanta = new RadioButton("Fanta");
        fanta.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        fanta.setTooltip(new Tooltip("Select Fanta"));
        fanta.setTextFill(Color.BLUEVIOLET);
        fanta.setToggleGroup(radioButtonGroup);
        fanta.setOnAction(e -> {System.out.println("fanta selected");
        	//Disable and enable textfield, buttons and radio buttons
        	numberOfFantaText.setDisable(false);
        	buy1.setDisable(false);
        
        	sprite.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	buy2.setDisable(true);
        	
        	coke.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	buy3.setDisable(true);
        	
        	lucozade.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
        	buy4.setDisable(true);
        	});
        GridPane.setConstraints(fanta,0,1);
        //Textfield for number of drinks
        numberOfFantaText = new TextField();
        numberOfFantaText.setPromptText("Enter number of drinks");
        numberOfFantaText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfFantaText, 1, 1);
        
        buy1 = new Button("Buy"); //button to buy fanta
        buy1.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy1.setTextFill(Color.BLUEVIOLET);
        buy1.setOnAction(e -> {
        	
        	valids(numberOfFantaText);//validate input from string to integer
        	System.out.println(inputDrinks);
        	
        	//Validations before calculating for the drink
        	if(CustomerTable.fantaQuantity <= 0) {
        		getOutOfStock();	
        	}
        	else if(CustomerTable.fantaQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}	
        	
        	else if(BankDetails.toppedUpCredit < (1.15*inputDrinks)) {
        		getAmountError();
        	}
        	
        	else if(!(isInt(numberOfFantaText, numberOfFantaText.getText()))) {
        		inputDrinks = 0;
        		numberOfFantaText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	
        	else {
        		//Calculations for buying a drink
        		CustomerTable.fantaQuantity -= inputDrinks;
        		System.out.println(inputDrinks);
        		
        		total = 1.15f * inputDrinks;
        		WriteToFile.writeTofile();        		
        		totalAmountFanta += total;
        		
        		fantaTotalCredit += inputDrinks;
        		System.out.println("Credit balance: " + BankDetails.toppedUpCredit);
        		
        		totalNumDrinksCredit = fantaTotalCredit + cokeTotalCredit + spriteTotalCredit + lucozadeTotalCredit;
                grandTotal = totalAmountFanta + totalAmountCoke + totalAmountSprite + totalAmountLucozade;
                System.out.println("Total number of drinks bought on credit: " + totalNumDrinksCredit);
                System.out.println("Cash generated on credit: " + grandTotal);
        		
                windowCredit.close();
        		ThankYouClass.thankYou();//Credit balance window
        		
        		
        		//Enable and disable textfields, buttons and radiobuttons
        		fanta.setDisable(false);
    			numberOfFantaText.setDisable(true);
    			numberOfFantaText.clear();
    			buy1.setDisable(true);
    			
    			coke.setDisable(false);
    			numberOfCokeText.setDisable(true);
    			numberOfCokeText.clear();
    			buy2.setDisable(true);
    			
    			sprite.setDisable(false);
    			numberOfSpriteText.setDisable(true);
    			numberOfSpriteText.clear();
    			buy3.setDisable(true);
    			
    			lucozade.setDisable(false);
    			numberOfLucozadeText.setDisable(true);
    			numberOfLucozadeText.clear();
    			buy4.setDisable(true);
        	}
        	
        	WriteToFile.writeTofile();//Update file
        	
        });
        GridPane.setConstraints(buy1,3,1);
        //END OF FANTA
        
      //Creating radio button for coke
        coke = new RadioButton("Coke");
        coke.setTooltip(new Tooltip("Select Coke"));
        coke.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        coke.setTextFill(Color.BLUE);
        coke.setToggleGroup(radioButtonGroup);
        coke.setOnAction(e -> {System.out.println("coke selected");
      //Disable and enable textfield, buttons and radio buttons
        	numberOfCokeText.setDisable(false);
        	buy2.setDisable(false);
        
	        sprite.setDisable(true);
	    	numberOfSpriteText.setDisable(true);
	    	buy3.setDisable(true);
	    	
	    	fanta.setDisable(true);
	    	numberOfFantaText.setDisable(true);
	    	buy1.setDisable(true);
	    	
	    	lucozade.setDisable(true);
	    	numberOfLucozadeText.setDisable(true);
	    	buy4.setDisable(true);
	    	
        	});
        GridPane.setConstraints(coke,0,2);
      //Textfield for number of drinks
        numberOfCokeText = new TextField();
        numberOfCokeText.setPromptText("Enter number of drinks");
        numberOfCokeText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfCokeText, 1, 2);
        
        buy2 = new Button("Buy"); //button to buy coke
        buy2.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy2.setTextFill(Color.BLUE);
        buy2.setOnAction(e -> {
        	
        	
        	valids(numberOfCokeText);// validate input number of drinks
        	System.out.println(inputDrinks);
        	
        	System.out.println(BankDetails.inputCredit);
        	//Validations before calculating for the drink
        	if(CustomerTable.cokeQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	else if(CustomerTable.cokeQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}
        	
        	
        	else if(BankDetails.inputCredit < (1.20*inputDrinks)) {
        		getAmountError();
        		
        	}
        	
        	else if(!(isInt(numberOfCokeText, numberOfCokeText.getText()))) {
        		inputDrinks = 0;
        		numberOfCokeText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	
        	else {
        		//Calculations for buying a drink
        		CustomerTable.cokeQuantity -= inputDrinks;
        		
        		total = 1.15f * inputDrinks;
        		WriteToFile.writeTofile();
        		totalAmountCoke += total;
        		
        		cokeTotalCredit += inputDrinks;
        		System.out.println("Credit balance: " + BankDetails.toppedUpCredit);
        		
        		totalNumDrinksCredit = fantaTotalCredit + cokeTotalCredit + spriteTotalCredit + lucozadeTotalCredit;
                grandTotal = totalAmountFanta + totalAmountCoke + totalAmountSprite + totalAmountLucozade;
                System.out.println("Total number of drinks bought on credit: " + totalNumDrinksCredit);
                System.out.println("Cash generated on credit: " + grandTotal);
        		
                windowCredit.close();
        		ThankYouClass.thankYou();//Credit balance window
        		
        		//Disable and enable textfield, buttons and radio buttons
        		fanta.setDisable(false);
    			numberOfFantaText.setDisable(true);
    			numberOfFantaText.clear();
    			buy1.setDisable(true);
    			
    			coke.setDisable(false);
    			numberOfCokeText.setDisable(true);
    			numberOfCokeText.clear();
    			buy2.setDisable(true);
    			
    			sprite.setDisable(false);
    			numberOfSpriteText.setDisable(true);
    			numberOfSpriteText.clear();
    			buy3.setDisable(true);
    			
    			lucozade.setDisable(false);
    			numberOfLucozadeText.setDisable(true);
    			numberOfLucozadeText.clear();
    			buy4.setDisable(true);
        		
        	}
        	WriteToFile.writeTofile();//Update file
        });
        GridPane.setConstraints(buy2,3,2);
        //END OF COKE
        
      //Creating radio button for sprite
        sprite = new RadioButton("Sprite");
        sprite.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        sprite.setTooltip(new Tooltip("Select Sprite"));
        sprite.setTextFill(Color.BLUEVIOLET);
        sprite.setToggleGroup(radioButtonGroup);
        sprite.setOnAction(e -> {System.out.println("sprite selected");
        //enable and disable textfields, buttons and radiobuttons
        	numberOfSpriteText.setDisable(false);
        	buy3.setDisable(false);
        
	        fanta.setDisable(true);
	    	numberOfFantaText.setDisable(true);
	    	buy1.setDisable(true);
	    	
	    	coke.setDisable(true);
	    	numberOfCokeText.setDisable(true);
	    	buy2.setDisable(true);
	    	
	    	lucozade.setDisable(true);
	    	numberOfLucozadeText.setDisable(true);
	    	buy4.setDisable(true);
	    	
        	});
        GridPane.setConstraints(sprite,0,3);
        //textfield for number of drinks
        numberOfSpriteText = new TextField();
        numberOfSpriteText.setPromptText("Enter number of drinks");
        numberOfSpriteText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfSpriteText, 1, 3);
        
        buy3 = new Button("Buy");//button to buy sprite
        buy3.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy3.setTextFill(Color.BLUEVIOLET);
        buy3.setOnAction(e -> {
        	
        	valids(numberOfSpriteText);//validate input
        	System.out.println(inputDrinks);
        
        	System.out.println(BankDetails.toppedUpCredit);
        	//Validate before calculations
        	if(CustomerTable.spriteQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	else if(CustomerTable.spriteQuantity < inputDrinks) {
        		getQuantityError();
        		
        	}
        	
        	
        	else if(BankDetails.toppedUpCredit < (1.15*inputDrinks)) {
        		getAmountError();
        	
        	}
        	
        	else if(!(isInt(numberOfSpriteText, numberOfSpriteText.getText()))) {
        		inputDrinks = 0;
        		numberOfSpriteText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	//Calculations for buying a drink
        	else {
        		CustomerTable.spriteQuantity -= inputDrinks;
        		
        		total = 1.15f * inputDrinks;
        		WriteToFile.writeTofile();
        		totalAmountSprite += total;
        		
        		spriteTotalCredit += inputDrinks;
        		System.out.println("Credit balance: " + BankDetails.toppedUpCredit);
        		
        		totalNumDrinksCredit = fantaTotalCredit + cokeTotalCredit + spriteTotalCredit + lucozadeTotalCredit;
                grandTotal = totalAmountFanta + totalAmountCoke + totalAmountSprite + totalAmountLucozade;
                System.out.println("Total number of drinks bought on credit: " + totalNumDrinksCredit);
                System.out.println("Cash generated on credit: " + grandTotal);
        		
                windowCredit.close();
        		ThankYouClass.thankYou();//Credit balance window
        		
        		fanta.setDisable(false);
    			numberOfFantaText.setDisable(true);
    			numberOfFantaText.clear();
    			buy1.setDisable(true);
    			
    			coke.setDisable(false);
    			numberOfCokeText.setDisable(true);
    			numberOfCokeText.clear();
    			buy2.setDisable(true);
    			
    			sprite.setDisable(false);
    			numberOfSpriteText.setDisable(true);
    			numberOfSpriteText.clear();
    			buy3.setDisable(true);
    			
    			lucozade.setDisable(false);
    			numberOfLucozadeText.setDisable(true);
    			numberOfLucozadeText.clear();
    			buy4.setDisable(true);
        	}
        	WriteToFile.writeTofile();//Update file
        	
        });
        GridPane.setConstraints(buy3,3,3);
        //END OF SPRITE
        
      //Creating radio button for lucozade
        lucozade = new RadioButton("Lucozade");
        lucozade.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        lucozade.setTooltip(new Tooltip("Select Lucozade"));
        lucozade.setTextFill(Color.BLUE);
        lucozade.setToggleGroup(radioButtonGroup);
        lucozade.setOnAction(e -> {System.out.println("lucozade selected");
        
        	//Enable and disable radiobuttos,textfields and buttons
        	numberOfLucozadeText.setDisable(false);
        	buy4.setDisable(false);
        
	        sprite.setDisable(true);
	    	numberOfSpriteText.setDisable(true);
	    	buy3.setDisable(true);
	    	
	    	coke.setDisable(true);
	    	numberOfCokeText.setDisable(true);
	    	buy2.setDisable(true);
	    	
	    	fanta.setDisable(true);
	    	numberOfFantaText.setDisable(true);
	    	buy1.setDisable(true);
	    	
        	});
        GridPane.setConstraints(lucozade,0,4);
        //textfield for number of drinks
        numberOfLucozadeText = new TextField();
        numberOfLucozadeText.setPromptText("Enter number of drinks");
        numberOfLucozadeText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfLucozadeText, 1, 4);
        
        buy4 = new Button("Buy");//button to buy drinks
        buy4.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        buy4.setTextFill(Color.BLUE);
        buy4.setOnAction(e -> {
        	
        	valids(numberOfLucozadeText);//validate input from string to integer
        	System.out.println(inputDrinks);
        	System.out.println(BankDetails.toppedUpCredit);
        	//Validate before calculations for buying a drink
        	if(CustomerTable.lucozadeQuantity <= 0) {
        		getOutOfStock();
        		
        	}
        	
        	else if(CustomerTable.lucozadeQuantity < inputDrinks) {
        		getQuantityError();     		
        	}
        	
        	else if(BankDetails.toppedUpCredit < (1.15*inputDrinks)) {
        		getAmountError();
        	
        	}
        	
        	else if(!(isInt(numberOfLucozadeText, numberOfLucozadeText.getText()))) {
        		inputDrinks = 0;
        		numberOfLucozadeText.clear();
        		System.out.println(inputDrinks);
        		
        	}
        	
        	else {
        		//calculations for buying a drink
        		CustomerTable.lucozadeQuantity -= inputDrinks;
        		
        		total = 1.15f * inputDrinks;
        		WriteToFile.writeTofile();
        		totalAmountLucozade += total;
        		
        		lucozadeTotalCredit += inputDrinks;
        		System.out.println("Credit balance: " + BankDetails.toppedUpCredit);
        		System.out.println("Lucozade total: " + totalAmountLucozade);
        		
        		totalNumDrinksCredit = fantaTotalCredit + cokeTotalCredit + spriteTotalCredit + lucozadeTotalCredit;
                grandTotal = totalAmountFanta + totalAmountCoke + totalAmountSprite + totalAmountLucozade;
                System.out.println("Total number of drinks bought on credit: " + totalNumDrinksCredit);
                System.out.println("Cash generated on credit: " + grandTotal);
        		
                windowCredit.close();
        		ThankYouClass.thankYou();//Credit balance window
        		
        		//enable and disable textfields, radiobuttons and buttons
    			fanta.setDisable(false);
    			numberOfFantaText.setDisable(true);
    			numberOfFantaText.clear();
    			buy1.setDisable(true);
    			
    			coke.setDisable(false);
    			numberOfCokeText.setDisable(true);
    			numberOfCokeText.clear();
    			buy2.setDisable(true);
    			
    			sprite.setDisable(false);
    			numberOfSpriteText.setDisable(true);
    			numberOfSpriteText.clear();
    			buy3.setDisable(true);
    			
    			lucozade.setDisable(false);
    			numberOfLucozadeText.setDisable(true);
    			numberOfLucozadeText.clear();
    			buy4.setDisable(true);
    			
        	}
        	WriteToFile.writeTofile();//update file
        	
        	
        });
        GridPane.setConstraints(buy4,3,4);
        //END OF LUCOZADE
        
        //button to buy top up
        topUp = new Button("Top Up");
        topUp.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        topUp.setTextFill(Color.DARKBLUE);
        topUp.setOnAction(e -> {
        	windowCredit.close();
        	BankDetails.bankDetails();
        	BankDetails.cancel.setDisable(true);
        	BankDetails.finish.setDisable(true);
        	});
        GridPane.setConstraints(topUp, 2, 5);
        //logout button to leave the system
        logOut = new Button("Logout");
        logOut.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        logOut.setTextFill(Color.DARKBLUE);
        logOut.setOnAction(e -> windowCredit.close());
        GridPane.setConstraints(logOut,0,5);
        //cancel button to cancel the order
        cancel = new Button("Cancel");
        cancel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        cancel.setTextFill(Color.DARKBLUE);
        cancel.setOnAction(e -> {
        	
        	//clear text boxes enable and disable textfields, radiobuttons and buttons
        	numberOfFantaText.clear();
        	fanta.setDisable(false);
        	buy1.setDisable(true);
        	numberOfFantaText.setDisable(true);
        	        	
        	numberOfSpriteText.clear();
        	sprite.setDisable(false);
        	buy2.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	
        	numberOfCokeText.clear();
        	coke.setDisable(false);      	
        	buy3.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	        	
        	numberOfLucozadeText.clear();
        	lucozade.setDisable(false);
        	buy4.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
        	
        });
        
        
        GridPane.setConstraints(cancel,1,5);
        //END CANCEL
        
        //setup the vbox to add a textfield and a button
        VBox vb = new VBox(10);
        reportsText = new TextField();//textfield to write complaint
        reportsText.setPromptText("Write a Complaint");
        reportsText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        reportsText.setMinWidth(200);
        reportsText.setMinHeight(50);
        
        addReports = new Button("Add Complaint");//button to add complaint
        addReports.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        addReports.setTextFill(Color.DARKBLUE);
        addReports.setOnAction(e -> {
        				complaints = reportsText.getText();
        				reportsText.clear();     				
        				submitComplaint();
        				
        				;});
        //END OF ADD COMPLAINTS
        
        GridPane.setConstraints(vb, 0, 6);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setAlignment(Pos.CENTER); // Align to center
		vb.setStyle("-fx-background-color: lightblue");
		vb.getChildren().addAll(reportsText, addReports);
		//END OF VBOX
        
        HBox help1 = new HBox();//Set up hbox for help button
		Button help = new Button("Help");
		GridPane.setConstraints(help, 3, 15);
		help.setStyle("-fx-background-color: red");
		help.setOnAction(e -> { //If the button is clicked, you will get window with information
			Register.getHelp(); 
		});
		help1.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		help1.getChildren().addAll(help);

        gridMenu.getChildren().addAll(menuLabel, fanta,numberOfFantaText, buy1, coke,numberOfCokeText, buy2, sprite, 
        		numberOfSpriteText, buy3, lucozade, numberOfLucozadeText, buy4, logOut, cancel,topUp,vb, help);
        
        grid.getChildren().addAll(stockLabel,drinks,price,quantity,fantaLabel,cokeLabel,spriteLabel,lucozadeLabel, 
        		priceFantaLabel,priceCokeLabel,priceSpriteLabel,priceLucozadeLabel,
        		quantityFantaLabel,quantityCokeLabel,quantitySpriteLabel,quantityLucozadeLabel, gridMenu);
        
        Scene scene = new Scene(grid, 400, 600);
        windowCredit.setScene(scene);
        windowCredit.show();
		
       
	}
	
	public static Alert submitComplaint() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Complaints");
		alert.setHeaderText(reportsText.getText());	
		alert.setContentText("Complaint submitted");
		alert.showAndWait();
		return alert;
		
	}
	
	public static Alert getCreditBalance() {//Method that will show a window with information
		
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Credit Balance");
		alert.setHeaderText("Credit balance: " + BankDetails.toppedUpCredit);	
		alert.setContentText("You got 5 cent discout for each drink you purchased" + "\nThank You for your purchase");
		
		alert.showAndWait();
		windowCredit.close();
		return alert;
		
	}
	
	public static boolean isInt(TextField drinkInput, String message) {//turn string input to an integer
		try {
			inputDrinks = Integer.parseInt(drinkInput.getText());
			System.out.println("Correct input: " + inputDrinks);
			return true;
		}catch(NumberFormatException e) {
			System.out.println(message + "is in correct");
			return false;
		}
	}
		
	
	public static Alert getOutOfStock() {//Method that will show a window with information

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Out Of Stock");
		alert.setHeaderText("Drink out of Stock");	
		alert.setContentText("The drink you selected is out of stock," + 
							"Please select a different drink.");
		alert.showAndWait();
		
		return alert;
		
	}
	
	public static Alert getQuantityError() {//Method that will show a window with information

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("We dont have enough in stock!");	
		alert.setContentText("Please enter a lesser number of drinks," + 
							"or select a different drink.");
		alert.showAndWait();
		
		return alert;
		
	}
		
	
	public static void getAmountError() { //Method what will give you alert box(confirmation)
		
		Alert alert1 = new Alert(AlertType.ERROR);
		alert1.setTitle("Error Amount");
		alert1.setHeaderText("Error in the amount!");
		alert1.setContentText("You don't have enough money in your account, "
				+ "\nPlease topup your account! ");
		
		alert1.showAndWait();
		
	}
	
	
	public static void valids(TextField tests) {//turn input string to an integer
        try {
        	
            inputDrinks = Integer.parseInt(tests.getText());
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Invalid input, you did not enter a number");
            windowCredit.close();
            CustomerTable.getInputError();
            creditCustomer();
            
            
        	numberOfFantaText.clear();
        	fanta.setDisable(false);
        	buy1.setDisable(true);
        	numberOfFantaText.setDisable(true);
        	
        	numberOfSpriteText.clear();
        	sprite.setDisable(false);
        	buy2.setDisable(true);
        	numberOfSpriteText.setDisable(true);
        	
        	numberOfCokeText.clear();
        	coke.setDisable(false);
        	buy3.setDisable(true);
        	numberOfCokeText.setDisable(true);
        	
        	numberOfLucozadeText.clear();
        	lucozade.setDisable(false);
        	buy4.setDisable(true);
        	numberOfLucozadeText.setDisable(true);
            inputDrinks = 0;
        }

    }

}
