package jdbc;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;
import java.awt.Toolkit;
public class AddStudent implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JButton adds,cancels;
	JComboBox an,ora;
	
	 Random ran = new Random();
	    long first4 = (ran.nextLong() % 9000L) + 1000L;
	    long first = Math.abs(first4);
	public AddStudent()
	{
		
		f = new JFrame("Add Student");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(900, 700);
        l12=new JLabel();
        l12.setBounds(0,0,900,700);
        l12.setLayout(null);
        f.add(l12);
        l1 = new JLabel("Student Details");
        l1.setBounds(320,30,500,50);
        l1.setFont(new Font("serif",Font.ITALIC,25));
        l1.setForeground(Color.BLUE);
        l12.add(l1);
        Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    f.setIconImage(icon);
 	    
 	   l2 = new JLabel("Nume");
       l2.setBounds(50,150,100,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l2);
       
       t1=new JTextField();
       t1.setBounds(150,150,150,30);
       l12.add(t1);
       
       l3 = new JLabel("Prenume");
       l3.setBounds(50,200,100,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l3);
       
       t2=new JTextField();
       t2.setBounds(150,200,150,30);
       l12.add(t2);
       
       l4 = new JLabel("CNP");
       l4.setBounds(50,250,100,30);
       l4.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l4);
       
       t3=new JTextField();
       t3.setBounds(150,250,150,30);
       l12.add(t3);
       
       l5 = new JLabel("Adresa");
       l5.setBounds(50,300,100,30);
       l5.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l5);
       
       t4=new JTextField();
       t4.setBounds(150,300,150,30);
       l12.add(t4);
       
       l6 = new JLabel("Nr.telefon");
       l6.setBounds(50,350,100,30);
       l6.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l6);
       
       t5=new JTextField();
       t5.setBounds(150,350,150,30);
       l12.add(t5);
       
       l7 = new JLabel("Email");
       l7.setBounds(350,150,100,30);
       l7.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l7);
       
       t6=new JTextField();
       t6.setBounds(440,150,150,30);
       l12.add(t6);
       
       l8 = new JLabel("IBAN");
       l8.setBounds(350,200,100,30);
       l8.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l8);
       
       t7=new JTextField();
       t7.setBounds(440,200,150,30);
       l12.add(t7);
       
       l9 = new JLabel("Nr.contract");
       l9.setBounds(350,250,100,30);
       l9.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l9);
       
       t8=new JTextField();
       t8.setBounds(480,250,150,30);
       t8.setText("302"+first);
       l12.add(t8);
       
       l10 = new JLabel("An studiu");
       l10.setBounds(350,300,100,30);
       l10.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l10);
       
       String ani[] = {"I","II","III","IV"};
       an = new JComboBox(ani);
       an.setBackground(Color.WHITE);
       an.setBounds(460,300,150,30);
       l12.add(an);
       
      
       
       l11 = new JLabel("Nr.ore");
       l11.setBounds(350,350,100,30);
       l11.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l11);
       
       String ore[] = {"20","25","15","18"};
       ora = new JComboBox(ore);
       ora.setBackground(Color.WHITE);
       ora.setBounds(460,350,150,30);
       l12.add(ora);
       
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
	      String combo1=(String)an.getSelectedItem();
	      String combo2=(String)ora.getSelectedItem();
	      String n=null;
	      if(e.getSource() == adds){
	            try{
	                WConnection cc = new WConnection();
	                String q = "insert into student(CNP, nume, prenume, adresa, nr_telefon , email, IBAN, nr_contract, an_studiu, nr_ore) values('"+c+"','"+a+"','"+b+"','"+d+"','"+ee+"','"+ff+"','"+g+"','"+h+"','"+combo1+"','"+combo2+"')";
	                cc.s.executeUpdate(q);
	               
	                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
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
        new AddStudent().f.setVisible(true);
    }
	

}

