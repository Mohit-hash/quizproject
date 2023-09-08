package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondPage extends JFrame implements ActionListener {
	
	String name;

    
    SecondPage(String name) {
    	this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("LET'S TAKE A QUIZ - "+name+"!");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 750);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(380, 630, 350, 70);
        clickhere.setFont(new Font("Lithograph", Font.BOLD, 23));
        clickhere.setBackground(Color.white);
        clickhere.setForeground(Color.black);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setSize(1170, 900);
        setLocation(350, 50);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        while(true) {
//            heading.setVisible(false);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//                
//            }
//            
//            heading.setVisible(true);
//            try {
//                Thread.sleep(500);
//            } catch (Exception e){
//                
//            }
//        }
   }
    
    public void actionPerformed(ActionEvent ae) {
  
        new Instructions(name);
        dispose();
      
    }
    
    public static void main(String args[]) {
        new SecondPage("User");
    }
}