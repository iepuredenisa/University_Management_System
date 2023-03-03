package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class Procente_activitati implements ActionListener {
	JFrame frame;
	JTable t1;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune,l1,l2,l3,l4,labb,sem,curs;
	JButton superad, ad, prof, stud, button,buttonBack,detaliistud,inscriere_curs,buttoninscriere;
    private ButtonGroup checkboxes;
    JComboBox cursuri;
    JTextField prcurs,prlab,prsem;
    String id_prof=null;
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
	    	  				frame.setVisible(false);
	    	  			}
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	 public Procente_activitati(String NUME,String PRENUME)
	 {
		 backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			myLabel= new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Profesor "+NUME+" "+PRENUME);
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
	        
	        buttoninscriere = new JButton("Adauga");
	        buttoninscriere.setBounds(100, 600, 200, 40);
	        buttoninscriere.setFocusable(false);
	        buttoninscriere.setBackground(Color.BLACK);
	     	buttoninscriere.setForeground(Color.WHITE);
	        myLabel.add(buttoninscriere);
	        
	        l1 = new JLabel("Alegeti cursul");
	        l1.setBounds(100,100,150,30);
	        l1.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(l1);
	        
	        cursuri = new JComboBox();
	        cursuri.setBackground(Color.WHITE);
	        cursuri.setBounds(250,100,150,30);
	        myLabel.add(cursuri);
	        
	        fillComboBox(NUME,PRENUME);
	        
	        labb = new JLabel("Procent laborator:");
	        labb.setBounds(100,450,250,30);
	        labb.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(labb);
	        
	        prlab = new JTextField();
	        prlab.setBackground(Color.WHITE);
	        prlab.setBounds(100,500,150,30);
	        myLabel.add(prlab);
	        
	        curs = new JLabel("Procent curs:");
	        curs.setBounds(300,450,150,30);
	        curs.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(curs);
	        
	        prcurs = new JTextField();
	        prcurs.setBackground(Color.WHITE);
	        prcurs.setBounds(300,500,150,30);
	        myLabel.add(prcurs);
	        
	        sem = new JLabel("Procent seminar:");
	        sem.setBounds(500,450,150,30);
	        sem.setFont(new Font("serif",Font.BOLD,20));
	        myLabel.add(sem);
	        
	        prsem = new JTextField();
	        prsem.setBackground(Color.WHITE);
	        prsem.setBounds(500,500,150,30);
	        myLabel.add(prsem);
	        
	        buttoninscriere.addActionListener(this);
	        
	        
	      
	 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Procente_activitati(null,null);
		}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
				 String nume_curs=(String)cursuri.getSelectedItem();
			      String procentlab=prlab.getText();
			      String procentsem=prsem.getText();
			      String procentcurs=prcurs.getText();
			      if(e.getSource() == buttoninscriere)
			      {
			    		try {
			      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
			      			
			      			CallableStatement callableStatement=null;
			      			ResultSet resultSet=null;
			      			
			      			String sql="{call adaugaprocente13(?,?,?,?,?)}";
			      		
			      			
			      			callableStatement=connection.prepareCall(sql);
			      			
			      			callableStatement.setString(1,id_prof);
			      			callableStatement.setString(2,nume_curs);
			      			callableStatement.setString(3,procentcurs);
			      			callableStatement.setString(4,procentlab);
			      			callableStatement.setString(5,procentsem);
			      			
			      			callableStatement.execute();
			      			connection.close();
			      			JOptionPane.showMessageDialog(null,"Procents asigned Successfully");
			                  frame.setVisible(false);
			      			
			      			
			      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
			      	             " Details are provided below:");
			      	          e2.printStackTrace(System.err);};
			    		
			      }
				
		 
	}
}

