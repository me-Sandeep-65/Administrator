
package administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Administrator extends JFrame implements ActionListener{
    static JLabel l1;
    static JButton b1;
//    static Dimension frameSize;
    static JLabel lid;
    static ImageIcon i1;
    
    public Administrator(){
        super("Administration");
        
        setSize(1366,830);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setContentPane(300,300,1366,390);   frame size
//        setLayout(null);
//        setLocation(100,100);    
            
//        frameSize = getSize();
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        setLocation((screenSize.width - frameSize.width) >> 1, (screenSize.height - frameSize.height) >> 1);
          setLocationRelativeTo(null);

        l1 = new JLabel("");
        b1 = new JButton("Next");
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        
        i1  = new ImageIcon(ClassLoader.getSystemResource("administrator/icons/first.jpg"));
        Image i3 = i1.getImage().getScaledInstance(getSize().width+20, getSize().height+20,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
            
        lid=new JLabel("DATABASE MANAGEMENT SYSTEMS PROJECT");
//        lid.setBounds(30,300,1500,100);
//        lid.setFont(new Font("serif",Font.BOLD ,40));
        lid.setForeground(Color.white);
        l1.add(lid);
       
//        b1.setBounds(frameSize.width-frameSize.width/5,frameSize.height-frameSize.height/5,150,50);
//        l1.setBounds(frameSize.width >>1, frameSize.height >>1, frameSize.width, frameSize.height);
        
        l1.add(b1);
        add(l1);
        b1.addActionListener(this);
        addComponentListener(new ComponentListener(){
            @Override
            public void componentHidden(ComponentEvent e){}
            @Override
            public void componentShown(ComponentEvent e){}
            @Override
            public void componentMoved(ComponentEvent e){}
            @Override
            public void componentResized(ComponentEvent e){
                b1.setBounds((e.getComponent().getSize().width)-(e.getComponent().getSize().width/4),(e.getComponent().getSize().height)-(e.getComponent().getSize().height/4),e.getComponent().getSize().width/10,e.getComponent().getSize().height/18 );
                l1.setBounds(0, 0, e.getComponent().getSize().width, e.getComponent().getSize().height); 
                lid.setBounds(e.getComponent().getSize().width/20, e.getComponent().getSize().height/3, e.getComponent().getSize().width, e.getComponent().getSize().height/10);
                lid.setFont(new Font("serif",Font.BOLD ,(e.getComponent().getSize().width + e.getComponent().getSize().height)/70));
                b1.setFont(new Font("serif",Font.BOLD ,(b1.getWidth() + b1.getHeight())/8));
            }
        });
        setVisible(true);
        validate();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        new login(this).setVisible(true);
    }
        
    public static void main(String[] args) {
        Administrator window = new Administrator();
        window.setVisible(true);
    }
}

