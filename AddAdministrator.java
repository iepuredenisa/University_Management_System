package jdbc;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;
import java.awt.Toolkit;

public class AddAdministrator implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JButton adds,cancels;
	JComboBox an,ora;
	
	 Random ran = new Random();
	    long first4 = (ran.nextLong() % 9000L) + 1000L;
	    long first = Math.abs(first4);
	public AddAdministrator()
	{
		
		f = new JFrame("Add Administrator");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(900, 700);
        
        l12=new JLabel();
        l12.setBounds(0,0,900,700);
        l12.setLayout(null);
        f.add(l12);
        
        l1 = new JLabel("Detalii administrator");
        l1.setBounds(320,40,800,100);
        l1.setFont(new Font("serif",Font.ITALIC,30));
        l1.setForeground(Color.BLUE);
        l12.add(l1);
        
       Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	   f.setIconImage(icon);
 	   
 	   l2 = new JLabel("Nume");
       l2.setBounds(100,150,100,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l2);
       
       t1=new JTextField();
       t1.setBounds(190,150,150,30);
       l12.add(t1);
       
       l3 = new JLabel("Prenume");
       l3.setBounds(100,200,100,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l3);
       
       t2=new JTextField();
       t2.setBounds(190,200,150,30);
       l12.add(t2);
       
       l4 = new JLabel("CNP");
       l4.setBounds(100,250,100,30);
       l4.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l4);
       
       t3=new JTextField();
       t3.setBounds(190,250,150,30);
       l12.add(t3);
       
       l5 = new JLabel("Adresa");
       l5.setBounds(100,300,100,30);
       l5.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l5);
       
       t4=new JTextField();
       t4.setBounds(190,300,150,30);
       l12.add(t4);
       
       l6 = new JLabel("Nr.telefon");
       l6.setBounds(450,150,100,30);
       l6.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l6);
       
       t5=new JTextField();
       t5.setBounds(580,150,150,30);
       l12.add(t5);
       
       l7 = new JLabel("Email");
       l7.setBounds(450,200,100,30);
       l7.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l7);
       
       t6=new JTextField();
       t6.setBounds(580,200,150,30);
       l12.add(t6);
       
       l8 = new JLabel("IBAN");
       l8.setBounds(450,250,100,30);
       l8.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l8);
       
       t7=new JTextField();
       t7.setBounds(580,250,150,30);
       l12.add(t7);
       
       l9 = new JLabel("Nr.contract");
       l9.setBounds(450,300,100,30);
       l9.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l9);
       
       t8=new JTextField();
       t8.setBounds(580,300,150,30);
       t8.setText("302"+first);
       l12.add(t8);
       
       
       adds = new JButton("Adauga");
       adds.setBackground(Color.BLACK);
       adds.setForeground(Color.WHITE);
       adds.setBounds(250,550,150,40);
       
       l12.add(adds);

       cancels=new JButton("Cancel");   
       cancels.setBackground(Color.BLACK);
       cancels.setForeground(Color.WHITE);
       cancels.setBounds(450,550,150,40);
       
       l12.add(cancels);
       
       adds.addActionListener(this);
       cancels.addActionListener(this);
       
       f.setVisible(true);
       f.setSize(900,700);
       f.setLocation(400,150);
       
       
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		 
	      String a=t1.getText();
	      String b=t2.getText();
	      String c=t3.getText();
	      String d=t4.getText();
	      String ee=t5.getText();
	      String ff=t6.getText();
	      String g=t7.getText();
	      String h=t8.getText();
	      
	      String n=null;
	      if(e.getSource() == adds){
	            try{
	                WConnection cc = new WConnection();
	                String q = "insert into administrator(CNP, nume, prenume, adresa, nr_telefon , email, IBAN, nr_contract) values ('"+c+"','"+a+"','"+b+"','"+d+"','"+ee+"','"+ff+"','"+g+"','"+h+"')";
	                cc.s.executeUpdate(q);
	               
	                JOptionPane.showMessageDialog(null,"Admin Details Inserted Successfully");
	                f.setVisible(false);
	            }catch(Exception eee){
	                System.out.println("The error is:"+eee);
	            }
	        }else if(e.getSource() == cancels){
	            f.setVisible(false);
	            //new Project().setVisible(true);
	            
	        }
	     /* WConnection cc = new WConnection();
	      try {
			ResultSet rs = cc.s.executeQuery("select * from student");
			while(rs.next())
			{
				System.out.println(rs.getString("prenume"));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}*/
	    }
	      
	public static void main(String[ ] arg){
        new AddAdministrator().f.setVisible(true);
    }
	

}