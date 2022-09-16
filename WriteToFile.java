

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

import javafx.scene.control.TextField;

public class WriteToFile {
	
	//public static float writeCredit;

    public static void writeTofile() { //Method which will write the user input to the file
    	
    	
    	BankDetails.isFloat();//validate if its float
    	//set a new file creating a path
        File file = new File("Registration.txt"); //Creating the new file
        System.out.println("File path is: " + new File("Registration.txt").getAbsolutePath());


        if (file.exists()) {  //if the file exist, write the message
            System.out.println("Found the file");

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }


            PrintWriter pw = null; //Setting PrintWritter to null
            try {
                pw = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            
            //writing to file
            
			pw.println("User Name: manager@gmail.com");
			pw.println("Pin: 1234");
			
            
            pw.print("\nUser Name: ");
            pw.println( Register.emailText.getText());
            pw.print("Pin: ");
            pw.println(Register.pinNumberText.getText());
            
            pw.print("Credit: € ");
            
            pw.println(BankDetails.toppedUpCredit);
           
            
            pw.close();
        }
    }
    
  


    public static void getFile() { //Check if the file exists

        File file = new File("Registration.txt");
        System.out.println("File path is: " + new File("Registration.txt").getAbsolutePath());


        if (file.exists())
            System.out.println("Found the file");
        else
            System.out.println("Did not find the file.");


    }
    
    

}
