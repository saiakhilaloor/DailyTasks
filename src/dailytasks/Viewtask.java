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

/**
 *
 * @author akhil
 */
public class Viewtask {
    String task,user;
    public Viewtask(String a, String b){
        task = a;
        user = b;
    }
    
    void run(){
        JFrame frame = new JFrame();
        frame.setSize(1300, 670);
        frame.setLayout(null);
        frame.setLocation(15, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel(task);
        title.setLocation(500, 100);
        title.setSize(700,200);
        title.setFont(new Font("Garamond",Font.BOLD,40));
        frame.add(title); 
        
        try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dailytasks", "root", "console.log()");
                    Statement st = con.createStatement();
                    ResultSet rs;
                    String query;
                    String desc;

                    query = "select * from tasks where title ='"+task+"' and user='"+user+"'";  
                    rs = st.executeQuery(query);
                    if(rs.next()){
                        desc = rs.getString(2);
                        JLabel l = new JLabel("<html>"+desc+"</html>");
                        l.setLocation(400, 180);
                        l.setSize(400,200);
                        l.setFont(new Font("Tahoma",Font.ITALIC,20));
                        frame.add(l); 
                        
                        JButton b = new JButton("Mark as finished");
                        b.setSize(200,30);
                        b.setLocation(450,350);
                        frame.add(b);
                        
                        b.addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String query;
                            query = "delete from tasks where title = '"+task+"'";
                            try {
                                st.execute(query);
                            } catch (SQLException ex) {
                                Logger.getLogger(Viewtask.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Managetasks m =  new Managetasks(user);
                            m.run();
                            frame.setVisible(false);
                        }
                        });
                        
                        JButton b1 = new JButton("Back");
                        b1.setSize(200,30);
                        b1.setLocation(650,350);
                        frame.add(b1);
                        
                        b1.addActionListener(new ActionListener(){

            @Override
                        public void actionPerformed(ActionEvent e) {    
                        Managetasks m = new Managetasks(user);
                        m.run();
                        frame.setVisible(false);
                        }   
                    });
                    }
                  
                } catch (Exception ex){
                    System.out.println(ex);
                }
        
        System.out.println(user);
        System.out.println(task);
        frame.setVisible(true);
    }
}
