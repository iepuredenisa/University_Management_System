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

public class Asignare_prof implements ActionListener{
    
	JFrame frame;
	private JPanel panel;
	ImageIcon backgr;
	JLabel myLabel, lab,operatiune;
	JButton superad, ad, prof, stud, button,buttonBack,addadm,addprof,addstud,detaliiadm,stergprof,stergstud,actprof,actstud,stergadm,actadm,cauta_nume,cauta_curs,
	asign_prof;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12, l13, l14,l16, l17,m3;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,  t11, t12,maxstud;
    private ButtonGroup checkboxes;
	JButton adds,cancels,prog;
	JComboBox activitate, ora1, ora2,dep,tip;
	
	public Asignare_prof() {
		backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		myLabel= new JLabel(backgr);
		myLabel.setSize(900,700);
		
		frame= new JFrame("Prof");
		frame.add(myLabel);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	   operatiune = new JLabel("Asignare");
       operatiune.setBounds(50, 50, 200, 30);
       operatiune.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(operatiune);
       
 	
 	   l2 = new JLabel("Nume");
       l2.setBounds(100,150,100,30);
       l2.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l2);
       
       t1=new JTextField();
       t1.setBounds(220,150,150,30);
       myLabel.add(t1);
       
       l3 = new JLabel("Prenume");
       l3.setBounds(100,200,100,30);
       l3.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l3);
       
       t2=new JTextField();
       t2.setBounds(220,200,150,30);
       myLabel.add(t2);
       
       l16 = new JLabel("Departament");
       l16.setBounds(100,250,150,30);
       l16.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l16);
       
       String departament[] = {"Automatica","Calculatoare"};
       dep = new JComboBox(departament);
       dep.setBackground(Color.WHITE);
       dep.setBounds(220,250,150,30);
       myLabel.add(dep);
       
       
       l11 = new JLabel("Minim ore");
       l11.setBounds(100,300,150,30);
       l11.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l11);
       
       String oreMin[] = {"2","6","10","12"};
       ora1 = new JComboBox(oreMin);
       ora1.setBackground(Color.WHITE);
       ora1.setBounds(220,300,150,30);
       myLabel.add(ora1);
       
       l13 = new JLabel("Maxim ore");
       l13.setBounds(100,350,150,30);
       l13.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l13);
       
       String oreMax[] = {"16","18","25","30"};
       ora2 = new JComboBox(oreMax);
       ora2.setBackground(Color.WHITE);
       ora2.setBounds(220,350,150,30);
       myLabel.add(ora2);
       
       l17 = new JLabel("Nume curs");
       l17.setBounds(100,400,150,30);
       l17.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l17);
       t12=new JTextField();
       t12.setBounds(220,400,150,30);
       myLabel.add(t12);
       
       String tip_activit[] = {"curs", "seminar", "laborator"};
       tip = new JComboBox(tip_activit);
       tip.setBackground(Color.WHITE);
       tip.setBounds(220,450,150,30);
       myLabel.add(tip);
       
       l8 = new JLabel("Tip activitate");
       l8.setBounds(100,450,150,30);
       l8.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(l8);
       
       m3 = new JLabel("Nr. studenti");
       m3.setBounds(100,500,150,40);
       m3.setFont(new Font("serif",Font.BOLD,20));
       myLabel.add(m3);
       
       maxstud=new JTextField();
       maxstud.setBounds(220,500,150,30);
       myLabel.add(maxstud);
       
       adds = new JButton("Adauga");
       adds.setBackground(Color.BLACK);
       adds.setForeground(Color.WHITE);
       adds.setBounds(550,250,150,40);
       
       prog = new JButton("Programare");
       prog.setBackground(Color.BLACK);
       prog.setForeground(Color.WHITE);
       prog.setBounds(550,300,150,40);
       myLabel.add(prog);
       
       prog.addActionListener(new ActionListener()
       {
    	  
 		@Override
 		public void actionPerformed(ActionEvent e) {
 			// TODO Auto-generated method stub
 			      new Programare_activitati(t12.getText(),t1.getText(),t2.getText(),(String)tip.getSelectedItem());
 		         }
 
       });
       
       myLabel.add(adds);
      
       adds.addActionListener(this);
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
            new Asignare_prof();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 String name=t1.getText();
	      String prenom=t2.getText();
	      if(doQuery(name,prenom)==0)
	    	  JOptionPane.showMessageDialog(null,"INTRODUCETI UN PROFESOR VALID");
	     String departament=(String)dep.getSelectedItem();
	      String min_ore=(String)ora1.getSelectedItem();
	      String max_ore=(String)ora2.getSelectedItem();
	      String nume_c=t12.getText();
	      String tip_activ=(String)tip.getSelectedItem();
	      String max_stud=(String)maxstud.getText();
	      if(e.getSource() == adds)
	      {
	    		try {
	      			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/platforma_studiu","root","InginerDenisa123");
	      			
	      			CallableStatement callableStatement=null;
	      			ResultSet resultSet=null;
	      			
	      			String sql="{call insertinformatii_profesor3(?,?,?,?,?,?,?,?)}";
	      		
	      			
	      			callableStatement=connection.prepareCall(sql);
	      			
	      			callableStatement.setString(1,nume_c);
	      			callableStatement.setString(2,name);
	      			callableStatement.setString(3,prenom);
	      			callableStatement.setString(4,min_ore);
	      			callableStatement.setString(5,max_ore);
	      			callableStatement.setString(6,departament);
	      			callableStatement.setString(7,tip_activ);
	      			callableStatement.setString(8,max_stud);
	      			
	      			callableStatement.execute();
	      			connection.close();
	      			if(doQuery(name,prenom)==1)
	      			JOptionPane.showMessageDialog(null,"Teacher asigned Successfully");
	                  
	      			
	      			
	      		}catch(Exception e2) {System.err.println("An Exception occured during JDBC Driver loading." + 
	      	             " Details are provided below:");
	      	          e2.printStackTrace(System.err);};
	    		
	      }
		
	}

}