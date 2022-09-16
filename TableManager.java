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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TableManager {
	public static Label stockLabel,
			drinks, price, quantity,menuLabel,
			fantaLabel, spriteLabel, cokeLabel, lucozadeLabel,
			priceCokeLabel, priceFantaLabel, priceSpriteLabel, priceLucozadeLabel,
			quantityFantaLabel, quantitySpriteLabel, quantityCokeLabel, quantityLucozadeLabel;

		
	public static TextField numberOfFantaText, numberOfCokeText, numberOfSpriteText, numberOfLucozadeText;
		
	public static Button addFanta, addCoke, addSprite, addLucozade, cancel, logOut, customerFeedback, sales, salesReport,
							customerReport, maintenanceReport;
		
	public static int fantaTotalCredit , spriteTotalCredit, cokeTotalCredit, lucozadeTotalCredit, totalNumDrinksCredit;
		
	public static int inputDrinks, totalQuantity;
		
	public static float total, grandTotal,
			totalAmountFanta,totalAmountCoke, totalAmountSprite, totalAmountLucozade;
	
	public static void tableManager() {
		
		Stage windowManager = new Stage();
		windowManager.setTitle("Manager Table");
		windowManager.initModality(Modality.APPLICATION_MODAL);
		
		
		
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
        //create labels to display drinks menu
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
        menuLabel = new Label("Add Drinks to Stock");
        menuLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD,18));
        menuLabel.setTextFill(Color.DARKBLUE);
        GridPane.setConstraints(menuLabel,0,0); //column 0, row 0
//A child's placement within the grid is defined by it's layout constraints
               
        //textfield for number of fanta
        numberOfFantaText = new TextField();
        numberOfFantaText.setPromptText("Enter number of drinks");
        numberOfFantaText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfFantaText, 1, 1);
        
        addFanta = new Button("Add Fanta"); //button to add drinks
        addFanta.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        addFanta.setTextFill(Color.BLUEVIOLET);
        addFanta.setOnAction(e -> {
        	valids(numberOfFantaText);
        	System.out.println(inputDrinks);
        	System.out.println(CustomerTable.fantaQuantity);
        	
            if((CustomerTable.fantaQuantity + inputDrinks) > 20) {
        		getQuantityError();
            }
        	else {
        		CustomerTable.fantaQuantity += inputDrinks; 	      
        		windowManager.close(); 
        		getUpdate();
        	}
        	
        });
        GridPane.setConstraints(addFanta,3,1);
        //END OF FANTA
        //text field to add cokes
        numberOfCokeText = new TextField();
        numberOfCokeText.setPromptText("Enter number of drinks");
        numberOfCokeText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfCokeText, 1, 2);
        
        addCoke = new Button("Add Coke"); //button to add drinks
        addCoke.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        addCoke.setTextFill(Color.BLUE);
        addCoke.setOnAction(e -> {
        	
        	valids(numberOfCokeText);//validate input
        	System.out.println(inputDrinks);
        	System.out.println(CustomerTable.cokeQuantity);
        	//check the conditions
            if((CustomerTable.cokeQuantity + inputDrinks) > 20) {
        		getQuantityError();
            }
        	else {
        		CustomerTable.cokeQuantity += inputDrinks; 	      
        		windowManager.close(); 
        		getUpdate();
        	}        	        	       		   		       		       	
        });
        GridPane.setConstraints(addCoke,3,2);
        //END OF COKE
           	
       //textfield to add number of drinks
        numberOfSpriteText = new TextField();
        numberOfSpriteText.setPromptText("Enter number of drinks");
        numberOfSpriteText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfSpriteText, 1, 3);
        
        addSprite = new Button("Add Sprite");//button to add drinks
        addSprite.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        addSprite.setTextFill(Color.BLUEVIOLET);
        addSprite.setOnAction(e -> {
        	
        	valids(numberOfSpriteText);//validate input
        	System.out.println(inputDrinks);
        	System.out.println(CustomerTable.spriteQuantity);
        	//check conditions
            if((CustomerTable.spriteQuantity + inputDrinks) > 20) {
        		getQuantityError();
            }
        	else {
        		CustomerTable.spriteQuantity += inputDrinks; 	      
        		windowManager.close(); 
        		getUpdate();
        	}        	        	        	       	
        	
        });
        GridPane.setConstraints(addSprite,3,3);
        //END OF SPRITE
         //text field to add number of drinks              	               
        numberOfLucozadeText = new TextField();
        numberOfLucozadeText.setPromptText("Enter number of drinks");
        numberOfLucozadeText.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        GridPane.setConstraints(numberOfLucozadeText, 1, 4);
        
        addLucozade = new Button("Add Lucozade");//button to add drinks
        addLucozade.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        addLucozade.setTextFill(Color.BLUE);
        addLucozade.setOnAction(e -> {
        	
        	valids(numberOfLucozadeText);//validate input
        	System.out.println(inputDrinks);
        	System.out.println(CustomerTable.lucozadeQuantity);
        	//check conditions
            if((CustomerTable.lucozadeQuantity + inputDrinks) > 20) {
        		getQuantityError();
            }
        	else {
        		CustomerTable.lucozadeQuantity += inputDrinks; 	      
        		windowManager.close(); 
        		getUpdate();
        	}        	        	
        	
        });
        GridPane.setConstraints(addLucozade,3,4);
        //END OF LUCOZADE
        
        sales = new Button("Sales");//button to check sales
        sales.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        sales.setTextFill(Color.DARKBLUE);
        sales.setOnAction(e -> {
        	ManagerLog.managerLog();
        	windowManager.close();
        	
        	});
        GridPane.setConstraints(sales, 2, 6);
        //SALES
        
        logOut = new Button("Logout");//button to logout
        logOut.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        logOut.setTextFill(Color.DARKBLUE);
        logOut.setOnAction(e -> windowManager.close());
        GridPane.setConstraints(logOut,0,6);
        //LOGOUT
        
        cancel = new Button("Cancel");//button to cancel process
        cancel.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        cancel.setTextFill(Color.DARKBLUE);
        cancel.setOnAction(e -> {	
	      	numberOfFantaText.clear(); 
	      	numberOfCokeText.clear();
	      	numberOfSpriteText.clear();
	      	numberOfLucozadeText.clear();
        	
        });
        GridPane.setConstraints(cancel,0,7);
        //CANCEL
        
        salesReport = new Button("Sales Report");//button to check sales report
        salesReport.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        salesReport.setTextFill(Color.DARKBLUE);
        salesReport.setOnAction(e -> {windowManager.close();
        	SalesReport.salesReport();
        					});
        GridPane.setConstraints(salesReport, 2, 7);
        //SALESREPORT
        
        customerReport = new Button("Customer Complaints");//button to check customer complaints
        customerReport.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        customerReport.setTextFill(Color.DARKBLUE);
        customerReport.setOnAction(e -> {MaintenanceLog.maintenanceLog();
        								windowManager.close();});
        GridPane.setConstraints(customerReport, 1, 7);
        //CUSTOMER REPORT
        
        maintenanceReport = new Button("Maintenance Report");//button to check maintenance report
        maintenanceReport.setFont(Font.font("Times New Roman", FontWeight.BOLD,14));
        maintenanceReport.setTextFill(Color.DARKBLUE);
        maintenanceReport.setOnAction(e -> {RepairedLog.repairedLog();
        						windowManager.close();});
        
        GridPane.setConstraints(maintenanceReport, 1, 6);
       // MAINTENANCE REPORT
        
        
        //hbox for help button
        HBox help1 = new HBox();
		Button help = new Button("Help");
		GridPane.setConstraints(help, 3, 15);
		help.setStyle("-fx-background-color: red");
		help.setOnAction(e -> { //If the button is clicked, you will get help window with small description
			Register.getHelp(); 
		});
		help1.setAlignment(Pos.BOTTOM_RIGHT); //Positioning of the button
		help1.getChildren().addAll(help);

        gridMenu.getChildren().addAll(menuLabel,numberOfFantaText, addFanta, numberOfCokeText, addCoke, 
        		numberOfSpriteText, addSprite,  numberOfLucozadeText, addLucozade, logOut, cancel,sales,salesReport, 
        		customerReport, maintenanceReport, help);
        
        grid.getChildren().addAll(stockLabel,drinks,price,quantity,fantaLabel,cokeLabel,spriteLabel,lucozadeLabel, 
        		priceFantaLabel,priceCokeLabel,priceSpriteLabel,priceLucozadeLabel,
        		quantityFantaLabel,quantityCokeLabel,quantitySpriteLabel,quantityLucozadeLabel, gridMenu);
        
        Scene scene = new Scene(grid, 400, 600);
        windowManager.setScene(scene);
        windowManager.show();
		
       
	}
	
	
	
	
	public static Alert getQuantityError() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("Can't exceed 20!");	
		alert.setContentText("Maximum quantity is 20");
		alert.showAndWait();
		
		return alert;
		
	}
	
	public static Alert getUpdate() {//Method what will give you alert box with explanation what the user needs to do in the window

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INFORMATION");
		alert.setHeaderText("Update!");	
		alert.setContentText("Drinks added");
		alert.showAndWait();
		TableManager.tableManager();
		return alert;
		
	}
		
	
	
	public static void valids(TextField tests) {
        try {
        	
            inputDrinks = Integer.parseInt(tests.getText());
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, you did not enter a number");
            inputDrinks = 0;
        }

    }
		
	

}
