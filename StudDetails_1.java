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

public class StudDetails_1 {
	JButton buttonBack;
	JFrame frame;
	JTable t1;
	ImageIcon backgr;
	JLabel tabelDate;
	String x[] = {"CNP", "nume", "prenume", "adresa", "nr_telefon" , "email", "IBAN", "nr_contract"};
    String y[][] = new String[20][13];
    int i=0, j=0;
    
    public StudDetails_1(String nume,String prenume)
    {
    	backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		tabelDate= new JLabel(backgr);
		tabelDate.setSize(900,700);
		
		frame= new JFrame("Detalii personale:");
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
			ResultSet rs = cc.s.executeQuery("SELECT* FROM Student WHERE nume = '" + nume + "' AND prenume = '" + prenume + "';");
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				
				y[i][j++]=rs.getString("CNP");
            y[i][j++]=rs.getString("nume");
            y[i][j++]=rs.getString("prenume");
            y[i][j++]=rs.getString("adresa");
            y[i][j++]=rs.getString("nr_telefon");
            y[i][j++]=rs.getString("email");
            y[i][j++]=rs.getString("iban");
            y[i][j++]=rs.getString("nr_contract");
				
            i++;
            j=0;
			}	
			
			t1=new JTable(y,x);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		

      JScrollPane sp = new JScrollPane(t1);
      sp.setBounds(20, 20, 1200, 330);
      tabelDate.add(sp);
      
      buttonBack = new JButton("Back");
      buttonBack.setBounds(600, 600, 200, 40);
      buttonBack.setFocusable(false);
      buttonBack.setBackground(Color.BLACK);
   	buttonBack.setForeground(Color.WHITE);
      tabelDate.add(buttonBack);
      
      
      buttonBack.addActionListener(new ActionListener()
      {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			new Ad_SAd(null, null, null,null,null);
			
		}
    	  
      });
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new StudDetails_1(null,null);
	}

}
