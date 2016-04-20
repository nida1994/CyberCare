//import java.sql.*;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.ColorUIResource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineUnavailableException;


public class Interface extends JPanel
{
	
	private JPanel blueSymbol,mainPanel,welcomeEHRPanel,registerPanel,loginPanel,regSuccess,
	loginSuccess,functionsPanel,changePassword,patientNewSearch,patientViewSearch,
	patientDeleteSearch,viewPatientSidePanel, panelSchedule, patientInfoPanel,patientPanel,
	patientDet1,parentsInfo,parentsInfo1,parentsInfo2,parentsInfo3,addressInfo1,
	insuranceDet1,patientPhoto1,patientInfo1,patientInfo2,patientInfo3,medicalRecords,
	insuranceInfo3,results,pendingServices,contactInfoI,prescriptions,Base,insuranceInfoPanel, 
	addressInfo,addressInfo2,addressInfo3,insuranceInfo1,insuranceInfo2,patientRegistration,
	patientRegistration1, patientRegistration2,parentPatientPanel,patientPanel2,medications,
	allergies, vitals,patientPanel3a,patientPanel4,patientPanel5,appointmentPanel,billsPanel,
	description, contactInfoII, iDInfo, currentMR, immunization, familyHistory, immunePanel, 
	familyHisPanel1, momRecords, vlastnameTextField,vfirstnameTextField, vbirthdateTextField,
	visualSidePanel,dlastnameTextField,dfirstnameTextField, dbirthdateTextField,patientPanel3b,
	patientPanel3c, add2, add6,add7,add8, add9, add10, add11, add12,add13, add14, add15, add16, add17, add18,
	add19, add20,add21,add22,add23,add24, add25, add26,dadRecords,med1,allergy1,vitals1,prescriptions1, 
	results1, pendingServices1,visuals,mainVisuals,patientVisDet, deleteConfirmPanel, visualPicPanel,
	visualsEditingPanel,mainSchedule,yearPanel,calendarPanel;
	private JTextArea evaluation,progressNotes;
	private JLabel welcome1, welcome2,psw,usn, fn, ln, cpass,rs,login,warning;
	private JPasswordField fieldPass1, fieldPass2,fp1, fp2, fp3;
	private JTextField tx1,tx2,tx3;
	private JButton rbutton,lbutton,sbutton,signbutton, getStarted, moreInfoSched, moreInfoNew;
	JScrollPane patientInfoScroll, medicalRecordsScroll, appointmentsScroll, billsScroll,janPane, scheduleScroll;
	Image image;
    ImageEditor editorArea;	
    private BufferedImage colorSample = new BufferedImage(
            16,16,BufferedImage.TYPE_INT_RGB);
	
    JTabbedPane Caltabbed2016, Caltabbed2015;
    Doctor d;
   VisualsPaintComponent vpc;
   
	public Interface()
	{   
		editorArea = new ImageEditor();
		
		//Blue Symbol Medical Icon
		blueSymbol = new JPanel(new BorderLayout());
		blueSymbol.setPreferredSize(new Dimension(500,500));
		try{

			BufferedImage myPicture = ImageIO.read(new File("Images/mi.jpg"));

			JLabel picLabel = new JLabel(new ImageIcon(myPicture));

			picLabel.setOpaque(true);

			blueSymbol.add(picLabel);

		}catch(Exception e){};
		
		add(blueSymbol);
		
		//Panel with welcome text and register and login buttons
		mainPanel = new JPanel();
		welcome1 = new JLabel("Welcome to CyberCare:");
		welcome2 = new JLabel("A Novel Electronic Health Record Management System\n");
		rbutton = new JButton("Register");
		lbutton = new JButton("Login");
		getStarted = new JButton("Get Started");
	    GridBagConstraints c = new GridBagConstraints();
		welcome1.setFont(new Font("Arial", Font.PLAIN, 23));
		welcome2.setFont(new Font("Arial", Font.PLAIN, 16));
		c.insets = new Insets(10,10,10,10);
		c.gridx = 0;
		c.gridy = 2;	
		mainPanel.add(welcome1, c);
		c.gridx = 0;
		c.gridy = 3;
		mainPanel.add(welcome2, c);
		c.gridx = 0;
		c.gridy = 4;
		mainPanel.add(rbutton,c);
		c.gridx = 0;
		c.gridy = 5;
	    mainPanel.add(lbutton,c);
	    c.gridx = 0;
	    c.gridy = 9;
	    mainPanel.add(getStarted,c);
	    
		mainPanel.setBackground(new Color(179, 255, 224));
		mainPanel.setPreferredSize(new Dimension(600,400));
		rbutton.setPreferredSize(new Dimension(200,50));
		lbutton.setPreferredSize(new Dimension(200,50));
		getStarted.setPreferredSize(new Dimension(100,50));
		getStarted.setBackground(Color.BLUE);	
		
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		RegisterButtonListener rlistener = new RegisterButtonListener();
		rbutton.addActionListener(rlistener);
	
		LoginButtonListener llistener = new LoginButtonListener();
		lbutton.addActionListener(llistener);
		
		getStartedButtonListener startlistener = new getStartedButtonListener();
		getStarted.addActionListener(startlistener);
		
		c.gridx = 10;
		c.gridy = 3;
		add(mainPanel, c);	
		
		//Top Panel  
		welcomeEHRPanel = new JPanel();
		welcomeEHRPanel.setLayout(new GridBagLayout());
		welcomeEHRPanel.setPreferredSize(new Dimension(2000,40));
		welcomeEHRPanel.setBackground(new Color(230, 230, 255));
		JButton change_password = new JButton("Change Password");
		JButton logout = new JButton("Log Out");
		JLabel w2 = new JLabel("Welcome to CyberCare");
				
		GridBagConstraints n = new GridBagConstraints();
		n.gridx = 55;
		n.gridy = 0;
		welcomeEHRPanel.add(w2,n);
		welcomeEHRPanel.add(change_password);
				
		welcomeEHRPanel.add(logout);		
				
		welcomeEHRPanel.setVisible(false);
				
		add(welcomeEHRPanel);	

		LogOutButtonListener lolistener = new LogOutButtonListener();
		logout.addActionListener(lolistener);
				
		//Register Panel
		registerPanel = new JPanel(new GridBagLayout());

		GridBagConstraints d = new GridBagConstraints();
		sbutton = new JButton("Submit");
		fn = new JLabel("First Name: ");
		ln = new JLabel("Last Name: ");
		usn = new JLabel("Username: ");
		fieldPass1 = new JPasswordField(10);
		psw = new JLabel("Password: ");
		cpass = new JLabel("Confirm Password: ");
		fieldPass2 = new JPasswordField(10);
		tx1 = new JTextField(10);
		tx2 = new JTextField(10);
		tx3 = new JTextField(10);
		warning = new JLabel("Every entry must be filled");
		registerPanel.setBackground(Color.WHITE);
		registerPanel.setPreferredSize(new Dimension(500,200)); 

		d.insets = new Insets(0,0,0,5);
		d.gridx = 0;
		d.gridy = 0;
		registerPanel.add(fn, d);	
		d.gridx = 1;
		d.gridy = 0;
		registerPanel.add(tx1,d);
		d.gridx = 0;
		d.gridy = 1;
		registerPanel.add(ln,d);
		d.gridx = 1;
		d.gridy = 1;
		registerPanel.add(tx2,d);	
		d.gridx = 0;
		d.gridy = 2;
		registerPanel.add(usn,d);
		d.gridx = 1;
		d.gridy = 2;
		registerPanel.add(tx3, d);
		d.gridx= 0;
		d.gridy= 3;
		registerPanel.add(psw,d);
		d.gridx = 1;
		d.gridy = 3;
		registerPanel.add(fieldPass1, d);
		d.gridx = 0;
		d.gridy = 4;
		registerPanel.add(cpass, d);
		d.gridx = 1;
		d.gridy = 4;
		registerPanel.add(fieldPass2, d);
				
		d.gridx = 10;
		d.gridy = 7;
		registerPanel.add(sbutton,d);

		SubmitButtonListener slistener = new SubmitButtonListener();
		sbutton.addActionListener(slistener);
				
		warning.setVisible(false);
		d.gridx = 0;
		d.gridy = 10;
		registerPanel.add(warning, d);
				
		registerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
		registerPanel.setVisible(false);
			
		mainPanel.add(registerPanel);
				
		//Login Panel
		loginPanel = new JPanel(new GridBagLayout());
		usn = new JLabel("Username:");
		JPasswordField pass = new JPasswordField(10);
		pass.setEchoChar('*');
		psw = new JLabel("Password:");
		tx1 = new JTextField(10);
		signbutton = new JButton("Sign In");

		loginPanel.setBackground(Color.WHITE);
		loginPanel.setPreferredSize(new Dimension(500,200));
		
		GridBagConstraints d1 = new GridBagConstraints();

		d1.gridx = 0;
		d1.gridy = 1;
		loginPanel.add(usn,d1);
		d1.gridx = 1;
		d1.gridy = 1;
		loginPanel.add(tx1,d1);
		d1.gridx = 0;
		d1.gridy = 2;
		loginPanel.add(psw,d1);
		d1.gridx = 1;
		d1.gridy = 2;
		loginPanel.add(pass,d1);
		d1.gridx = 2;
		d1.gridy = 3;
		loginPanel.add(signbutton,d1);

		SignButtonListener sblistener = new SignButtonListener();
		signbutton.addActionListener(sblistener);

		loginPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		loginPanel.setVisible(false);

		mainPanel.add(loginPanel);//Registration Successful Panel
		regSuccess = new JPanel(new GridBagLayout());
		
		regSuccess.setPreferredSize(new Dimension(400,200));
		regSuccess.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		regSuccess.setBackground(Color.WHITE);
		
		rs = new JLabel("Registration Successful!");

		rs.setFont(new Font("Courier New", Font.PLAIN, 20));
		JButton okbutton = new JButton("Ok");
		
		okbutton.setBackground(Color.WHITE);
		okbutton.setPreferredSize(new Dimension (70,50));
	    okbutton.setOpaque(true);
	 
		GridBagConstraints ls = new GridBagConstraints();
		ls.insets = new Insets(0,0,20,0);
		ls.gridx = 0;
		ls.gridy = 0;
		regSuccess.add(rs, ls);
		
		ls.gridx = 0;
		ls.gridy = 3;
		regSuccess.add(okbutton, ls);
		

		OKButtonListener oklistener2 = new OKButtonListener();
		okbutton.addActionListener(oklistener2);
		regSuccess.setVisible(false);

		mainPanel.add(regSuccess);	
		 
		//Different Functions Panel
		functionsPanel = new JPanel(new GridBagLayout());

		GridBagConstraints free =  new GridBagConstraints();
		ImageIcon icon = new ImageIcon("images/heart.jpg");
		JLabel textimage = new JLabel(icon);
		JLabel medehr = new JLabel("Medical EHR");
		JButton abutton = new JButton("Schedule");
		JButton nbutton = new JButton("New Patient");
		JButton vbutton = new JButton("View Patient Info");
		JButton dbutton = new JButton("Delete Patient");
		functionsPanel.setPreferredSize(new Dimension(1500,70));
		functionsPanel.setBackground(new Color(255,187,187));
		
		free.insets = new Insets(0,0,10,10);
		
		abutton.setBounds(20,30,50,30);	
		abutton.setFont(new Font("Courier New", Font.PLAIN, 15));	
		abutton.setBackground(Color.WHITE);
		
		nbutton.setBounds(20,30,50,30);	
		nbutton.setFont(new Font("Courier New", Font.PLAIN, 15));	
		nbutton.setBackground(Color.WHITE);
		
		vbutton.setPreferredSize(new Dimension(90,90));
		vbutton.setFont(new Font("Courier New", Font.PLAIN, 15));

		dbutton.setPreferredSize(new Dimension(90,90));
		dbutton.setFont(new Font("Courier New", Font.PLAIN, 15));
		
		
		free.gridx = 0;
		free.gridy = 0;
		functionsPanel.add(textimage, free);
		
		free.gridx = 1;
		free.gridy = 0 ;
		functionsPanel.add(medehr, free);
		
		free.gridx = 2;
		free.gridy = 0;
		functionsPanel.add(abutton, free);
		
		free.gridx = 3;
		free.gridy = 0;
		functionsPanel.add(nbutton, free);
		
		free.gridx = 4;
		free.gridy = 0;
		functionsPanel.add(vbutton, free);
		
		free.gridx = 5;
		free.gridy = 0;
		functionsPanel.add(dbutton, free);
		
        functionsPanel.setVisible(false);
			
		NewButtonListener nlistener = new NewButtonListener();
		nbutton.addActionListener(nlistener);
		
		ViewButtonListener vlistener = new ViewButtonListener();
		vbutton.addActionListener(vlistener);
		
		DeleteButtonListener dlistener = new DeleteButtonListener();
		dbutton.addActionListener(dlistener);
	
		ScheduleButtonListener alistener = new ScheduleButtonListener();
		abutton.addActionListener(alistener);
		add(functionsPanel);
		
		//ChangePassword Panel
		changePassword = new JPanel();
		changePassword.setLayout(new GridBagLayout());
		changePassword.setPreferredSize(new Dimension(500,300));
		changePassword.setBackground(new Color(153,235,255));
		changePassword.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

						
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);
						
		JLabel currentpass = new JLabel("Current Password: ");
		fp1 = new JPasswordField(10);
						
		JLabel newpass = new JLabel("New Password: ");
		fp2 = new JPasswordField(10);
						
		JLabel confirmpass = new JLabel("Confirm Password: ");
	    fp3 = new JPasswordField(10);
	    
	    JButton CPsubmit = new JButton("Submit");
						
		gbc.gridx = 0;
		gbc.gridy = 0;
		changePassword.add(currentpass, gbc);
						
	    gbc.gridx = 1;
		gbc.gridy = 0;
		changePassword.add(fp1, gbc);
						
		gbc.gridx = 0;
		gbc.gridy = 1;
		changePassword.add(newpass, gbc);
						
		gbc.gridx = 1;
		gbc.gridy = 1;
		changePassword.add(fp2, gbc);
						
		gbc.gridx = 0;
		gbc.gridy = 2;
		changePassword.add(confirmpass, gbc);
						
		gbc.gridx = 1;
	    gbc.gridy = 2;
		changePassword.add(fp3, gbc);
		
		gbc.gridx = 2;
	    gbc.gridy = 4;
		changePassword.add(CPsubmit, gbc);
		
		changePassword.setVisible(false);
						
		ChangePasswordButtonListener cplistener = new ChangePasswordButtonListener();
		change_password.addActionListener(cplistener);
		
		SubmitChangePasswordListener cpsublistener = new SubmitChangePasswordListener();
		CPsubmit.addActionListener(cpsublistener);
						
		add(changePassword);
								
		
		//Login Successful Panel
		loginSuccess = new JPanel(new GridBagLayout());
		
		loginSuccess.setPreferredSize(new Dimension(400,200));
		loginSuccess.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		loginSuccess.setBackground(Color.WHITE);

		login = new JLabel("Login Successful !");
		login.setFont(new Font("Courier New", Font.PLAIN, 20));
		JButton okbutton2 = new JButton("Ok");
		
		okbutton2.setBackground(Color.WHITE);
		okbutton2.setPreferredSize(new Dimension (70,50));
	    okbutton2.setOpaque(true);
	   
		GridBagConstraints l = new GridBagConstraints();
		l.insets = new Insets(0,0,20,0);
		l.gridx = 0;
		l.gridy = 1;
		loginSuccess.add(login, l);
		l.gridx = 0;
		l.gridy = 3;
		loginSuccess.add(okbutton2, l);
		
		OKButtonListener oklistener = new OKButtonListener();
		okbutton2.addActionListener(oklistener);
		
		loginSuccess.setVisible(false);

		mainPanel.add(loginSuccess);
		
		//Image SlideShow
		Base = new JPanel();
		Base.setPreferredSize(new Dimension(2000,2000));
		
		try{
			BufferedImage myPicture = ImageIO.read(new File("images/base.jpeg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			picLabel.setOpaque(true);
			picLabel.setBackground(Color.BLACK);
			Base.add(picLabel);

			}catch(Exception e){};
		
		Base.setVisible(false);
		add(Base);
        
		//PatientViewSearch
		patientViewSearch = new JPanel();
		patientViewSearch.setLayout(new GridBagLayout());		
		patientViewSearch.setPreferredSize(new Dimension(500,270));
				
		patientViewSearch.setBackground(new Color(255,250,205));
		patientViewSearch.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
		GridBagConstraints c4 = new GridBagConstraints();
		c4.insets = new Insets(0,0,10,0);
		
		JLabel s4 = new JLabel("Patient Search");
		s4.setFont(new Font("Courier New", Font.PLAIN, 25));
		s4.setBackground(Color. LIGHT_GRAY);
		s4.setOpaque(true);	
		
		c4.gridx=0;
		c4.gridy=0;
		patientViewSearch.add(s4, c4);
		
		JLabel searchby = new JLabel("Search By:");
		searchby.setFont(new Font("Courier New", Font.PLAIN, 20));
		c4.gridx=0;
		c4.gridy=1;
		patientViewSearch.add(searchby,c4);
		
		JLabel vlastName = new JLabel("Last Name:");
		c4.gridx = 0;
		c4.gridy = 2;
		patientViewSearch.add(vlastName,c4);
		
		
		JTextField vlN = new JTextField(10);
		c4.gridx = 1;
		c4.gridy = 2;
		vlastnameTextField = new JPanel();
		vlastnameTextField.setPreferredSize(new Dimension(150,35));
		vlastnameTextField.add(vlN);
		vlastnameTextField.setBackground(new Color(255,250,205));
		patientViewSearch.add(vlastnameTextField, c4);
		
		JLabel vfirstName = new JLabel("First Name:");
		c4.gridx = 0;
		c4.gridy = 3;
		vfirstnameTextField = new JPanel();

		patientViewSearch.add(vfirstName,c4);
		
		JTextField vfN = new JTextField(10);
		c4.gridx = 1;
		c4.gridy = 3;
		vfirstnameTextField = new JPanel();
		vfirstnameTextField.setPreferredSize(new Dimension(150,35));
		vfirstnameTextField.add(vfN);
		vfirstnameTextField.setBackground(new Color(255,250,205));
		patientViewSearch.add(vfirstnameTextField,c4);
		
		JLabel vBirthDate = new JLabel("Birth Date (MM/DD/YYYY)");
		c4.gridx = 0;
		c4.gridy = 4;
		
		patientViewSearch.add(vBirthDate,c4);
		
		JTextField vBD = new JTextField(10);
		c4.gridx = 1;
		c4.gridy = 4;
		vbirthdateTextField = new JPanel();
		vbirthdateTextField.setPreferredSize(new Dimension(150,35));
		vbirthdateTextField.add(vBD);
		vbirthdateTextField.setBackground(new Color(255,250,205));
		patientViewSearch.add(vbirthdateTextField,c4);
		
		JButton patientb2 = new JButton("Submit");
		JButton backb2 = new JButton("Back");
		
		c4.gridx = 12;
		c4.gridy = 25;
		patientViewSearch.add(patientb2,c4);
		
		c4.gridx = 0;
		c4.gridy = 25;
		patientViewSearch.add(backb2,c4);
		
		SubmitViewListener pnlistener2 = new SubmitViewListener();
		patientb2.addActionListener(pnlistener2);

		BackButtonListener2 blistener2 = new BackButtonListener2();
		backb2.addActionListener(blistener2);
		
		patientViewSearch.setVisible(false);
		c4.gridx = 3;
		c4.gridy = 3;
		add(patientViewSearch, c4);
        
		//PatientDeleteSearch
		patientDeleteSearch = new JPanel();
		patientDeleteSearch.setLayout(new GridBagLayout());		
		patientDeleteSearch.setPreferredSize(new Dimension(500,270));
				
		patientDeleteSearch.setBackground(new Color(255,250,205));
		patientDeleteSearch.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
				
		GridBagConstraints c5 = new GridBagConstraints();
		c5.insets = new Insets(0,0,10,0);
		
		JLabel s5 = new JLabel("Patient Search");
		s5.setFont(new Font("Courier New", Font.PLAIN, 25));
		s5.setBackground(Color. LIGHT_GRAY);
		s5.setOpaque(true);	
		
		c5.gridx=0;
		c5.gridy=0;
		patientDeleteSearch.add(s5, c5);
		
		JLabel searchby2 = new JLabel("Search By:");
		searchby2.setFont(new Font("Courier New", Font.PLAIN, 20));
		
		c5.gridx=0;
		c5.gridy=1;
		patientDeleteSearch.add(searchby2,c5);
		
		JLabel lastName = new JLabel("Last Name");
		c5.gridx = 0;
		c5.gridy = 2;
		patientDeleteSearch.add(lastName,c5);
		
		JTextField lN = new JTextField(10);
		c5.gridx = 1;
		c5.gridy = 2;
		
		dlastnameTextField = new JPanel();
		dlastnameTextField.setPreferredSize(new Dimension(150,35));
		dlastnameTextField.add(lN);
		dlastnameTextField.setBackground(new Color(255,250,205));
		patientDeleteSearch.add(dlastnameTextField,c5);
		
		JLabel firstName = new JLabel("First Name");
		c5.gridx = 0;
		c5.gridy = 3;
		patientDeleteSearch.add(firstName,c5);
		
		JTextField fN = new JTextField(10);
		c5.gridx = 1;
		c5.gridy = 3;
		dfirstnameTextField = new JPanel();
		dfirstnameTextField.setPreferredSize(new Dimension(150,35));
		dfirstnameTextField.add(fN);
		dfirstnameTextField.setBackground(new Color(255,250,205));
		patientDeleteSearch.add(dfirstnameTextField,c5);
		
		JLabel birthDate = new JLabel("Birth Date (MM/DD/YYYY)");
		c5.gridx = 0;
		c5.gridy = 4;
		patientDeleteSearch.add(birthDate,c5);
		
		JTextField bD = new JTextField(10);
		c5.gridx = 1;
		c5.gridy = 4;
		dbirthdateTextField = new JPanel();
		dbirthdateTextField.setPreferredSize(new Dimension(150,35));
		dbirthdateTextField.add(bD);
		dbirthdateTextField.setBackground(new Color(255,250,205));
		patientDeleteSearch.add(dbirthdateTextField,c5);
	
		JButton patientb3 = new JButton("Submit");
		JButton backb3 = new JButton("Back");
		
		c5.gridx = 12;
		c5.gridy = 25;
		patientDeleteSearch.add(patientb3,c5);
		
		c5.gridx = 0;
		c5.gridy = 25;
		patientDeleteSearch.add(backb3,c5);
		
		SubmitDeleteListener pnlistener3 = new SubmitDeleteListener();
		patientb3.addActionListener(pnlistener3);

		BackButtonListener3 blistener3 = new BackButtonListener3();
		backb3.addActionListener(blistener3);
		
		patientDeleteSearch.setVisible(false);
		c5.gridx = 3;
		c5.gridy = 3;
		add(patientDeleteSearch, c5);
		
		//Doctor Schedule
		mainSchedule = new JPanel(new BorderLayout());
		mainSchedule.setPreferredSize(new Dimension(1300,1000));
		mainSchedule.setBackground(Color.WHITE);
		
		panelSchedule = new JPanel();
		panelSchedule.setPreferredSize(new Dimension(1200,1400));
	    panelSchedule.setBackground(new Color(255,229,204));
	    panelSchedule.setBorder(BorderFactory.createLineBorder(new Color(255,153,153)));
	     
	    yearPanel = new JPanel();
	    yearPanel.setPreferredSize(new Dimension(200,100));
	    yearPanel.setBackground(new Color(204,255,204));
	    
	    calendarPanel = new JPanel();
	    calendarPanel.setPreferredSize(new Dimension(1200,780));
	    calendarPanel.setBackground(new Color(255,204,153));
	    
	    moreInfoSched = new JButton("More Info");
	    
	    infoSchedListener schedlistener = new infoSchedListener();
	    moreInfoSched.addActionListener(schedlistener);
	  
	    String[] yearStrings = {"2016", "2015"};
	    
	    JLabel calendarLabel = new JLabel("Pick A Year to View");
	    calendarLabel.setFont(new Font("Serif",Font.BOLD, 20));
	    
	    JComboBox yearCal = new JComboBox(yearStrings);
	    yearPanel.setBorder(BorderFactory.createLineBorder(Color.black));
	   
	    yearPanel.add(calendarLabel);
	    yearPanel.add(yearCal);
	    yearPanel.add(moreInfoSched);
	    
	    scheduleScroll = new JScrollPane(panelSchedule);
	
		mainSchedule.add(scheduleScroll);
		mainSchedule.setVisible(false);
	
		//2016 CALENDAR
		
		//JANUARY 
		String[] janColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		    
		String[][] janData = {{" ", " ", " ", " ", "", "1", "2"},
		{"3", "4", "5", "6", "7","8", "9"},
		{"10", "11", "12", "13", "14", "15", "16"},
		{"17", "18", "19", "21", "22", "23", "24"},
		{"25", "26", "27", "28", "29", "30", "31"}};
  
		JTable janCal = new JTable(janData, janColumns);
		janCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		janCal.setPreferredScrollableViewportSize(new Dimension(1000,780));
		janCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		janCal.setFont(new Font("Verdana", Font.BOLD, 20));
		janCal.setRowHeight(140);

		JScrollPane janPane = new JScrollPane(janCal);
   
		//FEBUARY 
		String[] febColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[][] febData = {
		{" ", "1 ", "2", "3", "4", "5", "6"},
		{"7", "8", "9", "10", "11","12", "13"},
		{"14", "15", "16", "17", "18", "19", "20"},
		{"21", "22", "23", "24", "25", "26", "27"},
		{"28", "29", " ", " ", " ", " ", " "}};
		   	  
		 JTable febCal = new JTable(febData, febColumns);
		 febCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		 febCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
		 febCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 febCal.setFont(new Font("Verdana", Font.BOLD, 20));
		 febCal.setRowHeight(140);
		 JScrollPane febPane = new JScrollPane(febCal);
		   	  
		 //MARCH
		 String[] marchColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	   	 String[][] marchData = {
	   	 {"", " ", "1", "2", "3", "4", "5"},
	   	 {"6","7", "8", "9", "10", "11", "12"},
	   	 {"13", "14", "15", "16", "17", "18","19"},
	   	 {"20", "21", "22", "23", "24", "25", "26"}, 
	   	 {"27", "28", "29", "30", "31", " ", " "}};
	   	     
	   	 JTable marchCal = new JTable(marchData, marchColumns);
		 marchCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		 marchCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
		 marchCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 marchCal.setFont(new Font("Verdana", Font.BOLD, 20));
		 marchCal.setRowHeight(140);

	   	 JScrollPane marchPane = new JScrollPane(marchCal);  
	   	   
	     //APRIL
	     String[] aprilColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
   	     String[][] aprilData = {
   	     {" ", " ", " ", " ", " ", "1", "2"},
   	     {"3", "4", "5", "6", "7", "8", "9"},
   	     {"10", "11", "12", "13", "14", "15", "16"},
   	     {"17", "18", "19", "20", "21", "22", "23"},
   	     {"24", "25", "26", "27", "28", "29", "30"}};
   	      
	   	 JTable aprilCal = new JTable(aprilData, aprilColumns);
		 aprilCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		 aprilCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
		 aprilCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 aprilCal.setFont(new Font("Verdana", Font.BOLD, 20));
		 aprilCal.setRowHeight(140);

   	   	JScrollPane aprilPane = new JScrollPane(aprilCal);  
    		   
   	    //MAY
   	   	String[] mayColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
   	   	String[][] mayData = {
	    {"1", "2", "3", "4", "5", "6", "7"},
	    {"8", "9", "10", "11", "12", "13", "!4"},
	    {"15", "16", "!7", "18", "19", "20", "21"},
	    {"22", "23", "24", "25", "26", "27", "28"},
	    {"29", "30", "31"}};
	  
   	   	JTable mayCal = new JTable(mayData, mayColumns);
   	   	mayCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
   	   	mayCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
		mayCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		mayCal.setFont(new Font("Verdana", Font.BOLD, 20));
		mayCal.setRowHeight(140);
		JScrollPane mayPane = new JScrollPane(mayCal);  
   	   
		//JUNE
		String[] juneColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    String[][] juneData = {
	    {" ", " ", " ", "1", "2", "3", "4"},
	    {"5", "6", "7", "8", "9", "10", "11"},
	    {"12","13","14","15","16","17", "18"},
	    {"19","20","21","22","23","24","25"},
	    {"26","27","28","29", "30", " ", " "}};
	    
	    JTable juneCal = new JTable(juneData, juneColumns);   
	    juneCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    juneCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    juneCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    juneCal.setFont(new Font("Verdana", Font.BOLD, 20));
	    juneCal.setRowHeight(140);
	    JScrollPane junePane = new JScrollPane(juneCal);
	   
	    //JUlY
		String[] julyColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] julyData = {
  	    {" ", " ", " ", " ", " ", "1", "2"},
  	    {"3", "4", "5", "6","7", "8", "9"},
  	    {"10","11","12","13","14","15","16"},
  	    {"17", "18", "19", "20", "21", "22", "23"},
  	    {"24", "25", "26", "27", "28", "29", "30"},
  	    {"31", " ", " ", " ", " ", " ", " "}};
  	   
	  	JTable julyCal = new JTable(julyData, julyColumns); 
		julyCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		julyCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
		julyCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		julyCal.setFont(new Font("Verdana", Font.BOLD, 20));
		julyCal.setRowHeight(140);
	    JScrollPane julyPane = new JScrollPane(julyCal);
	      
  	    //AUGUST
	    String[] augustColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    String[][] augustData = {
	    {"", "1", "2", "3", "4", "5", "6"},
	    {"7", "8", "9", "10", "11", "12", "13"},
	    {"14", "15", "16", "17", "18", "19", "20"},
	    {"21", "22", "23", "24", "25", "26", "27"},
	    {"28", "29", "30", "31", " ", " ", " "}};
	     
	    JTable augustCal = new JTable(augustData, augustColumns); 
	    augustCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    augustCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    augustCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    augustCal.setFont(new Font("Verdana", Font.BOLD, 20));
	    augustCal.setRowHeight(140);
        JScrollPane augustPane = new JScrollPane(augustCal);   
        
        //SEPTEMBER
        String[] septColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] septData = {
  	    {"", " ", " ", " ", "1", "2", "3"},
  	    {"4", "5", "6", "7", "8", "9", "10"},
  	    {"11", "12", "13", "14", "15", "16", "17"},
  	    {"18", "19", "20", "21", "22", "23", "24"},
  	    {"25", "26", "27", "28", "29", "30", " "}};
  	    
  	   JTable septCal = new JTable(septData, septColumns);  
	   septCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	   septCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
	   septCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   septCal.setFont(new Font("Verdana", Font.BOLD, 20));
	   septCal.setRowHeight(140);
	   JScrollPane septPane = new JScrollPane(septCal);  
	   
	    //OCTOBER
		String[] octColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] octData = {
  	    {"", " ", "  ", " ", " ", " ", "1"},
  	    {"2", "3", "4", "5", "6", "7", "8"},
  	    {"9", "10", "11", "12", "13", "14", "15"},
  	    {"16", "17", "18", "19", "20", "21", "22"},
  	    {"23", "24", "25", "26", "27", "28", "29"},
  	    {"30", "31", " ", " ", " ", " ", " "}};
  	    
  	   JTable octCal = new JTable(octData, octColumns);   
	   octCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	   octCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
	   octCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   octCal.setFont(new Font("Verdana", Font.BOLD, 20));
	   octCal.setRowHeight(140);
       JScrollPane octPane = new JScrollPane(octCal);  
 
       //NOVEMEBER
		String[] novColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] novData = {
  	    {"", " ", "1", "2", "3", "4", "5"},
  	    {"6", "7", "8", "9", "10", "11", "12"},
  	    {"13", "14", "15", "16", "17", "18", "19"},
  	    {"20", "21", "22", "23", "24", "25", "26"},
  	    {"27", "28", "29", "30", " ", " ", " "}};
  	    
  	    JTable novCal = new JTable(novData, novColumns);   
	    novCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    novCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    novCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    novCal.setFont(new Font("Verdana", Font.BOLD, 20));
	    novCal.setRowHeight(140);
        JScrollPane novPane = new JScrollPane(novCal); 
      
        //DECEMBER
		String[] decColumns = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] decData = {
  	    {" ", " ", " ", " ", "1", "2", "3"},
  	    {"4", "5", "6", "7", "8", "9", "10"},
  	    {"11", "12", "13", "14", "15", "16", "17"},
  	    {"18", "19", "20", "21", "22", "23", "24"},
  	    {"25", "26", "27", "28", "29", "30", "31"}};
  	    
  	    JTable decCal = new JTable(decData, decColumns);
	    decCal.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    decCal.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    decCal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    decCal.setFont(new Font("Verdana", Font.BOLD, 20));
	    decCal.setRowHeight(140);
        JScrollPane decPane = new JScrollPane(decCal); 
      
        Caltabbed2016 = new JTabbedPane();
	    
	    Caltabbed2016.setPreferredSize(new Dimension(1200,1000));
				
		Caltabbed2016.addTab("January",  janPane);
		Caltabbed2016.addTab("Febuary", febPane);
		Caltabbed2016.addTab("March", marchPane);
		Caltabbed2016.addTab("April", aprilPane);
		Caltabbed2016.addTab("May", mayPane);
		Caltabbed2016.addTab("June", junePane);
		Caltabbed2016.addTab("July", julyPane);
		Caltabbed2016.addTab("August", augustPane);
		Caltabbed2016.addTab("September", septPane);
		Caltabbed2016.addTab("October", octPane);
		Caltabbed2016.addTab("November", novPane);
		Caltabbed2016.addTab("December", decPane);
		
		calendarPanel.add(Caltabbed2016);
		
		//2015 CALENDAR
		
		//JANUARY
		String[] janColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    
		String[][] janData15 = {{" ", " ", " ", " ", "1", "2", "3"},
		{"4", "5", "6", "7", "8","9", "10"},
		{"11", "12", "13", "14", "15", "16", "17"},
		{"18", "19", "20", "21", "22", "23", "24"},
		{"25", "26", "27", "28", "29", "30", "31"}};
		
		JTable janCal15 = new JTable(janData15, janColumns15);
		janCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		janCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
		janCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		janCal15.setFont(new Font("Verdana", Font.BOLD, 20));
		janCal15.setRowHeight(140);

		JScrollPane janPane15 = new JScrollPane(janCal15);
		
		//FEBUARY
		String[] febColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[][] febData15 = {
		{"1", "2 ", "3", "4", "5", "6", "7"},
		{"8", "9", "10", "11", "12","13", "14"},
		{"15", "16", "17", "18", "19", "20", "21"},
		{"22", "23", "24", "25", "26", "27", "28"},
		{" ", " ", " ", " ", " ", " "}};
		   	  
		 JTable febCal15 = new JTable(febData15, febColumns15);
		 febCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		 febCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
		 febCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 febCal15.setFont(new Font("Verdana", Font.BOLD, 20));
		 febCal15.setRowHeight(140);
		 JScrollPane febPane15 = new JScrollPane(febCal15);
		
		 //MARCH
		 String[] marchColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	   	 String[][] marchData15 = {
	   	 {"1", "2", "3", "4", "5", "6", "7"},
	   	 {"8","9", "10", "11", "12", "13", "14"},
	   	 {"15", "16", "17", "18", "19", "20","21"},
	   	 {"22", "23", "24", "25", "26", "27", "28"}, 
	   	 {"29", "30", "31", " ", " ", " ", " "}};
	   	     
	   	 JTable marchCal15 = new JTable(marchData15, marchColumns15);
		 marchCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		 marchCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
		 marchCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 marchCal15.setFont(new Font("Verdana", Font.BOLD, 20));
		 marchCal15.setRowHeight(140);

	   	 JScrollPane marchPane15 = new JScrollPane(marchCal15);  
	   	 
	   	 //APRIL
	   	 String[] aprilColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
   	     String[][] aprilData15 = {
   	     {" ", " ", " ", "1", "2", "3", "4"},
   	     {"5", "6", "7", "8", "9", "10", "11"},
   	     {"12", "13", "14", "15", "16", "17", "18"},
   	     {"19", "20", "21", "22", "23", "24", "25"},
   	     {"26", "27", "28", "29", "30", " ", " "}};
   	      
	   	 JTable aprilCal15 = new JTable(aprilData15, aprilColumns15);
		 aprilCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		 aprilCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
		 aprilCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 aprilCal15.setFont(new Font("Verdana", Font.BOLD, 20));
		 aprilCal15.setRowHeight(140);
		 
		 JScrollPane aprilPane15 = new JScrollPane(aprilCal15); 
		 
		 //MAY
		 String[] mayColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	   	 String[][] mayData15 = {
		 {" ", " ", " ", " ", " ", "1", "2"},
		 {"3", "4", "5", "6", "7", "8", "9"},
		 {"10", "11", "!2", "13", "14", "15", "16"},
		 {"17", "18", "19", "20", "21", "22", "23"},
		 {"24", "25", "26","27", "28", "30", "31"}};
		  
	   	 JTable mayCal15 = new JTable(mayData15, mayColumns15);
	   	 mayCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	   	 mayCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	   	 mayCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   	 mayCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	   	 mayCal15.setRowHeight(140);
	   	 JScrollPane mayPane15 = new JScrollPane(mayCal15);  

   	    //JUNE
   	    String[] juneColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    String[][] juneData15 = {
	    {" ", "1", "2", "3", "4", "5", "6"},
	    {"7", "8", "9", "10", "11", "12", "13"},
	    {"14","15","16","17","18","19", "20"},
	    {"21","22","23","24","25","26","27"},
	    {"28","29","30"," ", " ", " ", " "}};
	    
	    JTable juneCal15 = new JTable(juneData15, juneColumns15);   
	    juneCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    juneCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    juneCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    juneCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	    juneCal15.setRowHeight(140);
	    JScrollPane junePane15 = new JScrollPane(juneCal15);
	   
	    //JULY
	    String[] julyColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] julyData15 = {
  	    {" ", " ", " ", "1", "2", "3", "4"},
  	    {"5", "6", "7", "8","9", "10", "11"},
  	    {"12","13","14","15","16","17","18"},
  	    {"19", "20", "21", "22", "23", "24", "25"},
  	    {"26", "27", "28", "29", "30", "31", " "}};
  	   
	  	JTable julyCal15 = new JTable(julyData15, julyColumns15); 
		julyCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		julyCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
		julyCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		julyCal15.setFont(new Font("Verdana", Font.BOLD, 20));
		julyCal15.setRowHeight(140);
	    JScrollPane julyPane15 = new JScrollPane(julyCal15);
	    
	    //AUGUST
	    String[] augustColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    String[][] augustData15 = {
	    {"", " ", " ", " ", " ", " ", "1"},
	    {"2", "3", "4", "5", "6", "7", "8"},
	    {"9", "10", "11", "12", "13", "14", "15"},
	    {"16", "17", "18", "19", "20", "21", "22"},
	    {"23", "24", "25", "26", "27", "28", "29"},
	    {"30", "31", " ", " ", " ", " ", " "}};
	     
	    JTable augustCal15 = new JTable(augustData15, augustColumns15); 
	    augustCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    augustCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    augustCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    augustCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	    augustCal15.setRowHeight(140);
        JScrollPane augustPane15 = new JScrollPane(augustCal15);   
        
	    //SEPTEMBER
        String[] septColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String[][] septData15 = {{" ", " ", "1", "2", "3", "4", "5"},
        		{"6", "7", "8", "9", "10","11", "12"},
        		{"13", "14", "15", "16", "17", "18", "19"},
        		{"20", "21", "22", "23", "24", "25", "26"},
        		{"27", "28", "29", "30", " ", " ", " "}};
        
  	   JTable septCal15 = new JTable(septData15, septColumns15);  
	   septCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	   septCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	   septCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   septCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	   septCal15.setRowHeight(140);
	   JScrollPane septPane15 = new JScrollPane(septCal15);  
	   
	    //OCTOBER
	    String[] octColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    String[][] octData15 = {{" ", " ", " ", " ", "1", "2", "3"},
        		{"4", "5", "6", "7", "8","9", "10"},
        		{"11", "12", "13", "14", "15", "16", "17"},
        		{"18", "19", "20", "21", "22", "23", "24"},
        		{"25", "26", "27", "28", "29", "30", "31"}};
 	    
 	   JTable octCal15 = new JTable(octData15, octColumns15);   
	   octCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	   octCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	   octCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	   octCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	   octCal15.setRowHeight(140);
       JScrollPane octPane15 = new JScrollPane(octCal15);  

	    //NOVEMBER
        String[] novColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	    String[][] novData15 = {{"1", "2 ", "3", "4", "5", "6", "7"},
	    		{"8", "9", "10", "11", "12","13", "14"},
	    		{"15", "16", "17", "18", "19", "20", "21"},
	    		{"22", "23", "24", "25", "26", "27", "28"},
	    		{"29", "30", " ", " ", " ", " ", ""}};
	    
	    JTable novCal15 = new JTable(novData15, novColumns15);   
	    novCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    novCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    novCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    novCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	    novCal15.setRowHeight(140);
        JScrollPane novPane15 = new JScrollPane(novCal15); 
	    
	    //DECEMBER
        String[] decColumns15 = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
  	    String[][] decData15 = {{" ", " ", " ", "1", "2", "3", "4"},
        		{"5", "6", "7", "8", "9","10", "11"},
        		{"12", "13", "14", "15", "16", "17", "18"},
        		{"19", "20", "21", "22", "23", "24", "25"},
        		{"26", "27", "28", "30", "31", " ", " "}};
  	    
  	    JTable decCal15 = new JTable(decData15, decColumns15);
	    decCal15.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
	    decCal15.setPreferredScrollableViewportSize(new Dimension(1000,700));
	    decCal15.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
	    decCal15.setFont(new Font("Verdana", Font.BOLD, 20));
	    decCal15.setRowHeight(140);
        JScrollPane decPane15 = new JScrollPane(decCal15); 
   	     
		 Caltabbed2015 = new JTabbedPane();
		
		 Caltabbed2015.setPreferredSize(new Dimension(1200,1000));
		
		 Caltabbed2015.addTab("January", janPane15);
		 Caltabbed2015.addTab("Febuary", febPane15);
		 Caltabbed2015.addTab("March", marchPane15);
		 Caltabbed2015.addTab("April", aprilPane15);
		 Caltabbed2015.addTab("May", mayPane15);
		 Caltabbed2015.addTab("June", junePane15);
		 Caltabbed2015.addTab("July", julyPane15);
		 Caltabbed2015.addTab("August", augustPane15);
		 Caltabbed2015.addTab("September", septPane15);
		 Caltabbed2015.addTab("October", octPane15);
		 Caltabbed2015.addTab("November", novPane15);
		 Caltabbed2015.addTab("December", decPane15);
		 
		 calendarPanel.add(Caltabbed2015);
		
		GridBagConstraints consSched = new GridBagConstraints();
		consSched.insets = new Insets(10,10,10,10);
		consSched.gridx = 0;
		consSched.gridy = 0;
		panelSchedule.add(yearPanel, consSched);
			 
		consSched.gridx = 0;
		consSched.gridy = 1;
		panelSchedule.add(calendarPanel, consSched);
		
		add(mainSchedule);
		
		ScheduleComboListener schedListener = new ScheduleComboListener();
		yearCal.addActionListener(schedListener);
	
		//New Patient Panel Form
		patientInfoPanel = new JPanel();
	    patientInfoPanel.setPreferredSize(new Dimension(800,800));
	    patientInfoPanel.setBackground(new Color(255,250,205));
		patientInfoPanel.setVisible(false);
				
		patientInfo1 = new JPanel(new GridBagLayout());
		patientInfo1.setPreferredSize(new Dimension(400,200));
		patientInfo1.setBackground(new Color(255,250,205));
		patientInfo1.setBorder(BorderFactory.createTitledBorder("Patient Information"));
		patientInfo1.setVisible(true);
		patientInfoPanel.add(patientInfo1);
		
		GridBagConstraints r5 = new GridBagConstraints();
		
		JLabel firstname = new JLabel("First Name: ");
		JTextField fn  = new JTextField(10); 
		
		r5.gridx = 0;
		r5.gridy = 0;
		patientInfo1.add(firstname, r5);
		
		r5.gridx = 1;
		r5.gridy = 0;
		patientInfo1.add(fn, r5);
		
		JLabel middlename = new JLabel("Middle Name: ");
		JTextField mn  = new JTextField(3); 
		r5.gridx = 0;
		r5.gridy = 1;
		patientInfo1.add(middlename, r5);
		
		r5.gridx = 1;
		r5.gridy = 1;
		patientInfo1.add(mn, r5);
		
		JLabel lastname = new JLabel("Last Name: ");
		JTextField ln = new JTextField(10);
		r5.gridx = 0;
		r5.gridy = 2;
		patientInfo1.add(lastname, r5);
		
		r5.gridx = 1;
		r5.gridy = 2;
		patientInfo1.add(ln, r5);
		
		JLabel gender = new JLabel("Gender");
		r5.gridx = 0;
		r5.gridy = 3;
		patientInfo1.add(gender, r5);
		
		String[] g = {"Female", "Male"};
		JComboBox gBox = new JComboBox(g);
		r5.gridx = 1;
		r5.gridy = 3;
		patientInfo1.add(gBox, r5);
		
		patientInfo2 = new JPanel(new GridBagLayout());
		patientInfo2.setBackground(new Color(255,250,205));
		patientInfo2.setPreferredSize(new Dimension(400,200));
		patientInfo2.setBorder(BorderFactory.createTitledBorder("Patient Information"));
		patientInfo2.setVisible(true);
		patientInfoPanel.add(patientInfo2);
		
		GridBagConstraints r6 = new GridBagConstraints();

	    JLabel prefix = new JLabel("Prefix:");
		r6.gridx = 0;
		r6.gridy = 1;
		patientInfo2.add(prefix, r6);
		
		String[] pfix = {"Mr", "Ms", "Mrs"};
		JComboBox prefixBox = new JComboBox(pfix);
		r6.gridx = 1;
		r6.gridy = 1;
		patientInfo2.add(prefixBox, r6);
		
		
		JLabel maritalstatus = new JLabel("Marital Status: ");
		r6.gridx = 0;
		r6.gridy = 2;
		patientInfo2.add(maritalstatus, r6);
		
		String[] mstatus = {"single", "married", "seperated", "divorced", "widowed"};
		JComboBox mstatusBox = new JComboBox(mstatus);
		r6.gridx = 1;
		r6.gridy = 2;
		patientInfo2.add(mstatusBox, r6);
	
		JLabel ethnicity  = new JLabel("Ethnicity:");
		r6.gridx = 0;
		r6.gridy= 3;
		patientInfo2.add(ethnicity, r6);
		
		String[] ethnarray = {"Hispanic", "Non-Hispanic"};
		JComboBox ethn = new JComboBox(ethnarray);
		r6.gridx = 1;
		r6.gridy= 3;
		patientInfo2.add(ethn, r6);
		
		
		JLabel race  = new JLabel("Race:");
		r6.gridx = 0;
		r6.gridy = 4;
		patientInfo2.add(race, r6);
		
		String[] racearray = {"White", "Black, African American", "Latino/Hispanic", "Native American", "Asian", "Pacific Islander", "Other"};
		JComboBox rstatusBox = new JComboBox(racearray);
		r6.gridx = 1;
		r6.gridy = 4;
		patientInfo2.add(rstatusBox, r6);
		
		patientInfo3 = new JPanel(new GridBagLayout());
		patientInfo3.setBackground(new Color(255,250,205));
		patientInfo3.setPreferredSize(new Dimension(800,200));
		patientInfo3.setBorder(BorderFactory.createTitledBorder("Patient Info"));
		patientInfo3.setVisible(true);
		patientInfoPanel.add(patientInfo3);
		
		GridBagConstraints r8 = new GridBagConstraints();

		JLabel birthdate = new JLabel("Date of Birth:");
		
		r8.gridx = 0;
		r8.gridy = 0;
		patientInfo3.add(birthdate, r8);
		
		String[] month = {"Month" , "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		JComboBox monthBox = new JComboBox(month);
		r8.gridx = 1;
		r8.gridy = 0;
		patientInfo3.add(monthBox,r8);
		
		String[] date = {"Date", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24","25","26", "27","28", "29", "30","31"};
		JComboBox dateBox = new JComboBox(date);
		r8.gridx = 2;
		r8.gridy = 0;
		patientInfo3.add(dateBox, r8);
		
		JTextField dobyear = new JTextField(10);
		dobyear.setText("Year");
				
		r8.gridx = 3;
		r8.gridy = 0;
		patientInfo3.add(dobyear,r8);
		
		JLabel age = new JLabel("Age");
		r8.gridx = 7;
		r8.gridy = 0;
		patientInfo3.add(age, r8);
		
		JTextField a = new JTextField(3);
		r8.gridx = 8;
		r8.gridy = 0;
		patientInfo3.add(a, r8);
		
		JLabel ssnum = new JLabel("Social Security Number:");
		r8.gridx = 0;
		r8.gridy = 1;
		patientInfo3.add(ssnum, r8);
		
		JTextField ssn = new JTextField(10);
		ssn.setText("xxx-xx-xxxx");
		r8.gridx = 1;
		r8.gridy = 1;
		patientInfo3.add(ssn, r8);
		
		JLabel emailaddress = new JLabel("Email Address: ");
		r8.gridx = 2;
		r8.gridy = 1;
		patientInfo3.add(emailaddress, r8);
		
		JTextField ea  = new JTextField(10); 
		r8.gridx = 3;
		r8.gridy = 1;
		patientInfo3.add(ea, r8);
		
		JLabel homePhone = new JLabel("Home Phone:");
		r8.gridx = 0;
		r8.gridy =3;
		patientInfo3.add(homePhone, r8);
		
		JTextField hp = new JTextField(10);
		r8.gridx = 1;
		r8.gridy = 3;
		patientInfo3.add(hp, r8);
		
		JLabel WorkPhone = new JLabel("Work Phone:");
		r8.gridx = 2;
		r8.gridy = 3;
		patientInfo3.add(WorkPhone, r8);
		
		JTextField wp  = new JTextField(10); 
		r8.gridx = 3;
		r8.gridy = 3;
		patientInfo3.add(wp, r8);
		
		JLabel CellPhone = new JLabel("Cell Phone:");
		r8.gridx = 0;
		r8.gridy = 4;
		patientInfo3.add(CellPhone, r8);
		
		JTextField cellph  = new JTextField(10);
		r8.gridx = 1;
		r8.gridy = 4;
		patientInfo3.add(cellph, r8);
		
		JButton cnpatient1 = new JButton("Create New Patient");
		r8.gridx = 8;
		r8.gridy = 5;
		patientInfo3.add(cnpatient1, r8);
		
		moreInfoNew = new JButton("More Info");
		r8.gridx = 0;
		r8.gridy = 5;
		patientInfo3.add(moreInfoNew,r8);
		
		moreInfoNewListener mnewlistener = new moreInfoNewListener();
		moreInfoNew.addActionListener(mnewlistener);
		
		//add(patientInfoPanel);
	
		//ParentsInfo
		parentsInfo = new JPanel(new FlowLayout());
		parentsInfo.setPreferredSize(new Dimension(800,800));
		parentsInfo.setBackground(new Color(255,250,205));
		parentsInfo.setVisible(false);
		
		parentsInfo1 = new JPanel(new GridBagLayout());
		parentsInfo.add(parentsInfo1);
		parentsInfo1.setPreferredSize(new Dimension(400,200));
		parentsInfo1.setBorder(BorderFactory.createTitledBorder("Mother"));
		parentsInfo1.setBackground(new Color(255,250,205));
		
		GridBagConstraints r7 = new GridBagConstraints();
		
		JLabel motherLastname = new JLabel("Mother Last Name: ");
		r7.gridx = 0;
		r7.gridy = 0;
		parentsInfo1.add(motherLastname, r7);
		
		JTextField mln = new JTextField(10);
		r7.gridx = 1;
		r7.gridy = 0;
		parentsInfo1.add(mln, r7);
		
		JLabel motherfirstname = new JLabel("Mother First Name: ");
		r7.gridx = 0;
		r7.gridy = 2;
		parentsInfo1.add(motherfirstname, r7);
	
		JTextField mfn = new JTextField(10);
		r7.gridx = 1;
		r7.gridy = 2;
		parentsInfo1.add(mfn, r7);
		
		JLabel motherssnum = new JLabel("Social Security Number:");
		r7.gridx = 0;
		r7.gridy = 3;
		parentsInfo1.add(motherssnum, r7);
		
		JTextField momssn = new JTextField(10);
		momssn.setText("xxx-xx-xxxx");
		r7.gridx = 1;
		r7.gridy = 3;
		parentsInfo1.add(momssn, r7);
		
		JLabel momhomePhone = new JLabel("Home Phone:");
		r7.gridx = 0;
		r7.gridy = 4;
		parentsInfo1.add(momhomePhone, r7);
		
		JTextField momhPhone = new JTextField(10);
		r7.gridx = 1;
		r7.gridy = 4;
		parentsInfo1.add(momhPhone, r7);
		
		JLabel momcellPhone = new JLabel("Cell Phone:");
		r7.gridx = 0;
		r7.gridy = 5;
		parentsInfo1.add(momcellPhone, r7);
		
		JTextField momcPhone = new JTextField(10);
		r7.gridx = 1;
		r7.gridy = 5;
		parentsInfo1.add(momcPhone, r7);
		
		parentsInfo2 = new JPanel(new GridBagLayout());
		parentsInfo.add(parentsInfo2);
		parentsInfo2.setBorder(BorderFactory.createTitledBorder("Father"));
		parentsInfo2.setPreferredSize(new Dimension(400,200));
		parentsInfo2.setBackground(new Color(255,250,205));
		
		GridBagConstraints r10 = new GridBagConstraints();
		
		JLabel fatherLastname = new JLabel("Father Last Name: ");
		r10.gridx = 0;
		r10.gridy = 0;
		parentsInfo2.add(fatherLastname, r10);
		
		JTextField fln = new JTextField(10);
		r10.gridx= 1;
		r10.gridy = 0;
		parentsInfo2.add(fln, r10);
	
		JLabel fatherfirstname = new JLabel("Father First Name: ");
		r10.gridx = 0;
		r10.gridy = 1;
		parentsInfo2.add(fatherfirstname, r10);
		
		JTextField ffn = new JTextField(10);
		r10.gridx = 1;
		r10.gridy = 1;
		parentsInfo2.add(ffn, r10);
		
		JLabel fatherssnum = new JLabel("Social Security Number:");
		r10.gridx = 0;
		r10.gridy = 2;
		parentsInfo2.add(fatherssnum, r10);
		
		JTextField dadssn = new JTextField(10);
		dadssn.setText("xxx-xx-xxxx");
		r10.gridx = 1;
		r10.gridy = 2;
		parentsInfo2.add(dadssn, r10);
		
		JLabel dadhomePhone = new JLabel("Home Phone:");
		r10.gridx = 0;
		r10.gridy = 3;
		parentsInfo2.add(dadhomePhone, r10);
		
		JTextField dadhPhone = new JTextField(10);
		r10.gridx = 1;
		r10.gridy = 3;
		parentsInfo2.add(dadhPhone, r10);
		
		JLabel dadcellPhone = new JLabel("Cell Phone:");
		r10.gridx = 0;
		r10.gridy = 4;
		parentsInfo2.add(dadcellPhone, r10);
		
		JTextField dadcPhone = new JTextField(10);
		r10.gridx = 1;
		r10.gridy = 4;
		parentsInfo2.add(dadcPhone, r10);
		
		parentsInfo3 = new JPanel(new GridBagLayout());
		parentsInfo3.setPreferredSize(new Dimension(800,200));
		parentsInfo3.setBorder(BorderFactory.createTitledBorder("Guardian"));
		parentsInfo3.setBackground(new Color(255,250,205));
		parentsInfo.add(parentsInfo3);
		
		GridBagConstraints r11 = new GridBagConstraints();
		
		JLabel gLastname = new JLabel("Guardian Last Name: ");
		r11.gridx = 0;
		r11.gridy = 0;
		parentsInfo3.add(gLastname, r11);
		
		JTextField gln = new JTextField(11);
		r11.gridx= 1;
		r11.gridy = 0;
		parentsInfo3.add(gln, r10);
		
	    JLabel gfirstname = new JLabel("Guardian First Name: ");
	    r11.gridx = 0;
		r11.gridy = 1;
	    parentsInfo3.add(gfirstname, r11);
	    
		JTextField gf  = new JTextField(10); 
		r11.gridx = 1;
		r11.gridy = 1;
		parentsInfo3.add(gf, r11);
		
		JLabel gssnum = new JLabel("Social Security Number:");
		r11.gridx = 0;
		r11.gridy = 2;
		parentsInfo3.add(gssnum, r11);
		
		JTextField gssn = new JTextField(10);
		gssn.setText("xxx-xx-xxxx");
		r11.gridx = 1;
		r11.gridy = 2;
		parentsInfo3.add(gssn, r11);
		
		JLabel ghomePhone = new JLabel("Home Phone:");
		r11.gridx = 0;
		r11.gridy = 3;
		parentsInfo3.add(ghomePhone, r11);
		
		JTextField ghPhone = new JTextField(10);
		r11.gridx = 1;
		r11.gridy = 3;
		parentsInfo3.add(ghPhone, r11);
		
		JLabel gcellPhone = new JLabel("Cell Phone:");
		r11.gridx = 0;
		r11.gridy = 4;
		parentsInfo3.add(gcellPhone, r11);
		
		JTextField gcPhone = new JTextField(10);
		r11.gridx = 1;
		r11.gridy = 4;
		parentsInfo3.add(gcPhone, r11);
		
		JButton cnpatient2 = new JButton("Create New Patient");
		r11.gridx = 7;
		r11.gridy = 5;
		parentsInfo3.add(cnpatient2, r11);
				
		//Address	
		addressInfo = new JPanel(new FlowLayout());
		addressInfo.setPreferredSize(new Dimension (800,800));
		addressInfo.setBackground(new Color(255,250,205));
		addressInfo.setVisible(true);
		
		addressInfo1 = new JPanel(new GridBagLayout());
		addressInfo.add(addressInfo1);
		addressInfo1.setPreferredSize(new Dimension(400,200));
		addressInfo1.setBorder(BorderFactory.createTitledBorder("Address"));
		addressInfo1.setBackground(new Color(255,250,205));
		addressInfo1.setVisible(true);
		
		GridBagConstraints r12 = new GridBagConstraints();
		
		JLabel address = new JLabel("Address:");
		r12.gridx = 0;
		r12.gridy = 0;
		addressInfo1.add(address, r12);
		
		JTextField a1  = new JTextField(20); 
		r11.gridx = 1;
		r11.gridy = 0;
		addressInfo1.add(a1, r11);

		JLabel aptnum = new JLabel("Apt #");
		r12.gridx = 0;
		r12.gridy = 1;
		addressInfo1.add(aptnum, r12);
		
		JTextField apttf = new JTextField(5);
		r11.gridx = 1;
		r11.gridy = 1;
		addressInfo1.add(apttf, r11);
		
		JLabel city = new JLabel("City:");
		r11.gridx = 0;
		r11.gridy = 2;
		addressInfo1.add(city, r11);

		JTextField city2  = new JTextField(10);
		r11.gridx = 1;
		r11.gridy = 2;
		addressInfo1.add(city2, r11);

		JLabel state = new JLabel("State:");
		r11.gridx = 0;
		r11.gridy = 3;
		addressInfo1.add(state, r11);

		JTextField st  = new JTextField(5); 
		r11.gridx = 1;
		r11.gridy = 3;
		addressInfo1.add(st, r11);
		
		JLabel zipcode = new JLabel("Zip Code:");
		r11.gridx = 0;
		r11.gridy = 4;
		addressInfo1.add(zipcode, r11);
		
		JTextField zc  = new JTextField(10); 
		r11.gridx = 1;
		r11.gridy = 4;
		addressInfo1.add(zc, r11);
		
		addressInfo2 = new JPanel(new GridBagLayout());
		addressInfo2.setPreferredSize(new Dimension(400,200));
		addressInfo2.setBorder(BorderFactory.createTitledBorder("Pharmacy Info"));
		addressInfo2.setBackground(new Color(255,250,205));
		addressInfo.add(addressInfo2);
		
		GridBagConstraints r13 = new GridBagConstraints();
		
		JLabel pharmacy = new JLabel("Pharmacy Name:");
		r13.gridx = 0;
		r13.gridy = 0;
		addressInfo2.add(pharmacy,r13);
		
		JTextField pharm = new JTextField(10);
		r13.gridx = 1;
		r13.gridy = 0;
		addressInfo2.add(pharm,r13);
		
		JLabel pharmaddress = new JLabel("Address:");
		r13.gridx = 0;
		r13.gridy = 1;
		addressInfo2.add(pharmaddress, r13);
		
		JTextField pharmadd = new JTextField(10);
		r13.gridx = 1;
		r13.gridy = 1;
		addressInfo2.add(pharmadd,r13);
		
		JLabel pharmnumber = new JLabel("Phone Number:");
		r13.gridx = 0;
		r13.gridy = 2;
		addressInfo2.add(pharmnumber,r13);
		
		JTextField pharmtf = new JTextField(10);
		r13.gridx = 1;
		r13.gridy = 2;
		addressInfo2.add(pharmtf,r13);
		
		addressInfo3 = new JPanel(new GridBagLayout());
		addressInfo3.setPreferredSize(new Dimension(800,200));
		addressInfo3.setBackground(new Color(255,250,205));
		addressInfo3.setBorder(BorderFactory.createTitledBorder("Physician Info"));
		addressInfo.add(addressInfo3);
		
		GridBagConstraints r14 = new GridBagConstraints();
		
		addressInfo.add(addressInfo3);
		
		JLabel physician = new JLabel("Primary Physician:");
		r14.gridx = 0;
		r14.gridy = 0;
		addressInfo3.add(physician, r14);
		
		JTextField physicianame = new JTextField(10);
		r14.gridx = 1;
		r14.gridy = 0;
		addressInfo3.add(physicianame, r14);
		
		JLabel physiciannum = new JLabel("Phone Number:");
		r14.gridx = 0;
		r14.gridy = 1;
		addressInfo3.add(physiciannum, r14);
		
		JTextField physiciantf = new JTextField(10);
		r14.gridx = 1;
		r14.gridy = 1;
		addressInfo3.add(physiciantf, r14);
		
		JLabel physicianemail = new JLabel("Email Address:");
		r14.gridx = 0;
		r14.gridy = 2;
		addressInfo3.add(physicianemail, r14);
		
		JTextField emailtf = new JTextField(10);
		r14.gridx = 1;
		r14.gridy = 2;
		addressInfo3.add(emailtf, r14);
		
		JButton cnpatient3 = new JButton("Create New Patient");
		r14.gridx = 4;
		r14.gridy = 4;
		addressInfo3.add(cnpatient3, r14);
		
		//Insurance Info
		insuranceInfoPanel = new JPanel(new FlowLayout());
		insuranceInfoPanel.setPreferredSize(new Dimension(800,800));
		insuranceInfoPanel.setBackground(new Color(255,250,205));
		insuranceInfoPanel.setVisible(false);
		
		insuranceInfo1 = new JPanel(new GridBagLayout());
		insuranceInfo1.setPreferredSize(new Dimension(400,200));
		insuranceInfo1.setBorder(BorderFactory.createTitledBorder("Primary Policy"));
		insuranceInfo1.setBackground(new Color(255,250,205));
		insuranceInfoPanel.add(insuranceInfo1);
		
		GridBagConstraints r15 = new GridBagConstraints();
		
		JLabel Insuranceinfo = new JLabel("Insurance Company Name:");
		r15.gridx = 0;
		r15.gridy = 0;
		insuranceInfo1.add(Insuranceinfo,r15);
		
		JTextField insurance = new JTextField(10);
		r15.gridx = 1;
		r15.gridy = 0;
		insuranceInfo1.add(insurance,r15);
			
		JLabel policyholder = new JLabel("Address:");
		r15.gridx = 0;
		r15.gridy = 1;
		insuranceInfo1.add(policyholder,r15);
		
		JTextField ph = new JTextField(10);
		r15.gridx = 1;
		r15.gridy = 1;
		insuranceInfo1.add(ph,r15);
		
		JLabel id = new JLabel("City:");
		r15.gridx = 0;
		r15.gridy = 2;
		insuranceInfo1.add(id,r15);
		
		JTextField idtf = new JTextField(10);
		r15.gridx = 1;
		r15.gridy = 2;
		insuranceInfo1.add(idtf,r15);
		
		JLabel groupid = new JLabel("State:");
		r15.gridx = 0;
		r15.gridy = 3;
		insuranceInfo1.add(groupid,r15);
		
		JTextField grouptf = new JTextField(7);
		r15.gridx = 1;
		r15.gridy = 3;
		insuranceInfo1.add(grouptf,r15);
		
		insuranceInfo2 = new JPanel(new GridBagLayout());
		insuranceInfoPanel.add(insuranceInfo2);
	    insuranceInfo2.setPreferredSize(new Dimension(400,200));
	    insuranceInfo2.setBackground(new Color(255,250,205));
	    insuranceInfo2.setBorder(BorderFactory.createTitledBorder("Primary Policy"));

		GridBagConstraints r16 = new GridBagConstraints();

		JLabel nameinsured = new JLabel("Name of Insured");
		r16.gridx = 0;
		r16.gridy = 0;
		insuranceInfo2.add(nameinsured, r16);
				
		JTextField ni = new JTextField(10);
		r16.gridx = 1;
		r16.gridy = 0;
		insuranceInfo2.add(ni, r16);

		JLabel relationship = new JLabel("Relationship:");
		r16.gridx = 0;
		r16.gridy = 1;
		insuranceInfo2.add(relationship, r16);

		JTextField relat = new JTextField(10);
		r16.gridx = 1;
		r16.gridy = 1;
		insuranceInfo2.add(relat, r16);
		
		JLabel policynum = new JLabel("Policy #:");
		r16.gridx = 0;
		r16.gridy = 2;
		insuranceInfo2.add(policynum, r16);

		JTextField policynumtf = new JTextField(10);
		r16.gridx = 1;
		r16.gridy = 2;
		insuranceInfo2.add(policynumtf, r16);
	
		JLabel groupnum  = new JLabel("Group #:");
		r16.gridx = 0;
		r16.gridy = 3;
		insuranceInfo2.add(groupnum, r16);

		JTextField groupnumtf = new JTextField(10);
		r16.gridx = 1;
		r16.gridy = 3;
		insuranceInfo2.add(groupnumtf, r16);
		
		insuranceInfo3 = new JPanel(new GridBagLayout());
		insuranceInfo3.setPreferredSize(new Dimension(800,200));
		insuranceInfo3.setBackground(new Color(255,250,205));
		insuranceInfo3.setBorder(BorderFactory.createTitledBorder("Secondary Policy"));
		insuranceInfoPanel.add(insuranceInfo3);
		
		GridBagConstraints r17 = new GridBagConstraints();
		
		JLabel Insuinfo = new JLabel("Insurance Company Name:");
		r17.gridx = 0;
		r17.gridy = 0;
		insuranceInfo3.add(Insuinfo,r17);
		
		JTextField insur = new JTextField(10);
		r17.gridx = 1;
		r17.gridy = 0;
		insuranceInfo3.add(insur,r17);
			
		JLabel polholder = new JLabel("Address:");
		r17.gridx = 2;
		r17.gridy = 0;
		insuranceInfo3.add(polholder,r17);
		
		JTextField phold = new JTextField(10);
		r17.gridx = 3;
		r17.gridy = 0;
		insuranceInfo3.add(phold,r17);
		
		JLabel cit = new JLabel("City:");
		r17.gridx = 4;
		r17.gridy = 0;
		insuranceInfo3.add(cit,r17);
		
		JTextField cittf = new JTextField(5);
		r17.gridx = 5;
		r17.gridy = 0;
		insuranceInfo3.add(cittf,r17);
		
		JLabel stid = new JLabel("State:");
		r17.gridx = 0;
		r17.gridy = 1;
		insuranceInfo3.add(stid,r17);
		
		JTextField sttf = new JTextField(5);
		r17.gridx = 1;
		r17.gridy = 1;
		insuranceInfo3.add(sttf,r17); 
		
		JLabel nameofinsured = new JLabel("Name of Insured");
		r17.gridx = 2;
		r17.gridy = 1;
		insuranceInfo3.add(nameofinsured, r17);
				
		JTextField nameis = new JTextField(10);
		r17.gridx = 3;
		r17.gridy = 1;
		insuranceInfo3.add(nameis, r17);

		JLabel relathip = new JLabel("Relationship:");
		r17.gridx = 4;
		r17.gridy = 1;
		insuranceInfo3.add(relathip, r17);

		JTextField relatsh = new JTextField(10);
		r17.gridx = 5;
		r17.gridy = 1;
		insuranceInfo3.add(relatsh, r17);
		
		JLabel polnum = new JLabel("Policy #:");
		r17.gridx = 0;
		r17.gridy = 2;
		insuranceInfo3.add(polnum, r17);

		JTextField polnumtf = new JTextField(10);
		r17.gridx = 1;
		r17.gridy = 2;
		insuranceInfo3.add(polnumtf, r17);
	
		JLabel gnum  = new JLabel("Group #:");
		r17.gridx = 2;
		r17.gridy = 2;
		insuranceInfo3.add(gnum, r17);

		JTextField gnumtf = new JTextField(10);
		r17.gridx = 3;
		r17.gridy = 2;
		insuranceInfo3.add(gnumtf, r17);
		
		JButton cnpatient4 = new JButton("Create New Patient");
		r17.gridx = 5;
		r17.gridy = 3;
		insuranceInfo3.add(cnpatient4, r17);
							
		//PatientRegistrationForm
		patientRegistration = new JPanel(new GridLayout());
		patientRegistration1 = new JPanel(new GridBagLayout());
		patientRegistration2 = new JPanel(new GridBagLayout());
		patientRegistration1.setBackground(Color.YELLOW);
		patientRegistration1.setPreferredSize(new Dimension(100,50));
		patientRegistration2.setPreferredSize(new Dimension(100,50));
		patientRegistration.setPreferredSize(new Dimension(900,500));
		patientRegistration.setVisible(false);
		patientRegistration.setBackground(new Color(245,245,245));		
		GridBagConstraints r = new GridBagConstraints();
		patientRegistration.setBorder(BorderFactory.createTitledBorder("Patient Registration"));		
				
	  		
		JButton bpanel = new JButton("Back");
		r.gridx = 6;
		r.gridy = 10;
		patientRegistration2.add(bpanel, r);
		add(patientRegistration);

		JTabbedPane tabbed = new JTabbedPane();
	    
	    tabbed.setPreferredSize(new Dimension(800,600));
				
		tabbed.addTab("Patient Info",  patientInfoPanel);
		tabbed.addTab("Parent/Guardian", parentsInfo);
		tabbed.addTab("Address", addressInfo);
		tabbed.addTab("Insurance Info", insuranceInfoPanel);
			
		r.gridx = 0;
		r.gridy = 4;
		patientRegistration.add(tabbed);
	
	
		//Patient Information Panel on View Page
		patientInfo1 = new JPanel(new GridLayout());
		patientInfo1.setPreferredSize(new Dimension(1200,130));
		patientInfo1.setVisible(true);
		patientInfo1.setBackground(new Color(255,228,225));
		patientInfo1.setBorder(BorderFactory.createTitledBorder("Patient Information"));
	  
		GridBagConstraints p21 = new GridBagConstraints();
		
		patientDet1 = new JPanel(new GridBagLayout());
		patientDet1.setPreferredSize(new Dimension(200,200));
		patientDet1.setBackground(Color.WHITE);
		patientDet1.setBorder(BorderFactory.createTitledBorder("Patient Details"));

		JLabel pname = new JLabel("Patient Name:");
		p21.gridx = 0;
		p21.gridy = 0;
		patientDet1.add(pname,p21);
		
		JLabel patientGender = new JLabel("Gender: ");
		p21.gridx = 0;
		p21.gridy = 1;
		patientDet1.add(patientGender, p21);
		
		JLabel dateofbirth = new JLabel("DOB:");
		p21.gridx = 0;
		p21.gridy = 2;
		patientDet1.add(dateofbirth, p21);
		
		JLabel socialsn = new JLabel("SSN:");
		p21.gridx = 0;
		p21.gridy = 3;
		patientDet1.add(socialsn, p21);
		
		patientInfo1.add(patientDet1);
		JPanel encounterDet1 = new JPanel();
		encounterDet1.setPreferredSize(new Dimension(200,200));
		encounterDet1.setBackground(new Color(211,211,211));
		encounterDet1.setBorder(BorderFactory.createTitledBorder("Encounter Details"));
		patientInfo1.add(encounterDet1);

		//Insurance Details
		insuranceDet1 = new JPanel(new GridBagLayout());
		insuranceDet1.setPreferredSize(new Dimension(200,200));
		insuranceDet1.setBorder(BorderFactory.createTitledBorder("Insurance Details"));
		
		GridBagConstraints p21c = new GridBagConstraints();

		JLabel pinsurance = new JLabel("Primary Insurance:");
		p21c.gridx = 0;
		p21c.gridy = 0;
		insuranceDet1.add(pinsurance,p21c);
		
		JLabel insurancebalance = new JLabel("Insurance Balance:");
		p21c.gridx = 0;
		p21c.gridy = 1;
		insuranceDet1.add(insurancebalance,p21c);
		
		JLabel pbalance = new JLabel("Patient Balance:");
		p21c.gridx = 0;
		p21c.gridy = 2;
		insuranceDet1.add(pbalance,p21c);
		
		JLabel totalbalance = new JLabel("Total Balance:");
		p21c.gridx = 0;
		p21c.gridy = 3;
		insuranceDet1.add(totalbalance,p21c);
		
		JLabel copay = new JLabel("Copay:");
		p21c.gridx = 0;
		p21c.gridy = 4;
		insuranceDet1.add(copay,p21c);
		
		insuranceDet1.setBackground(Color.WHITE);
		
		patientInfo1.add(insuranceDet1);
		
		//PatientPhoto1
		patientPhoto1 = new JPanel(new GridBagLayout());
		ImageIcon pimage = new ImageIcon("user.png");
		JLabel p21d = new JLabel(pimage);
		patientPhoto1.setPreferredSize(new Dimension(200,200));
		patientPhoto1.setBorder(BorderFactory.createTitledBorder("Patient Photo"));
		patientPhoto1.setBackground(new Color(211,211,211));
		patientPhoto1.add(p21d);
		patientInfo1.add(patientPhoto1);
		
		//Adding Info Bar to Panel
		patientPanel = new JPanel();
		patientPanel.add(patientInfo1);
	
		patientPanel2 = new JPanel(new GridBagLayout());
		patientPanel2.setPreferredSize(new Dimension(1700,900));
		patientPanel2.setBackground(new Color(245,245,245));
		
		//Description
		description= new JPanel(new GridLayout(3, 2));
		description.setBorder(BorderFactory.createTitledBorder("Description"));
		description.setPreferredSize(new Dimension(590,300));
		description.setVisible(true);
		
		GridBagConstraints grid2 = new GridBagConstraints();

		JLabel desage = new JLabel("Age: ");
		grid2.gridx=0;
		grid2.gridy=0;
		description.add(desage, grid2);
				
		JTextField desagetxt= new JTextField(3);
		grid2.gridx = 1;
		grid2.gridy = 0;
		add2 = new JPanel();
		add2.add(desagetxt);
		description.add(add2, grid2);
	
		GridBagConstraints grid1 = new GridBagConstraints();
		grid1.gridx=0;
		grid1.gridy=0;
		patientPanel2.add(description,grid1);
		
		//Contact Info
		contactInfoI = new JPanel(new GridBagLayout());
		contactInfoI.setBorder(BorderFactory.createTitledBorder("Contact Info I"));
		contactInfoI.setPreferredSize(new Dimension(590,300));
		contactInfoI.setVisible(true);
		
		GridBagConstraints grid1a = new GridBagConstraints();
		
		JLabel addressLine1 = new JLabel("Address Line 1: ");
		grid1a.gridx=0;
		grid1a.gridy=0;
		contactInfoI.add(addressLine1, grid1a);
				
		JTextField addL1= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 0;
		add7 = new JPanel();
		add7.add(addL1);
		contactInfoI.add(add7, grid1a);
			
		JLabel addcity = new JLabel("City: ");
		grid1a.gridx=2;
		grid1a.gridy=0;
		contactInfoI.add(addcity, grid1a);
		
		JTextField addCity= new JTextField(5);
		grid1a.gridx = 3;
		grid1a.gridy = 0;
		add9 = new JPanel();
		add9.add(addCity);
		contactInfoI.add(add9, grid1a);
		
		JLabel astate = new JLabel("State: ");
		grid1a.gridx=4;
		grid1a.gridy=0;
		contactInfoI.add(astate, grid1a);	

		JTextField aState= new JTextField(5);
		grid1a.gridx = 5;
		grid1a.gridy = 0;
		add9 = new JPanel();
		add9.add(aState);
		contactInfoI.add(add9, grid1a);
			
		JLabel zip = new JLabel("Zip: ");
		grid1a.gridx=1;
		grid1a.gridy=1;
		contactInfoI.add(zip, grid1a);
		
		JTextField addzip= new JTextField(7);
		grid1a.gridx = 2;
		grid1a.gridy = 1;
		add10 = new JPanel();
		add10.add(addzip);
		contactInfoI.add(add10, grid1a);
		
		JLabel workphone = new JLabel("Work Ph # : ");
		grid1a.gridx=3;
		grid1a.gridy=1;
		contactInfoI.add(workphone, grid1a);
		
		JTextField addWorkPhone= new JTextField(20);
		workphone.setText(" - -");
		grid1a.gridx = 4;
		grid1a.gridy = 1;
		add6 = new JPanel();
		add6.add(addWorkPhone);
		contactInfoI.add(add6, grid1a);
		
		JLabel mobile = new JLabel("Mobile # : ");
		mobile.setText(" - -");
		grid1a.gridx=0;
		grid1a.gridy=5;
		//contactInfoI.add(mobile, grid1a);
		
		JTextField addMobile= new JTextField(20);
		grid1a.gridx = 1;
		grid1a.gridy = 5;
		add11 = new JPanel();
		add11.add(addMobile);
		//contactInfoI.add(add11, grid1a);
		
		JLabel homephone = new JLabel("Home Ph # : ");
		grid1a.gridx=2;
		grid1a.gridy=5;
		//contactInfoI.add(homephone, grid1a);
		
		JTextField addHomePhone= new JTextField(20);
		addHomePhone.setText(" - -");
		grid1a.gridx = 3;
		grid1a.gridy = 5;
		add7 = new JPanel();
		add7.add(addHomePhone);
		//contactInfoI.add(add7, grid1a);
		
		JLabel email = new JLabel("Email: ");
		grid1a.gridx=0;
		grid1a.gridy=6;
		//contactInfoI.add(email, grid1a);
		
		JTextField addemail= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 6;
		add8 = new JPanel();
		add8.add(addemail);
		//contactInfoI.add(add8, grid1a);
		
		grid1.gridx=1;
		grid1.gridy=0;
		patientPanel2.add(contactInfoI,grid1);
		
		//Contact Info II
		contactInfoII = new JPanel();
		contactInfoII.setBorder(BorderFactory.createTitledBorder("Contact Info II"));
		contactInfoII.setPreferredSize(new Dimension(590,300));
		contactInfoII.setVisible(true);
		
		JLabel cname = new JLabel("Contact Name: ");
		grid1a.gridx=0;
		grid1a.gridy=0;
		contactInfoII.add(cname, grid1a);
		
		JTextField addcnmetxt= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 0;
		add9 = new JPanel();
		add9.add(addcnmetxt);
		contactInfoII.add(add9, grid1a);
		
		JLabel addline1 = new JLabel("Address Line 1: ");
		grid1a.gridx=0;
		grid1a.gridy=1;
		contactInfoII.add(addline1, grid1a);
		
		JTextField addtxt1= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 1;
		add10 = new JPanel();
		add10.add(addtxt1);
		contactInfoII.add(add10, grid1a);
		
		JLabel addline2 = new JLabel("Address Line 2: ");
		grid1a.gridx=0;
		grid1a.gridy=2;
		contactInfoII.add(addline2, grid1a);
		
		JTextField addtxt2= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 2;
		add11 = new JPanel();
		add11.add(addtxt2);
		contactInfoII.add(add11, grid1a);
		
		JLabel ccity = new JLabel("City: ");
		grid1a.gridx=0;
		grid1a.gridy=3;
		contactInfoII.add(ccity, grid1a);
		
		JTextField ctxt2= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 3;
		add11 = new JPanel();
		add11.add(ctxt2);
		contactInfoII.add(add11, grid1a);
		
		JLabel cstate = new JLabel("State: ");
		grid1a.gridx=2;
		grid1a.gridy=3;
		contactInfoII.add(cstate, grid1a);
		
		JTextField cstatetxt2= new JTextField(8);
		grid1a.gridx = 3;
		grid1a.gridy = 3;
		add12 = new JPanel();
		add12.add(cstatetxt2);
		contactInfoII.add(add11, grid1a);
		
		JLabel czip = new JLabel("Zip: ");
		grid1a.gridx=0;
		grid1a.gridy=4;
		contactInfoII.add(czip, grid1a);
		
		JTextField cziptxt2= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 4;
		add13 = new JPanel();
		add13.add(cziptxt2);
		contactInfoII.add(add11, grid1a);
		
		JLabel cworkphone = new JLabel("Work Phone #: ");
		grid1a.gridx=2;
		grid1a.gridy=4;
		contactInfoII.add(cworkphone, grid1a);
		
		JTextField cwptxt2= new JTextField(15);
		grid1a.gridx = 3;
		grid1a.gridy = 4;
		add14 = new JPanel();
		add14.add(cwptxt2);
		contactInfoII.add(add11, grid1a);
		
		JLabel mobilephone = new JLabel("Mobile #: ");
		grid1a.gridx=0;
		grid1a.gridy=5;
		contactInfoII.add(mobilephone, grid1a);
		
		JTextField cmobilephonetxt2= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 5;
		add15 = new JPanel();
		add15.add(cmobilephonetxt2);
		contactInfoII.add(add11, grid1a);
		
		JLabel chomephone = new JLabel("Home Phone #: ");
		grid1a.gridx=2;
		grid1a.gridy=5;
		contactInfoII.add(chomephone, grid1a);
		
		JTextField chomephonetxt2= new JTextField(15);
		grid1a.gridx = 3;
		grid1a.gridy = 5;
		add16 = new JPanel();
		add16.add(chomephonetxt2, grid1a);
		contactInfoII.add(add11, grid1a);
		
		grid1.gridx=0;
		grid1.gridy=1;
		patientPanel2.add(contactInfoII,grid1);
		
		//ID Information
		iDInfo= new JPanel();
		iDInfo.setBorder(BorderFactory.createTitledBorder("ID Information"));
		iDInfo.setPreferredSize(new Dimension(590,300));
		iDInfo.setVisible(true);
		
		JLabel driversID = new JLabel("Drivers License: ");
		grid1a.gridx=0;
		grid1a.gridy=0;
		iDInfo.add(driversID, grid1a);
		
		JTextField drivertxt= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 0;
		add17 = new JPanel();
		add17.add(drivertxt);
		iDInfo.add(add17, grid1a);
		
		JLabel licenseSt  = new JLabel("State: ");
		grid1a.gridx=0;
		grid1a.gridy=1;
		iDInfo.add(licenseSt, grid1a);
		
		JTextField sttxt= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 1;
		add18 = new JPanel();
		add18.add(sttxt);
		iDInfo.add(add18, grid1a);
		
		JLabel expiryDate = new JLabel("Expiry Date: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		iDInfo.add(expiryDate, grid1a);
		
		JTextField expirytxt= new JTextField(8);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add19 = new JPanel();
		add19.add(expirytxt);
		iDInfo.add(add19, grid1a);
		
		JLabel empStatus = new JLabel("Emp. Status: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		iDInfo.add(empStatus, grid1a);
		
		JTextField empStatustxt= new JTextField(8);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add20 = new JPanel();
		add20.add(empStatustxt);
		iDInfo.add(add20, grid1a);
		
		JLabel employer = new JLabel("Employer : ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		iDInfo.add(employer, grid1a);
		
		JTextField employertxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add21 = new JPanel();
		add21.add(employertxt);
		iDInfo.add(add21, grid1a);
		
		grid1.gridx=1;
		grid1.gridy=1;
		patientPanel2.add(iDInfo,grid1);
		
		//Mom Records
		momRecords = new JPanel();
		momRecords.setBorder(BorderFactory.createTitledBorder("Mother Records"));
		momRecords.setPreferredSize(new Dimension(590,300));

		JLabel motherLN = new JLabel("Mother Last Name: ");
		grid1a.gridx=0;
		grid1a.gridy=0;
		momRecords.add(motherLN, grid1a);
		
		JTextField mothertxt= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 0;
		add22 = new JPanel();
		add22.add(mothertxt);
		momRecords.add(add2, grid1a);
		
		JLabel motherFN = new JLabel("Mother First Name: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		momRecords.add(motherFN, grid1a);
		
		JTextField motherFNtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add23 = new JPanel();
		add23.add(motherFNtxt);
		momRecords.add(add23, grid1a);
		
		JLabel motherSSN = new JLabel("SSN:: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		momRecords.add(motherSSN, grid1a);
		
		JTextField momSSNtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add24 = new JPanel();
		add24.add(momSSNtxt);
		momRecords.add(add24, grid1a);
		
		JLabel momHP = new JLabel("Home Phone: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		momRecords.add(momHP, grid1a);
		
		JTextField momHPtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add25 = new JPanel();
		add25.add(momHPtxt);
		momRecords.add(add25, grid1a);
		
		JLabel momCP = new JLabel("Cell Phone:: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		momRecords.add(momCP, grid1a);
		
		JTextField momCPtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add26 = new JPanel();
		add26.add(momCPtxt);
		momRecords.add(add26, grid1a);
		
		grid1.gridx = 0;
		grid1.gridy = 2;
		patientPanel2.add(momRecords,grid1);
		
		//Father Records
		dadRecords = new JPanel();
		dadRecords.setBorder(BorderFactory.createTitledBorder("Father Records"));
		dadRecords.setPreferredSize(new Dimension(590,300));

		JLabel dadLN = new JLabel("Father Last Name: ");
		grid1a.gridx=0;
		grid1a.gridy=0;
		dadRecords.add(dadLN, grid1a);
		
		JTextField dadtxt= new JTextField(15);
		grid1a.gridx = 1;
		grid1a.gridy = 0;
		add22 = new JPanel();
		add22.add(dadtxt);
		dadRecords.add(add2, grid1a);
		
		JLabel dadFN = new JLabel("Father First Name: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		dadRecords.add(dadFN, grid1a);
		
		JTextField dadFNtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add23 = new JPanel();
		add23.add(dadFNtxt);
		dadRecords.add(add23, grid1a);
		
		JLabel dadSSN = new JLabel("SSN:: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		dadRecords.add(dadSSN, grid1a);
		
		JTextField dadSSNtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add24 = new JPanel();
		add24.add(dadSSNtxt);
		dadRecords.add(add24, grid1a);
		
		JLabel dadHP = new JLabel("Home Phone: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		dadRecords.add(dadHP, grid1a);
		
		JTextField dadHPtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add25 = new JPanel();
		add25.add(dadHPtxt);
		dadRecords.add(add25, grid1a);
		
		JLabel dadCP = new JLabel("Cell Phone:: ");
		grid1a.gridx=1;
		grid1a.gridy=2;
		dadRecords.add(dadCP, grid1a);
		
		JTextField dadCPtxt= new JTextField(15);
		grid1a.gridx = 0;
		grid1a.gridy = 2;
		add26 = new JPanel();
		add26.add(dadCPtxt);
		dadRecords.add(add26, grid1a);
		
		grid1.gridx = 1;
		grid1.gridy = 2;
		patientPanel2.add(dadRecords,grid1);
	 
		//ParentPatientPanel
		parentPatientPanel = new JPanel();
		parentPatientPanel.setPreferredSize(new Dimension(1000,1080));
		parentPatientPanel.setBackground(new Color(245,245,245));
		
		parentPatientPanel.add(patientPanel);
		
		parentPatientPanel.add(patientPanel2);

		//Parent Patient Info Panel
		patientInfoScroll = new JScrollPane(parentPatientPanel);
		patientInfoScroll.setBackground(new Color(245,245,245));
		
		//Medical Records  
		medicalRecords = new JPanel();
		medicalRecords.setPreferredSize(new Dimension(1000,1470));
		medicalRecords.setBackground(new Color(245,245,245));
	
		//First Half of Medical Records
		currentMR = new JPanel();
		currentMR.setPreferredSize(new Dimension(500, 25));
		currentMR.setBackground(new Color(192,192,192));
		JLabel currentStatus = new JLabel("Current Medical History");
		currentStatus.setFont(new Font("Serif", Font.PLAIN, 20));
		currentMR.add(currentStatus);
		medicalRecords.add(currentMR);
		
		patientPanel3a = new JPanel(new GridBagLayout());
		patientPanel3a.setPreferredSize(new Dimension(1800,700));
		patientPanel3a.setBackground(new Color(255,204,204));
	
		GridBagConstraints grid3 = new GridBagConstraints();

		//Medications
		medications = new JPanel();
		medications.setBorder(BorderFactory.createTitledBorder("Medications"));
		medications.setPreferredSize(new Dimension(590,230));
		medications.setVisible(true);
		
		String[] medColumns = {"Date", "Drug", "Sig"};
		
		String[][] medData = {{"4/12/2012", "Advil", "1-Amt", ""}};
		
		med1 = new JPanel();
		med1.setPreferredSize(new Dimension(540,170));
		med1.setBackground(new Color(204,255,255));
		
		JTable medTable = new JTable();
		medTable = new JTable(medData, medColumns);
		medTable.setPreferredScrollableViewportSize(new Dimension(520,100));
		
		int gap0 = 10;

		medTable.setRowHeight(medTable.getRowHeight() + gap0);
		medTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		medTable.setFillsViewportHeight(true);
		
		JScrollPane medpane = new JScrollPane(medTable);
		
		med1.add(medpane);
		medications.add(med1);
		
		grid3.gridx=0;
		grid3.gridy=0;
		patientPanel3a.add(medications, grid3);
		
		medicalRecords.add(patientPanel3a);

		//Allergies
		allergies = new JPanel();
		allergies.setBorder(BorderFactory.createTitledBorder("Allergies"));
		allergies.setPreferredSize(new Dimension(590,230));
		allergies.setVisible(true);
		
		String[] allColumns = {"Date", "Allergy", "Severity"};
		
		String[][] allData = {{"4/04/2012", "Peanut", "Mild"}, {"6/07/2013", "Chocolate", "Moderate"}};
		
		allergy1 = new JPanel();
		allergy1.setPreferredSize(new Dimension(540,170));
		allergy1.setBackground(new Color(204,255,255));
		
		JTable allergyTable = new JTable();
		allergyTable = new JTable(allData, allColumns);
		allergyTable.setPreferredScrollableViewportSize(new Dimension(520,100));
		//allergy1.add(allergypic);
		
		int allergygap = 10;

		allergyTable.setRowHeight(medTable.getRowHeight() + allergygap);
		allergyTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		allergyTable.setFillsViewportHeight(true);
		
		JScrollPane allergypane = new JScrollPane(allergyTable);

		allergy1.add(allergypane);
		allergies.add(allergy1, grid3);

		grid3.gridx=1;
		grid3.gridy=0;
		patientPanel3a.add(allergies,grid3);

		//Vitals
		vitals = new JPanel();
		vitals.setBorder(BorderFactory.createTitledBorder("Vitals"));
		vitals.setPreferredSize(new Dimension(590,230));
		vitals.setVisible(true);
		
		String[] vitalsColumns = {"Respitory Rate", "Heart Rate", "Blood Pressure", "Height", "Weight(lbs)"};
		
		String[][] vitalsData = {{"50", "120", "70", "5'6", "130"}};
		
		vitals1 = new JPanel();
		vitals1.setPreferredSize(new Dimension(540,170));
		vitals1.setBackground(new Color(204,255,255));
		
		JTable vitalsTable = new JTable();
		vitalsTable = new JTable(vitalsData, vitalsColumns);
		vitalsTable.setPreferredScrollableViewportSize(new Dimension(520,100));
		
		int vitalsgap = 10;

		vitalsTable.setRowHeight(medTable.getRowHeight() + vitalsgap);
		vitalsTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		vitalsTable.setFillsViewportHeight(true);
		
		JScrollPane vitalspane = new JScrollPane(vitalsTable);

		vitals1.add(vitalspane);
		vitals.add(vitals1);

		grid3.gridx=0;
		grid3.gridy=1;
		patientPanel3a.add(vitals,grid3);
		
		//Prescriptions
		prescriptions = new JPanel();
		prescriptions.setBorder(BorderFactory.createTitledBorder("Prescriptions"));
		prescriptions.setPreferredSize(new Dimension(590,230));
		
		String[] prescriptionsColumns = {"Date", "Prescription", "Quantity"};
		
		String[][] prescriptionsData = {{"4/04/2012", "Tylenol", "30 grams"}};
		
		prescriptions1 = new JPanel();
		prescriptions1.setPreferredSize(new Dimension(540,170));
		prescriptions1.setBackground(new Color(204,255,255));
		
		JTable prescriptionsTable = new JTable();
		prescriptionsTable = new JTable(prescriptionsData, prescriptionsColumns);
		prescriptionsTable.setPreferredScrollableViewportSize(new Dimension(520,100));
		
		int prescriptionssgap = 10;

		prescriptionsTable.setRowHeight(medTable.getRowHeight() + prescriptionssgap);
		prescriptionsTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		prescriptionsTable.setFillsViewportHeight(true);
		
		JScrollPane prescriptionsspane = new JScrollPane(prescriptionsTable);
		
		prescriptions1.add(prescriptionsspane);
		prescriptions.add(prescriptions1);

		grid3.gridx=1;
		grid3.gridy=1;

		patientPanel3a.add(prescriptions,grid3);
		
		//Results
		results = new JPanel();
		results.setBorder(BorderFactory.createTitledBorder("Results"));
		results.setPreferredSize(new Dimension(590,230));
		
		String[] resultsColumns = {"Date", "Description"};
		
		String[][] resultsData = {{"4/04/2012", "High Blood Pressure"}};
		
		results1 = new JPanel();
		results1.setPreferredSize(new Dimension(540,170));
		results1.setBackground(new Color(204,255,255));
		
		JTable resultsTable = new JTable();
		resultsTable = new JTable(resultsData, resultsColumns);
		resultsTable.setPreferredScrollableViewportSize(new Dimension(520,100));
		
		int resultsgap = 10;

		resultsTable.setRowHeight(medTable.getRowHeight() + resultsgap);
		resultsTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		resultsTable.setFillsViewportHeight(true);
		
		JScrollPane resultspane = new JScrollPane(resultsTable);
		
		results1.add(resultspane);
		results.add(results1);

		grid3.gridx = 0;
		grid3.gridy = 2;

		patientPanel3a.add(results,grid3);
		
		//PendingServices
		pendingServices = new JPanel();
		pendingServices.setBorder(BorderFactory.createTitledBorder("Pending Services"));
		pendingServices.setPreferredSize(new Dimension(590,230));
		
		String[] pendingServicesColumns = {"Date", "Recommend Type", "Description"};
		
		String[][] pendingServicesData = {{"5/04/2014", "Lab", "Blood Test"}};
		
		pendingServices1 = new JPanel();
		pendingServices1.setPreferredSize(new Dimension(540,170));
		pendingServices1.setBackground(new Color(204,255,255));
		
		JTable pendingServicesTable = new JTable();
		pendingServicesTable = new JTable(pendingServicesData, pendingServicesColumns);
		pendingServicesTable.setPreferredScrollableViewportSize(new Dimension(520,100));
		
		int pendingServicesgap = 10;

		pendingServicesTable.setRowHeight(medTable.getRowHeight() + pendingServicesgap);
		pendingServicesTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		pendingServicesTable.setFillsViewportHeight(true);
		
		JScrollPane pendingServicespane = new JScrollPane(pendingServicesTable);

		pendingServices1.add(pendingServicespane);
		pendingServices.add(pendingServices1);

		grid3.gridx = 1;
		grid3.gridy = 2;
		patientPanel3a.add(pendingServices,grid3);
		medicalRecords.add(patientPanel3a);
		
		//Second Half of Medical Records
		familyHistory = new JPanel();
		familyHistory.setPreferredSize(new Dimension(500, 25));
		familyHistory.setBackground(new Color(192,192,192));
		JLabel familyHis = new JLabel("Family History");
		familyHis.setFont(new Font("Serif", Font.PLAIN, 20));
		familyHistory.add(familyHis);
		
		medicalRecords.add(familyHistory);	
		
		patientPanel3b = new JPanel();
		patientPanel3b.setPreferredSize(new Dimension(1300,400));
		patientPanel3b.setBackground(new Color(255,204,204));
		
		familyHisPanel1 = new JPanel();
		familyHisPanel1.setPreferredSize(new Dimension(1300, 400));

		JTable familyHisTable = new JTable();
		familyHisTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		String[] familyHisColumn = {"Medical Condition (Y/N)", "Mother", "Father", "Sister",
		"Brother", "M. Grandmother", "M. Grandfather", "P. Grandmother", 
		"P. Grandfather", "M. Aunt", "M. Uncle","P Aunt", "P. Uncle"};

		String[][] familyHisData = {
		{"Anemia", "N", "Y", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "N"},
		{"Asthma", "Y", "N", "N", "N", "N", "N", "Y", "N", "N", "Y", "N", "N"},
		{"Autoimmune Disorder", "N", "N", "Y", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
		{"Bleeding Problems", "N", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "Y", "N"},
		{"Cancer, Breast", "N", "N", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "N"},
		{"Cancer, Melanoma", "N", "N", "N", "N", "N", "Y", "N", "N","N", "N", "N", "N"}, 
		{"Cancer, Ovary", "N", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "N", "N"}, 
		{"Heart Attack/Heart Disease", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "N"}, 
		{"Depression", "N", "N", "Y", "N", "N", "N", "N", "N", "N", "N", "N", "N"}, 
		{"Diabetes", "N", "Y", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"}, 
		{"Eczema", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "Y"}, 
		{"Genertic Disorder", "N", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "N", "N"}, 
		{"High Cholestorol", "N", "N", "N", "N", "N", "N", "N", "N", "Y", "N", "N", "N"}, 
		{"High Blood Pressure", "N", "N", "N", "N", "N", "N", "N", "N", "Y", "N", "N", "N"}, 
		{"Immune Disorder", "N", "Y", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "N"},
		{"Kidney Disease", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "Y"},
		{"Learning Disability", "N", "N", "N", "N", "N", "N", "N", "Y", "N", "`N", "N", "N"},
		{"Stroke", "N", "Y", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"},
		{"Substance Abuse", "Y", "N", "N", "N", "N", "N", "Y", "N", "N", "Y", "N", "N"},
		{"Thyroid Disorders", "N", "N", "N", "N", "N", "Y", "N", "N","N", "N", "N", "N"},
		{"Tobacco Use", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "N", "N", "Y"},
		{"Tuberculosis", "N", "N", "N", "N", "N", "N", "N", "Y", "N", "`N", "N", "N"},
		{"Death before age 56", "N", "N", "N", "N", "N", "N", "Y", "N", "N", "N", "Y", "N"},
		{"Other", "N", "Y", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"}};
		
		familyHisTable = new JTable(familyHisData, familyHisColumn);
		familyHisTable.setPreferredScrollableViewportSize(new Dimension(1100,350));
		//allergy1.add(allergypic);
		
		int familyHisgap = 10;

		familyHisTable.setRowHeight(medTable.getRowHeight() + familyHisgap);
		familyHisTable.getTableHeader().setFont(new Font("Vermont", Font.ITALIC, 12));
		familyHisTable.setFillsViewportHeight(true);
		
		JScrollPane familyHispane = new JScrollPane(familyHisTable);
			
		familyHisPanel1.add(familyHispane);
		
		patientPanel3b.add(familyHisPanel1);
		
		medicalRecords.add(patientPanel3b);
	 	
		//Third Part of Medical Records
		immunization = new JPanel();
		immunization.setPreferredSize(new Dimension(500, 25));
		immunization.setBackground(new Color(192,192,192));
		JLabel immunizationLabel = new JLabel("Immunization Records");
		immunizationLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		immunization.add(immunizationLabel);
		medicalRecords.add(immunization);
		
		patientPanel3c = new JPanel(new GridBagLayout());
		patientPanel3c.setPreferredSize(new Dimension(1200,300));
		patientPanel3c.setBackground(new Color(255,204,204));
		
		immunePanel = new JPanel();
		immunePanel.setPreferredSize(new Dimension(700,300));
		
		JTable immunizationTable = new JTable();
		
		String[] columns  = {"Vaccine", "Type", "Date Given(m/d/yy)", "Administered By","Next Dose Date"};
		
		String[][] data = {{"Heppatitus A", "Inactivated/Killed", "10/23/2015", "Clinic", "06/23/2016"}, 
				{"Meningoccal", "Subunit/conjugate", "11/05/2015", "Doctor", "03/15/2016"},
				{"Human Papillomavirus", "Subunit/conjugate", "02/07/2016", "Clinic", "05/07/2016"}, 
				{"Influenza", "Subunit/conjugate", "01/15/2016", "Doctor", "07/21/2016"},
				{"Zoster(shingles)", "Live, attenuated", "12/25/2015", "Clinic", "04/03/2016"}};
		
		
		immunizationTable = new JTable(data, columns);
		immunizationTable.setPreferredScrollableViewportSize(new Dimension(650,200));
		immunizationTable.setFillsViewportHeight(true);
		
		int gap3 = 10;
		immunizationTable.setRowHeight(immunizationTable.getRowHeight() + gap3);
		immunizationTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		immunizationTable.setFillsViewportHeight(true);
		
		JScrollPane jps = new JScrollPane(immunizationTable);
		immunePanel.add(jps);
		
		patientPanel3c.add(immunePanel);
		medicalRecords.add(patientPanel3c);
		
		medicalRecordsScroll = new JScrollPane(medicalRecords);
		
		//Visuals
		mainVisuals = new JPanel(new BorderLayout());
		mainVisuals.setPreferredSize(new Dimension(1170,750));
		mainVisuals.setBackground(new Color(255,204,153));
	
		visualSidePanel = new JPanel();
		visualSidePanel.setPreferredSize(new Dimension(280,690));
		visualSidePanel.setBackground(new Color(255,229,204));

		patientVisDet = new JPanel(new GridBagLayout());
		patientVisDet.setPreferredSize(new Dimension(270,100));
		JLabel Last = new JLabel("Last:");
		JLabel First = new JLabel("First:");
		JLabel Birth = new JLabel("Birth Date: ");
		JLabel Gender = new JLabel("Gender:");
		
		JLabel Lasttxt = new JLabel("Arif");
		JLabel Firsttxt = new JLabel("Nida");
		JLabel Birthtxt = new JLabel("12/01/1994");
		JLabel Gendertxt = new JLabel("Female");
		
		GridBagConstraints patientVis = new GridBagConstraints();
		
		patientVis.gridx=0;
		patientVis.gridy=0;
		patientVisDet.add(Last, patientVis);
		
		patientVis.gridx=1;
		patientVis.gridy=0;
		patientVisDet.add(Lasttxt, patientVis);
		
		patientVis.gridx=0;
		patientVis.gridy=1;
		patientVisDet.add(First, patientVis);
		
		patientVis.gridx=1;
		patientVis.gridy=1;
		patientVisDet.add(Firsttxt, patientVis);
		
		patientVis.gridx=0;
		patientVis.gridy=2;
		patientVisDet.add(Birth, patientVis);
		
		patientVis.gridx=1;
		patientVis.gridy=2;
		patientVisDet.add(Birthtxt, patientVis);
		
		patientVis.gridx=0;
		patientVis.gridy=3;
		patientVisDet.add(Gender, patientVis);
		
		patientVis.gridx=1;
		patientVis.gridy=3;
		patientVisDet.add(Gendertxt, patientVis);
		
		patientVisDet.setBorder(BorderFactory.createTitledBorder("Patient Info"));
		visualSidePanel.add(patientVisDet);
		
		progressNotes = new JTextArea(8,23);
		progressNotes.setBorder(BorderFactory.createTitledBorder("Progress Notes"));
		visualSidePanel.add(progressNotes);
		
		evaluation = new JTextArea(28,24);
		evaluation.setBorder(BorderFactory.createTitledBorder("Evaluation"));
		visualSidePanel.add(evaluation);
		
		JScrollPane visualSideScroll = new JScrollPane(visualSidePanel);
		
		visuals = new JPanel(new GridBagLayout());
		visuals.setPreferredSize(new Dimension(900,400));
		visuals.setBackground(new Color(255,229,204));
		
		visualsEditingPanel = new JPanel(new GridBagLayout());
		visualsEditingPanel.setPreferredSize(new Dimension(100,600));
		visualsEditingPanel.setBackground(new Color(255,204,153));
		
		GridBagConstraints editConstraints = new GridBagConstraints();
				
		JButton importButton = new JButton("Import");	
		editConstraints.gridx = 0;
		editConstraints.gridy = 0;
		importButton.setPreferredSize(new Dimension(100,70));
		visualsEditingPanel.add(importButton, editConstraints);
		
		ImportButtonListener importlistener = new ImportButtonListener();
		importButton.addActionListener(importlistener);
	
		JButton colorButton = new JButton("Color");
		editConstraints.gridx = 0;
		editConstraints.gridy = 1;
		colorButton.setPreferredSize(new Dimension(100,70));
		visualsEditingPanel.add(colorButton, editConstraints);
		
		setDoubleBuffered(true);
		
		ColorButtonListener colorListener = new ColorButtonListener();
		colorButton.addActionListener(colorListener);
		
        colorButton.setIcon(new ImageIcon(colorSample));
		
		JButton undo = new JButton("Undo");
		editConstraints.gridx = 0;
		editConstraints.gridy = 2;
		undo.setPreferredSize(new Dimension(100,70));
		visualsEditingPanel.add(undo,editConstraints);
		
		UndoButtonListener undoListener = new UndoButtonListener();
		undo.addActionListener(undoListener);
		
		JButton clear = new JButton("Clear");
		editConstraints.gridx = 0;
		editConstraints.gridy = 3;
		clear.setPreferredSize(new Dimension(100,70));
		visualsEditingPanel.add(clear,editConstraints);
		
		ClearButtonListener cblistener = new ClearButtonListener();
		clear.addActionListener(cblistener);
		
		JButton save = new JButton("Save");
		editConstraints.gridx = 0;
		editConstraints.gridy = 4;
		save.setPreferredSize(new Dimension(100,70));
		visualsEditingPanel.add(save, editConstraints);

		SaveButtonListener savelistener = new SaveButtonListener();
		save.addActionListener(savelistener);
		
		GridBagConstraints vis = new GridBagConstraints();
		visualPicPanel = new JPanel(new BorderLayout());
		visualPicPanel.setPreferredSize(new Dimension(700,500));
		visualPicPanel.setBorder(BorderFactory.createTitledBorder("Image Editor")); 
		visualPicPanel.setBackground(Color.WHITE);
		
		vis.gridx = 0;
		vis.gridx = 0; 		
		visuals.add(visualPicPanel, vis);
	
		vis.gridx = 1;
		vis.gridy = 0;
		visuals.add(visualsEditingPanel, vis);
		
		mainVisuals.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		mainVisuals.add(visualSideScroll, BorderLayout.LINE_START);
		mainVisuals.add(visuals);
			
		JScrollPane visualMainScroll = new JScrollPane(mainVisuals);
		
		//Appointments
		appointmentPanel = new JPanel(new GridBagLayout());
		appointmentPanel.setPreferredSize(new Dimension(1000,300));
		appointmentPanel.setBackground(Color.WHITE);
		
		patientPanel4 = new JPanel(new GridBagLayout());
		patientPanel4.setBackground(new Color(192,192,192));
		patientPanel4.setPreferredSize(new Dimension(600,300));

		String[] apptColumns  = {"Date", "Time","Status","Reason For Visit"};
		
		String[][] apptData = {{"02/15/2012", "3:15pm", "Completed", "Fever"}, 
				{"06/16/2012", "12:00pm", "Completed", "Nausea"}, 
				{"02/15/2013", "4:30pm", "Completed", "Severe Headache"},
				{"08/23/2013","5:15pm", "Completed", "Checkup"},
				{"02/21/2014", "2:15pm", "Completed", "Checkup"}, 
				{"08/13/2014", "1:30pm", "Missed", "Checkup"},
				{"09/02/2014", "1:00pm", "Completed", "Checkup"},
				{"03/23/2015", "3:15pm", "Completed", "Checkup"}, 
				{"09/18/2015", "6:30pm", "Completed", "Checkup"}, 
				{"03/30/2016", "2:00pm", "Pending", "Checkup"}};
		
		JTable apptTable = new JTable(apptData, apptColumns);
		apptTable.setPreferredScrollableViewportSize(new Dimension(500,200));
		
		// Create Space Between Rows 
		int gap4 = 10;
		apptTable.setRowHeight(apptTable.getRowHeight() + gap4);
		apptTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		apptTable.setFillsViewportHeight(true);
		
		JScrollPane apptpane = new JScrollPane(apptTable);
		
		ImageIcon appointPic1 = new ImageIcon("images/medicon.jpg");
		JLabel aptPic1 = new JLabel(appointPic1);
		
		ImageIcon appointPic2 = new ImageIcon("images/medicon.jpg");
		JLabel aptPic2 = new JLabel(appointPic2);
		
		GridBagConstraints grid4 = new GridBagConstraints();
		
		grid4.gridx = 1;
		grid4.gridy = 3;		
		patientPanel4.add(apptpane, grid4);
		
		GridBagConstraints grid5 = new GridBagConstraints();
		grid5.gridx = 0;
		grid5.gridy = 0;
		appointmentPanel.add(aptPic1, grid5);
		
		grid5.gridx = 2;
		grid5.gridy = 0;
		appointmentPanel.add(patientPanel4, grid5);
		appointmentsScroll = new JScrollPane(appointmentPanel);
		
		grid5.gridx = 3;
		grid5.gridy = 0;
		appointmentPanel.add(aptPic2, grid5);
		
		//Bills
		billsPanel = new JPanel(new GridBagLayout());
		billsPanel.setPreferredSize(new Dimension(1000,300));
		
		
		patientPanel5 = new JPanel(new GridBagLayout());
		patientPanel5.setPreferredSize(new Dimension(600,300));
		patientPanel5.setBackground(new Color(192,192,192));
		
		ImageIcon billPic1 = new ImageIcon("images/logo.png");
		JLabel bPic1 = new JLabel(billPic1);
		
		ImageIcon billPic2 = new ImageIcon("images/TextLogo.png");
		JLabel bPic2 = new JLabel(billPic2);
		
		String[] billsColumns  = {"Bill ID", "Visit Date(m/d/yy)", "Rendering Provider", "Location", 
		"Status", "Bill Date"};
		
		String[][] billsData = {{"1001", "12/01/1994", "Dr.Samina Johnson", "Brooklyn, NY", "Completed", "12/01/1994"}, 
		{"1002", "10/23/1990", "Dr.Sohail Arif", "Manhattan,NY", "Pending", "10/23/1990"}, 
		{"1003", "10/21/1996", "Dr. Sibgha Arif", "Bronx,NY", "Completed", "10/21/1996"}, 
		{"1004", "02/07/2007", "Dr.Arif Pervez", "Brooklyn,NY", "Pending", "02/07/2007"}, 
		{"1005", "12/29/2005", "Dr.Zynah Sohail", "Queens,NY", "Completed", "12/29/2005"}, 
		{"1006", "10/16/2013", "Dr.Gissel Rivera", "Manhattan,NY", "Pending", "10/16/2013"}};
		
		JTable billsTable = new JTable(billsData, billsColumns);
		billsTable.setPreferredScrollableViewportSize(new Dimension(500,200));
		int gap5 = 10;
		billsTable.setRowHeight(billsTable.getRowHeight() + gap5);
		billsTable.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 12));
		billsTable.setFillsViewportHeight(true);
		
		JScrollPane billspane = new JScrollPane(billsTable);
		
		GridBagConstraints grid6 = new GridBagConstraints();
		grid6.gridx = 1;
		grid6.gridy = 3;
		patientPanel5.add(billspane, grid6);
		
		GridBagConstraints grid7 = new GridBagConstraints();
		grid7.gridx = 0;
		grid7.gridy = 0;
		billsPanel.add(bPic1, grid7);
		
		grid7.gridx = 0;
		grid7.gridy = 1;
		billsPanel.add(patientPanel5, grid7);
		
		grid7.gridx = 0;
		grid7.gridy = 2;
		billsPanel.add(bPic2, grid7);
		
		billsScroll = new JScrollPane(billsPanel);
		
		//View Patient Panel Side Bar
		viewPatientSidePanel = new JPanel(new BorderLayout());
		viewPatientSidePanel.setPreferredSize(new Dimension(1250,600));
        viewPatientSidePanel.setBackground(new Color(255,255,204));
        
        JTabbedPane tab = new JTabbedPane();
		tab.setTabPlacement(SwingConstants.LEFT);
	    tab.addTab("Patient Info", patientInfoScroll);
	    tab.addTab("Medical Records", medicalRecordsScroll);
	    tab.addTab("Visuals", visualMainScroll);
	    tab.addTab("Appointments", appointmentsScroll);
	    tab.addTab("Bills", billsScroll);
	    
	    viewPatientSidePanel.add(tab);
	    
		viewPatientSidePanel.setVisible(false);
		add(viewPatientSidePanel);
		
		deleteConfirmPanel = new JPanel();
		deleteConfirmPanel.setPreferredSize(new Dimension(500,500));
		deleteConfirmPanel.setBackground(Color.GRAY);
		JLabel confirm = new JLabel("Are you sure you want to delete this patient ?");
		deleteConfirmPanel.add(confirm);
		JButton submitDelete = new JButton("YES");
		JButton cancelDelete = new JButton("NO");
		deleteConfirmPanel.add(submitDelete);
		deleteConfirmPanel.add(cancelDelete);
		deleteConfirmPanel.setVisible(false);
		add(deleteConfirmPanel);
		
	}
	    //Register Button Listener that will save data in doctor registration table     
		private class RegisterButtonListener implements ActionListener
		{   
			public void actionPerformed(ActionEvent e)
			{
				mainPanel.setPreferredSize(new Dimension(600, 700));
				registerPanel.setVisible(true);
				loginPanel.setVisible(false);
				functionsPanel.setVisible(false);
				regSuccess.setVisible(false);
				getStarted.setVisible(false);
			}

		}
		
		//Submit Button for Register check 
		private class SubmitButtonListener implements ActionListener 
		{
		  public void actionPerformed(ActionEvent e)
		  {
			   
			  regSuccess.setVisible(true);
			  registerPanel.setVisible(false);
			  try {
				d.insertRow();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }

		}
		
		//Get Started
		private class getStartedButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				 try {
			         java.net.URL u = this.getClass().getClassLoader().getResource("getStarted.wav");
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
		}
		
		private class LoginButtonListener implements ActionListener
		{   
			public void actionPerformed(ActionEvent e)
			{
				mainPanel.setPreferredSize(new Dimension(600,700));
				loginPanel.setVisible(true);
				registerPanel.setVisible(false);
				regSuccess.setVisible(false);
				functionsPanel.setVisible(false);
				viewPatientSidePanel.setVisible(false);
				getStarted.setVisible(false);
			}

		}
		
		private class LogOutButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
			         
			         java.net.URL u = this.getClass().getClassLoader().getResource("loggedOut.wav");
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
				JOptionPane.showMessageDialog(mainPanel, "You have logged out successfully!");
				mainPanel.setVisible(true);
				blueSymbol.setVisible(true);
				loginSuccess.setVisible(false);
				changePassword.setVisible(false);
				welcomeEHRPanel.setVisible(false);
				functionsPanel.setVisible(false);
			}
		}
		
		private class SignButtonListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent e)
	      {	
				loginSuccess.setVisible(true);
				loginPanel.setVisible(false);
				registerPanel.setVisible(false);
				try {
					d.login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				
				
		  }

	  }
		
		private class OKButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
		      welcomeEHRPanel.setVisible(true);
		      mainPanel.setVisible(false);
		      blueSymbol.setVisible(false);
			  functionsPanel.setVisible(true);
			  regSuccess.setVisible(false);
			  loginPanel.setVisible(false);
			  registerPanel.setVisible(false);
			  Base.setVisible(true);
			}
		}	
		
		private class NewButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				patientRegistration.setVisible(true);
				mainSchedule.setVisible(false);
				patientDeleteSearch.setVisible(false);
				patientViewSearch.setVisible(false);
				welcomeEHRPanel.setVisible(true);
				functionsPanel.setVisible(true);
				changePassword.setVisible(false);
				panelSchedule.setVisible(false);
				mainPanel.setVisible(false);
				Base.setVisible(false);
				viewPatientSidePanel.setVisible(false);
				patientPanel.setVisible(false);
				patientPanel.setVisible(false);
				patientInfoPanel.setVisible(false);

			}
		}
		private class ViewButtonListener implements ActionListener

		{ public void actionPerformed(ActionEvent e)

		 {		
			Base.setVisible(false);
			patientRegistration.setVisible(false);
			patientInfoPanel.setVisible(false);
			patientDeleteSearch.setVisible(false);
			patientViewSearch.setVisible(true);
			patientDeleteSearch.setVisible(false);
			welcomeEHRPanel.setVisible(true);
			functionsPanel.setVisible(true);
			patientPanel.setVisible(false);
			mainSchedule.setVisible(false);
			changePassword.setVisible(false);
			viewPatientSidePanel.setVisible(false);
			mainPanel.setVisible(false);
			panelSchedule.setVisible(false);
			viewPatientSidePanel.setVisible(false);	

			try {
		       
		         java.net.URL u = this.getClass().getClassLoader().getResource("search.wav");
		         AudioInputStream audio = AudioSystem.getAudioInputStream(u);
		         Clip c = AudioSystem.getClip();
		         c.open(audio);
		         c.start();
		      } catch (UnsupportedAudioFileException error) {
		         error.printStackTrace();
		      } catch (IOException errow) {
		         errow.printStackTrace();
		      } catch (LineUnavailableException error) {
		         error.printStackTrace();
		}

		 }

		}
		private class DeleteButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Base.setVisible(false);
				patientRegistration.setVisible(false);
				functionsPanel.setVisible(true);
				patientDeleteSearch.setVisible(true);
				mainSchedule.setVisible(false);
				patientViewSearch.setVisible(false);
				patientInfoPanel.setVisible(false);
				patientPanel.setVisible(false);
				viewPatientSidePanel.setVisible(false);
				changePassword.setVisible(false);
				
				try {
			       
			         java.net.URL u = this.getClass().getClassLoader().getResource("search.wav");
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
			
		}
		
		private class ScheduleButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				mainSchedule.setVisible(true);
				panelSchedule.setVisible(true);
				patientInfoPanel.setVisible(false);
				patientViewSearch.setVisible(false);
				patientRegistration.setVisible(false);
				mainPanel.setVisible(false);
				patientDeleteSearch.setVisible(false);
				Base.setVisible(false);
				changePassword.setVisible(false);
				patientPanel.setVisible(false);
				viewPatientSidePanel.setVisible(false);

			}
		}
		
		private class infoSchedListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
			   try {
			
			         java.net.URL u = this.getClass().getClassLoader().getResource("schedule.wav");
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
		}
		
		private class moreInfoNewListener implements ActionListener 
		{	
			public void actionPerformed(ActionEvent e)
			{
			  try {
			         java.net.URL u = this.getClass().getClassLoader().getResource("moreInfoNew.wav");
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
			
		}
		private class ChangePasswordButtonListener implements ActionListener
		{   
			public void actionPerformed(ActionEvent e)
			{
				welcomeEHRPanel.setVisible(true);
				Base.setVisible(false);
				patientDeleteSearch.setVisible(false);
				patientViewSearch.setVisible(false);
				patientRegistration.setVisible(false);
				changePassword.setVisible(true);
				functionsPanel.setVisible(true);
				mainSchedule.setVisible(false);
				registerPanel.setVisible(false);
				regSuccess.setVisible(false);
				viewPatientSidePanel.setVisible(false);
				panelSchedule.setVisible(false);
						
			}

		}
		
		private JPanel getLabelDesign()
		{
			JPanel panelDesign = new JPanel();
			panelDesign.setOpaque(true);
			panelDesign.setBackground(new Color(153,204,255));
			JLabel passwordChange = new JLabel("Your password has been changed.", JLabel.CENTER);
			passwordChange.setForeground(Color.BLACK);
			panelDesign.add(passwordChange);
			return panelDesign;
		}
		
		
		private class SubmitChangePasswordListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				 new UIManager();
		         UIManager.put("OptionPane.background",new   ColorUIResource(204,255,204));
		         UIManager.put("Panel.background",new ColorUIResource(204,255,204));
		         JOptionPane.showMessageDialog(null, "Your Password has been changed.", 
		         "Green", 
		          JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		private class SubmitViewListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				patientRegistration.setVisible(false);
				patientViewSearch.setVisible(false);
				patientPanel.setVisible(true);
				viewPatientSidePanel.setVisible(true);
			}	
		}
		
		private class SubmitDeleteListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
			         java.net.URL u = this.getClass().getClassLoader().getResource("sureDelete.wav");
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
				
				int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this patient?", "Warning: This Cannot Be Undone", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				
				if(response == JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(patientDeleteSearch,"Patient Successfully Deleted !");					
				}
				
				if(response == JOptionPane.NO_OPTION)
				{
					patientDeleteSearch.setVisible(true);
				
				}
				patientRegistration.setVisible(false);
				patientViewSearch.setVisible(false);
				patientPanel.setVisible(false);

			}	
		}
		
		private class BackButtonListener2 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				functionsPanel.setVisible(true);
				Base.setVisible(true);
				patientNewSearch.setVisible(false);
				patientRegistration.setVisible(false);
				
			}
		}
		
		private class BackButtonListener3 implements ActionListener
		{
			
			public void actionPerformed(ActionEvent e)
			{
				functionsPanel.setVisible(true);
				Base.setVisible(true);
				patientNewSearch.setVisible(false);
				patientViewSearch.setVisible(false);

				
			}
		}
		
		private class ImportButtonListener implements ActionListener
		{
				public void actionPerformed(ActionEvent e)
				{
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle ("Choose Image..");
					 
					FileNameExtensionFilter filter = 
					        new FileNameExtensionFilter("JPG Images", "jpg");
					fc.setFileFilter(filter);    
					int returnVal = fc.showDialog( fc, "Choose..");
					File file = null;
					         
					if (returnVal == JFileChooser.APPROVE_OPTION)
					    file = fc.getSelectedFile();  
						image = null;
						visualPicPanel.removeAll();
					try
					{
					    image = ImageIO.read(file);      
					} catch (IOException err) {}
					           
					    ImageIcon image2 = new ImageIcon (file+"");        
						visualPicPanel.add(new JLabel(image2)); 
				}
						
		}
		
		private class ColorButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{	  
			  Color jcolor = Color.BLUE;
			  jcolor = JColorChooser.showDialog(null, "Choose a color",jcolor);
			  editorArea = new ImageEditor(); 
			 //vpc.setColor(); 
			     
			}
		}		
		
		private class UndoButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}
		
		private class ClearButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				visualPicPanel.removeAll();
				visualPicPanel.repaint();
			}
		}
		
		private class SaveButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}
		
		private class ScheduleComboListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				 JComboBox comboMonth = (JComboBox) e.getSource();
				  Object selected = comboMonth.getSelectedItem();
				  
				  if(selected == "2016")
				  {  
					 Caltabbed2015.setVisible(false);
					 Caltabbed2016.setVisible(true);
				  }
				
				  if(selected == "2015")
				  {  
					  Caltabbed2016.setVisible(false);
					  Caltabbed2015.setVisible(true);
				   	  
				  }   
			}
	  }
		

		
}


		