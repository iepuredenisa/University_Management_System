package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DeleteProfesor implements ActionListener {
	JFrame frame;
	JLabel myLabel,l1,l2,l3;
	JTextField t1,t2,t3;
	
	JButton buttonstergere,buttonBack;
	ImageIcon backgr;
	
	public DeleteProfesor(String CNP,String nume, String prenume)
	{
		
		backgr= new ImageIcon(this.getClass().getResource("/un.jpg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("Eliminare profesor:");
		frame.add(myLabel);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	   buttonBack = new JButton("Back");
        buttonBack.setBounds(30, 600, 200, 40);
        buttonBack.setFocusable(false);
        buttonBack.setBackground(Color.BLACK);
     	buttonBack.setForeground(Color.WHITE);
        myLabel.add(buttonBack);
        
         
       
         
        
        
        l1 = new JLabel("Introduceti Numele");
        l1.setBounds(250,450,200,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        myLabel.add(l1);
        
        t1=new JTextField();
        t1.setBounds(450,450,200,30);
        myLabel.add(t1);
        
        l2 = new JLabel("Introduceti Prenumele");
        l2.setBounds(250,500,200,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        myLabel.add(l2);
        
        t2=new JTextField();
        t2.setBounds(450,500,200,30);
        myLabel.add(t2);
        
        l3 = new JLabel("Introduceti CNP-ul");
        l3.setBounds(250,550,200,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        myLabel.add(l3);
        
        t3=new JTextField();
        t3.setBounds(450,550,200,30);
        myLabel.add(t3);
        
        buttonBack.addActionListener(new ActionListener()
        {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			//new Ad_SAd(prenume,nume,CNP);
  			frame.setVisible(false);
  			
  		}
      	  
        });
        
        buttonstergere = new JButton("Eliminati");
	    buttonstergere.setBounds(650, 600, 200, 40);
	    buttonstergere.setFocusable(false);
	    buttonstergere.setBackground(Color.BLACK);
	    buttonstergere.setForeground(Color.WHITE);
	    myLabel.add(buttonstergere);
	
	    
	    
     
     buttonstergere.addActionListener(new ActionListener()
    		 {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			 if (nume.equals("") || prenume.equals("") || CNP.equals("")) {
                 JOptionPane.showMessageDialog(null, "Verifica daca ai completat toate campurile", "Error",
                         JOptionPane.WARNING_MESSAGE);
              }else if (CNP.length() != 13 || !CNP.chars().allMatch(Character::isDigit)) {
               JOptionPane.showMessageDialog(null, "CNP gresit !", " Error", JOptionPane.WARNING_MESSAGE);}
			try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
			
			CallableStatement callableStatement=null;
			ResultSet resultSet=null;
			
			String sql="{call deleteprofesor2(?,?,?)}";
			
			callableStatement=connection.prepareCall(sql);
			
			callableStatement.setString(1,t3.getText());
			callableStatement.setString(2,t1.getText());
			callableStatement.setString(3,t2.getText());
			
			callableStatement.execute();
			connection.close();
			JOptionPane.showMessageDialog(null,"Teacher Deleted Successfully");
            frame.setVisible(false);
			
		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	             " Details are provided below:");
	          e2.printStackTrace(System.err);};
				
			}
   	  
		
	});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		