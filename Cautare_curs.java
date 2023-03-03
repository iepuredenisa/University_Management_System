package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Cautare_curs implements ActionListener {

	
	
	JFrame frame;
	
	ImageIcon backgr;
	JLabel myLabel, lab,label,l1,l2,l3;
	JButton superad, ad, prof, stud, button, buttonBack, buttonS;
	JTextField te,t2,t3;
	JTable t1;
	JLabel tabelDate;
	String x[] = {"nume", "prenume"};
    String y[][] = new String[20][13];
    int i=0, j=0;
	
	Cautare_curs()
	{
		backgr= new ImageIcon(this.getClass().getResource("/ji.jpg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(600,300);
		
		frame= new JFrame("Cauta curs");
		frame.add(myLabel);
		frame.setSize(600,300);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	   buttonBack = new JButton("Back");
       buttonBack.setBounds(500, 200, 70, 20);
       buttonBack.setFocusable(false);
       buttonBack.setBackground(Color.BLACK);
    	buttonBack.setForeground(Color.WHITE);
       myLabel.add(buttonBack);
       
       buttonBack.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			new Ad_SAd(null,null,null,null,null);
 			
 		}
     	  
       });
       
       l1 = new JLabel("Adaugati numele cursului:");
       l1.setBounds(160,100,400,30);
       l1.setFont(new Font("serif",Font.BOLD,20));
       l1.setForeground(Color.BLACK);
       myLabel.add(l1);
       
       te=new JTextField();
       te.setBounds(180,130,200,30);
       myLabel.add(te);
       buttonS = new JButton("Search");
       buttonS.setBounds(230, 200, 100, 20);
       buttonS.setFocusable(false);
       buttonS.setBackground(Color.BLACK);
    	buttonS.setForeground(Color.WHITE);
       myLabel.add(buttonS);
       
       //String a=te.getText();
            
       buttonS.addActionListener(new ActionListener()
       {
    	  
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			      new Tabel_prof_curs(te.getText());
 		         }
 
       });
	}
       
       
		           
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  new Cautare_curs();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
	}
	

}
