
package jdbc;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateProfesor implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1,lab2;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b,b1,b2; 
    String id_emp;

  public  UpdateProfesor(String nume,String prenume,String CNP){
        f=new JFrame("Update Profesor details");
        f.setSize(900,650);
        f.setLocation(450,150);
        f.setBackground(Color.white);
        f.setLayout(null);

        JLabel l1 = new JLabel("Dati CNP-ul");
        l1.setBounds(50,100,500,30);
        l1.setFont(new Font("serif",Font.ITALIC,20));
        f.add(l1);
        
        t12 = new JTextField();
        t12.setBounds(500,100,200,30);
        f.add(t12);
        

        
        id8 = new JLabel("Update Profesor Details:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,40));
        id8.setForeground(Color.black);
        f.add(id8);


        id1 = new JLabel("Nume");
        id1.setBounds(50,170,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        f.add(id1);

        t1=new JTextField();
        t1.setBounds(200,170,150,30);
        f.add(t1);

        id2 = new JLabel("Prenume");
        id2.setBounds(400,170,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        f.add(id2);

        t2=new JTextField();
        t2.setBounds(600,170,150,30);
        f.add(t2);

        id3= new JLabel("Adresa");
        id3.setBounds(50,220,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        f.add(id3);

        t3=new JTextField();
        t3.setBounds(200,220,150,30);
        f.add(t3);

        id4= new JLabel("Nr. telefon");  
        id4.setBounds(400,220,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        f.add(id4);

        t4=new JTextField();
        t4.setBounds(600,220,150,30);
        f.add(t4);

        id5= new JLabel("Email");
        id5.setBounds(50,270,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        f.add(id5);

        t5=new JTextField();
        t5.setBounds(200,270,150,30);
        f.add(t5);

        id6= new JLabel("IBAN");
        id6.setBounds(400,270,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        f.add(id6);

        t6=new JTextField();
        t6.setBounds(600,270,150,30);
        f.add(t6);

        
        b = new JButton("Actualizare");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,520,150,40);
        
        f.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,520,150,40);
        
        f.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
    }



    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            try{
                WConnection con = new WConnection();
                String str = "update profesor set nume='"+t1.getText()+"',prenume='"+t2.getText()+"',adresa='"+t3.getText()+"', nr_telefon='"+t4.getText()+"',email='"+t5.getText()+"',IBAN='"+t6.getText()+"' where CNP='"+t12.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new ProfDetails(t1.getText(),t2.getText(),t12.getText(),t1.getText(),t2.getText());
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            //new Project().setVisible(true);
        }
        
    }

    public static void main(String[] arg){
        new UpdateProfesor(null,null,null).f.setVisible(true);
    }
}