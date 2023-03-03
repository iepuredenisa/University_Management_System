
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
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class Tabel_stud_curs implements ActionListener{
	ImageIcon backgr;
	JButton buttonBack,afisstud;
	JFrame frame;
	//JTable t1;
	JLabel tabelDate;
	String x[] = {"nume", "prenume","CNP"};
    String y[][] = new String[20][13];
    String id_prof=null, id_materie=null;
    String nume,prenume;
    JTextField numm,prenn;
    private javax.swing.JScrollPane jScrollPanel;
    private javax.swing.JTable t1;
    
    int i=0, j=0;
    public Tabel_stud_curs(String nume,String prenume,String descriere)
    {
    	
    	numm=new JTextField();
        numm.setText(nume);
        
        prenn=new JTextField();
        prenn.setText(prenume);
        
    	backgr= new ImageIcon(this.getClass().getResource("/img.jpeg"));
		tabelDate= new JLabel(backgr);
		tabelDate.setSize(900,700);
		
		frame= new JFrame(nume +" "+  prenume);
		frame.add(tabelDate);
		frame.setSize(900,700);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    
	    Image icon=new ImageIcon(this.getClass().getResource("/utcn-logo.png")).getImage();
 	    frame.setIconImage(icon);
 	    
 	    
 		WConnection cc = new WConnection();
	/*      try {
 ResultSet rs = cc.s.executeQuery("select profesor.nume, profesor.prenume from profesor, inscriere, materie where profesor.id_profesor=inscriere.id_profesor and materie.id_materie=inscriere.id_materie and materie.descriere='" +a+"' limit 1;");
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next())
			{
				
				
            y[i][j++]=rs.getString("profesor.nume");
            y[i][j++]=rs.getString("profesor.prenume");
        
				
            i++;
			
            j=0;
			}
			t1=new JTable(y,x);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		*/
 		try {
 		ResultSet rs = cc.s.executeQuery("select profesor.id_profesor from profesor where profesor.nume='"+nume+"' and profesor.prenume='"+prenume+"'");
		ResultSetMetaData rsmd = rs.getMetaData();
		while(rs.next())
		{
			id_prof=rs.getString("id_profesor");
			
			//cursuri.addItem(rs.getString("activitate_predata"));
		}
		
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
     // al 2-lea id de la materie
      try {
  		ResultSet rsss = cc.s.executeQuery("select materie.id_materie from materie where materie.descriere='"+ descriere+ "'");
  					ResultSetMetaData rsmd = rsss.getMetaData();
  					while(rsss.next())
  					{
  						id_materie=rsss.getString("id_materie");
  						
  						//cursuri.addItem(rs.getString("activitate_predata"));
  					}
  					
  				} catch (SQLException e1) {
  					
  					e1.printStackTrace();
  				}
      
      try {
    	  ResultSet rss = cc.s.executeQuery("select student.nume, student.prenume,student.CNP from student, inscriere  where student.id_student=inscriere.id_student and inscriere.id_materie= '"+ id_materie+"' and inscriere.id_profesor= '"+ id_prof+"'");;
    	 			ResultSetMetaData rsmd = rss.getMetaData();
    	 			while(rss.next())
    	 			{
    	 				
                 //    System.out.println(id_prof+" "+id_materie);
                     
    	             y[i][j++]=rss.getString("student.nume");
    	             y[i][j++]=rss.getString("student.prenume");
    	             y[i][j++]=rss.getString("student.CNP");
    	         
    	 				
    	             i++;
    	 			
    	             j=0;
    	 			}
    	 			t1=new JTable(y,x);
    	 		} catch (SQLException e1) {
    	 			
    	 			e1.printStackTrace();
    	 		}
      System.out.println(id_prof+" "+id_materie);
    	     JScrollPane sp = new JScrollPane(t1);
    	     sp.setBounds(70, 40, 600, 200);
    	     tabelDate.add(sp);
	  		//ResultSet rsss = cc.s.executeQuery("select student.nume, student.prenume, student.CNP  from student, inscriere  where student.id_student=inscriere.id_student and inscriere.id_materie= '"+ id_materie+"' and inscriere.id_profesor= '"+ id_prof+"' limit 1");
	  		
      


  
    
   /* afisstud = new JButton("Afisare Studenti");
    afisstud.setBounds(570, 600, 200, 40);
    afisstud.setFocusable(false);
    afisstud.setBackground(Color.BLACK);
 	afisstud.setForeground(Color.WHITE);
    frame.add(afisstud);
    
    afisstud.addActionListener(new ActionListener()
    {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			///new DeleteAdministrator(CNP,nume,profil);
			//new Tabel_studenti(a);
			
			
			
		}
  	  
    });
    */
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
			//new Tabel_studenti(a);
			frame.setVisible(false);
			
			
		}
  	  
    });
    
    
    t1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            JTableMouseClicked(evt);
        }
    } );
    }
    
  
    
   
    private void JTableMouseClicked(java.awt.event.MouseEvent evt)
    {
    	int index=t1.getSelectedRow();
    	TableModel model=t1.getModel();
    	String value1 =model.getValueAt(index,0).toString();
    	String value2= model.getValueAt(index,1).toString();
    	String value3 =model.getValueAt(index,2).toString();
    	
    	
    	new Add_n_student(value1, value2, value3,numm.getText(),prenn.getText());
    	
    
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new Tabel_stud_curs(null,null,null);
    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
