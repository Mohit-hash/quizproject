package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
    AdminLogin() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        

        JLabel heading = new JLabel("ADMIN LOGIN");
        heading.setBounds(170, 8, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 35));
        heading.setForeground(Color.black);
        add(heading);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Lithograph", Font.BOLD, 25));
        lblusername.setBounds(90, 90, 200, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setFont(new Font("Lithograph", Font.BOLD, 25));
        tfusername.setBounds(250, 90, 180, 40);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(90, 160, 200, 30);
        lblpassword.setFont(new Font("Lithograph", Font.BOLD, 25));
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setFont(new Font("Lithograph", Font.BOLD, 25));
        tfpassword.setBounds(250, 150, 180, 40);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 240, 200, 60);
        login.setFont(new Font("Lithograph", Font.BOLD, 25));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 15, 350, 350);
        add(image);
        
        setSize(800, 450);
        setLocation(650, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
    	String username = tfusername.getText();
        String password = tfpassword.getText();
        System.out.println(username);
        System.out.println(password);
        if(true) {
        	setVisible(false);
        	new AdminHome();
        }
        else {
        	JOptionPane.showMessageDialog(null, "Invalid username or password");
            setVisible(false);
        }
    	
    	
        
    }
    
    public static void main(String[] args) {
        new AdminLogin();
    }
}