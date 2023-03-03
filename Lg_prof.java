package jdbc;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

import java.awt.Color;
import java.text.Format;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lg_prof implements ActionListener{
	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune;
	JButton superad, ad, prof, stud, button,buttonBack,detaliiprof,procente,programare,program,AdNote;
    private ButtonGroup checkboxes;
    String str;
    SimpleDateFormat sdf;
	public Lg_prof(String profil, String nume,String CNP,String NUME,String PRENUME)
	 {
		backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("Profesor "+nume);
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
       
       procente = new JButton("Adauga procente");
       procente.setBounds(100, 150, 200, 40);
       procente.setFocusable(false);
       procente.setBackground(Color.BLACK);
       procente.setForeground(Color.WHITE);
       myLabel.add(procente);
       
       procente.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			new Procente_activitati(NUME,PRENUME);
 			
 		}
     	  
       });
       
       programare = new JButton("Programare activitati");
       programare.setBounds(100, 200, 200, 40);
       programare.setFocusable(false);
       programare.setBackground(Color.BLACK);
       programare.setForeground(Color.WHITE);
       myLabel.add(programare);
       
       programare.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			new Program_prof(NUME,PRENUME);
 			
 		}
     	  
       });
       
       detaliiprof = new JButton("Detalii personale");
       detaliiprof.setBounds(100, 100, 200, 40);
       detaliiprof.setFocusable(false);
       detaliiprof.setBackground(Color.BLACK);
    	detaliiprof.setForeground(Color.WHITE);
       myLabel.add(detaliiprof);
       
       detaliiprof.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			
 			new ProfDetails(profil,nume,CNP,NUME,PRENUME);
 			
 			
 			
 		}
     	  
       });
       
       
       
       program = new JButton("Activitati zi curenta");
       program.setBounds(100, 250, 200, 40);
       program.setFocusable(false);
       program.setBackground(Color.BLACK);
       program.setForeground(Color.WHITE);
       myLabel.add(program);
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
       program.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			new Vizualizare_orar_prof(NUME,PRENUME,str);
 			
 		}
     	  
       });
	 
	  AdNote = new JButton("Adauga note");
	  AdNote.setBounds(100, 300, 200, 40);
	  AdNote.setFocusable(false);
	  AdNote.setBackground(Color.BLACK);
	  AdNote.setForeground(Color.WHITE);
      myLabel.add(AdNote);
      
      AdNote.addActionListener(new ActionListener()
      {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			new Ad_Note(NUME,PRENUME);
			
			
			
		}
    	  
      });
      

	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Lg_prof(null,null,null,null,null);
	}
	
	
	

}

