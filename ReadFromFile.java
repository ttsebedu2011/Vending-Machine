
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFromFile {

	//creating username and password instances
	public static String userName;
	public static String pin;
	public static String userCustomer;
	public static String pinCustomer;

	public static void readTheFile(String title) { //Method to read from the file
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new FileReader("Registration.txt")); //Create BufferedReader in order to read the file
			
			String line;
			
			//Read through the file
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if(line.contains("User Name: manager@gmail.com")) userName = "manager@gmail.com" ; 
				if(line.contains("Pin: 1234")) pin = "1234" ; 
				
				if(line.contains("User Name")) userCustomer = line.split(":")[1].trim() ; 
				if(line.contains("Pin")) pinCustomer = line.split(":")[1].trim() ;
				
				
			}
			
		} catch (IOException e) { //Throw exception if the username and password is not found
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
}