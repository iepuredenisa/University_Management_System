package jdbc;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Grup_studiu_ implements ActionListener {

    
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
 
	public Grup_studiu_(String NUME, String PRENUME, String CNP) {
		
		
		    
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
	    
	
	       
	       JButton adaugaprof = new JButton("Inscriere grup studiu");
	       adaugaprof.setBounds(100, 100, 200, 40);
	       adaugaprof.setFocusable(false);
	       adaugaprof.setBackground(Color.BLACK);
	       adaugaprof.setForeground(Color.WHITE);
	       myLabel.add(adaugaprof);
	       
	       adaugaprof.addActionListener(new ActionListener()
	       {

	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			// TODO Auto-generated method stub
	 			new New_grup( NUME, PRENUME, CNP);//inscriere grup, exista grupuri pentru fiecare materie
	 			
	 		}
	     	  
	       });
	       
	       JButton mesaj = new JButton("Adauga meet");
	       mesaj.setBounds(100, 150, 200, 40);
	       mesaj.setFocusable(false);
	       mesaj.setBackground(Color.BLACK);
	       mesaj.setForeground(Color.WHITE);
	       myLabel.add(mesaj);
	       
	       mesaj.addActionListener(new ActionListener()
	       {

	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			// TODO Auto-generated method stub
	 			new Adauga_meet( NUME, PRENUME, CNP);
	 			
	 		}
	     	  
	       });
	       
	       JButton membrii = new JButton("Inscriere meet");
	       membrii.setBounds(100, 200, 200, 40);
	       membrii.setFocusable(false);
	       membrii.setBackground(Color.BLACK);
	       membrii.setForeground(Color.WHITE);
	       myLabel.add(membrii);
	       
	       membrii.addActionListener(new ActionListener()
	       {

	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			// TODO Auto-generated method stub
	 			new Inscriere_meet( NUME, PRENUME, CNP);
	 			
	 		}
	     	  
	       });
	       
	       JButton membriiV = new JButton("Vizualizare membrii");
	       membriiV.setBounds(100, 250, 200, 40);
	       membriiV.setFocusable(false);
	       membriiV.setBackground(Color.BLACK);
	       membriiV.setForeground(Color.WHITE);
	       myLabel.add(membriiV);
	       
	       membriiV.addActionListener(new ActionListener()
	       {

	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			// TODO Auto-generated method stub
	 			new Mmbrii_grup(NUME,PRENUME);
	 			
	 		}
	     	  
	       });
	       
	       JButton mesajj = new JButton("Vizualizare mesaje");
	       mesajj.setBounds(100, 300, 200, 40);
	       mesajj.setFocusable(false);
	       mesajj.setBackground(Color.BLACK);
	       mesajj.setForeground(Color.WHITE);
	       myLabel.add(mesajj);
	       
	       mesajj.addActionListener(new ActionListener()
	       {

	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			// TODO Auto-generated method stub
	 			new Mesaje_grup(NUME,PRENUME);
	 			
	 		}
	     	  
	       });
	    
		    
	    
		    
		    
		  
		
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
new Grup_studiu_(null,null,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
