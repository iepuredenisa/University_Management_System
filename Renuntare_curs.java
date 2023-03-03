package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Renuntare_curs implements ActionListener {
	JFrame frame;
	JTable t1;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune,l1,l2,l3,l4,activitate,ora,zi;
	JButton superad, ad, prof, stud, button,buttonBack,detaliistud,inscriere_curs,buttonstergere,cancel;
    private ButtonGroup checkboxes;
    JComboBox curs,activitati,ore,zile;
    JTextField n,p,c;
	public Renuntare_curs(String nume,String prenume,String CNP)
	{
		backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("Renuntare curs "+nume+" "+prenume);
		frame.add(myLabel);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
       
       buttonBack = new JButton("Inapoi");
        buttonBack.setBounds(600, 600, 200, 40);
        buttonBack.setFocusable(false);
        buttonBack.setBackground(Color.BLACK);
     	buttonBack.setForeground(Color.WHITE);
        myLabel.add(buttonBack);
        
        buttonBack.addActionListener(new ActionListener()
        {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			frame.setVisible(false);
  			
  		}
      	  
        });
        
        
        l1 = new JLabel("Nume curs");
        l1.setBounds(100,100,150,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        myLabel.add(l1);
        
        String cursuri[] = {"OOP", "MES", "MSI","CAN","AF","BD","PC","SDA","ENG"};
        curs = new JComboBox(cursuri);
        curs.setBackground(Color.WHITE);
        curs.setBounds(200,100,150,30);
        myLabel.add(curs);
        
        buttonstergere = new JButton("Parasiti cursul");
        buttonstergere.setBounds(100, 600, 200, 40);
        buttonstergere.setFocusable(false);
        buttonstergere.setBackground(Color.BLACK);
     	buttonstergere.setForeground(Color.WHITE);
        myLabel.add(buttonstergere);
        
 
        
        
        buttonstergere.addActionListener(new ActionListener()
        {
     	  
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stub
  			try {
  	  			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
  	  			
  	  			java.sql.CallableStatement callableStatement=null;
  	  			ResultSet resultSet=null;
  	  			
  	  			String sql="{call renuntarecurs(?,?,?,?)}";
  	  		
  	  			
  	  			callableStatement=connection.prepareCall(sql);
  	  			
  	  			callableStatement.setString(1,curs.getSelectedItem().toString());
  	  			callableStatement.setString(2,nume);
  	  			callableStatement.setString(3,prenume);
  	  			callableStatement.setString(4,CNP);
  	  			
  	  			
  	  			callableStatement.execute();
  	  			connection.close();
  	  			
  	  			JOptionPane.showMessageDialog(null,"Successfully");
  	              frame.setVisible(false);
  	  			
  	  			
  	  		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
  	  	             " Details are provided below:");
  	  	          e2.printStackTrace(System.err);};
  		      }
  			
  			      
  		         
  
        });
        
        

        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Renuntare_curs(null,null,null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
