
package administrator;

import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class admin extends JFrame implements ActionListener{
    JMenuItem logout;
    
    public admin(String s){
        super("Library Section");
        JMenuBar menubar=new JMenuBar();
        menubar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        menubar.setAlignmentY(RIGHT_ALIGNMENT);
        ImageIcon i3 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("administrator/icons/second.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        JMenu acc=new JMenu(s);
        acc.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        acc.setIcon(i3);
        JMenu pad=new JMenu("        ");
        pad.setEnabled(false);
        
        JMenuItem name=new JMenuItem("");
        JMenuItem job=new JMenuItem("");
        JMenuItem phone=new JMenuItem("");
        JMenuItem email=new JMenuItem("");
        name.setEnabled(false);
        job.setEnabled(false);
        phone.setEnabled(false);
        email.setEnabled(false);
        logout=new JMenuItem("Log Out");        
        
        try{
            Connection c1=new Connection();
            ResultSet rs = c1.s.executeQuery("select name,job,phone,email from employee where empid='"+s+"'");
            while(rs.next()){
                name.setText("Name: "+rs.getString("name"));
                job.setText("Role: "+rs.getString("job"));
                phone.setText("Mobile: "+rs.getString("phone"));
                email.setText("Email: "+rs.getString("email"));
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        
        logout.addActionListener(this);
        
        acc.add(name);
        acc.add(job);
        acc.add(phone);
        acc.add(email);
        acc.addSeparator();
        acc.add(logout);
        menubar.add(pad);
        menubar.add(acc);
        add(menubar,NORTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1366,830);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==logout){
            dispose();
            new Administrator();
        }
    }

}
