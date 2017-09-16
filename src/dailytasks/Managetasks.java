/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailytasks;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author akhil
 */
public class Managetasks {
    
    String user;
    public Managetasks(String a){
        user = a;
    }
    
    void run() {
        JFrame frame = new JFrame();
        frame.setSize(1300, 670);
        frame.setLayout(null);
        frame.setLocation(15, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JLabel title =  new JLabel("Create a task");
        title.setLocation(80,00);
        title.setSize(300,100);
        frame.add(title);
        
        JLabel l1 = new JLabel("Title :");
        l1.setLocation(80,30);
        l1.setSize(100,100);
        frame.add(l1);
        
        JTextField text = new JTextField();
        text.setColumns(50);
        text.setSize(200,30);
        text.setLocation(80, 100);
        text.setToolTipText("Enter a title for the Task");
        frame.add(text);
        
        JLabel l2 = new JLabel("Description :");
        l2.setLocation(80,90);
        l2.setSize(100,100);
        frame.add(l2);
        
        JTextArea text1 = new JTextArea();
        text1.setBounds(10,10,300,80);
        text1.setLocation(80, 150);
        text1.setToolTipText("Enter description of the Task");
        frame.add(text1);
        
        JButton b1 = new JButton("Logout");
        b1.setSize(100,30);
        b1.setLocation(1100,30);
        frame.add(b1);
        
        JButton b2 = new JButton("Save");
        b2.setSize(80,25);
        b2.setLocation(80,250);
        frame.add(b2);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dailytasks", "root", "console.log()");
            Statement st = con.createStatement();
            ResultSet rs;
            String query;
        
            query = "select * from tasks where user = '"+user+"'";  
            rs = st.executeQuery(query);
            int i=1;
            int j = 100;
            int x =65;
            while(rs.next()){
                String s = rs.getString(1);
                JLabel l = new JLabel(i+".");
                l.setLocation(560,x);
                l.setSize(100,100);
                frame.add(l);
                i++;
                x+=40;
                JButton b = new JButton(s);
                b.setSize(300,30);
                b.setLocation(580,j);
                frame.add(b);
        
                j+=40;
            b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Viewtask v = new Viewtask(s,user);
                v.run();
               // System.out.println(s);
               frame.setVisible(false);
            }
        });
            }
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dailytasks", "root", "console.log()");
                    Statement st = con.createStatement();
                    ResultSet rs;
                    String query;
                    String titl,desc;
                    titl = text.getText();
                    desc = text1.getText();
                    
                    query = "Insert into tasks values('"+titl+"','"+desc+"','"+user+"')";  
                    st.execute(query);
                    
                  
                } catch (Exception ex){
                    System.out.println(ex);
                }
                Managetasks m = new Managetasks(user);
               
                    m.run();
               
                frame.setVisible(false);
            }
            
        });
        JLabel title1 = new JLabel("Your Task list");
        title1.setLocation(580,00);
        title1.setSize(300,100);
        frame.add(title1);
        
        b1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logged Out Successfully");
                Login l = new Login();
                l.run();
                frame.setVisible(false);
            }
        });
        
        frame.setVisible(true);
    }
    
}
