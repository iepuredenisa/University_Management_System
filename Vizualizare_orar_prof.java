package jdbc;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import java.text.Format;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Vizualizare_orar_prof {

	private JFrame frame;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Vizualizare_orar_prof(null,null,null);
	}

	/**
	 * Create the application.
	 */
	public Vizualizare_orar_prof(String nume , String prenume , String zi) {
		frame = new JFrame();
		frame.setBounds(100, 100, 955, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(46, 85, 844, 521);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Orar profesor", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 10, 458, 474);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tip", "Materia", "Ora"
			}
		));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Activitati generale", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(367, 10, 424, 474);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tip activitate", "Activitate predata"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(93);
		
		
		
		try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
		
		String query="call orar_prof_laborator('"+nume+"', '"+prenume+"', '"+zi+"')";
		java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rez = sta.executeQuery(query);
        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
        
      
	
        
        
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        int cols=rsmd.getColumnCount();
        String activitate,ora_activ,tip_a;
        while (rez.next())
        {   tip_a=rez.getString(1);
        	activitate=rez.getString(2);
        	ora_activ=rez.getString(3);
        	String[] row= {tip_a,activitate,ora_activ};
        	model.addRow(row);
        
        }
       
		sta.close();
		
		connection.close();
		
        
			//callableStatement=connection.prepareCall(sql);
		}
		
		catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
  	             " Details are provided below:");
  	          e2.printStackTrace(System.err);};
		try
		{
			  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
			  String query1="call orar_prof_seminar('"+nume+"', '"+prenume+"', '"+zi+"')";
		        java.sql.Statement sta1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        ResultSet rez1 = sta1.executeQuery(query1);
		        java.sql.ResultSetMetaData rsmd1=rez1.getMetaData();
		        
		        
	        DefaultTableModel model=(DefaultTableModel) table.getModel();
	        int cols=rsmd1.getColumnCount();
	        String activitate,ora_activ,tip_a;
	        
	        while (rez1.next())
	        {
	        	 tip_a=rez1.getString(1);
	         	activitate=rez1.getString(2);
	         	ora_activ=rez1.getString(3);
	        	String[] row= {tip_a,activitate,ora_activ};
	        	model.addRow(row);
	        }
	        
		}
		
			catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	  	             " Details are provided below:");
	  	          e2.printStackTrace(System.err);};
	

			
	try
	{
		  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
		  String query2="call orar_prof_curs('"+nume+"', '"+prenume+"', '"+zi+"')";
	        java.sql.Statement sta2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet rez2 = sta2.executeQuery(query2);
	        java.sql.ResultSetMetaData rsmd2=rez2.getMetaData();
	        
	        
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        int cols=rsmd2.getColumnCount();
        String activitate,ora_activ,tip_a;
        
        while (rez2.next())
        {
        	 tip_a=rez2.getString(1);
         	activitate=rez2.getString(2);
         	ora_activ=rez2.getString(3);
        	String[] row= {tip_a,activitate,ora_activ};
        	model.addRow(row);
        }
        
	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
  	             " Details are provided below:");
  	          e2.printStackTrace(System.err);};
  	          
  	          
  	          
  	    	frame.setVisible(true);
  	    //	contentPane.setVisible(true);
	
	try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	
	String query3="call orar_examene_profesor('"+nume+"', '"+prenume+"')";
	java.sql.Statement sta3 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    ResultSet rez3 = sta3.executeQuery(query3);
    java.sql.ResultSetMetaData rsmd3=rez3.getMetaData();
    
  

    
    
    DefaultTableModel model=(DefaultTableModel) table.getModel();
    int cols=rsmd3.getColumnCount();
    String activitate,ora_activ,tip_a;
    while (rez3.next())
    {   tip_a=rez3.getString(1);
    	activitate=rez3.getString(2);
    	ora_activ=rez3.getString(3);
    	String[] row= {tip_a,activitate,ora_activ};
    	model.addRow(row);
    
    }
   
	sta3.close();
	
	connection.close();
	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	             " Details are provided below:");
	          e2.printStackTrace(System.err);};
	          
		try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	    	
	    	String query4="call orar_coloviu_profesor('"+nume+"', '"+prenume+"')";
	    	java.sql.Statement sta4 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        ResultSet rez4 = sta4.executeQuery(query4);
	        java.sql.ResultSetMetaData rsmd4=rez4.getMetaData();
	        
	      

	        
	        
	        DefaultTableModel model=(DefaultTableModel) table.getModel();
	        int cols=rsmd4.getColumnCount();
	        String activitate,ora_activ,tip_a;
	        while (rez4.next())
	        {   tip_a=rez4.getString(1);
	        	activitate=rez4.getString(2);
	        	ora_activ=rez4.getString(3);
	        	String[] row= {tip_a,activitate,ora_activ};
	        	model.addRow(row);
	        
	        }
	       
	    	sta4.close();
	    	
	    	connection.close();
	    	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	    	             " Details are provided below:");
	    	          e2.printStackTrace(System.err);};
	    	          
	    	          
	    	          try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	    		    	
	    		    	String query4="call orar_partial_profesor('"+nume+"', '"+prenume+"')";
	    		    	java.sql.Statement sta4 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    		        ResultSet rez4 = sta4.executeQuery(query4);
	    		        java.sql.ResultSetMetaData rsmd4=rez4.getMetaData();
	    		        
	    		      

	    		        
	    		        
	    		        DefaultTableModel model=(DefaultTableModel) table.getModel();
	    		        int cols=rsmd4.getColumnCount();
	    		        String activitate,ora_activ,tip_a;
	    		        while (rez4.next())
	    		        {   tip_a=rez4.getString(1);
	    		        	activitate=rez4.getString(2);
	    		        	ora_activ=rez4.getString(3);
	    		        	String[] row= {tip_a,activitate,ora_activ};
	    		        	model.addRow(row);
	    		        
	    		        }
	    		       
	    		    	sta4.close();
	    		    	
	    		    	connection.close();
	    		    	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	    		    	             " Details are provided below:");
	    		    	          e2.printStackTrace(System.err);};
	    		    	          
	    		    	          
	    		    	          try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	    		    		    	
	    		    		    	String query4="call orar_restanta_l_profesor('"+nume+"', '"+prenume+"')";
	    		    		    	java.sql.Statement sta4 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    		    		        ResultSet rez4 = sta4.executeQuery(query4);
	    		    		        java.sql.ResultSetMetaData rsmd4=rez4.getMetaData();
	    		    		        
	    		    		      

	    		    		        
	    		    		        
	    		    		        DefaultTableModel model=(DefaultTableModel) table.getModel();
	    		    		        int cols=rsmd4.getColumnCount();
	    		    		        String activitate,ora_activ,tip_a;
	    		    		        while (rez4.next())
	    		    		        {   tip_a=rez4.getString(1);
	    		    		        	activitate=rez4.getString(2);
	    		    		        	ora_activ=rez4.getString(3);
	    		    		        	String[] row= {tip_a,activitate,ora_activ};
	    		    		        	model.addRow(row);
	    		    		        
	    		    		        }
	    		    		       
	    		    		    	sta4.close();
	    		    		    	
	    		    		    	connection.close();
	    		    		    	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	    		    		    	             " Details are provided below:");
	    		    		    	          e2.printStackTrace(System.err);};
	    		    		    	          
	    		    		    	          try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	    		    		    		    	
	    		    		    		    	String query4="call orar_restanta_c_profesor('"+nume+"', '"+prenume+"')";
	    		    		    		    	java.sql.Statement sta4 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    		    		    		        ResultSet rez4 = sta4.executeQuery(query4);
	    		    		    		        java.sql.ResultSetMetaData rsmd4=rez4.getMetaData();
	    		    		    		        
	    		    		    		      

	    		    		    		        
	    		    		    		        
	    		    		    		        DefaultTableModel model=(DefaultTableModel) table.getModel();
	    		    		    		        int cols=rsmd4.getColumnCount();
	    		    		    		        String activitate,ora_activ,tip_a;
	    		    		    		        while (rez4.next())
	    		    		    		        {   tip_a=rez4.getString(1);
	    		    		    		        	activitate=rez4.getString(2);
	    		    		    		        	ora_activ=rez4.getString(3);
	    		    		    		        	String[] row= {tip_a,activitate,ora_activ};
	    		    		    		        	model.addRow(row);
	    		    		    		        
	    		    		    		        }
	    		    		    		       
	    		    		    		    	sta4.close();
	    		    		    		    	
	    		    		    		    	connection.close();
	    		    		    		    	}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	    		    		    		    	             " Details are provided below:");
	    		    		    		    	          e2.printStackTrace(System.err);};
	    		    		    		    	   

	   	try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	    		    		    		    	  		
	    String query="call activitati_profesor('"+nume+"', '"+prenume+"')";
	    java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	    ResultSet rez = sta.executeQuery(query);
	    java.sql.ResultSetMetaData rsmd=rez.getMetaData();
	    		    		    		    	          
	    		    		    		    	        
	    		    		    		    	  	
	    		    		    		    	          
	    		    		    		    	          
	   DefaultTableModel model=(DefaultTableModel) table_1.getModel();
	    		 int cols=rsmd.getColumnCount();
	    		 String tip_a,activitate;
	    		   while (rez.next())
	    		   {   tip_a=rez.getString(1);
	    		   	activitate=rez.getString(2);
	    		   String[] row= {tip_a,activitate};
	    		    model.addRow(row);
	    		    		    		    	          
	     }
	    		    		    		    	         
	    		    	sta.close();
	    		    		    		    	  		
	    		   	connection.close();
	    		    		    		    	  		
	    		    		    		    	          
	    		    		    		    	  			//callableStatement=connection.prepareCall(sql);
	   	}
	    		    		    		    	  		
	    	catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	    		    		        " Details are provided below:");
	    	   e2.printStackTrace(System.err);};
	
		// TODO Auto-generated constructor stub
	
	    	
	    	
	        
	
	
    
		//callableStatement=connection.prepareCall(sql);
	


	/**
	 * Initialize the contents of the frame.
	 */
	}
}
