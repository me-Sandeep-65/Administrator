
package administrator;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class admin extends JFrame{
    public admin(String s){
        JLabel j=new JLabel(s);
        add(j);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 200, 200);
        setVisible(true);
    }
    
}
