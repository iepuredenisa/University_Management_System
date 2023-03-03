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
import javax.swing.JTable;
import javax.swing.JTextField;

public class New_grup implements ActionListener {
	JFrame frame;
	JTable t1;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune,l1,l2,l3,l4,labb,sem,curs;
	JButton superad, ad, prof, stud, button,buttonBack,detaliistud,inscriere_curs,buttoninscriere,adds;
    private ButtonGroup checkboxes;
    JComboBox cursuri;
    JTextField prcurs,prlab,prsem;
    String id_stud=null;
    public void fillComboBox(String NUME,String PRENUME,String CNP)
	 {
    	
    	WConnection cc = new WConnection();
	      try {
ResultSet rs = cc.s.executeQuery("select student.id_student from student where student.nume='"+NUME+"' and student.prenume='"+PRENUME+"' and student.CNP='"+CNP+"'");
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				id_stud=rs.getString("id_student");
				
				//cursuri.addItem(rs.getString("activitate_predata"));
			}
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	      
	      try {
	    	  ///daca e null mesaj//////////////////////////////
	    	  ResultSet rss = cc.s.executeQuery("SELECT inscriere_student.denumire_materie from inscriere_student where inscriere_student.id_student ='"+id_stud+"' group by denumire_materie");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				cursuri.addItem(rss.getString("denumire_materie"));
	    	  			}
	    	  			if(cursuri.getSelectedItem()==null)
	    	  			{
	    	  				JOptionPane.showMessageDialog(null,"Nu sunteti inscris la nicio materie");
	    	  				frame.setVisible(false);
	    	  			}
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	 public New_grup(String NUME,String PRENUME,String CNP)
	 {
		 backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			myLabel= new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Grup studiu");
			frame.add(myLabel);
			frame.setSize(900,700);
			frame.setLayout(null);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		    frame.setLocationRelativeTo(null);
		    
		    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
	 	    frame.setIconImage(icon);
	 	    
	       
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
	      
	        
	        l1 = new JLabel("Alegeti materia");
	        l1.setBounds(100,100,150,30);
	        l1.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l1);
	        
	        cursuri = new JComboBox();
	        cursuri.setBackground(Color.WHITE);
	        cursuri.setBounds(250,100,150,30);
	        myLabel.add(cursuri);
	        
	    
	    
	        
	        fillComboBox(NUME,PRENUME,CNP);
	        
	        adds = new JButton("Inscriere grup");
	        adds.setBackground(Color.BLACK);
	        adds.setForeground(Color.WHITE);
	        adds.setBounds(100,600,200,40);
	        myLabel.add(adds);
	        adds.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			String materie=cursuri.getSelectedItem().toString();
	  	      if(e.getSource() == adds)
	  	      {
	  	    		try {
	  	      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	  	      			
	  	      			CallableStatement callableStatement=null;
	  	      			ResultSet resultSet=null;
	  	      			
	  	      			String sql="{call inscriere_grup(?,?,?,?)}";
	  	      		
	  	      			
	  	      			callableStatement=connection.prepareCall(sql);
	  	      			
	  	      			callableStatement.setString(1,NUME);
	  	      			callableStatement.setString(2,PRENUME);
	  	      			callableStatement.setString(3,CNP);
	  	      			callableStatement.setString(4,materie);
	  	      			
	  	      			callableStatement.execute();
	  	      			connection.close();
	  	      			
	  	      			JOptionPane.showMessageDialog(null,"Inscris la grup!");
	  	                  
	  	      			
	  	      			
	  	      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	  	      	             " Details are provided below:");
	  	      	          e2.printStackTrace(System.err);};
	  	    		
	  	      }
	  			
	  		}
	      	  
	        });
	      
	   
	      
	        
	        
	      
	        
	        
	      
	 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new New_grup(null,null,null);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	    
	      
		
	}

	

}
