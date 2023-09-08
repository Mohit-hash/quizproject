package quiz;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveStudent extends JFrame implements ActionListener {
    
    Choice cUsername;
    JButton delete, back;
    
    RemoveStudent() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Delete Selected Student");
        heading.setBounds(400, 13, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.black);
        add(heading);
        
        
        JLabel labelempId = new JLabel("Username");
        labelempId.setFont(new Font("Lithograph", Font.BOLD, 30));
        labelempId.setBounds(130, 130, 200, 60);
        add(labelempId);
        
        cUsername = new Choice();
        cUsername.setFont(new Font("Lithograph", Font.BOLD, 30));
        cUsername.setBounds(350, 130, 250, 60);
        add(cUsername);
        
        try {
            Conn c = new Conn();
            String query = "select * from feereport_accountant";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cUsername.add(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setFont(new Font("Lithograph", Font.BOLD, 30));
        labelname.setBounds(130, 230, 200, 60);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setFont(new Font("Lithograph", Font.BOLD, 30));
        lblname.setBounds(300, 230, 200, 60);
        add(lblname);
        
        JLabel labelphone = new JLabel("Status");
        labelphone.setFont(new Font("Lithograph", Font.BOLD, 30));
        labelphone.setBounds(130, 330, 200, 60);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setFont(new Font("Lithograph", Font.BOLD, 30));
        lblphone.setBounds(300, 330, 250, 60);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Score");
        labelemail.setFont(new Font("Lithograph", Font.BOLD, 30));
        labelemail.setBounds(130, 430, 200, 60);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setFont(new Font("Lithograph", Font.BOLD, 30));
        lblemail.setBounds(300, 430, 200, 60);
        add(lblemail);
        
        try {
            Conn c = new Conn();
            String query = "select * from feereport_accountant where username = '"+cUsername.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("status"));
                lblemail.setText(rs.getString("score"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cUsername.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from feereport_accountant where username = '"+cUsername.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("status"));
                        lblemail.setText(rs.getString("score"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(340, 550, 200,60);
        delete.setFont(new Font("Lithograph", Font.BOLD, 27));
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(70, 550, 200,60);
        back.setFont(new Font("Lithograph", Font.BOLD, 27));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(700, 160, 400, 400);
        add(image);
        
        setSize(1300, 800);
        setLocation(300, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from feereport_accountant where username = '"+cUsername.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student's Information Deleted Sucessfully");
                new AdminHome();
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new AdminHome();
            dispose();
            
        }
    }

    public static void main(String[] args) {
        new RemoveStudent();
    }
}
