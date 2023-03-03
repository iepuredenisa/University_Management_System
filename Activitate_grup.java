package jdbc;

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
import javax.swing.JTextField;

public class Activitate_grup implements ActionListener {
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
	
	public Activitate_grup(String NUME,String PRENUME, String CNP, String materie)
	{
		
	backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
myLabel= new JLabel(backgr);
myLabel.setSize(900,700);

	frame= new JFrame("Activitate grup");
	frame.add(myLabel);
	frame.setSize(900,700);
	frame.setLayout(null);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    
    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
    frame.setIconImage(icon);
    

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Activitate_grup(null,null,null,null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
