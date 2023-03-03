package jdbc;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;
import java.awt.Toolkit;

public class AddTeacher implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l13, l14;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,  t11;
	JButton adds,cancels;
	JComboBox activitate, ora1, ora2;
	
	 Random ran = new Random();
	    long first4 = (ran.nextLong() % 9000L) + 1000L;
	    long first = Math.abs(first4);
	public AddTeacher()
	{
		
		f = new JFrame("Add Teacher");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(900, 700);
        l12=new JLabel();
        l12.setBounds(0,0,900,700);
        l12.setLayout(null);
        f.add(l12);
        
        l1 = new JLabel("Detalii profesor");
        l1.setBounds(320,40,500,50);
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
       l6.setBounds(100,350,100,30);
       l6.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l6);
       
       t5=new JTextField();
       t5.setBounds(190,350,150,30);
       l12.add(t5);
       
       l7 = new JLabel("Email");
       l7.setBounds(100, 400, 100,30);
       l7.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l7);
       
       t6=new JTextField();
       t6.setBounds(190, 400, 150, 30);
       l12.add(t6);
       
       l8 = new JLabel("IBAN");
       l8.setBounds(450,150,100,30);
       l8.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l8);
       
       t7=new JTextField();
       t7.setBounds(580,150,150,30);
       l12.add(t7);
       
       l9 = new JLabel("Nr.contract");
       l9.setBounds(450,200,100,30);
       l9.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l9);
       
       t8=new JTextField();
       t8.setBounds(580,200,150,30);
       t8.setText("302"+first);
       l12.add(t8);
       
       
       l14 = new JLabel("Departament");
       l14.setBounds(450, 250, 150, 30);
       l14.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l14);
       
       t11=new JTextField();
       t11.setBounds(580,250,150,30);
       l12.add(t11);
       
       l10 = new JLabel("Activitate");
       l10.setBounds(450, 300, 150, 30);
       l10.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l10);
       
       String activitati[] = {"curs","laborator","seminar"};
       activitate = new JComboBox(activitati);
       activitate.setBackground(Color.WHITE);
       activitate.setBounds(580,300,150,30);
       l12.add(activitate);
       
      
       l11 = new JLabel("Minim ore");
       l11.setBounds(450,350,150,30);
       l11.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l11);
       
       String oreMin[] = {"2","6","10","12"};
       ora1 = new JComboBox(oreMin);
       ora1.setBackground(Color.WHITE);
       ora1.setBounds(580,350,150,30);
       l12.add(ora1);
       
       l13 = new JLabel("Maxim ore");
       l13.setBounds(450,400,150,30);
       l13.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l13);
       
       String oreMax[] = {"16","18","25","30"};
       ora2 = new JComboBox(oreMax);
       ora2.setBackground(Color.WHITE);
       ora2.setBounds(580,400,150,30);
       l12.add(ora2);
       
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
	      String h=t8.getText(); //nr contract
	      
	      String i= t11.getText(); //departament
	      
	      String combo1=(String)activitate.getSelectedItem();
	      String combo2=(String)ora1.getSelectedItem();
	      String combo3=(String)ora2.getSelectedItem();
	      String n=null;
	      
	      if(e.getSource() == adds){
	            try{
	                WConnection cc = new WConnection();
	                String q = "insert into profesor(CNP, nume, prenume, adresa, nr_telefon , email, IBAN, nr_contract) values('"+c+"','"+a+"','"+b+"','"+d+"','"+ee+"','"+ff+"','"+g+"','"+h+"')";
	                cc.s.executeUpdate(q);
	                
	                String infoProf = "insert into informatii_profesor(activitate_predata, min_ore_predare, max_ore_predare, departament) values('"+combo1+"', '"+combo2+"', '"+combo3+"', '"+i+"')";
	               cc.s.executeUpdate(infoProf);
	               
	                JOptionPane.showMessageDialog(null,"Teacher Details Inserted Successfully");
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
        new AddTeacher().f.setVisible(true);
    }
	

}