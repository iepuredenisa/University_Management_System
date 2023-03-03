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

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add_n_student implements ActionListener {
	
	JFrame f;
	JLabel l12, l1, l2 , l3, l4, l5, l6, l7,mat;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JButton adds, cancels, buttonBack;
	String id_prof=null;
	JComboBox cursuri;
	JTextField nume_prof,prenume_prof,nume_student,prenume_student,CNP_student;
	public void fillComboBox(String NUME,String PRENUME)
	 {
   	
   	WConnection cc = new WConnection();
	      try {
ResultSet rs = cc.s.executeQuery("select profesor.id_profesor from profesor where profesor.nume='"+NUME+"' and profesor.prenume='"+PRENUME+"'");
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				id_prof=rs.getString("id_profesor");
				
				//cursuri.addItem(rs.getString("activitate_predata"));
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	      
	      try {
	    	  ///daca e null mesaj//////////////////////////////
	    	  ResultSet rss = cc.s.executeQuery("SELECT informatii_profesor.activitate_predata from informatii_profesor where (informatii_profesor.id_profesor ='"+id_prof+"' and informatii_profesor.tip='curs')");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				cursuri.addItem(rss.getString("activitate_predata"));
	    	  			}
	    	  			if(cursuri.getSelectedItem()==null)
	    	  			{
	    	  				JOptionPane.showMessageDialog(null,"Nu sunteti profesor de curs");
	    	  				f.setVisible(false);
	    	  			}
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	public Add_n_student(String nume, String prenume, String CNP,String nprof,String pprof)
	{
		f = new JFrame("Note");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(900, 700);
        l12=new JLabel();
        l12.setBounds(0,0,900,700);
        l12.setLayout(null);
        f.add(l12);
        
        l1 = new JLabel("Note obtinute");
        l1.setBounds(320,30,500,50);
        l1.setFont(new Font("serif",Font.ITALIC,25));
        l1.setForeground(Color.BLUE);
        l12.add(l1);
        Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
        
        mat = new JLabel("Alegeti materia");
        mat.setBounds(600,150,150,30);
        mat.setFont(new Font("serif",Font.BOLD,20));
        l12.add(mat);
        
        cursuri = new JComboBox();
        cursuri.setBackground(Color.WHITE);
        cursuri.setBounds(600,200,150,30);
        l12.add(cursuri);
        
        fillComboBox(nprof,pprof);
        
        l2 = new JLabel("Nota colocviu");
        l2.setBounds(100,150,350,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l12.add(l2);
        
        t1=new JTextField();
        t1.setBounds(300,150,50,30);
        l12.add(t1);
        
        l3 = new JLabel("Nota restanta colocviu");
        l3.setBounds(100,200,350,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l12.add(l3);
        
        t2=new JTextField();
        t2.setBounds(300,200,50,30);
        l12.add(t2);
        
        l4 = new JLabel("Nota seminar");
        l4.setBounds(100,250,350,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l12.add(l4);
        
        t3=new JTextField();
        t3.setBounds(300,250,50,30);
        l12.add(t3);
        
        l5 = new JLabel("Nota partial");
        l5.setBounds(100,300,350,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l12.add(l5);
        
        t4=new JTextField();
        t4.setBounds(300,300,50,30);
        l12.add(t4);
        
        l6 = new JLabel("Nota examen");
        l6.setBounds(100,350,350,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        l12.add(l6);
        
        t5=new JTextField();
        t5.setBounds(300,350,50,30);
        l12.add(t5);
        
        l7 = new JLabel("Nota restanta examen");
        l7.setBounds(100,400,350,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        l12.add(l7);
        
        t6=new JTextField();
        t6.setBounds(300,400,50,30);
        l12.add(t6);
        
        adds = new JButton("Adauga");
        adds.setBackground(Color.BLACK);
        adds.setForeground(Color.WHITE);
        adds.setBounds(100,550,150,40);
        
        l12.add(adds);

        cancels=new JButton("Cancel");   
        cancels.setBackground(Color.BLACK);
        cancels.setForeground(Color.WHITE);
        cancels.setBounds(600,550,150,40);
        
        l12.add(cancels);
        
        buttonBack=new JButton("Back");   
        buttonBack.setBackground(Color.BLACK);
        buttonBack.setForeground(Color.WHITE);
        buttonBack.setBounds(350,550,150,40);
        
        l12.add(buttonBack);
        
        JButton buttonfinal = new JButton("Situatie finala");   
        buttonfinal.setBackground(Color.BLACK);
        buttonfinal.setForeground(Color.WHITE);
        buttonfinal.setBounds(500,100,150,40);
        
        l12.add(buttonfinal);
        
        adds.addActionListener(this);
        cancels.addActionListener(this);
        
        
        nume_prof=new JTextField();
        nume_prof.setText(nprof);
        
        prenume_prof=new JTextField();
        prenume_prof.setText(pprof);
        
        
        nume_student=new JTextField();
        nume_student.setText(nume);
        
        prenume_student=new JTextField();
        prenume_student.setText(prenume);
        
        CNP_student=new JTextField();
        CNP_student.setText(CNP);
        
        
        
        cancels.addActionListener(new ActionListener()
        {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			
  			f.setVisible(false);
  			
  		}
      	   });
        
        
        buttonBack.addActionListener(new ActionListener()
        {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  			
  			f.setVisible(false);
  			
  		}
      	   });
        
     
	
        
		adds.addActionListener(new ActionListener()
        		{
			
        	      public void actionPerformed(ActionEvent e)
        	      {
        	    	  
        	    	   String curs=(String)cursuri.getSelectedItem();
        	    	  Integer  nota_colocviu=Integer.parseInt(t1.getText().toString());
  	    			Integer nota_res_colocviu=Integer.parseInt(t2.getText().toString());
  	    			Integer  nota_seminar=Integer.parseInt(t3.getText().toString());
  	    			Integer nota_partial=Integer.parseInt(t4.getText().toString());
  	    			Integer nota_examen=Integer.parseInt(t5.getText().toString());
  	    			Integer nota_res_examen=Integer.parseInt(t6.getText().toString());
  	    			
  	    			
  	    	       
  	    			
  	    			String numeProf=nume_prof.getText();
  	    			String prenumeProf=prenume_prof.getText();
  	    			String numeStudent=nume_student.getText();
  	    			String prenumeStudent=prenume_student.getText();
  	    			String CNPStudent=CNP_student.getText();
        	    	  try {
        	    		  
        	    		  
        	    		  
        	    			
      	      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
      	      			
      	      			CallableStatement callableStatement=null;
      	      			ResultSet resultSet=null;
      	      			
      	      			String sql="{call adauga_note2(?,?,?,?,?,?,?,?,?,?,?,?)}";
      	      		 
      	          
      	      			
      	      			callableStatement=connection.prepareCall(sql);
      	      			
      	      			callableStatement.setString(1,curs);
      	      			callableStatement.setString(2,numeProf);
      	      			callableStatement.setString(3,prenumeProf);
      	      			callableStatement.setString(4,numeStudent);
      	      			callableStatement.setString(5,prenumeStudent);
      	      			callableStatement.setString(6,CNPStudent);
      	      			callableStatement.setInt(7, nota_colocviu);
      	      			callableStatement.setInt(8,nota_res_colocviu);
      	      			callableStatement.setInt(9,nota_seminar);
      	      			callableStatement.setInt(10,nota_partial);
      	      			callableStatement.setInt(11,nota_examen);
      	      			callableStatement.setInt(12,nota_res_examen);
      	      			callableStatement.execute();
      	      			connection.close();
      	      		System.out.println(curs+numeProf);	
      	      			
      	      			
      	      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
      	      	             " Details are provided below:");
      	      	          e2.printStackTrace(System.err);};
      	      	          
      	      	          
      	      	          
      	      	      try {
      	  	  			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
      	  	  			
      	  	  			CallableStatement callableStatement=null;
      	  	  			ResultSet resultSet=null;
      	  	  			
      	  	  			String sql="{call nota_finala5(?,?,?,?)}";
      	  	  		
      	  	  			
      	  	  			callableStatement=connection.prepareCall(sql);
      	  	  			
      	  	  			
      	  	  		System.out.println(nume+prenume+CNP+curs);
      	  	  			callableStatement.setString(1,nume);
      	  	  			callableStatement.setString(2,prenume);
      	  	  			callableStatement.setString(3,CNP);
      	  	  			callableStatement.setString(4,curs);
      	  	  		callableStatement.execute();
      	  	  			connection.close();
      	  	  			JOptionPane.showMessageDialog(null,"Notele au fost introduse cu succes");
      	  	             // f.setVisible(false);
      	  	  			
      	  	  			
      	  	  		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
      	  	  	             " Details are provided below:");
      	  	  	          e2.printStackTrace(System.err);};
        	      }
        	
        		});
	//	String curss=(String)cursuri.getSelectedItem();
   
	  	
	  		          
	           
	  	        
	  	
	  		
           
		 f.setIconImage(icon);
	 	    f.setVisible(true);
 	    
	}
	public static void main(String[ ] arg){
        new Add_n_student(null, null, null,null,null);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		/*String curs=(String)cursuri.getSelectedItem();
		String nota_colocviu=(String)t1.getText();
		String nota_res_colocviu=(String)t2.getText();
		String nota_seminar=(String)t3.getText();
		String nota_partial=(String)t4.getText();
		String nota_examen=(String)t5.getText();
		String nota_res_examen=(String)t6.getText();
		String numeProf=nume_prof.getText();
		String prenumeProf=prenume_prof.getText();
		String numeStudent=nume_student.getText();
		String prenumeStudent=prenume_student.getText();
		String CNPStudent=CNP_student.getText();
	      if(e.getSource() == adds)
	      {
	    		
	      	          
	      	          
	      	        
	      }*/
		
		
	}
}
