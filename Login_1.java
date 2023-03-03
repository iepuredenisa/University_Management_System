package jdbc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*import proiect.DupaLoginA;
import proiect.DupaLoginP;
import proiect.DupaLoginS;*/



public class Login_1 {

	JFrame frame;
	ImageIcon backgr;
	JLabel myLabel, lab, l1,l2,l3,label;
	JButton superad, ad, prof, stud, button, buttonBack, buttonLg;
	JTextField t1,t2,t3;


	    public Login_1(String n)
	    {
	    	
	    	 
	    	backgr= new ImageIcon(this.getClass().getResource("/un.jpg"));
			myLabel= new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Autentificare:");
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
	        
	        
	        label = new JLabel(n);
	         label.setHorizontalAlignment(SwingConstants.CENTER);
	         label.setFont(new Font("serif",Font.BOLD,18));
	         label.setBounds(280, 380, 350, 60);
	         myLabel.add(label);
	         
	       
	         
	        
	        
	        l1 = new JLabel("Nume");
	        l1.setBounds(270,450,200,30);
	        l1.setFont(new Font("serif",Font.BOLD,20));
	        l1.setForeground(Color.BLACK);
	        myLabel.add(l1);
	        
	        t1=new JTextField();
	        t1.setBounds(350,450,200,30);
	        myLabel.add(t1);
	        
	        l2 = new JLabel("Prenume");
	        l2.setBounds(270,500,200,30);
	        l2.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l2);
	        
	        t2=new JTextField();
	        t2.setBounds(350,500,200,30);
	        myLabel.add(t2);
	        
	        l3 = new JLabel("CNP");
	        l3.setBounds(270,550,200,30);
	        l3.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l3);
	        
	        t3=new JTextField();
	        t3.setBounds(350,550,200,30);
	        myLabel.add(t3);
	        
	        buttonBack.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new Login();
	  			
	  		}
	      	  
	        });
	        buttonLg = new JButton("Login");
		     buttonLg.setBounds(650, 600, 200, 40);
		     buttonLg.setFocusable(false);
		     buttonLg.setBackground(Color.BLACK);
		     buttonLg.setForeground(Color.WHITE);
		      myLabel.add(buttonLg);
		      buttonLg.addActionListener(new ActionListener()
		      {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					   String nume = t1.getText();
		                String prenume = t2.getText();
		                String parola = t3.getText();
		                String NUME = t1.getText();
		                String PRENUME = t2.getText();
		   if (nume.equals("") || prenume.equals("") || parola.equals("")) {
		                    JOptionPane.showMessageDialog(null, "Verifica daca ai completat toate campurile", "Error",
		                            JOptionPane.WARNING_MESSAGE);
		   }else if (parola.length() != 13 || !parola.chars().allMatch(Character::isDigit)) {
               JOptionPane.showMessageDialog(null, "CNP gresit !", " Error", JOptionPane.WARNING_MESSAGE);}
					
				
				else {
                    int rasp = doQuery(label.getText(), nume, prenume, parola,NUME,PRENUME);
                    if (rasp == 1) {
                        switch (label.getText()) {
                            case "SuperAdministrator" -> {
                                frame.dispose();
                                new Ad_SAd(label.getText(), nume + " " + prenume,parola,NUME,PRENUME);
                               
                            }
                            
                            case "Administrator" -> {
                                frame.dispose();
                                new Ad_Ad(label.getText(), nume + " " + prenume,parola,NUME,PRENUME);
                               
                            }
                            
                            case "Profesor" -> {
                                frame.dispose();
                                new Lg_prof(label.getText(), nume + " " + prenume,parola,NUME,PRENUME);
                                
                            }
                            case "Student" -> {
                                frame.dispose();
                                new Lg_stud(label.getText(), nume + " " + prenume,PRENUME,parola,NUME,PRENUME);
                                
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "NU EXISTI IN BAZA NOASTRA DE DATE!", "WARINIG!", JOptionPane.WARNING_MESSAGE);

                }
            }

				
		    	  
		      });
	    }
	    
	    private int doQuery(String tabela, String nume, String prenume, String CNP,String NUME,String PRENUME) {
	        try {
	        	 WConnection cc = new WConnection();
	           // Statement s =  new createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            if (tabela.equals("SuperAdministrator"))
	                tabela = "SuperAdministrator";
	            ResultSet rs = cc.s.executeQuery("SELECT * FROM platforma_studiu." + tabela.toLowerCase() + " WHERE nume = '" + nume + "' AND prenume = '" + prenume + "' AND CNP = '" + CNP + "';");
	            int rows = 0;
	            while (rs.next()) {
	                rows++;
	            }
	            if (rows == 0)
	                return 0;

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return 1;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new Login_1(null);
	}

}
