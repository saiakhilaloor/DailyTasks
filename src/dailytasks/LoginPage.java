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
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author akhil
 */
public class LoginPage {
    void run(){
        JFrame frame = new JFrame("Login to DailyTasks");
        frame.setSize(1300, 670);
        frame.setLayout(null);
        frame.setLocation(15, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Login to DailyTasks");
        title.setLocation(380, 80);
        title.setSize(600,200);
        title.setFont(new Font("Bodoni",Font.BOLD,40));
        frame.add(title);     
        
        JLabel name = new JLabel("Username :");
        name.setLocation(400, 180);
        name.setSize(600,200);
        name.setFont(new Font("Bodoni",Font.BOLD,25));
        frame.add(name);
        
        JTextField text = new JTextField();
        text.setColumns(50);
        text.setSize(200,30);
        text.setLocation(600, 270);
        text.setToolTipText("Enter username");
        frame.add(text);
        
        JLabel pass = new JLabel("Password :");
        pass.setLocation(400, 250);
        pass.setSize(600,200);
        pass.setFont(new Font("Bodoni",Font.BOLD,25));
        frame.add(pass);
        
        JPasswordField text1 = new JPasswordField();
        text1.setColumns(50);
        text1.setSize(200,30);
        text1.setLocation(600, 335);
        text1.setToolTipText("Enter Password");
        frame.add(text1);
        
        JButton b1 = new JButton("Login");
        b1.setSize(150,40);
        b1.setLocation(550, 420);
        frame.add(b1);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dailytasks", "root", "");
                    Statement st = con.createStatement();
                    ResultSet rs;
                    String query;
                    String uname,passwd;
                    uname = text.getText();
                    passwd = "";
                    char[] pwdtemp = (char[])text1.getPassword();
                    for(int i=0;i<pwdtemp.length;++i) {
                        passwd += pwdtemp[i];
                    }
                    query = "select * from user_info where username = '"+uname+"'";
                    rs = st.executeQuery(query);
                    if(rs.next()){
                        String pass = rs.getString(3);
                        if(pass.equals(passwd)){
                            JOptionPane.showMessageDialog(null, "Login Successful.");
                            frame.setVisible(false);
                            Homepage h = new Homepage(uname);
                            h.run();
                        }else{
                            JOptionPane.showMessageDialog(null, "Wrong Password");
                            text1.setText("");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid ID.");
                        text.setText("");
                        text1.setText("");
                    }
                } catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });
        
        frame.setVisible(true);
    }
}
