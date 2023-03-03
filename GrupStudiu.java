package jdbc;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;
import java.awt.Toolkit;

public class GrupStudiu implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	JButton adds,cancels;
	JComboBox an,ora;
	
	 Random ran = new Random();
	    long first4 = (ran.nextLong() % 9000L) + 1000L;
	    long first = Math.abs(first4);
	    
	public GrupStudiu()
	{
		
		f = new JFrame("Grup de studiu");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(900, 700);
        
        l12=new JLabel();
        l12.setBounds(0,0,900,700);
        l12.setLayout(null);
        f.add(l12);
        
        l1 = new JLabel("Detalii grup");
        l1.setBounds(320,40,800,100);
        l1.setFont(new Font("serif",Font.ITALIC,30));
        l1.setForeground(Color.BLUE);
        l12.add(l1);
        
       Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	   f.setIconImage(icon);
 	   
 	   l2 = new JLabel("Nr. part");
       l2.setBounds(100,150,100,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l2);
       
       t1=new JTextField();
       t1.setBounds(250,150,150,30);
       l12.add(t1);
       
       l3 = new JLabel("Max. part");
       l3.setBounds(100,200,100,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       l12.add(l3);
       
       t2=new JTextField();
       t2.setBounds(250,200,150,30);
       l12.add(t2);
       
       
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
	      
	      String n=null;
	      if(e.getSource() == adds){
	            try{
	                WConnection cc = new WConnection();
	                String q = "insert into grup_studiu(nr_participanti, nr_max_participanti) values ('"+a+"','"+b+"')";
	                cc.s.executeUpdate(q);
	               
	                JOptionPane.showMessageDialog(null,"Study Group Details Inserted Successfully");
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
        new GrupStudiu().f.setVisible(true);
    }
	

}