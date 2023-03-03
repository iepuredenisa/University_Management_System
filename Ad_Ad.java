package jdbc;

import java.awt.Color;
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

public class Ad_Ad implements ActionListener{
       
	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune;
	JButton superad, ad, prof, stud, button,buttonBack,addprof,addstud,detaliiadm,stergstud,stergprof,actstud,actprof;
    private ButtonGroup checkboxes;
	
	 public Ad_Ad(String profil, String nume,String CNP,String NUME,String PRENUME)
	 {

			backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			myLabel= new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Administrator "+nume);
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
	        
	        addprof = new JButton("Adauga Profesor");
	        addprof.setBounds(100, 100, 200, 40);
	        addprof.setFocusable(false);
	        addprof.setBackground(Color.BLACK);
	     	addprof.setForeground(Color.WHITE);
	        myLabel.add(addprof);
	        
	        addprof.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new AddTeacher();
	  			
	  		}
	      	  
	        });
	        
	     
	        
	        
	        
	        addstud = new JButton("Adauga Student");
	        addstud.setBounds(100, 150, 200, 40);
	        addstud.setFocusable(false);
	        addstud.setBackground(Color.BLACK);
	     	addstud.setForeground(Color.WHITE);
	        myLabel.add(addstud);
	        
	        addstud.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new AddStudent();
	  			
	  		}
	      	  
	        });
	        
	        detaliiadm = new JButton("Detalii personale");
	        detaliiadm.setBounds(100, 200, 200, 40);
	        detaliiadm.setFocusable(false);
	        detaliiadm.setBackground(Color.BLACK);
	     	detaliiadm.setForeground(Color.WHITE);
	        myLabel.add(detaliiadm);
	        
	        detaliiadm.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new ADDetails(profil,nume,CNP,NUME,PRENUME);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        
	        stergprof = new JButton("Elimina Profesor");
	        stergprof.setBounds(100, 250, 200, 40);
	        stergprof.setFocusable(false);
	        stergprof.setBackground(Color.BLACK);
	     	stergprof.setForeground(Color.WHITE);
	        myLabel.add(stergprof);
	        
	        stergprof.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new DeleteProfesor(CNP,nume,profil);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        
	        stergstud = new JButton("Elimina Student");
	        stergstud.setBounds(100, 300, 200, 40);
	        stergstud.setFocusable(false);
	        stergstud.setBackground(Color.BLACK);
	     	stergstud.setForeground(Color.WHITE);
	        myLabel.add(stergstud);
	        
	        stergstud.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new DeleteStudent(CNP,nume,profil);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        actstud = new JButton("Actualizare Student");
	        actstud.setBounds(100, 350, 200, 40);
	        actstud.setFocusable(false);
	        actstud.setBackground(Color.BLACK);
	     	actstud.setForeground(Color.WHITE);
	        myLabel.add(actstud);
	        
	        
	        
	        actstud.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new UpdateStudent(nume,profil,CNP,NUME,PRENUME);
	  			
	  		}
	      	  
	        });
	        actprof = new JButton("Actualizare Profesor");
	        actprof.setBounds(100, 400, 200, 40);
	        actprof.setFocusable(false);
	        actprof.setBackground(Color.BLACK);
	     	actprof.setForeground(Color.WHITE);
	        myLabel.add(actprof);
	        
	        
	        
	        actprof.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new UpdateProfesor(nume,profil,CNP);
	  			
	  		}
	      	  
	        });
	        
	 }

	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Ad_Ad(null,null,null,null,null);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
