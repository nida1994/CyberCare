import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {
	
	public Main()
	{
		JFrame frame = new JFrame("CyberCare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Interface in = new Interface();
		in.setVisible(true);
		frame.getContentPane().add(in);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		
		 try {
	        
	         URL u  = this.getClass().getClassLoader().getResource("soundEffect.aiff");
	         AudioInputStream audio = AudioSystem.getAudioInputStream(u);    
	         Clip c = AudioSystem.getClip();
	         c.open(audio);
	         c.start();
	      } catch (UnsupportedAudioFileException error) {
	         error.printStackTrace();
	      } catch (IOException error) {
	         error.printStackTrace();
	      } catch (LineUnavailableException error) {
	         error.printStackTrace();
	      }
		 
		
    }
	
	public static void main(String[] args) throws Exception {
		Doctor doctor = new Doctor();
		doctor.newDoctorTable();
		new Main();
		new ImageEditor();
	}
	

	public static Connection getConnect() throws Exception {
		
		try {

			String drvr = "com.mysql.jdbc.Driver";
			String link = "jdbc:mysql://127.0.0.1:3307/EHRdb";
			String uname = "root";
			String passwrd = "";
			Class.forName(drvr);
			Connection connection = DriverManager.getConnection(link, uname, passwrd);
			System.out.println("Connection Successful");
			return connection;
		} // Catch any errors
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
