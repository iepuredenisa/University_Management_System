package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ad_SAd implements ActionListener{
       
	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune;
	JButton superad, ad, prof, stud, button,buttonBack,addadm,addprof,addstud,detaliiadm,stergprof,stergstud,actprof,actstud,stergadm,actadm,asign_prof,cauta_nume,cauta_curs;
    private ButtonGroup checkboxes;
	
	 public Ad_SAd(String profil, String nume,String CNP,String NUME,String PRENUME)
	 {

			backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
			myLabel= new JLabel(backgr);
			myLabel.setSize(900,700);
			
			frame= new JFrame("Super-Administrator "+nume);
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
	        
	        addadm = new JButton("Adauga Administrator");
	        addadm.setBounds(100, 100, 200, 40);
	        addadm.setFocusable(false);
	        addadm.setBackground(Color.BLACK);
	     	addadm.setForeground(Color.WHITE);
	        myLabel.add(addadm);
	        
	        addadm.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new AddAdministrator();
	  			
	  		}
	      	  
	        });
	        
	        addprof = new JButton("Adauga Profesor");
	        addprof.setBounds(100, 150, 200, 40);
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
	        addstud.setBounds(100, 200, 200, 40);
	        addstud.setFocusable(false);
	        addstud.setBackground(Color.BLACK);
	     	addstud.setForeground(Color.WHITE);
	        myLabel.add(addstud);
	        
	        detaliiadm = new JButton("Detalii personale");
	        detaliiadm.setBounds(100, 250, 200, 40);
	        detaliiadm.setFocusable(false);
	        detaliiadm.setBackground(Color.BLACK);
	     	detaliiadm.setForeground(Color.WHITE);
	        myLabel.add(detaliiadm);
	        
	        addstud.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new AddStudent();
	  			
	  		}
	      	  
	        });
	        
	        
	        
	        
	        detaliiadm.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new SADetails(profil,nume,CNP,NUME,PRENUME);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        stergprof = new JButton("Elimina Profesor");
	        stergprof.setBounds(100, 300, 200, 40);
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
	        stergstud.setBounds(100, 350, 200, 40);
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
	        
	        stergadm = new JButton("Elimina Administrator");
	        stergadm.setBounds(100, 400, 200, 40);
	        stergadm.setFocusable(false);
	        stergadm.setBackground(Color.BLACK);
	     	stergadm.setForeground(Color.WHITE);
	        myLabel.add(stergadm);
	        
	        stergadm.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			
	  			new DeleteAdministrator(CNP,nume,profil);
	  			
	  			
	  			
	  		}
	      	  
	        });
	        actstud = new JButton("Actualizare Student");
	        actstud.setBounds(100, 450, 200, 40);
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
	        actprof.setBounds(100, 500, 200, 40);
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
	        
	        actadm = new JButton("Actualizare Administrator");
	        actadm.setBounds(100, 550, 200, 40);
	        actadm.setFocusable(false);
	        actadm.setBackground(Color.BLACK);
	     	actadm.setForeground(Color.WHITE);
	        myLabel.add(actadm);
	        
	        
	        
	        actadm.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new UpdateAdministrator(nume,profil,CNP);
	  			
	  		}
	      	  
	        });
	        
	        cauta_nume = new JButton("Cautare nume");
	        cauta_nume.setBounds(600, 100, 200, 40);
	        cauta_nume.setFocusable(false);
	        cauta_nume.setBackground(Color.BLACK);
	     	cauta_nume.setForeground(Color.WHITE);
	        myLabel.add(cauta_nume);
	        
	        
	        
	        cauta_nume.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new Cautare_nume();
	  			
	  		}
	  		
	   
	        });
	        cauta_curs = new JButton("Cautare curs");
	        cauta_curs.setBounds(600, 150, 200, 40);
	        cauta_curs.setFocusable(false);
	        cauta_curs.setBackground(Color.BLACK);
	     	cauta_curs.setForeground(Color.WHITE);
	        myLabel.add(cauta_curs);
	        
	        
	        
	        cauta_curs.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new Cautare_curs();
	  			
	  		}
	        });
	        asign_prof = new JButton("Asignare profesor");
	        asign_prof.setBounds(600, 200, 200, 40);
	        asign_prof.setFocusable(false);
	        asign_prof.setBackground(Color.BLACK);
	        asign_prof.setForeground(Color.WHITE);
	        myLabel.add(asign_prof);
	        
	        
	        
	        asign_prof.addActionListener(new ActionListener()
	        {

	  		@Override
	  		public void actionPerformed(ActionEvent e) {
	  			// TODO Auto-generated method stub
	  			new Asignare_prof();
	  			
	  		}
	        });
	        
	        
	 }

	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Ad_SAd(null,null,null,null,null);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

