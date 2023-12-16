
package administrator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class library extends JFrame{
    
    public library(String s){
        JMenuBar menubar=new JMenuBar();
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100, 100, 200, 200);
        setVisible(true);
    }
}
