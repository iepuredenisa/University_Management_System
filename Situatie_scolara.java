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

public class Situatie_scolara {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	int i=1,j=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Situatie_scolara(null,null,null);
	}

	/**
	 * Create the application.
	 */
	public Situatie_scolara(String nume , String prenume , String CNP) {
		frame = new JFrame("SITUATIE "+ nume+" "+prenume);
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
		tabbedPane.addTab("Situatie scolara", null, panel, null);
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
				 "Materia", "Nota finala","Situatie finala"
			}
		));
		
		
		
		
		try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
		
		String query="call catalog_note('"+nume+"', '"+prenume+"', '"+CNP+"')";
		java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rez = sta.executeQuery(query);
        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
        
          
        
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        int cols=rsmd.getColumnCount();
      
        String materie, nota,sit;
        while (rez.next())
        {  
        	materie=rez.getString(1);
        	 nota=rez.getString(2);
        	sit=rez.getString(3);
        	
        	String[] row= {materie, nota,sit};
        
        	model.addRow(row);
        
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
