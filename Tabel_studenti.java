package jdbc;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tabel_studenti implements ActionListener{
	ImageIcon backgr;
	JButton buttonBack,afisstud;
	JFrame frame;
	JTable t1;
	JLabel tabelDate;
	String x[] = {"nume", "prenume"};
    String y[][] = new String[20][13];
    int i=0, j=0;
    public Tabel_studenti(String a)
    {
    	
    	backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		tabelDate= new JLabel(backgr);
		tabelDate.setSize(900,700);
		
		frame= new JFrame(a);
		frame.add(tabelDate);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	    
 		WConnection cc = new WConnection();
	      try {
 ResultSet rs = cc.s.executeQuery("select student.nume, student.prenume from student, inscriere, materie where student.id_student=inscriere.id_student and materie.id_materie=inscriere.id_materie and materie.descriere='" +a+"';");
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				
				
            y[i][j++]=rs.getString("student.nume");
            y[i][j++]=rs.getString("student.prenume");
        
				
            i++;
			
            j=0;
			}
			t1=new JTable(y,x);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
    JScrollPane sp = new JScrollPane(t1);
    sp.setBounds(70, 40, 600, 200);
    tabelDate.add(sp);
    
    buttonBack = new JButton("Back");
    buttonBack.setBounds(100, 600, 200, 40);
    buttonBack.setFocusable(false);
    buttonBack.setBackground(Color.BLACK);
 	buttonBack.setForeground(Color.WHITE);
    frame.add(buttonBack);
    
    buttonBack.addActionListener(new ActionListener()
    {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			///new DeleteAdministrator(CNP,nume,profil);
			//new Tabel_studenti();
			frame.setVisible(false);
			
			
			
		}
  	  
    });
    
    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new Tabel_studenti(null);
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
