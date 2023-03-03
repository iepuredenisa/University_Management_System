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
import javax.swing.JTextField;

public class Program_prof implements ActionListener{
    
	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune,ll,cc,ss;
	JButton superad, ad, prof, stud, button,buttonBack,addadm,addprof,addstud,detaliiadm,stergprof,stergstud,actprof,actstud,stergadm,actadm,cauta_nume,cauta_curs,
	asign_prof;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l13, l14,l16, l17,m3,activ;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,  t11, t12,maxstud;
    private ButtonGroup checkboxes;
	JButton adds,cancels,buttonprog;
	JComboBox activitate, ora1, ora2,dep,tip,cursuri,seminare,laburi,AA;
	String id_prof;
	public void fillComboBox_curs(String NUME,String PRENUME)
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
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	
	public void fillComboBox_seminar(String NUME,String PRENUME)
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
	    	  ResultSet rss = cc.s.executeQuery("SELECT informatii_profesor.activitate_predata from informatii_profesor where (informatii_profesor.id_profesor ='"+id_prof+"' and informatii_profesor.tip='seminar')");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				seminare.addItem(rss.getString("activitate_predata"));
	    	  			}
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	
	public void fillComboBox_lab(String NUME,String PRENUME)
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
	    	  ResultSet rss = cc.s.executeQuery("SELECT informatii_profesor.activitate_predata from informatii_profesor where (informatii_profesor.id_profesor ='"+id_prof+"' and informatii_profesor.tip='laborator')");
	    	  			ResultSetMetaData rsmd = rss.getMetaData();
	    	  			while(rss.next())
	    	  			{
	    	  				
	    	  				laburi.addItem(rss.getString("activitate_predata"));
	    	  			}
	    	  			
	    	  		
	    	  		} catch (SQLException e1) {
	    	  			
	    	  			e1.printStackTrace();
	    	  		}
	      
		
	 }
	
	public Program_prof(String NUME, String PRENUME) {
		backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("Programare");
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
       
 	
 	   l2 = new JLabel("Nume:");
       l2.setBounds(100,150,200,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l2);
       
       
       t1=new JTextField();
       t1.setBounds(320,150,150,30);
       myLabel.add(t1);
       
       t1.setText(NUME);
       
       l3 = new JLabel("Prenume:");
       l3.setBounds(100,200,100,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l3);
       
       t2=new JTextField();
       t2.setBounds(320,200,150,30);
       myLabel.add(t2);
       t2.setText(PRENUME);
       
       
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
       
       buttonprog = new JButton("Programare");
       buttonprog.setBounds(100, 600, 200, 40);
       buttonprog.setFocusable(false);
       buttonprog.setBackground(Color.BLACK);
       buttonprog.setForeground(Color.WHITE);
       myLabel.add(buttonprog);
       
       buttonprog.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			String curs = (String) cursuri.getSelectedItem();
            String seminar = (String) seminare.getSelectedItem();
            String laborator = (String) laburi.getSelectedItem();
           

       
            switch (AA.getSelectedItem().toString()) {
                case "laborator" -> {
                	if(laborator==null)
                		JOptionPane.showMessageDialog(null, "Nu aveti laboratoare la aceasta materie", "Error",
                                JOptionPane.WARNING_MESSAGE);
                	else
                	{
                		    frame.dispose();
                    new Progr_laborator(laborator,NUME,PRENUME);
                
                	}
                    
                   
                }
                
                case "seminar" -> {
                	if(seminar==null)
                		JOptionPane.showMessageDialog(null, "Nu aveti seminarii la aceasta materie", "Error",
                                JOptionPane.WARNING_MESSAGE);
                	else
                	{
                		frame.dispose();
                    new Prog_seminar(seminar,NUME,PRENUME);
                	}
                    
                   
                }
                
                case "curs" -> {
                	if(curs==null)
                		JOptionPane.showMessageDialog(null, "Nu aveti cursuri la aceasta materie", "Error",
                                JOptionPane.WARNING_MESSAGE);
                	else
                	{
                		frame.dispose();
                    new Progr_curs(curs,NUME,PRENUME);
                	}
                    
                    
                }
               
            }
        } 
	
 			
     	  
       });
       
       cc = new JLabel("Cursuri:");
       cc.setBounds(100,250,100,30);
       cc.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(cc);
       
       cursuri = new JComboBox();
       cursuri.setBackground(Color.WHITE);
       cursuri.setBounds(100,300,150,30);
       myLabel.add(cursuri);
       
       fillComboBox_curs(NUME,PRENUME);
       
       ss = new JLabel("Seminarii:");
       ss.setBounds(300,250,100,30);
       ss.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(ss);
       
       seminare = new JComboBox();
       seminare.setBackground(Color.WHITE);
       seminare.setBounds(300,300,150,30);
       myLabel.add(seminare);
       
       fillComboBox_seminar(NUME,PRENUME);
       
       ll = new JLabel("Laboratoare:");
       ll.setBounds(500,250,150,30);
       ll.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(ll);
       
       laburi = new JComboBox();
       laburi.setBackground(Color.WHITE);
       laburi.setBounds(500,300,150,30);
       myLabel.add(laburi);
       
       fillComboBox_lab(NUME,PRENUME);
       
       
       activ = new JLabel("Alegeti activitatea");
       activ.setBounds(500,350,250,30);
       activ.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(activ);
       
       String activitati[] = {"laborator", "seminar", "curs"};
       AA= new JComboBox(activitati);
       AA.setBackground(Color.WHITE);
       AA.setBounds(500,400,150,30);
       myLabel.add(AA);
       /*buttonprog = new JButton("Programeaza");
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
 		      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","Madalina22@");
 		      			
 		      			CallableStatement callableStatement=null;
 		      			ResultSet resultSet=null;
 		      			
 		      			String sql="{call programareactivitati24(?,?,?,?,?)}";
 		      		
 		      			
 		      			callableStatement=connection.prepareCall(sql);
 		      			
 		      			callableStatement.setString(1,nume_curs);
 		      			callableStatement.setString(2,nume_prof);
 		      			callableStatement.setString(3,prenume_prof);
 		      			callableStatement.setString(4,tip);
 		      			callableStatement.setString(5,nr_ore);
 		      			
 		      			
 		      			callableStatement.execute();
 		      			connection.close();
 		      			JOptionPane.showMessageDialog(null,"Successfully");
 		                  frame.setVisible(false);
 		      			
 		      			
 		      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
 		      	             " Details are provided below:");
 		      	          e2.printStackTrace(System.err);};
 		    		
 		      }
 			
 		
 			
 		
     	  
       });
       
       
      
       buttonprog.addActionListener(this);
       */
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