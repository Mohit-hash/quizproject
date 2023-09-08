package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions extends JFrame implements ActionListener{

    String name;
    JButton start, back;
    
    Instructions(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ALL THE BEST");
        heading.setBounds(250, 30, 700, 40);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 37));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 800, 450);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 24));
        rules.setText(
            "<html>"+ 
            	"                INSTRUCTIONS" + "<br><br>" +
                "1. You will have 25 seconds for each question" + "<br><br>" +
                "2. You will have total 10 questions" + "<br><br>" +
                "3. Each question will have 10 points" + "<br><br>" +
                "4. You can use 50-50 LifeLine which will disable 2 wrong answer" + "<br><br>" +
            "<html>"
        );
        add(rules);
        
     
        
        start = new JButton("Start");
        start.setBounds(300, 490, 150, 60);
        start.setFont(new Font("Tahoma", Font.PLAIN, 30));
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
           new Quiz(name);
        } else {
            setVisible(false);
           
        }
    }
    
    public static void main(String[] args) {
        new Instructions("User");
    }
}