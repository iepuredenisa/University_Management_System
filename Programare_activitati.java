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
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Programare_activitati implements ActionListener{
    
	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune;
	JButton superad, ad, prof, stud, button,buttonBack,addadm,addprof,addstud,detaliiadm,stergprof,stergstud,actprof,actstud,stergadm,actadm,cauta_nume,cauta_curs,
	asign_prof;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l13, l14,l16, l17,m3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,  t11, t12,maxstud;
    private ButtonGroup checkboxes;
	JButton adds,cancels,buttonprog;
	JComboBox activitate, ora1, ora2,dep,tip;
	
	public Programare_activitati(String nume_curs, String nume_prof,String prenume_prof, String tip) {
		backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("Prof");
		frame.add(myLabel);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	   operatiune = new JLabel("Programeaza");
       operatiune.setBounds(50, 50, 200, 30);
       operatiune.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(operatiune);
       
 	
 	   l2 = new JLabel("Data inceput semestru:");
       l2.setBounds(100,150,200,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l2);
       
       
       t1=new JTextField();
       t1.setBounds(320,150,150,30);
       myLabel.add(t1);
       
       t1.setText("2022-10-03");
       
       l3 = new JLabel("Nr. ore");
       l3.setBounds(100,200,100,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l3);
       
       t2=new JTextField();
       t2.setBounds(320,200,150,30);
       myLabel.add(t2);
       
       l16 = new JLabel("Data sfarsit semestru:");
       l16.setBounds(100,250,200,30);
       l16.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l16);
       
       t3=new JTextField();
       t3.setBounds(320,250,150,30);
       myLabel.add(t3);
       t3.setText("2023-03-03");
       
       buttonBack = new JButton("Back");
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
       
       buttonprog = new JButton("Programeaza");
       buttonprog.setBounds(100, 600, 200, 40);
       buttonprog.setFocusable(false);
       buttonprog.setBackground(Color.BLACK);
    	buttonprog.setForeground(Color.WHITE);
       myLabel.add(buttonprog);
       
       buttonprog.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			String data_inceput=t1.getText();
 		      String nr_ore=t2.getText();
 		     String data_final=t2.getText();
 		     
 		    		try {
 		      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
 		      			
 		      			CallableStatement callableStatement=null;
 		      			ResultSet resultSet=null;
 		      			
 		      			String sql="{call programareactivitati28(?,?,?,?,?)}";
 		      		
 		      			
 		      			callableStatement=connection.prepareCall(sql);
 		      			
 		      			callableStatement.setString(1,nume_curs);
 		      			callableStatement.setString(2,nume_prof);
 		      			callableStatement.setString(3,prenume_prof);
 		      			callableStatement.setString(4,tip);
 		      			callableStatement.setString(5,nr_ore);
 		      			
 		      			
 		      			callableStatement.execute();
 		      			connection.close();
 		      			if(doQuery(nume_prof,prenume_prof)==1)
 		      			JOptionPane.showMessageDialog(null,"Successfully");
 		                  frame.setVisible(false);
 		      			
 		      			
 		      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
 		      	             " Details are provided below:");
 		      	          e2.printStackTrace(System.err);};
 		    		
 		      }
 			
 		
 			
 		
     	  
       });
       
       
      
       buttonprog.addActionListener(this);
      // cancels.addActionListener(this);
	}
	
	private int doQuery(String NUME,String PRENUME) {
        try {
        	 WConnection cc = new WConnection();
           // Statement s =  new createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
            ResultSet rs = cc.s.executeQuery("SELECT * FROM platforma_studiu.profesor WHERE nume = '" + NUME + "' AND prenume = '" + PRENUME + "';");
            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            if (rows == 0)
                return 0;

        } catch (SQLException e) {
            ///System.out.println(e.getMessage());
        }
        return 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new Programare_activitati(null,null,null,null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}