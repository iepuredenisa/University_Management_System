package jdbc;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;



 
public class Login implements ActionListener{

	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab;
	JButton superad, ad, prof, stud, button;
    private ButtonGroup checkboxes;
	
	public Login(){
		backgr= new ImageIcon(this.getClass().getResource("/un.jpg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("LOGIN");
		frame.add(myLabel);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	    superad=new JButton("SuperAdministrator");
 	    superad.setBounds(350, 400, 200, 40);
 	   superad.setBackground(Color.BLACK);
       superad.setForeground(Color.WHITE);
 	    myLabel.add(superad);
 	    
 	   ad=new JButton("Administrator");
	    ad.setBounds(350, 450, 200, 40);
	   ad.setBackground(Color.BLACK);
      ad.setForeground(Color.WHITE);
	    myLabel.add(ad);
	    
	    
	    prof=new JButton("Profesor");
 	    prof.setBounds(350, 500, 200, 40);
 	    prof.setBackground(Color.BLACK);
       prof.setForeground(Color.WHITE);
 	    myLabel.add(prof);
 	    
 	    
 	   stud=new JButton("Student");
 	  stud.setBounds(350, 550, 200, 40);
 	 stud.setBackground(Color.BLACK);
 	stud.setForeground(Color.WHITE);
	    myLabel.add(stud);
	    
	    // ne asiguram ca a fost apasat vreun buton
	    checkboxes = new ButtonGroup();
		checkboxes.add(superad);
		checkboxes.add(ad);
		checkboxes.add(prof);
		checkboxes.add(stud);
	    
	 
	
      superad.addActionListener(new ActionListener()
      {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Login_1(superad.getText());
			
		}
    	  
      });
      
      ad.addActionListener(new ActionListener()
      {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Login_1(ad.getText());
			
		}
    	  
      });
      
      prof.addActionListener(new ActionListener()
      {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Login_1(prof.getText());
			
		}
    	  
      });
      
      stud.addActionListener(new ActionListener()
      {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Login_1(stud.getText());
			
		}
    	  
      });
			
	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}


}