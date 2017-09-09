/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailytasks;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author akhil
 */
public class Signup {
    void run(){
        JFrame frame = new JFrame("Signup for DailyTasks");
        frame.setSize(1300, 670);
        frame.setLayout(null);
        frame.setLocation(15, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Signup for DailyTasks");
        title.setLocation(370, 20);
        title.setSize(600,200);
        title.setFont(new Font("Bodoni",Font.BOLD,40));
        frame.add(title);   
        
        JLabel email = new JLabel("Email-Id    :");
        email.setLocation(400, 113);
        email.setSize(600,200);
        email.setFont(new Font("Bodoni",Font.BOLD,25));
        frame.add(email);
        
        JTextField text2 = new JTextField();
        text2.setColumns(50);
        text2.setSize(200,30);
        text2.setLocation(600, 200);
        text2.setToolTipText("Enter email id");
        frame.add(text2);
        
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
        
        JTextField text1 = new JTextField();
        text1.setColumns(50);
        text1.setSize(200,30);
        text1.setLocation(600, 335);
        text1.setToolTipText("Enter Password");
        frame.add(text1);
        
        JLabel mob = new JLabel("Phone No :");
        mob.setLocation(400, 320);
        mob.setSize(600,200);
        mob.setFont(new Font("Bodoni",Font.BOLD,25));
        frame.add(mob);
        
        JTextField text3 = new JTextField();
        text3.setColumns(50);
        text3.setSize(200,30);
        text3.setLocation(600, 400);
        text3.setToolTipText("Enter Mobile Number");
        frame.add(text3);
        
        JButton b1 = new JButton("Signup");
        b1.setSize(150,40);
        b1.setLocation(550, 470);
        frame.add(b1);
        
        frame.setVisible(true);
    }
}
