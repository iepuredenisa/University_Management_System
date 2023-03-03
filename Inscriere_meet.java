package jdbc;

import java.awt.EventQueue;
import java.util.Date;
import java.awt.EventQueue;
import java.time.LocalTime;

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
import java.time.LocalTime;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inscriere_meet implements ActionListener {

	private JFrame frame;
	private JTextField Ora;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField denum;
	String id_stud=null;
	JComboBox comboBox ,comboBox_1;
	String nume_prof,prenume_prof;
	JComboBox denumire ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Inscriere_meet(null,null,null);
	}

	/**
	 * Create the application.
	 */
	
	
	public void fillComboBoxpdenumiri(String materie)
	 {
 	

	    	WConnection cc = new WConnection();
		      try {
	ResultSet rs = cc.s.executeQuery("select meet_grup.scriere from meet_grup inner join grup_studiu on meet_grup.id_grup=grup_studiu.id_grup inner join materie on materie.id_materie=grup_studiu.id_materie and materie.descriere='"+materie+"' group by scriere");
	
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next())
				{
					denumire.addItem(rs.getString("scriere"));
					
					
					//cursuri.addItem(rs.getString("activitate_predata"));
				}
				
			
				
				
	  			
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		      
		     
		      
		
	 }
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
    
	public Inscriere_meet(String nume,String prenume,String CNP) {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 729);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(10, 10, 434, 672);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel labmat = new JLabel("Materia");
		labmat.setFont(new Font("Arial", Font.BOLD, 15));
		labmat.setBounds(100, 100, 100, 40);
		panel.add(labmat);
		
		comboBox = new JComboBox();
		comboBox.setBounds(200, 100, 100, 40);
		panel.add(comboBox);
		
		JLabel labprof = new JLabel("Profesor");
		labprof.setFont(new Font("Arial", Font.BOLD, 15));
		labprof.setBounds(100, 150, 90, 24);
		panel.add(labprof);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(200, 150, 100, 40);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Descriere");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(100, 200, 90, 24);
		panel.add(lblNewLabel_4);
		
		 denumire = new JComboBox();
		denumire.setBounds(200, 200, 100, 40);
		panel.add(denumire);
		
		
		JLabel Ad_meet = new JLabel("INSCRIERE MEET");
		Ad_meet.setForeground(new Color(255, 255, 255));
		Ad_meet.setFont(new Font("Arial", Font.BOLD, 15));
		Ad_meet.setHorizontalAlignment(SwingConstants.CENTER);
		Ad_meet.setBounds(98, 10, 194, 62);
		panel.add(Ad_meet);
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Inscriere");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				  
				  
				  
				 String materiee=comboBox.getSelectedItem().toString();
				String descrieree=denumire.getSelectedItem().toString();
	  			String nume_proff = comboBox_1.getSelectedItem().toString();
			     LocalTime time;
			     
			     java.sql.Time data_ex= new java.sql.Time(new Date().getTime());
			     // java.sql.Date sqlDate = new java.sql.Date(dtToday.getTime());
	  	
	  		   //  data_col=convertDate(data_col);
	  		    // data_res_col=convertDate(data_res_col);
	  		     

		    		try {
		      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
		      			
		      			java.sql.CallableStatement callableStatement=null;
		      			ResultSet resultSet=null;
		      			
		      			String sql="{call inscriere_meet(?,?,?,?,?,?)}";
		      		
		      			
		      			callableStatement=connection.prepareCall(sql);
		      			
		      			callableStatement.setString(1,nume);
		      			callableStatement.setString(2,prenume);
		      			callableStatement.setString(3,CNP);
		      			callableStatement.setString(4,materiee);
		      			callableStatement.setString(5,descrieree);
		      			callableStatement.setString(6,nume_proff);
		      			
		      			callableStatement.execute();
		      			connection.close();
		      			
		      			JOptionPane.showMessageDialog(null,"Successfully");
		                  frame.setVisible(false);
		      			
		      			
		      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
		      	             " Details are provided below:");
		      	          e2.printStackTrace(System.err);};
		      	          
		      	          
		      	          
		      	        try {
			      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
			      			
			      			java.sql.CallableStatement callableStatement=null;
			      			ResultSet resultSet=null;
			      			
			      			String sql="{call validare_meet20(?,?,?,?,?,?,?)}";
			      		
			      			
			      			callableStatement=connection.prepareCall(sql);
			      			
			      			callableStatement.setString(1,nume);
			      			callableStatement.setString(2,prenume);
			      			callableStatement.setString(3,CNP);
			      			callableStatement.setString(4,materiee);
			      			callableStatement.setString(5,descrieree);
			      			callableStatement.setString(6,nume_proff);
			      			callableStatement.setTime(7,data_ex);
			      			System.out.println(data_ex);
			      			
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
  			denumire.removeAllItems();
  			 fillComboBoxprofesori(comboBox.getSelectedItem().toString());
  			
  			
  		}
      	  
        });
		
		comboBox_1.addActionListener(new ActionListener()
        {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			denumire.removeAllItems();
  			 fillComboBoxpdenumiri(comboBox.getSelectedItem().toString());
  			
  			
  		}
      	  
        });
		
		
		frame.setVisible(true);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		

