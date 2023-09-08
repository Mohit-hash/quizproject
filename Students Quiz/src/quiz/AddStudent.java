package quiz;

import java.awt.*;
import javax.swing.*;

import java.util.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddStudent extends JFrame implements ActionListener{
    
   
    
    JTextField tfname, tfusername, tfpassword;
    JLabel lblempId;
    JButton add, back;
    
    AddStudent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Student Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 46);
        labelname.setFont(new Font("serif", Font.PLAIN, 45));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setFont(new Font("serif", Font.PLAIN, 41));
        tfname.setBounds(420, 150, 260, 46);
        add(tfname);
        
        JLabel labelfname = new JLabel("Username");
        labelfname.setBounds(50, 240, 210, 46);
        labelfname.setFont(new Font("serif", Font.PLAIN, 45));
        add(labelfname);
        
        tfusername = new JTextField();
        tfusername.setFont(new Font("serif", Font.PLAIN, 41));
        tfusername.setBounds(420, 240, 260, 46);
        add(tfusername);
             
      
        
        JLabel labeladdress = new JLabel("Password");
        labeladdress.setBounds(50, 330, 210, 46);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 45));
        add(labeladdress);
        
        tfpassword = new JTextField();
        tfpassword.setFont(new Font("serif", Font.PLAIN, 41));
        tfpassword.setBounds(420, 330, 260, 46);
        add(tfpassword);
        
        
        
        add = new JButton("Add Details");
        add.setBounds(180, 550, 270, 50);
        add.setFont(new Font("Lithograph", Font.BOLD, 38));
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setFont(new Font("Lithograph", Font.BOLD, 38));
        back.setBounds(530, 550, 210, 50);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String username = tfusername.getText();
            String password = tfpassword.getText();
 
            try {
            	Conn conn = new Conn();
            	ResultSet rs = conn.s.executeQuery("select * from feereport_accountant where username='"+username+"'");
            	if(rs.next()) {
            		setVisible(false);
            		JOptionPane.showMessageDialog(null, "Username Already Exist! Try differnet Username");
            		new AddStudent();
            		
            	}
            	else { 
            try {
                
                String query = "insert into feereport_accountant values('"+name+"', '"+username+"', '"+password+"', 'Not Attempted', 0)";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new AdminHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
           
            	}}
            catch(Exception e) {
            	e.printStackTrace();
            }
        } else {
          
            new AdminHome();
            dispose();
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
