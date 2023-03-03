package jdbc;
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

public class Progr_curs  {

	private JFrame frame;
	private JTextField ZiCurs;
	private JTextField OraCurs;
	private JTextField DataExamen;
	private JTextField DataRestanta;
	
   //private Image calendar= new ImageIcon(Progr_laborator.class.getResource("images/calendar.png")).getImage();
	ImageIcon calendar;
	private JTextField DataPartial;
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Progr_laborator window = new Progr_laborator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		new Progr_curs(null, null,null);
	}
	private static java.sql.Date convertDate(java.util.Date date)
	{
		java.sql.Date myDate= new java.sql.Date(date.getTime());
		return myDate;
	}


	public Progr_curs(String curs,String NUME, String PRENUME) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(36, 91, 87));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(198, 136, 255, 37);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		  Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	 	    frame.setIconImage(icon);
		
		ZiCurs = new JTextField();
		ZiCurs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (ZiCurs.getText().equals("Zi curs"))
				{
					ZiCurs.setText("");
				}
				else 
				{
					ZiCurs.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (ZiCurs.getText().equals(""))
					ZiCurs.setText("Zi curs");
			}
		});
		ZiCurs.setBorder(null);
		ZiCurs.setFont(new Font("Arial", Font.BOLD, 12));
		ZiCurs.setText("Zi curs");
		ZiCurs.setBounds(10, 10, 96, 19);
		panel.add(ZiCurs);
		ZiCurs.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(198, 198, 255, 37);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		OraCurs = new JTextField();
		OraCurs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (OraCurs.getText().equals("Ora curs"))
				{
					OraCurs.setText("");
				}
				else 
				{
					OraCurs.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (OraCurs.getText().equals(""))
				{
					OraCurs.setText("Ora curs");
				}
			}
		});
		OraCurs.setBorder(null);
		OraCurs.setFont(new Font("Arial", Font.BOLD, 12));
		OraCurs.setText("Ora curs");
		OraCurs.setBounds(10, 10, 96, 19);
		panel_1.add(OraCurs);
		OraCurs.setColumns(10);
		
		DataExamen = new JTextField();
		DataExamen.setHorizontalAlignment(SwingConstants.CENTER);
		DataExamen.setBorder(null);
		DataExamen.setBackground(new Color(64, 128, 128));
		DataExamen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DataExamen.setText("Data Examen");
		DataExamen.setBounds(197, 257, 89, 30);
		frame.getContentPane().add(DataExamen);
		DataExamen.setColumns(15);
		
		DataRestanta = new JTextField();
		DataRestanta.setHorizontalAlignment(SwingConstants.CENTER);
		DataRestanta.setBorder(null);
		DataRestanta.setToolTipText("");
		DataRestanta.setText("Data restanta");
		DataRestanta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DataRestanta.setColumns(15);
		DataRestanta.setBackground(new Color(64, 128, 128));
		DataRestanta.setBounds(198, 312, 141, 30);
		frame.getContentPane().add(DataRestanta);
		
		JDateChooser Res_colocviu = new JDateChooser();
		Res_colocviu.setBounds(349, 312, 104, 29);
		frame.getContentPane().add(Res_colocviu);
		
		JDateChooser Colocviu = new JDateChooser();
		Colocviu.setBounds(313, 257, 141, 30);
		frame.getContentPane().add(Colocviu);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(103, 182, 168));
				
			}
		});
		
		
		panel_2.addMouseListener(new MouseAdapter()
        {

  		@Override
  		public void mouseClicked(MouseEvent e) {
  			
  			String ziua_c=ZiCurs.getText();
		      String ora_c=OraCurs.getText();
		     // java.sql.Date sqlDate = new java.sql.Date(dtToday.getTime());
  	   java.sql.Date data_ex= new java.sql.Date(Colocviu.getDate().getTime());
  		     java.sql.Date data_res= new java.sql.Date(Res_colocviu.getDate().getTime());
  		   java.sql.Date data_p= new java.sql.Date(Res_colocviu.getDate().getTime());
  		   //  data_col=convertDate(data_col);
  		    // data_res_col=convertDate(data_res_col);
  		     

	    		try {
	      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	      			
	      			java.sql.CallableStatement callableStatement=null;
	      			ResultSet resultSet=null;
	      			
	      			String sql="{call programarecurs4(?,?,?,?,?,?,?,?)}";
	      		
	      			
	      			callableStatement=connection.prepareCall(sql);
	      			
	      			callableStatement.setString(1,NUME);
	      			callableStatement.setString(2,PRENUME);
	      			callableStatement.setString(3,curs);
	      			callableStatement.setString(4,ziua_c);
	      			callableStatement.setString(5,ora_c);
	      			callableStatement.setDate(6,data_ex);
     			callableStatement.setDate(7,data_p);
     			callableStatement.setDate(8,data_res);
	      			
	      			callableStatement.execute();
	      			connection.close();
	      			
	      			JOptionPane.showMessageDialog(null,"Successfully");
	                  frame.setVisible(false);
	      			
	      			
	      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	      	             " Details are provided below:");
	      	          e2.printStackTrace(System.err);};
  		      }
  			
  		
  			
  		
      	  
        });
        
     //   panel_2.addActionListener(this);
        
		panel_2.setBackground(new Color(103, 182, 168));
		panel_2.setBounds(213, 394, 229, 50);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Programează");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(62, 15, 123, 25);
		panel_2.add(lblNewLabel);
		
		JLabel IconLogo = new JLabel("");
		IconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		IconLogo.setBounds(198, 10, 255, 97);
		frame.getContentPane().add(IconLogo);
		frame.setBackground(new Color(64, 128, 128));
		frame.setBounds(new Rectangle(5, 5, 2, 3));
		frame.setBounds(100, 100, 680, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		calendar= new ImageIcon(this.getClass().getResource("/calendar.png"));
		IconLogo.setIcon(calendar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(349, 354, 104, 30);
		frame.getContentPane().add(dateChooser);
		
		DataPartial = new JTextField();
		DataPartial.setHorizontalAlignment(SwingConstants.CENTER);
		DataPartial.setBorder(null);
		DataPartial.setToolTipText("");
		DataPartial.setText("Data partial");
		DataPartial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		DataPartial.setColumns(15);
		DataPartial.setBackground(new Color(64, 128, 128));
		DataPartial.setBounds(198, 354, 141, 30);
		frame.getContentPane().add(DataPartial);
		frame.setVisible(true);
		
	}
}
