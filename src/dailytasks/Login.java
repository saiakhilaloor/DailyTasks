/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailytasks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author akhil
 */
public class Login {
    void run(){
        JFrame frame = new JFrame("DailyTasks");
        frame.setSize(1300, 670);
        frame.setLayout(null);
        frame.setLocation(15, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Welcome to DailyTasks");
        title.setLocation(400, 120);
        title.setSize(600,200);
        title.setFont(new Font("Bodoni",Font.BOLD,40));
        frame.add(title);
        
        JButton b1 = new JButton("Login");
        b1.setSize(200,40);
        b1.setLocation(550, 320);
        frame.add(b1);
        
        JButton b2 = new JButton("Signup");
        b2.setSize(200,40);
        b2.setLocation(550,400);
        frame.add(b2);
        
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                LoginPage l = new LoginPage();
                l.run();
                frame.setVisible(false);
            }
        });
        
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Signup s = new Signup();
                s.run();
                frame.setVisible(false);
            }
        });
        
        frame.setVisible(true);
    }
}
