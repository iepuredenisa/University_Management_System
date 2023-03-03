package jdbc;

import java.awt.Component;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Mesaje_grup {
	ImageIcon backgr;
	JButton buttonBack,afisstud;
	JFrame frame;
	JTable t1;
	String id_stud_sender=null;
	String id_stud_primitor=null;
	JLabel Mesaj,myLabel;
	public void fillLabel(String NUME,String PRENUME)
	 {
   	
   	WConnection cc = new WConnection();
	      try {
	    	  System.out.println(NUME);
ResultSet rs = cc.s.executeQuery("select student.id_student from student where student.nume='"+NUME+"' and student.prenume='"+PRENUME+"'");
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				id_stud_primitor=rs.getString("id_student");
				
				//cursuri.addItem(rs.getString("activitate_predata"));
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	      
	      try {
	    	  ///daca e null mesaj//////////////////////////////
	    	  ResultSet rss = cc.s.executeQuery("select mesaje_grup.nume_t,mesaje_grup.prenume_t,mesaje_grup.text from mesaje_grup where mesaje_grup.id_student='"+id_stud_primitor+"'");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			String txt="<html>";
	    	  			while(rss.next())
	    	  			{
	    	  				//Mesaj.add()
	    	  				txt+=(rss.getString("nume_t")+"     "+rss.getString("prenume_t")+"       ti-a trimis un mesaj: "+rss.getString("text"));
	    	  				txt+="<br><html>";	
	    	  			}
	    	  			//txt="</html>";
	    	  			Mesaj.setText(txt);
	    	  		
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	public Mesaje_grup(String nume,String prenume)
	{

		 backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			 myLabel = new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Student "+nume);
			frame.add(myLabel);
			frame.setSize(900,700);
			frame.setLayout(null);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		    frame.setLocationRelativeTo(null);
		    
		    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	 	    frame.setIconImage(icon);
	 	    
 	   Mesaj = new JLabel();
 	  
		Mesaj.setBounds(100, 30, 400, 100);
		myLabel.add(Mesaj);
		//Mesaj.setText("haha");
		fillLabel(nume,prenume);
		
 	    
	}

}
