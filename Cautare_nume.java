package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Cautare_nume implements ActionListener{

	
	JFrame frame;
	
	ImageIcon backgr;
	JLabel myLabel, lab,label,l1,l2,l3;
	JButton superad, ad, prof, stud, button, buttonBack, buttonS;
	JTextField te,t2,t3;
	JComboBox tip;
	JLabel tabelDate;
	String x[] = {"CNP", "nume", "prenume", "adresa", "nr_telefon" , "email", "IBAN", "nr_contract"};
    String y[][] = new String[20][13];
    int i=0, j=0;
    JTable tab;
    
    Cautare_nume()
    {
    	backgr= new ImageIcon(this.getClass().getResource("/bus.jpg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(640,640);
		
		frame= new JFrame("Search");
		frame.add(myLabel);
		frame.setSize(640,640);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	   label = new JLabel("Cauta utilizator");
       label.setHorizontalAlignment(SwingConstants.CENTER);
       label.setFont(new Font("serif",Font.BOLD,18));
       label.setBounds(100, 100, 350, 60);
       myLabel.add(label);
       
       
       l1 = new JLabel("Nume");
       l1.setBounds(90,250,200,30);
       l1.setFont(new Font("serif",Font.BOLD,20));
       l1.setForeground(Color.BLACK);
       myLabel.add(l1);
       
       te=new JTextField();
       te.setBounds(210,250,200,30);
       myLabel.add(te);
       
       l2 = new JLabel("Prenume");
       l2.setBounds(90,300,200,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l2);
       
       t2=new JTextField();
       t2.setBounds(210,300,200,30);
       myLabel.add(t2);
       
       l3 = new JLabel("Tip utilizator");
       l3.setBounds(90,350,200,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l3);
       
       String tipul[] = {"profesor","student"};
       tip = new JComboBox(tipul);
       tip.setBackground(Color.WHITE);
       tip.setBounds(210,350,200,30);
       myLabel.add(tip);
       
       
       buttonBack = new JButton("Back");
       buttonBack.setBounds(400, 550, 200, 40);
       buttonBack.setFocusable(false);
       buttonBack.setBackground(Color.BLACK);
    	buttonBack.setForeground(Color.WHITE);
       myLabel.add(buttonBack);
    
       
       
       buttonBack.addActionListener(new ActionListener()
       {

 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 		
 			new Ad_SAd(null, null, null,null,null);
 			
 		}
     	  
       });
       buttonS = new JButton("Cauta");
	     buttonS.setBounds(210, 400, 200, 40);
	     buttonS.setFocusable(false);
	     buttonS.setBackground(Color.BLACK);
	     buttonS.setForeground(Color.WHITE);
	      myLabel.add(buttonS);
	      buttonS.addActionListener(new ActionListener()
	      {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   String nume = te.getText();
	                String prenume = t2.getText();
	                
	   if (nume.equals("") || prenume.equals("") ) {
	                    JOptionPane.showMessageDialog(null, "Verifica daca ai completat toate campurile", "Error",
	                            JOptionPane.WARNING_MESSAGE);
	   }
				
			
			else {
                int rasp = doQuery((String)tip.getSelectedItem(), nume, prenume);
                if (rasp == 1) {
                    switch ((String)tip.getSelectedItem()) {
                        case "profesor" -> {
                            frame.dispose();
                            new ProfDetails_1(nume,prenume);
                           
                        }
                        
                        case "student" -> {
                            frame.dispose();
                            new StudDetails_1(nume,prenume);
                           
                        }
                  
                    }
                } else
                    JOptionPane.showMessageDialog(null, "NU EXISTI IN BAZA NOASTRA DE DATE!", "WARINIG!", JOptionPane.WARNING_MESSAGE);

            }
        }

			
	    	  
	      });
    }

		
    private int doQuery(String tabela, String nume, String prenume) {
        try {
        	 WConnection cc = new WConnection();
           // Statement s =  new createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            if (tabela.equals("profesor"))
                tabela = "profesor";
            ResultSet rs = cc.s.executeQuery("SELECT * FROM platforma_studiu." + tabela.toLowerCase() + " WHERE nume = '" + nume + "' AND prenume = '" + prenume + "';");
            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            if (rows == 0)
                return 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }
    
       
     
       
       
       

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new Cautare_nume();
	}

}
