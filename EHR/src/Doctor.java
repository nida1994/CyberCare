import java.sql.Connection;
import java.sql.PreparedStatement;

public class Doctor {

public  void newDoctorTable() throws Exception {
	try{
	 Connection connect = 	Main.getConnect();
	 PreparedStatement newDTable = connect.prepareStatement("CREATE TABLE IF NOT EXISTS doctor_registration(ID int NOT NULL AUTO_INCREMENT, FirstName varchar(255) NOT NULL, LastName varchar(255) NOT NULL, UserName varchar(225) NOT NULL, Password varchar(255) NOT NULL, PRIMARY KEY(ID))");
	 newDTable.executeUpdate();  
	
	}catch(Exception e) 
	{
		System.out.println(e);
	}
	finally{System.out.println("Table Created");}	
	}

public void insertRow() throws Exception {
	
	
}

public void login() throws Exception
{
	//if else placed here 
}
}