import java.sql.Connection;
import java.sql.PreparedStatement;

public class Patient {
	
	
public Patient() throws Exception
{
	Main.getConnect();

}
public static void newPatientTable() throws Exception {
	try{
	 Connection connect = Main.getConnect();
	 PreparedStatement newPatTable = connect.prepareStatement("CREATE TABLE IF NOT EXISTS patient_registration(ID int NOT NULL AUTO_INCREMENT, "
	 + "FirstName varchar(255) NOT NULL, MiddleInitial varchar(10), LastName varchar(255) NOT NULL,"
	 + "Gender varchar(6) NOT NULL, Prefix varchar(3), Marital Status varchar(10), Ethnicity varchar(15), Race varchar(20),"
	 + "Date_of_Birth varchar(255), Age varchar(3), Social Security Number varchar(11), Email Address varchar(255),"
	 + "Home Phone # varchar(15), Work Phone # varchar(15), Cell Phone # varchar(15), Mother Last Name varchar(255),"
	 + "Mother First Name varchar(255), Mom Social Security Number varchar(255), Mom Home Phone Number varchar(20), Mom Cell Phone Number varchar(20),"
	 + "Father Last Name varchar(255), Father First Name varchar(255), Father Social Security Number, Father Home Phone Number varchar(20) Father Cell Phone Number varchar(20),"
	 + "Guardian Last Name varchar(255), Guardian First Name varchar(255), Guardian Social Security Number, Guardian Home Phone Number varchar(20), "
	 + "Address varchar(500), Apt# varchar(30), City varchar(255), State varchar(255), ZipCode varchar(255), Pharmacy Name varchar(255), "
	 + "Address varchar(255), Pharmacy Phone Number varchar(255), Primary Physician varchar(255), Physician Phone Number varchar(255),"
	 + "Physician Email Address varchar(255), Insurance Company Name I varchar(255), Insurance Company I Address varchar(255), City varchar(255), State varchar(255),"
	 + "Name of Insured varchar(255), Relationship varchar(255), Policy # varchar(255), Group # varchar(255), Insurance Company Name II varchar(255), Insurance Company II Address,"
	 + "City varchar(255), State varchar(255), Name of Insured varchar(255), Relationship varchar(255), Policy # varchar(255), Group # varchar(255),PRIMARY KEY(ID))");
	 newPatTable.executeUpdate();  
	
	}catch(Exception e) 
	{
		System.out.println(e);
	}
	finally{System.out.println("Table Created");}	
	}
}