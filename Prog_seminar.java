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

public class Prog_seminar  {

	private JFrame frame;
	private JTextField ZiSeminar;
	private JTextField OraSeminar;
	
   //private Image calendar= new ImageIcon(Progr_laborator.class.getResource("images/calendar.png")).getImage();
	ImageIcon calendar;
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Progr_laborator window = new Progr_laborator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		new Prog_seminar(null, null,null);
	}
	private static java.sql.Date convertDate(java.util.Date date)
	{
		java.sql.Date myDate= new java.sql.Date(date.getTime());
		return myDate;
	}


	public Prog_seminar(String seminar,String NUME, String PRENUME) {
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
		
		ZiSeminar = new JTextField();
		ZiSeminar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (ZiSeminar.getText().equals("Zi seminar"))
				{
					ZiSeminar.setText("");
				}
				else 
				{
					ZiSeminar.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (ZiSeminar.getText().equals(""))
					ZiSeminar.setText("Zi seminar");
			}
		});
		ZiSeminar.setBorder(null);
		ZiSeminar.setFont(new Font("Arial", Font.BOLD, 12));
		ZiSeminar.setText("Zi seminar");
		ZiSeminar.setBounds(10, 10, 96, 19);
		panel.add(ZiSeminar);
		ZiSeminar.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(198, 198, 255, 37);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		OraSeminar = new JTextField();
		OraSeminar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (OraSeminar.getText().equals("Ora seminar"))
				{
					OraSeminar.setText("");
				}
				else 
				{
					OraSeminar.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (OraSeminar.getText().equals(""))
				{
					OraSeminar.setText("Ora seminar");
				}
			}
		});
		OraSeminar.setBorder(null);
		OraSeminar.setFont(new Font("Arial", Font.BOLD, 12));
		OraSeminar.setText("Ora seminar");
		OraSeminar.setBounds(10, 10, 96, 19);
		panel_1.add(OraSeminar);
		OraSeminar.setColumns(10);
		
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
  			
  			String ziua_c=ZiSeminar.getText();
		      String ora_c=OraSeminar.getText();
		     // java.sql.Date sqlDate = new java.sql.Date(dtToday.getTime());

  		   //  data_col=convertDate(data_col);
  		    // data_res_col=convertDate(data_res_col);
  		     

		      try {
	      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	      			
	      			java.sql.CallableStatement callableStatement=null;
	      			ResultSet resultSet=null;
	      			
	      			String sql="{call programaresem2(?,?,?,?,?)}";
	      		
	      		
	      			callableStatement=connection.prepareCall(sql);
	      			
	      			callableStatement.setString(1,NUME);
	      			callableStatement.setString(2,PRENUME);
	      			callableStatement.setString(3,seminar);
	      			callableStatement.setString(4,ziua_c);
	      			callableStatement.setString(5,ora_c);
	      		
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
		panel_2.setBounds(210, 283, 229, 50);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Programează");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 15, 123, 25);
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
		frame.setVisible(true);
		
	}
}
