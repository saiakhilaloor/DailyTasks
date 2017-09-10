/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailytasks;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author akhil
 */
public class Homepage {
    
    String user;
    
    public Homepage(String a){
        user = a;
    }
    
    void run(){
        JFrame frame = new JFrame(user);
        frame.setSize(1300, 670);
        frame.setLayout(null);
        frame.setLocation(15, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("Welcome to Daily Tasks "+ user);
        title.setLocation(380, 00);
        title.setSize(700,200);
        title.setFont(new Font("Garamond",Font.ITALIC,30));
        frame.add(title); 
        
        JButton b1 = new JButton("Logout");
        b1.setSize(100,30);
        b1.setLocation(1100,30);
        frame.add(b1);
        
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
