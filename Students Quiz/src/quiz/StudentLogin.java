package quiz;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentLogin extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
   
    StudentLogin() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        

        JLabel heading = new JLabel("STUDENT LOGIN");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/images.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 30, 300, 300);
        add(image);
        
        setSize(800, 450);
        setLocation(650, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
        	String username = tfusername.getText();
            String password = tfpassword.getText();
            
            Conn c = new Conn();
            String query = "select * from feereport_accountant where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
            	String name=rs.getString("name");
            	
            	dispose();
                new SecondPage(name);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                dispose();
                new StudentLogin();
            }
     } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    public static void main(String[] args) {
        new StudentLogin();
    }
}