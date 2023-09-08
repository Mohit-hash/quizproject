package quiz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Score extends JFrame implements ActionListener {

	String name;
	int score;
	Score(String name, int score) {
		this.name = name;
		this.score=score;
        setBounds(400, 150, 950, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(5, 100, 300, 250);
        add(image);
        
        JLabel heading = new JLabel("Quiz Is Over");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);
        
        JLabel lblscore = new JLabel("Hi "+name+"! Your score is " + score);
        lblscore.setBounds(400, 200, 1200, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 35));
        add(lblscore);
        
        JButton submit = new JButton("EXIT");
        submit.setBounds(470, 270, 220, 60);
        submit.setFont(new Font("Lithograph", Font.BOLD, 35));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
       
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
       
        try {
            
            Conn c = new Conn();
            String query = "UPDATE feereport_accountant SET score="+score+", status = 'Attempted' where name = '"+name+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
            	
            	
                setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(null, "Scores Not Updated");
                setVisible(false);
            }
     } catch (Exception e) {
        e.printStackTrace();
    }
        
    }

    public static void main(String[] args) {
    	new Score("User", 30);
    }
}