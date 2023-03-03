package jdbc;

import java.awt.Color;
import java.awt.EventQueue;
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
import jdbc.Table_stud;

public class Ad_Note implements ActionListener {
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
	    	  			//if(cursuri.getSelectedItem()==null)
	    	  			//{
	    	  				//JOptionPane.showMessageDialog(null,"Nu sunteti profesor de curs");
	    	  				//frame.setVisible(false);
	    	  			//}
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				cursuri.addItem(rss.getString("activitate_predata"));
	    	  			}
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	 public Ad_Note(String NUME,String PRENUME)
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
	        
	        buttoninscriere = new JButton("Continua");
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
	        
	       
	        
	        buttoninscriere.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  		//	new Table_stud(NUME, PRENUME, (String)cursuri.getSelectedItem());
	  			
	  			new Tabel_stud_curs(NUME, PRENUME, (String)cursuri.getSelectedItem());
	  			/*EventQueue.invokeLater(new Runnable() {
	  				public void run() {
	  						try {
	  					Table_stud window = new Table_stud(null, null,null);
	  						window.getFrame().setVisible(true);
	  						} catch (Exception e) {
	  						e.printStackTrace();
	  					}
	  					}
	  					
	  			});
	  			new Table_stud(NUME, PRENUME, (String)cursuri.getSelectedItem());
	  		}*/
	  		}
	        });
	      
	 }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Ad_Note(null,null);
		}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
				
			     
			    
				
		 
	}
}

