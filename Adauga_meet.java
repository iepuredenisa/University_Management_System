package jdbc;

import java.awt.EventQueue;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.mysql.cj.jdbc.CallableStatement;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Adauga_meet {

	private JFrame frame;
	private JTextField Ora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField denum;
	String id_stud=null;
	JComboBox comboBox ,comboBox_1;
	String nume_prof,prenume_prof;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Adauga_meet(null,null,null);
	}

	/**
	 * Create the application.
	 */
	
	
	public void fillComboBoxprofesori(String materie)
	 {
  	

	    	WConnection cc = new WConnection();
		      try {
	ResultSet rs = cc.s.executeQuery("select  profesor.nume from profesor inner join informatii_profesor on profesor.id_profesor=informatii_profesor.id_profesor and informatii_profesor.activitate_predata='"+materie+"' group by nume");
	
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next())
				{
					comboBox_1.addItem(rs.getString("nume"));
					
					
					//cursuri.addItem(rs.getString("activitate_predata"));
				}
				
			
				
				if(comboBox_1.getSelectedItem()==null)
	  			{
	  				JOptionPane.showMessageDialog(null,"Nu exista profesori la aceasta materie ");
	  				frame.setVisible(false);
	  			}
	  			
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		      
		     
		      
		
	 }
	 public void fillComboBoxgrupuri(String nume,String prenume,String CNP)
	 {
   	

	    	WConnection cc = new WConnection();
		      try {
	ResultSet rs = cc.s.executeQuery("select student.id_student from student where student.nume='"+nume+"' and student.prenume='"+prenume+"' and student.CNP='"+CNP+"'");
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next())
				{
					id_stud=rs.getString("id_student");
					
					//cursuri.addItem(rs.getString("activitate_predata"));
				}
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		      
		      try {
		    	  ///daca e null mesaj//////////////////////////////
		    	  ResultSet rss = cc.s.executeQuery("select materie.descriere from materie inner join  grup_studiu on materie.id_materie=grup_studiu.id_materie inner join activitate_suplimentara on grup_studiu.id_grup=activitate_suplimentara.id_grup and activitate_suplimentara.id_student='"+id_stud+"'");
		    	  			ResultSetMetaData rsmd = rss.getMetaData();
		    	  			
		    	  			while(rss.next())
		    	  			{
		    	  				
		    	  				comboBox.addItem(rss.getString("descriere"));
		    	  			}
		    	  			if(comboBox.getSelectedItem()==null)
		    	  			{
		    	  				JOptionPane.showMessageDialog(null,"Nu sunteti inscris la niciun curs");
		    	  				frame.setVisible(false);
		    	  			}
		    	  			
		    	  		
		    	  		} catch (SQLException e1) {
		    	  			
		    	  			e1.printStackTrace();
		    	  		}
		      
		
	 }
    
	public Adauga_meet(String nume,String prenume,String CNP) {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(10, 10, 434, 672);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(206, 88, 136, 35);
		panel.add(dateChooser);
		
		Ora = new JTextField();
		Ora.setBounds(206, 133, 136, 35);
		panel.add(Ora);
		Ora.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(206, 192, 136, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(206, 249, 136, 34);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(53, 366, 102, 35);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(206, 366, 142, 35);
		panel.add(comboBox_1);
		
		denum = new JTextField();
		denum.setBounds(206, 306, 136, 35);
		panel.add(denum);
		denum.setColumns(10);
		
		JLabel Ad_meet = new JLabel("ADAUGA MEET");
		Ad_meet.setForeground(new Color(255, 255, 255));
		Ad_meet.setFont(new Font("Arial", Font.BOLD, 15));
		Ad_meet.setHorizontalAlignment(SwingConstants.CENTER);
		Ad_meet.setBounds(98, 10, 194, 62);
		panel.add(Ad_meet);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("Data");
		lblNewLabel.setBounds(72, 88, 83, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ora");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(82, 137, 68, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nr. participanti");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(42, 194, 125, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Timp expirare");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(58, 251, 112, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Descriere");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(65, 310, 90, 24);
		panel.add(lblNewLabel_4);
		
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				  java.sql.Date data_ex =new java.sql.Date(dateChooser.getDate().getTime());
				  
				  String ora=Ora.getText();
				  String nr_min=textField.getText();
				  String timp_exp=textField_1.getText();
				 String materiee=comboBox.getSelectedItem().toString();
				 String descrieree=denum.getText();
	  			String nume_proff = comboBox_1.getSelectedItem().toString();
			     
			     // java.sql.Date sqlDate = new java.sql.Date(dtToday.getTime());
	  	
	  		   //  data_col=convertDate(data_col);
	  		    // data_res_col=convertDate(data_res_col);
	  		     

		    		try {
		      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
		      			
		      			java.sql.CallableStatement callableStatement=null;
		      			ResultSet resultSet=null;
		      			
		      			String sql="{call creare_meet(?,?,?,?,?,?,?)}";
		      		
		      			
		      			callableStatement=connection.prepareCall(sql);
		      			
		      			callableStatement.setDate(1,data_ex);
		      			callableStatement.setString(2,ora);
		      			callableStatement.setString(3,nr_min);
		      			callableStatement.setString(4,timp_exp);
		      			callableStatement.setString(5,descrieree);
		      			callableStatement.setString(6,materiee);
		      			callableStatement.setString(7,nume_proff);
		      			
		      			callableStatement.execute();
		      			connection.close();
		      			
		      			JOptionPane.showMessageDialog(null,"Successfully");
		                  frame.setVisible(false);
		      			
		      			
		      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		      	             " Details are provided below:");
		      	          e2.printStackTrace(System.err);};
	  		      }
	  			

				
			
			
		});
			
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 64, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(121, 490, 148, 56);
		panel.add(btnNewButton);
		fillComboBoxgrupuri(nume,prenume,CNP);
		comboBox.addActionListener(new ActionListener()
        {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			comboBox_1.removeAllItems();
  			 fillComboBoxprofesori(comboBox.getSelectedItem().toString());
  			
  			
  		}
      	  
        });
		frame.setVisible(true);
		}
}
		

