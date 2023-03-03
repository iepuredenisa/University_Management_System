package jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mmbrii_grup {

	private JFrame frame;

	private JTextField txtMembriiGrupului;
	
	private JTable table_1;
	private JTextField materia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	new Mmbrii_grup(null,null);
	}

	/**
	 * Create the application.
	 */
	public Mmbrii_grup(String n, String p) {
		frame = new JFrame("Membrii grupului");
		frame.setBounds(100, 100, 849, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(42, 31, 736, 640);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	    frame.setIconImage(icon);
	    
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(92, 83, 526, 530);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NO","NUME", "PRENUME"
			}
		));
		
		materia = new JTextField();
		materia.setBounds(424, 42, 96, 19);
		panel_1.add(materia);
		materia.setColumns(10);
		
		JLabel Vizualiz = new JLabel("MEMBRII GRUPULUI");
		Vizualiz.setFont(new Font("Tahoma", Font.BOLD, 12));
		Vizualiz.setHorizontalAlignment(SwingConstants.CENTER);
		Vizualiz.setBounds(119, 27, 295, 46);
		panel_1.add(Vizualiz);
		
		JButton vezi = new JButton("Afisare");
		vezi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int t=table_1.getRowCount();
				
				  DefaultTableModel model_1=(DefaultTableModel) table_1.getModel();
				  for (int j=0;j<t;j++)
				  {
					  model_1.removeRow(0);
				  }
               int i=1;				
				try{Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
				
				String query="call viuzalizare_membrii_grup('"+materia.getText()+"')";
				java.sql.Statement sta = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		        ResultSet rez = sta.executeQuery(query);
		        java.sql.ResultSetMetaData rsmd=rez.getMetaData();
		        
		      
			
		        
		        
		        DefaultTableModel model=(DefaultTableModel) table_1.getModel();
		        int cols=rsmd.getColumnCount();
		        String no,nume,prenume;
		        while (rez.next())
		        {  no=String.valueOf(i);
		        	nume=rez.getString(1);
		        	prenume=rez.getString(2);
		        	
		        	String[] row= {no,nume,prenume};
		        	model.addRow(row);
		        	i++;
		        
		        }
		       
				sta.close();
				
				connection.close();
				
		        
					//callableStatement=connection.prepareCall(sql);
				}
				
				catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		  	             " Details are provided below:");
		  	          e2.printStackTrace(System.err);};
			
				//int index=table_1.getSelectedRow();
				/*TableModel model_2=table_1.getModel();
				String nume_s=model_2.getValueAt(index, 1).toString();
				String prenume_s=model_2.getValueAt(index, 2).toString();
				System.out.println(nume_s+" "+prenume_s);
				
				new Trimite_mesaj(nume_s,prenume_s);
			 */
				//System.out.println(index);
					
			}
			
			
		});
		
		table_1.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseClicked(java.awt.event.MouseEvent evt) {
	            JTableMouseClicked(evt,n,p);
	        }
	    } );
		vezi.setBounds(533, 41, 85, 21);
		panel_1.add(vezi);
		
		

		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(88, 22, 43));
	
		panel.setLayout(null);
	
		
		
		frame.setVisible(true);
	}
	
	   private void JTableMouseClicked(java.awt.event.MouseEvent evt,String n, String p)
	    {
	    	int index=table_1.getSelectedRow();
	    	TableModel model=table_1.getModel();
	    
	    	String value2= model.getValueAt(index,1).toString();
	    	String value3 =model.getValueAt(index,2).toString();
	    	
	    	
	    	new Trimite_mesaj(value2, value3,n,p);
	    	
	    
	    }
}
