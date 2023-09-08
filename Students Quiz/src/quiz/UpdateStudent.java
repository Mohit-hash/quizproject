package quiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
  
    JTextField tfname, tfusername, tfpassword, tfstatus, tfscore;
    JLabel lblempId;
    JButton add, back;
   
	String uname;
    
    UpdateStudent(String uname) {
        this.uname = uname;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(320, 30, 800, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 53));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(100, 200, 200, 50);
        labelname.setFont(new Font("Lithograph", Font.BOLD, 40));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setFont(new Font("Lithograph", Font.BOLD, 40));
        tfname.setBounds(370, 200, 300, 50);
        add(tfname);
             
       
        
        JLabel labeladdress = new JLabel("Password");
        labeladdress.setBounds(100, 300, 200, 50);
        labeladdress.setFont(new Font("Lithograph", Font.BOLD, 40));
        add(labeladdress);
        
        tfpassword = new JTextField();
        tfpassword.setFont(new Font("Lithograph", Font.BOLD, 40));
        tfpassword.setBounds(370, 300, 300, 50);
        add(tfpassword);
        
        JLabel labelstatus = new JLabel("Status");
        labelstatus.setBounds(100, 400, 200, 50);
        labelstatus.setFont(new Font("Lithograph", Font.BOLD, 40));
        add(labelstatus);
        
        tfstatus = new JTextField();
        tfstatus.setFont(new Font("Lithograph", Font.BOLD, 40));
        tfstatus.setBounds(370, 400, 300, 50);
        add(tfstatus);
        
        JLabel labelscore = new JLabel("Score");
        labelscore.setBounds(700, 200, 200, 60);
        labelscore.setFont(new Font("Lithograph", Font.BOLD, 40));
        add(labelscore);
        
        tfscore = new JTextField();
        tfscore.setFont(new Font("Lithograph", Font.BOLD, 40));
        tfscore.setBounds(840, 200, 100, 60);
        add(tfscore);
        
        JLabel labelempId = new JLabel("Username:");
        labelempId.setBounds(770, 350, 240, 30);
        labelempId.setFont(new Font("Lithograph", Font.BOLD, 40));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(770, 410, 250, 30);
        lblempId.setFont(new Font("Lithograph", Font.BOLD, 40));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from feereport_accountant where username = '"+uname+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
            	tfname.setText(rs.getString("name"));
                lblempId.setText(rs.getString("username"));
                tfpassword.setText(rs.getString("password"));
                tfstatus.setText(rs.getString("status"));
                tfscore.setText(rs.getString("score"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(700, 550, 260,60);
        add.setFont(new Font("Lithograph", Font.BOLD, 27));
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(300, 550, 200,60);
        back.setFont(new Font("Lithograph", Font.BOLD, 27));
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(1300, 800);
        setLocation(300, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String username = lblempId.getText();
            String password = tfpassword.getText();
            String status = tfstatus.getText();
            String score = tfscore.getText();
         
            
            try {
                Conn conn = new Conn();
                String query = "update feereport_accountant set name = '"+name+"', password = '"+password+"', status = '"+status+"', score = "+score+" where username = '"+uname+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                dispose();
                new AdminHome();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            
            new AdminHome();
            dispose();
        }
    }

    public static void main(String[] args) {
        new UpdateStudent("hcltb0403796");
    }
}