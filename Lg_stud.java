package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Lg_stud implements ActionListener {
	JFrame frame;
	JTable t1;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune;
	JButton superad, ad, prof, stud, button,buttonBack,detaliistud,inscriere_curs,renuntare_curs,grup_studiu,Orar_s;
    private ButtonGroup checkboxes;
    String str;
    SimpleDateFormat sdf;
	 public Lg_stud(String profil,String nume,String prenume,String CNP,String NUME,String PRENUME)
	 {
		 backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			myLabel= new JLabel(backgr);
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
	 	    
	 	   operatiune = new JLabel("Alegeti o operatiune");
	       operatiune.setBounds(50, 50, 200, 30);
	       operatiune.setFont(new Font("serif",Font.BOLD,20));
	       myLabel.add(operatiune);
	       
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
	  			new Login();
	  			
	  		}
	      	  
	        });
	        detaliistud = new JButton("Detalii personale");
	        detaliistud.setBounds(100, 100, 200, 40);
	        detaliistud.setFocusable(false);
	        detaliistud.setBackground(Color.BLACK);
	     	detaliistud.setForeground(Color.WHITE);
	        myLabel.add(detaliistud);
	        
	        detaliistud.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new StudDetails(profil,nume,CNP,NUME,PRENUME);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        inscriere_curs = new JButton("Inscriere la curs");
	        inscriere_curs.setBounds(100, 150, 200, 40);
	        inscriere_curs.setFocusable(false);
	        inscriere_curs.setBackground(Color.BLACK);
	     	inscriere_curs.setForeground(Color.WHITE);
	        myLabel.add(inscriere_curs);
	        
	        inscriere_curs.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new Inscriere_CURS(PRENUME,NUME,CNP);
	  			
	  			
	  			
	  		}
	      	  
	        });
	       
	        
	     
	 
	        renuntare_curs = new JButton("Renuntare la curs");
	        renuntare_curs.setBounds(100, 200, 200, 40);
	        renuntare_curs.setFocusable(false);
	        renuntare_curs.setBackground(Color.BLACK);
	     	renuntare_curs.setForeground(Color.WHITE);
	        myLabel.add(renuntare_curs);
	        
	        renuntare_curs.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new Renuntare_curs(NUME,PRENUME,CNP);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        
	        grup_studiu = new JButton("Grup de studiu");
	        grup_studiu.setBounds(100, 250, 200, 40);
	        grup_studiu.setFocusable(false);
	        grup_studiu.setBackground(Color.BLACK);
	     	grup_studiu.setForeground(Color.WHITE);
	        myLabel.add(grup_studiu);
	        
	        grup_studiu.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new Grup_studiu_(NUME,PRENUME,CNP);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        
	        
	        JButton situatie = new JButton("Situatie scolara");
	        situatie.setBounds(100, 300, 200, 40);
	        situatie.setFocusable(false);
	        situatie.setBackground(Color.BLACK);
	        situatie.setForeground(Color.WHITE);
	        myLabel.add(situatie);
	        
	        situatie.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new Situatie_scolara(NUME,PRENUME,CNP);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        Calendar cal = Calendar.getInstance();
	        Date thisDate=new Date();
	         sdf = new SimpleDateFormat("yyyy-MM-dd");  // simple data f
	      
	        Format f = new SimpleDateFormat("EEEE");  
	        str = f.format(new Date()); 
	       
	       sdf.setLenient(false);
	       
	       
	     
	     	 
	     	  
	      
	        if (str.equals("Monday")) str="Luni";
	        else  if (str.equals("Tuesday")) str="Marti";
	        else if (str.equals("Wednesday")) str="Miercuri";
	        else if (str.equals("Thursday")) str="Joi";
	        else if (str.equals("Friday")) str="Vineri";
	        else if  (str.equals("Saturday")) str="Sambata";
	        else if (str.equals("Sunday")) str="Duminica";
	        
	        Orar_s = new JButton("Vizualizare orar");
	        Orar_s.setBounds(100, 300, 200, 40);
	        Orar_s.setFocusable(false);
	        Orar_s.setBackground(Color.BLACK);
	        Orar_s.setForeground(Color.WHITE);
	        myLabel.add(Orar_s);
	        
	        Orar_s.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new Vizualizare_orar_student(NUME,PRENUME,str);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        
	        
	 }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Lg_stud(null,null,null,null,null,null);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		 
		
	}
}

