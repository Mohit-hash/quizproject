package quiz;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewStudent extends JFrame implements ActionListener{

    JTable table;
    Choice cusername;
    JButton search, print, update, back;
    
    ViewStudent() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search by Username");
        searchlbl.setFont(new Font("Lithograph", Font.BOLD, 30));
        searchlbl.setBounds(20, 50, 330, 60);
        add(searchlbl);
        
        cusername = new Choice();
        cusername.setFont(new Font("Lithograph", Font.BOLD, 30));
        cusername.setBounds(380, 50, 250, 60);
        add(cusername);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from feereport_accountant");
            while(rs.next()) {
                cusername.add(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            Conn c = new Conn();
       
            ResultSet rs = c.s.executeQuery("select * from feereport_accountant");
            table.setRowHeight(30);
            table.setFont(new Font("Lithograph", Font.BOLD, 30));
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 200, 1500, 950);
        add(jsp);
        
        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Lithograph", Font.BOLD, 23));
        search.setBounds(100, 140, 160, 40);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setFont(new Font("Lithograph", Font.BOLD, 23));
        print.setBounds(300, 140,160, 40);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Lithograph", Font.BOLD, 23));
        update.setBounds(700, 140, 160, 40);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Lithograph", Font.BOLD, 23));
        back.setBounds(500, 140, 160, 40);
        back.addActionListener(this);
        add(back);
        
        setSize(1500, 950);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from feereport_accountant where username = '"+cusername.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
           
            new UpdateStudent(cusername.getSelectedItem());
            dispose();
        } else {
            
            new AdminHome();
            dispose();
        }
    }

    public static void main(String[] args) {
        new ViewStudent();
    }
}