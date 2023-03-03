package jdbc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Table_stud implements ActionListener{

	
	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	String id_prof=null;
	String id_materie=null;

	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTable getTable_1() {
		return table_1;
	}
	public void setTable_1(JTable table_1) {
		this.table_1 = table_1;
	}
	public JTable getTable_2() {
		return table_2;
	}
	public void setTable_2(JTable table_2) {
		this.table_2 = table_2;
	}
/*	public String getId_prof() {
		return id_prof;
	}
	public void setId_prof(String id_prof) {
		this.id_prof = id_prof;
	}
	public String getId_materie() {
		return id_materie;
	}
	public void setId_materie(String id_materie) {
		this.id_materie = id_materie;
	}*/
	/**
	 * Launch the application.
	 */
	
	 public void fillComboBox(String nume, String prenume,String descriere)
	 {
    	
		 WConnection cc = new WConnection();
		 try {
		 		ResultSet rs = cc.s.executeQuery("select profesor.id_profesor from profesor where profesor.nume='"+nume+"' and profesor.prenume='"+prenume+"'");
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next())
				{
					id_prof=rs.getString("id_profesor");
					
					//cursuri.addItem(rs.getString("activitate_predata"));
				}
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		     // al 2-lea id de la materie
		      try {
		  		ResultSet rsss = cc.s.executeQuery("select materie.id_materie from materie where materie.descriere='"+ descriere+ "'");
		  					ResultSetMetaData rsmd = rsss.getMetaData();
		  					while(rsss.next())
		  					{
		  						id_materie=rsss.getString("id_materie");
		  						
		  						//cursuri.addItem(rs.getString("activitate_predata"));
		  					}
		  					
		  				} catch (SQLException e1) {
		  					
		  					e1.printStackTrace();
		  				}
	     // al 2-lea id de la materie
	      try {
	  		ResultSet rs = cc.s.executeQuery("select materie.id_materie from materie where materie.descriere='"+ descriere+ "'");
	  					ResultSetMetaData rsmd = rs.getMetaData();
	  					while(rs.next())
	  					{
	  						id_materie=rs.getString("id_materie");
	  						
	  						//cursuri.addItem(rs.getString("activitate_predata"));
	  					}
	  					
	  				} catch (SQLException e1) {
	  					
	  					e1.printStackTrace();
	  				}
	      try {
		  		ResultSet rsss = cc.s.executeQuery("select student.nume, student.prenume, student.CNP  from student, inscriere  where student.id_student=inscriere.id_student and inscriere.id_materie= '"+ id_materie+"' and inscriere.id_profesor= '"+ id_prof+"' limit 1");
		  		//ResultSet rsss=cc.s.executeQuery("select * from materie");			
	    	  ResultSetMetaData rsmd = rsss.getMetaData();
		  					DefaultTableModel model=(DefaultTableModel) table_2.getModel();
		  					int cols=rsmd.getColumnCount();
		  					String[] colName=new String[cols];
		  					for (int i=0;i<cols;i++)
		  						colName[i]=rsmd.getColumnName(i+1);
		  					model.setColumnIdentifiers(colName);
		  					String  Nume,Prenume,CNP;
		  					while(rsss.next())
		  					{
		  						
		  						Nume=rsss.getString(1);
		  						Prenume=rsss.getString(2);
		  					//	CNP=rsss.getString(3);
		  						String[] row= {Nume, Prenume};
		  						model.addRow(row);
		  						System.out.println(Nume + " "+Prenume);
		  						
		  						
		  						//cursuri.addItem(rs.getString("activitate_predata"));
		  					}
		  					
		  					
		  				} catch (SQLException e1) {
		  					
		  					e1.printStackTrace();
		  				}
		    
	}
	  
		
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public Table_stud(String nume, String prenume,String descriere)
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		frame.setBounds(100, 100, 1080, 692);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Afișează studenți");
		btnNewButton.setForeground(new Color(50, 80, 120));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fillComboBox(nume,prenume,descriere);
				WConnection cc = new WConnection();
				try {
			  		ResultSet rsss = cc.s.executeQuery("select student.nume, student.prenume, student.CNP  from student, inscriere  where student.id_student=inscriere.id_student and inscriere.id_materie= '"+ id_materie+"' and inscriere.id_profesor= '"+ id_prof+"' limit 1");
			  					ResultSetMetaData rsmd = rsss.getMetaData();
			  					DefaultTableModel model=(DefaultTableModel) table_2.getModel();
			  					int cols=rsmd.getColumnCount();
			  					String[] colName=new String[cols];
			  					for (int i=0;i<cols;i++)
			  						colName[i]=rsmd.getColumnName(i+1);
			  					model.setColumnIdentifiers(colName);
			  					String nr_crt, Nume,Prenume,CNP;
			  					while(rsss.next())
			  					{
			  						nr_crt=rsss.getString(1);
			  						Nume=rsss.getString(2);
			  						Prenume=rsss.getString(3);
			  						CNP=rsss.getString(4);
			  						String[] row= {nr_crt, Nume, Prenume,CNP};
			  						model.addRow(row);
			  						
			  						
			  						//cursuri.addItem(rs.getString("activitate_predata"));
			  					}
			  					
			  					
			  				} catch (SQLException e1) {
			  					
			  					e1.printStackTrace();
			  				}
			
			
			}
		});
		btnNewButton.setBounds(85, 267, 152, 64);
		frame.getContentPane().add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(449, 106, 659, 426);
		frame.getContentPane().add(scrollPane);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nr. crt", "Nume", "Prenume", "CNP"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_2.getColumnModel().getColumn(0).setPreferredWidth(60);
		table_2.getColumnModel().getColumn(0).setMaxWidth(2147483642);
		scrollPane.setViewportView(table_2);
		fillComboBox(nume, prenume, descriere);
		System.out.println(id_prof);
		System.out.println(id_materie);
		
		
	}
	public static void main(String[] args) {
/*EventQueue.invokeLater(new Runnable() {
		public void run() {
				try {
			Table_stud window = new Table_stud(null, null,null);
				window.frame.setVisible(true);
				} catch (Exception e) {
				e.printStackTrace();
			}
			}
			
	});
	*/
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
