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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Inscriere_CURS implements ActionListener {
	JFrame frame;
	JTable t1;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune,l1,l2,l3,l4,activitate,ora,zi;
	JButton superad, ad, prof, stud, button,buttonBack,detaliistud,inscriere_curs,buttoninscriere,buttontotal;
    private ButtonGroup checkboxes;
    JComboBox curs,activitati,ore,zile;
    JTextField n,p,c;
    
   
    
    public void fillComboBoxactivitati(String materie)
	 {
   	
   	WConnection cc = new WConnection();
	      
	      try {
	    	  ///daca e null mesaj//////////////////////////////
	    	  ResultSet rss = cc.s.executeQuery("SELECT informatii_profesor.tip from informatii_profesor where informatii_profesor.activitate_predata ='"+materie+"' group by tip");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				activitati.addItem(rss.getString("tip"));
	    	  			}
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
    
    
    public void fillComboBoxzile(String materie,String tip)
	 {
  	
  	WConnection cc = new WConnection();
	      
	      try {
	    	  ///daca e null mesaj//////////////////////////////
	    	  if(tip.equals("curs"))
	    	  {  
	    		   ResultSet rss = cc.s.executeQuery("SELECT activitati.zi_curs from activitati where activitati.activitate_predata ='"+materie+"' group by zi_curs");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				zile.addItem(rss.getString("zi_curs"));
	    	  			}
	    	  }
	    	  
	    	  if(tip.equals("laborator"))
	    	  {  
	    		   ResultSet rss = cc.s.executeQuery("SELECT activitati.zi_lab from activitati where activitati.activitate_predata ='"+materie+"' group by zi_lab");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				zile.addItem(rss.getString("zi_lab"));
	    	  			}
	    	  }
	    	  
	    	  if(tip.equals("seminar"))
	    	  {  
	    		   ResultSet rss = cc.s.executeQuery("SELECT activitati.zi_seminar from activitati where activitati.activitate_predata ='"+materie+"' group by zi_seminar");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				zile.addItem(rss.getString("zi_seminar"));
	    	  			}
	    	  }
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
	    		  
	    }
    
    
    public void fillComboBoxore(String materie,String tip)
	 {
 	
 	WConnection cc = new WConnection();
	      
	      try {
	    	  ///daca e null mesaj//////////////////////////////
	    	  if(tip.equals("curs"))
	    	  {  
	    		   ResultSet rss = cc.s.executeQuery("SELECT activitati.ora_curs from activitati where activitati.activitate_predata ='"+materie+"' group by ora_curs");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				ore.addItem(rss.getString("ora_curs"));
	    	  			}
	    	  }
	    	  
	    	  if(tip.equals("laborator"))
	    	  {  
	    		   ResultSet rss = cc.s.executeQuery("SELECT activitati.ora_lab from activitati where activitati.activitate_predata ='"+materie+"' group by ora_lab");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				ore.addItem(rss.getString("ora_lab"));
	    	  			}
	    	  }
	    	  
	    	  if(tip.equals("seminar"))
	    	  {  
	    		   ResultSet rss = cc.s.executeQuery("SELECT activitati.ora_seminar from activitati where activitati.activitate_predata ='"+materie+"' group by ora_seminar");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				ore.addItem(rss.getString("ora_seminar"));
	    	  			}
	    	  }
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
	    		  
	    }
	 

		
	 
	 public Inscriere_CURS(String prenume, String nume,String CNP)
	 {
		 backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			myLabel= new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Student "+nume+" "+prenume);
			frame.add(myLabel);
			frame.setSize(900,700);
			frame.setLayout(null);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		    frame.setLocationRelativeTo(null);
		    
		    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	 	    frame.setIconImage(icon);
	 	    
	       
	       buttonBack = new JButton("Back");
	        buttonBack.setBounds(600, 600, 200, 40);
	        buttonBack.setFocusable(false);
	        buttonBack.setBackground(Color.BLACK);
	     	buttonBack.setForeground(Color.WHITE);
	        myLabel.add(buttonBack);
	        
	        buttonBack.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			frame.setVisible(false);
	  			
	  		}
	      	  
	        });
	        
	        buttoninscriere = new JButton("Aderare");
	        buttoninscriere.setBounds(100, 600, 200, 40);
	        buttoninscriere.setFocusable(false);
	        buttoninscriere.setBackground(Color.BLACK);
	     	buttoninscriere.setForeground(Color.WHITE);
	        myLabel.add(buttoninscriere);
	        
	        
	       /* JButton buttontotal = new JButton("Inscriere");
	        buttontotal.setBounds(50, 600, 200, 40);
	        buttontotal.setFocusable(false);
	        buttontotal.setBackground(Color.BLACK);
	     	buttontotal.setForeground(Color.WHITE);
	        myLabel.add(buttontotal);*/
	        
	        l1 = new JLabel("Nume curs");
	        l1.setBounds(100,100,150,30);
	        l1.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l1);
	        
	        String cursuri[] = {"OOP", "MES", "MSI","CAN","AF","BD","PC","SDA","ENG"};
	        curs = new JComboBox(cursuri);
	        curs.setBackground(Color.WHITE);
	        curs.setBounds(200,100,150,30);
	        myLabel.add(curs);
	        curs.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			activitati.removeAllItems();
	  			 fillComboBoxactivitati(curs.getSelectedItem().toString());
	  			
	  			
	  		}
	      	  
	        });
	        
	        l2 = new JLabel("Nume");
	        l2.setBounds(100,150,300,30);
	        l2.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l2);
	        
	        n = new JTextField();
	        n.setBackground(Color.WHITE);
	        n.setBounds(200,150,150,30);
	        myLabel.add(n);
	        n.setText(nume);
	        
	        l3 = new JLabel("Prenume");
	        l3.setBounds(100,200,300,30);
	        l3.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l3);
	        
	        p = new JTextField();
	        p.setBackground(Color.WHITE);
	        p.setBounds(200,200,150,30);
	        myLabel.add(p);
	        p.setText(prenume);
	        
	        l4 = new JLabel("CNP");
	        l4.setBounds(100,250,300,30);
	        l4.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l4);
	        
	        c = new JTextField();
	        c.setBackground(Color.WHITE);
	        c.setBounds(200,250,150,30);
	        myLabel.add(c);
	        c.setText(CNP);
	        //buttoninscriere.addActionListener(this);
	        buttoninscriere.addActionListener(new ActionListener()
	        {

	  		
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			zile.removeAllItems();
	  			fillComboBoxzile(curs.getSelectedItem().toString(),activitati.getSelectedItem().toString());
	  			ore.removeAllItems();
	  			fillComboBoxore(curs.getSelectedItem().toString(),activitati.getSelectedItem().toString());
	  			
	  			
	  			 String materiee=(String) curs.getSelectedItem();
	  		      String nume=n.getText();
	  		     String prenume=(String)p.getText();
	  		      String cnpp=(String)c.getText();
	  		      String tipp=(String)activitati.getSelectedItem();
	  		      String oraa=(String)ore.getSelectedItem();
	  		      String zii=(String)zile.getSelectedItem();
	  		      
	  		      String sql2=null;
	  		    	  
	  		    	  try {
	  		      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	  		      			
	  		      			CallableStatement callableStatement=null;
	  		      			ResultSet resultSet=null;
	  		      			//Statement s=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	  		      			System.out.println(tipp);
	  		      	      System.out.println(oraa);
	  		      	      System.out.println(zii);	
	  		      			 sql2="{call inserare_activitate(?,?,?,?,?,?,?)}";
	  		      			 
	  		      			 //resultSet=s.executeQuery(sql2);
	  		      		
	  		      			
	  		      			callableStatement=connection.prepareCall(sql2);
	  		      			
	  		      			callableStatement.setString(1,nume);
	  		      			callableStatement.setString(2,prenume);
	  		      			callableStatement.setString(3,cnpp);
	  		      			callableStatement.setString(4,materiee);
	  		      			callableStatement.setString(5,tipp);
	  		      			callableStatement.setString(6,oraa);
	  		      			callableStatement.setString(7,zii);
	  		      			
	  		      			callableStatement.execute();
	  		      			System.out.println(callableStatement);
	  		      			connection.close();
	  		      			//JOptionPane.showMessageDialog(null,"Student assigned Successfully");
	  		                  //frame.setVisible(false);
	  		      			
	  		      			
	  		      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	  		      	             " Details are provided below:");
	  		      	          e2.printStackTrace(System.err);};
	  		    	  
	  		    	   //if(tipp.equals("seminar")|| tipp.equals("laborator"))
	  		    	  //{
	  		    		  try {
	  			      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	  			      			
	  			      			CallableStatement callableStatement=null;
	  			      			ResultSet resultSet=null;
	  			      			
	  			      			System.out.println(tipp);
	  			      	      System.out.println(oraa);
	  			      	      System.out.println(zii);
	  			      			
	  			      				String sql="{call minimstudenti23(?,?,?,?)}";
	  			      		
	  			      			
	  			      			callableStatement=connection.prepareCall(sql);
	  			      			System.out.println(materiee+nume+prenume+cnpp);
	  			      			callableStatement.setString(1,materiee);
	  			      			callableStatement.setString(2,nume);
	  			      			callableStatement.setString(3,prenume);
	  			      			callableStatement.setString(4,cnpp);
	  			      			
	  			      			callableStatement.execute();
	  			      			connection.close();
	  			      			
	  			      			
	  			      			
	  			      			//JOptionPane.showMessageDialog(null,"Student assigned Successfully");
	  			                  //frame.setVisible(false);
	  			      			
	  			      			
	  			      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	  			      	             " Details are provided below:");
	  			      	          e2.printStackTrace(System.err);};
	  			      	          
	  			      
	  			      	          
	  			      	     	try {
	  				      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	  				      			
	  				      			CallableStatement callableStatement=null;
	  				      			ResultSet resultSet=null;
	  				      		
	  				      			System.out.println(tipp);
	  				      	      System.out.println(oraa);
	  				      	      System.out.println(zii);
	  				      	      	String ocupat=null;
	  				      			
	  				      			//	String sql="{call activitati_student10(?,?,?,?,?,?)}";
	  				      		String sql3="call activitati_student10('"+nume+"', '"+prenume+"','"+cnpp+"','"+materiee+"', '"+tipp+"', '"+oraa+"','"+zii+"')";
	  				      			
	  				      			callableStatement=connection.prepareCall(sql3);
	  				      			System.out.println(nume+prenume+cnpp+materiee+tipp+oraa+zii);

	  				      		/*	callableStatement.setString(1,nume);
	  				      			callableStatement.setString(2,prenume);
	  				      			callableStatement.setString(3,cnpp);
	  				      			callableStatement.setString(4,materiee);
	  				      			callableStatement.setString(5,tipp);
	  				      			callableStatement.setString(6,oraa);
	  				      			callableStatement.setString(7,zii);
	  				      			*/
	  				      		//	callableStatement.setInt (8,ocupat);
	  				      			callableStatement.execute();
	  				      			connection.close();
	  				      		//	if(ocupat !=0)
	  				      				//JOptionPane.showMessageDialog(null,"Studentul este ocupat");
	  				      			//else
	  				      			//JOptionPane.showMessageDialog(null,"Student assigned Successfully");
	  				      			
	  				      			
	  				      			//else
	  				      				//JOptionPane.showMessageDialog(null,"Nu ati putut fi asignat in perioada selectat");
	  				      			
	  				                  frame.setVisible(false);
	  				      			
	  				      			
	  				      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	  				      	             " Details are provided below:");
	  				      	          e2.printStackTrace(System.err);};
	  		    	  }
	  		    	  
	  			
	  		
	      	  
	        });
	        
	        activitate = new JLabel("Alegeti activitatea");
	        activitate.setBounds(500,100,300,30);
	        activitate.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(activitate);
	        
	        //String acti[] = {"OOP", "MES", "MSI","CAN","AF","BD","PC","SDA","ENG"};
	        activitati = new JComboBox();
	        activitati.setBackground(Color.WHITE);
	        activitati.setBounds(500,150,150,30);
	        myLabel.add(activitati);
	        
	        activitati.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			zile.removeAllItems();
	  			fillComboBoxzile(curs.getSelectedItem().toString(),activitati.getSelectedItem().toString());
	  			ore.removeAllItems();
	  			fillComboBoxore(curs.getSelectedItem().toString(),activitati.getSelectedItem().toString());
	  			
	  		}
	      	  
	        });
	        
	        ora = new JLabel("Alegeti ora");
	        ora.setBounds(500,200,300,30);
	        ora.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(ora);
	        
	        ore = new JComboBox();
	        ore.setBackground(Color.WHITE);
	        ore.setBounds(500,250,150,30);
	        myLabel.add(ore);
	        
	        zi = new JLabel("Alegeti ziua");
	        zi.setBounds(500,300,300,30);
	        zi.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(zi);
	        
	        zile = new JComboBox();
	        zile.setBackground(Color.WHITE);
	        zile.setBounds(500,350,150,30);
	        myLabel.add(zile);
	        
	       
	        
	        
	      
	 }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Inscriere_CURS(null,null,null);
		}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	    		
	      	        
	      
	}
}


