package jdbc;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
import java.text.Format;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Vizualizare_orar_student {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	int i=1,j=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Vizualizare_orar_student(null,null,null);
	}

	/**
	 * Create the application.
	 */
	public Vizualizare_orar_student(String nume , String prenume , String zi) {
		frame = new JFrame("Orar "+ nume+" "+prenume);
		frame.setBounds(100, 100, 955, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		  Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	 	    frame.setIconImage(icon);
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
				"No", "Materia", "Tip","Zi", "Ora"
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
					"No", "Materia", "Tip","Zi", "Ora"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(93);
		
		
		
		try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
		
		String query="call orar_student_ZiCurenta('"+nume+"', '"+prenume+"', '"+zi+"')";
		java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rez = sta.executeQuery(query);
        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
        
      
	
        
        
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        int cols=rsmd.getColumnCount();
      
        String nr, activitate,tip_a,zi_a,ora;
        while (rez.next())
        {  nr=String.valueOf(i);
        	activitate=rez.getString(1);
        	 tip_a=rez.getString(2);
        	zi_a=rez.getString(3);
        	ora=rez.getString(4);
        	String[] row= {nr,activitate,tip_a,zi_a,ora};
        	i++;
        	model.addRow(row);
        
        }
       
		sta.close();
		
		connection.close();
		
        
			//callableStatement=connection.prepareCall(sql);
		}
		
		catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
  	             " Details are provided below:");
  	          e2.printStackTrace(System.err);};
  	        try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
  	   
  			String query="call orar_student_ZiCurenta_meet('"+nume+"', '"+prenume+"')";
  			java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
  	        ResultSet rez = sta.executeQuery(query);
  	        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
  	        
  	      
  		
  	        
  	        
  	        DefaultTableModel model=(DefaultTableModel) table.getModel();
  	        int cols=rsmd.getColumnCount();
  	        
  	        String nr, activitate,tip_a,ora;
			java.sql.Date zi_a;
  	        while (rez.next())
  	        {  nr=String.valueOf(i);
  	        	activitate=rez.getString(1);
  	        	 tip_a=rez.getString(2);
  	        	zi_a=rez.getDate(3);
  	        	ora=rez.getString(4);
  	        	String[] row= {nr,activitate,tip_a,String.valueOf(zi_a),ora};
  	        	i++;
  	        	model.addRow(row);
  	        
  	        }
  	       
  			sta.close();
  			
  			connection.close();
  			
  	        
  				//callableStatement=connection.prepareCall(sql);
  			}
  			
  			catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
  	  	             " Details are provided below:");
  	  	          e2.printStackTrace(System.err);};
		
  	  	      try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
  	   	   
    			String query="call orar_student_meet('"+nume+"', '"+prenume+"')";
    			java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	        ResultSet rez = sta.executeQuery(query);
    	        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
    	        
    	      
    		
    	        
    	        
    	        DefaultTableModel model=(DefaultTableModel) table_1.getModel();
    	        int cols=rsmd.getColumnCount();
    	        
    	        String nr, activitate,tip_a,ora;
  			java.sql.Date zi_a;
    	        while (rez.next())
    	        {  nr=String.valueOf(j);
    	        	activitate=rez.getString(1);
    	        	 tip_a=rez.getString(2);
    	        	zi_a=rez.getDate(3);
    	        	ora=rez.getString(4);
    	        	String[] row= {nr,activitate,tip_a,String.valueOf(zi_a),ora};
    	        
    	        	model.addRow(row);
    	        	j++;
    	        
    	        }
    	       
    			sta.close();
    			
    			connection.close();
    			
    	        
    				//callableStatement=connection.prepareCall(sql);
    			}
    			
    			catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
    	  	             " Details are provided below:");
    	  	          e2.printStackTrace(System.err);};
    	  	          
    	  	          
    	  	    	
    	  			try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
    	  			
    	  			String query="call orar_student('"+nume+"', '"+prenume+"')";
    	  			java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    	  	        ResultSet rez = sta.executeQuery(query);
    	  	        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
    	  	        
    	  	      
    	  		
    	  	        
    	  	        
    	  	        DefaultTableModel model=(DefaultTableModel) table_1.getModel();
    	  	        int cols=rsmd.getColumnCount();
    	  	      
    	  	        String nr, activitate,tip_a,zi_a,ora;
    	  	        while (rez.next())
    	  	        {  nr=String.valueOf(i);
    	  	        	activitate=rez.getString(1);
    	  	        	 tip_a=rez.getString(2);
    	  	        	zi_a=rez.getString(3);
    	  	        	ora=rez.getString(4);
    	  	        	String[] row= {nr,activitate,tip_a,zi_a,ora};
    	  	        	
    	  	        	model.addRow(row);
    	  	        	j++;
    	  	        
    	  	        }
    	  	       
    	  			sta.close();
    	  			
    	  			connection.close();
    	  			
    	  	        
    	  				//callableStatement=connection.prepareCall(sql);
    	  			}
    	  			
    	  			catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
    	  	  	             " Details are provided below:");
    	  	  	          e2.printStackTrace(System.err);};
	}
}
