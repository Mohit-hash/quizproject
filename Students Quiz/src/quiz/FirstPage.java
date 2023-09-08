package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FirstPage extends JFrame implements ActionListener{
    
	JButton login;
	JButton login1,exit;
    FirstPage() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("WELCOME");
        heading.setBounds(430, 180, 300, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 52));
        heading.setForeground(Color.RED);
        add(heading);
        
        
        login = new JButton("STUDENT LOGIN");
        login.setBounds(80, 100, 298, 60);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Lithograph", Font.BOLD, 27));
        login.addActionListener(this);
        add(login);
       
        login1 = new JButton("ADMIN LOGIN");
        login1.setBounds(135, 190, 200, 60);
        login1.setFont(new Font("Lithograph", Font.BOLD, 25));
        login1.setBackground(Color.BLACK);
        login1.setForeground(Color.WHITE);
        login1.addActionListener(this);
        add(login1);
        
        
        exit = new JButton("EXIT");
        exit.setBounds(170, 280, 98, 60);
        exit.setFont(new Font("Lithograph", Font.BOLD, 20));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 15, 350, 350);
        //add(image);
        
        
        
        
        setSize(800, 450);
        setLocation(650, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        while(true) {
          heading.setVisible(false);
          try {
              Thread.sleep(500);
          } catch (Exception e){
              
          }
          
          heading.setVisible(true);
          try {
              Thread.sleep(500);
          } catch (Exception e){
              
          }
      }
    }
    
    public void actionPerformed(ActionEvent ae) {
    	 if (ae.getSource() == login) {
    		
    		 new StudentLogin();
    		 dispose();
    		
    		}
    	 else if (ae.getSource() == login1) {
    		 new AdminLogin();
    		 dispose();
    		
    	 }
    	 else {
    		 dispose();
    		 Runtime.getRuntime().halt(0);
    		 //System.exit(EXIT_ON_CLOSE);
    	 }
    	
    }
    
    public static void main(String[] args) {
        new FirstPage();
    }
}