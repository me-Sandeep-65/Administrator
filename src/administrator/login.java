
package administrator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener, WindowListener{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
    JFrame fr;
    
    login(JFrame f){

        super("Login");

        fr=f;
        fr.setEnabled(false);
        setLayout(null);
        setResizable(false);

        l1 = new JLabel("Username");
        l1.setBounds(40,40,100,30);
        add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(40,90,100,30);
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,40,150,30);
        t1.setFont(new Font("serif",Font.PLAIN,15));
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,90,150,30);
        t2.setFont(new Font("serif",Font.PLAIN,15));
        t2.setEchoChar('*');
        add(t2);
        
//        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("administrator/icons/eye_icon2.png"));
        ImageIcon i3 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("administrator/icons/eye_icon2.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        b3 = new JButton(i3);
        b3.setBackground(Color.WHITE);
        b3.setBounds(310,90,30,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("administrator/icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        i1 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i1);
        l3.setBounds(390,40,150,150);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(40,180,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,180,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);

        setSize(600,300);
        setLocationRelativeTo(null);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setLocation((screenSize.width-this.getWidth())>>1, (screenSize.height-this.getHeight())>>1);
        addWindowListener(this);
        setVisible(true);
    }
    
    @Override
    public void windowDeactivated(WindowEvent e){}
    @Override
    public void windowActivated(WindowEvent e){}
    @Override
    public void windowDeiconified(WindowEvent e){}
    @Override
    public void windowIconified(WindowEvent e){}
    @Override
    public void windowClosed(WindowEvent e){}
    @Override
    public void windowClosing(WindowEvent e){
        fr.setEnabled(true);
    }
    @Override
    public void windowOpened(WindowEvent e){}
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Connection c1 = new Connection();
                String u = t1.getText();
                String v = t2.getText();
            
                String q = "select role from login where username='"+u+"' and password='"+v+"'";
                
                ResultSet rs = c1.s.executeQuery(q); 
                if(rs.next()){
                    String s=rs.getString("role");
                    if(s.equals("admin")) {
                        new admin(s);
                    }
                    else if(s.equals("library")){
                        new library(s);
                    }
                    
                    fr.dispose();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==b2){
            fr.setEnabled(true);
            dispose();
        }
        else{
            if(t2.getEchoChar()=='*'){
                t2.setEchoChar((char) 0);
                ImageIcon i3 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("administrator/icons/eye_icon1.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                b3.setIcon(i3);
            }
            else{
                t2.setEchoChar('*');
                ImageIcon i3 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("administrator/icons/eye_icon2.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
                b3.setIcon(i3);
            }
        }
    }
    
    public static void main(String args []){
          
    }
}

