package jdbc;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JTextField;
import java.awt.Font;

public class Trimite_mesaj {

	private JFrame frame;
	ImageIcon calendar;
	private JTextField txtScrietiMesajulAici;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Trimite_mesaj(null,null,null,null);
	}

	/**
	 * Create the application.
	 */
	public Trimite_mesaj(String nume_d, String prenume_d,String nume_t, String prenume_t) {
		frame = new JFrame("Mesaj catre ");
		frame.setBounds(100, 100, 642, 696);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	    frame.setIconImage(icon);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 659);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(309, 54, 10, -39);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 578, 628, 71);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel IconLogo = new JLabel("");
		IconLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String txt=txtScrietiMesajulAici.getText();
				try {
	  	  			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	  	  			
	  	  			java.sql.CallableStatement callableStatement=null;
	  	  			ResultSet resultSet=null;
	  	  			
	  	  			String sql="{call mesaj(?,?,?,?,?)}";
	  	  		
	  	  			
	  	  			callableStatement=connection.prepareCall(sql);
	  	  			
	  	  			callableStatement.setString(1,nume_d);
	  	  			callableStatement.setString(2,prenume_d);
	  	  		callableStatement.setString(3,txt);
	  	  	callableStatement.setString(4,nume_t);
  	  		callableStatement.setString(5,prenume_t);
  	  			
	  	  			
	  	  			
	  	  			callableStatement.execute();
	  	  			connection.close();
	  	  			
	  	  			JOptionPane.showMessageDialog(null,"Mesaj trimis");
	  	              frame.setVisible(false);
	  	  			
	  	  			
	  	  		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	  	  	             " Details are provided below:");
	  	  	          e2.printStackTrace(System.err);};
	  		      }
			
		});
		IconLogo.setBounds(552, 0, 66, 61);
		panel_2.add(IconLogo);
		
		calendar= new ImageIcon(this.getClass().getResource("/send-message.png"));
		IconLogo.setIcon(calendar);
		
		txtScrietiMesajulAici = new JTextField();
		txtScrietiMesajulAici.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtScrietiMesajulAici.setText("Scrieti mesajul aici");
		txtScrietiMesajulAici.setBounds(10, 10, 508, 51);
		panel_2.add(txtScrietiMesajulAici);
		txtScrietiMesajulAici.setColumns(10);
		
		
		txtScrietiMesajulAici.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtScrietiMesajulAici.getText().equals("Scrieti mesajul aici"))
				{
					txtScrietiMesajulAici.setText("");
				}
				else 
				{
					txtScrietiMesajulAici.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtScrietiMesajulAici.getText().equals(""))
					txtScrietiMesajulAici.setText("Scrieti mesajul aici");
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 255));
		panel_3.setBounds(0, 0, 628, 64);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel Numele = new JLabel(nume_d +" "+prenume_d);
		Numele.setBounds(10, 10, 188, 44);
		panel_3.add(Numele);
		frame.setVisible(true);
	}
	



		
}
