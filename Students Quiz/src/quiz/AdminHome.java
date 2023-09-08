package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminHome extends JFrame implements ActionListener{

    JButton removeicon, addicon, viewicon, updateicon;
    JButton view, add, update, remove, logout;
    
    
    AdminHome() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/main.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 950, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1500, 950);
        add(image);
        
        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(320, 30, 820, 60);
        heading.setFont(new Font("Raleway", Font.BOLD, 55));
        image.add(heading);
        
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/create.jpeg"));
        Image i21 = i11.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        ImageIcon i31 = new ImageIcon(i21);
        addicon = new JButton(i31);
        addicon.setBounds(182,108,i31.getIconWidth(),i31.getIconHeight());
        //image.add(addicon);
       

        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpeg"));
        Image i211 = i111.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        ImageIcon i311 = new ImageIcon(i211);
        viewicon = new JButton(i311);
        viewicon.setBounds(380,108,i311.getIconWidth(),i311.getIconHeight());
        //image.add(viewicon);
        
        ImageIcon i1111 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpeg"));
        Image i2111 = i1111.getImage().getScaledInstance(165, 165, Image.SCALE_DEFAULT);
        ImageIcon i3111 = new ImageIcon(i2111);
        updateicon = new JButton(i3111);
        updateicon.setBounds(580,108,i3111.getIconWidth(),i3111.getIconHeight());
       // image.add(updateicon);
        
        ImageIcon i11111 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpeg"));
        Image i21111 = i11111.getImage().getScaledInstance(165, 165, Image.SCALE_DEFAULT);
        ImageIcon i31111 = new ImageIcon(i21111);
        removeicon = new JButton(i31111);
        removeicon.setBounds(770,108,i31111.getIconWidth(),i31111.getIconHeight());
       // image.add(removeicon);
        
        add = new JButton("Add Student");
        add.setBounds(260, 450, 230, 40);
        add.setFont(new Font("Lithograph", Font.BOLD, 25));
        add.setBackground(Color.WHITE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Student");
        view.setBounds(510, 450, 230, 40);
        view.setFont(new Font("Lithograph", Font.BOLD, 25));
        view.setBackground(Color.WHITE);
        view.setForeground(Color.BLACK);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Student");
        update.setBounds(775, 450, 230, 40);
        update.setFont(new Font("Lithograph", Font.BOLD, 25));
        update.setBackground(Color.WHITE);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Student");
        remove.setBounds(1050, 450, 230, 40);
        remove.setFont(new Font("Lithograph", Font.BOLD, 25));
        remove.setBackground(Color.WHITE);
        remove.setForeground(Color.BLACK);
        remove.addActionListener(this);
        image.add(remove);
        
        logout = new JButton("LOGOUT");
        logout.setBounds(1190, 750, 190, 40);
        logout.setFont(new Font("Lithograph", Font.BOLD, 25));
        logout.setBackground(Color.WHITE);
        logout.setForeground(Color.BLACK);
        logout.addActionListener(this);
        image.add(logout);
        
        setSize(1500, 950);
        setLocation(200, 35);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == view) {
        	 
        	 new ViewStudent();
        	 dispose();
        	 
        } else if (ae.getSource() == add) {
        	
        	new AddStudent();
        	dispose();
        } else if (ae.getSource() == update) {
        	
            new ViewStudent();
            dispose();
        } else if (ae.getSource() == remove) {
        	 new RemoveStudent();
        	dispose();
           
        }
        else {
        	
        	new AdminLogin();
        	dispose();
        }
        
    }

    public static void main(String[] args) {
        new AdminHome();
    }
}