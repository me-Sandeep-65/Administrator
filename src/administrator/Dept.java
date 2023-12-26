
package administrator;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Dept extends JFrame implements ActionListener{
    String OurDepartment;
    
    JMenuItem logout;
    CardLayout clayout;
    JLabel l2;
    JButton done;
    JButton back;
    
    JLabel tTotal2;
    JList list;
    JTextField getbid;
    
    DefaultListModel model3;
    JList list3;
    
    public Dept(String s){
        super("Department");
        Dimension wSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1366,830);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menubar=new JMenuBar();
        menubar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        menubar.setAlignmentY(RIGHT_ALIGNMENT);
        ImageIcon i3 = new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("administrator/icons/second.jpg")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        JMenu acc=new JMenu(s);
        acc.setToolTipText("Click for more options.");
        acc.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        acc.setIcon(i3);
        JMenu pad=new JMenu("        ");
        pad.setEnabled(false);
        
        JMenuItem name=new JMenuItem("Name: ");
        JMenuItem job=new JMenuItem("Role: ");
        JMenuItem phone=new JMenuItem("Mobile: ");
        JMenuItem email=new JMenuItem("Email: ");
        name.setEnabled(false);
        job.setEnabled(false);
        phone.setEnabled(false);
        email.setEnabled(false);
        logout=new JMenuItem("Log Out");
        Connection c1=new Connection();        
        
        try{
            ResultSet rs = c1.s.executeQuery("select name,job,phone,email,deptid from employee where empid='"+s+"'");
            while(rs.next()){
                name.setText("Name: "+rs.getString("name"));
                job.setText("Role: "+rs.getString("job"));
                phone.setText("Mobile: "+rs.getString("phone"));
                email.setText("Email: "+rs.getString("email"));
                OurDepartment=rs.getString("deptid");
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
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("administrator/icons/first.jpg"));
        Image i4 = i1.getImage().getScaledInstance((int)wSize.getWidth()+30, (int)wSize.getHeight(),Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i4);
        JLabel l1 = new JLabel(i2);
        
        JPanel p1=new JPanel();
        GridBagLayout baglayout=new GridBagLayout();
//        p1.setOpaque(false);
//        p1.setBackground(Color.red);
        p1.setLayout(baglayout);
        GridBagConstraints gbc1=new GridBagConstraints();
        gbc1.fill=GridBagConstraints.HORIZONTAL;
        gbc1.weighty=1;
        gbc1.insets=new Insets(17,10,17,10);
        
        JButton emplo=new JButton("Employee");
        emplo.setBackground(Color.black);
        emplo.setForeground(Color.white);
        gbc1.gridx=0; gbc1.gridy=0;
        p1.add(emplo,gbc1);
        emplo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                 clayout.show(l2,"1");
            }
        });
        
        JButton faculty=new JButton("Faculty");
        faculty.setBackground(Color.black);
        faculty.setForeground(Color.white);
        gbc1.gridx=0; gbc1.gridy=1;
        p1.add(faculty,gbc1);
        faculty.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                 clayout.show(l2,"2");
            }
        });
        
        JButton Courses=new JButton("Courses");
        Courses.setBackground(Color.black);
        Courses.setForeground(Color.white);
        gbc1.gridx=0; gbc1.gridy=2;
        p1.add(Courses,gbc1);
        Courses.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                 clayout.show(l2,"3");
            }
        });
        
        JButton Student=new JButton("Student Info");
        Student.setBackground(Color.black);
        Student.setForeground(Color.white);
        gbc1.gridx=0; gbc1.gridy=3;
        p1.add(Student,gbc1);
        Student.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                 clayout.show(l2,"4");
            }
        });
        
        JButton deptstu=new JButton("Students");
        deptstu.setBackground(Color.black);
        deptstu.setForeground(Color.white);
        gbc1.gridx=0; gbc1.gridy=4;
        p1.add(deptstu,gbc1);
        deptstu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                 clayout.show(l2,"5");
            }
        });
        
//        JButton addsupplier=new JButton("Add Supplier");
//        addsupplier.setBackground(Color.black);
//        addsupplier.setForeground(Color.white);
//        gbc1.gridx=0; gbc1.gridy=5;
//        p1.add(addsupplier,gbc1);
//        addsupplier.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent ae){
//                 clayout.show(l2,"6");
//            }
//        });
        
        gbc1.gridx=1; gbc1.gridy=0; gbc1.gridheight=6;
        i4 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
        i2 = new ImageIcon(i4);
        l2=new JLabel(i2);
        
        clayout=new CardLayout();
        l2.setLayout(clayout);
        
        GridBagConstraints gbc2=new GridBagConstraints();
        gbc2.insets=new Insets(0, 25, 5, 25);
        JPanel p2=new JPanel();
        p2.setBackground(Color.yellow);
        p2.setLayout(baglayout);
        
        JLabel title2=new JLabel("Employee");
        title2.setFont(new Font("serif",Font.BOLD,25));
        title2.setForeground(Color.black);
        gbc2.gridx=0; gbc2.gridy=0;
//        gbc2.gridwidth=3;
        p2.add(title2,gbc2);
              
        gbc2.insets=new Insets(0, 15, 5, 15);        
        JLabel lTotal2=new JLabel("Total:     ");
        lTotal2.setOpaque(true);
        lTotal2.setFont(new Font("serif",Font.BOLD,15));
        lTotal2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        
        gbc2.fill=GridBagConstraints.BOTH;
        JTable table2=new JTable(new DefaultTableModel());
        try {
            ResultSet rs=c1.s.executeQuery("select empid,name,age,gender,job,phone,email from employee where deptid='"+OurDepartment+"' and (job<>'faculty' or job<>'Faculty')");
            table2.setModel(DbUtils.resultSetToTableModel(rs));
            ((DefaultTableModel)table2.getModel()).setColumnIdentifiers(new String[]{"Employee ID","Name","Age","Gender","Job","Mobile","Email"});
            rs=c1.s.executeQuery("select count(empid) from employee where deptid='"+OurDepartment+"' and (job<>'faculty' or job<>'Faculty')");
            rs.next();
            lTotal2.setText("Total:  "+rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane pane=new JScrollPane(table2);
        gbc2.gridx=0; gbc2.gridy=1;
//        gbc2.gridheight=2;
        gbc2.weightx=1;
        gbc2.weighty=5000;    
        p2.add(pane,gbc2);
        
        gbc2.fill=GridBagConstraints.HORIZONTAL;
        gbc2.insets=new Insets(5, 15, 20, 15);
        gbc2.anchor=GridBagConstraints.PAGE_END;
        gbc2.weighty=1;
        gbc2.gridx=0; gbc2.gridy=3;
        p2.add(lTotal2,gbc2);
        
        
        GridBagConstraints gbc3=new GridBagConstraints();
        gbc3.insets=new Insets(0, 25, 5, 25);
        JPanel p3=new JPanel();
        p3.setBackground(Color.green);
        p3.setLayout(baglayout);
        
        JLabel title3=new JLabel("Faculty");
        title3.setFont(new Font("serif",Font.BOLD,25));
        title3.setForeground(Color.black);
        gbc3.gridx=0; gbc3.gridy=0;
//        gbc2.gridwidth=3;
        p3.add(title3,gbc3);
              
        gbc3.insets=new Insets(0, 15, 5, 15);        
        JLabel lTotal3=new JLabel("Total:     ");
        lTotal3.setOpaque(true);
        lTotal3.setFont(new Font("serif",Font.BOLD,15));
        lTotal3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        
        gbc3.fill=GridBagConstraints.BOTH;
        JTable table3=new JTable(new DefaultTableModel());
        try {
            ResultSet rs=c1.s.executeQuery("select empid,name,age,gender,phone,email from employee where deptid='"+OurDepartment+"' and (job='faculty' or job='Faculty')");
            table3.setModel(DbUtils.resultSetToTableModel(rs));
            ((DefaultTableModel)table3.getModel()).setColumnIdentifiers(new String[]{"Employee ID","Name","Age","Gender","Mobile","Email"});
            rs=c1.s.executeQuery("select count(empid) from employee where deptid='"+OurDepartment+"' and (job='faculty' or job='Faculty')");
            rs.next();
            lTotal3.setText("Total:  "+rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }        
        JScrollPane pane3=new JScrollPane(table3);
        gbc3.gridx=0; gbc3.gridy=1;
//        gbc2.gridheight=2;
        gbc3.weightx=1;
        gbc3.weighty=5000;    
        p3.add(pane3,gbc3);
        
        gbc3.fill=GridBagConstraints.HORIZONTAL;
        gbc3.insets=new Insets(5, 15, 20, 15);
        gbc3.anchor=GridBagConstraints.PAGE_END;
        gbc3.weighty=1;
        gbc3.gridx=0; gbc3.gridy=3;
        p3.add(lTotal3,gbc3);        
        
        GridBagConstraints gbc4=new GridBagConstraints();
        gbc4.insets=new Insets(0, 25, 5, 25);
        JPanel p4=new JPanel();
        p4.setBackground(Color.yellow);
        p4.setLayout(baglayout);
        
        JLabel title4=new JLabel("Courses");
        title4.setFont(new Font("serif",Font.BOLD,25));
        title4.setForeground(Color.black);
        gbc4.gridx=0; gbc4.gridy=0;
//        gbc2.gridwidth=3;
        p4.add(title4,gbc4);
              
        gbc4.insets=new Insets(0, 15, 5, 15);        
        JLabel lTotal4=new JLabel("Total:     ");
        lTotal4.setOpaque(true);
        lTotal4.setFont(new Font("serif",Font.BOLD,15));
        lTotal4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        
        gbc4.fill=GridBagConstraints.BOTH;
        JTable table4=new JTable(new DefaultTableModel());
        try {
            ResultSet rs=c1.s.executeQuery("select courseid,name,duration,facultyid from course where deptid='"+OurDepartment+"'");
            table4.setModel(DbUtils.resultSetToTableModel(rs));
            ((DefaultTableModel)table4.getModel()).setColumnIdentifiers(new String[]{"Course ID","Name","Duration","Faculty ID"});
            rs=c1.s.executeQuery("select count(courseid) from course where deptid='"+OurDepartment+"'");
            rs.next();
            lTotal4.setText("Total:  "+rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }          
        JScrollPane pane4=new JScrollPane(table4);
        gbc4.gridx=0; gbc4.gridy=1;
//        gbc2.gridheight=2;
        gbc4.weightx=1;
        gbc4.weighty=5000;    
        p4.add(pane4,gbc4);
        
        gbc4.fill=GridBagConstraints.HORIZONTAL;
        gbc4.insets=new Insets(5, 15, 20, 15);
        gbc4.anchor=GridBagConstraints.PAGE_END;
        gbc4.weighty=1;
        gbc4.gridx=0; gbc4.gridy=3;
        p4.add(lTotal4,gbc4);
        
        JPanel p5=new JPanel();
        p5.setBackground(Color.pink);
        p5.setLayout(baglayout);
        GridBagConstraints gbc5=new GridBagConstraints();
        gbc5.insets=new Insets(0, 15, 5, 15);        
        
        JLabel title5=new JLabel("Student Course info");
        title5.setFont(new Font("serif",Font.BOLD,25));
        title5.setForeground(Color.black);
        gbc5.gridx=0; gbc5.gridy=0;
        gbc5.gridwidth=3;
        p5.add(title5,gbc5);
        
        
        gbc5.fill=GridBagConstraints.HORIZONTAL;  
        gbc5.weightx=1;
        JLabel idNo5=new JLabel("Student ID:");
        gbc5.gridx=0; gbc5.gridy=1;
        gbc5.gridwidth=1;
        p5.add(idNo5,gbc5);
//        
        JTextField idField5=new JTextField();
        idField5.setPreferredSize(new Dimension(90,25));
        idField5.setHorizontalAlignment(11);
        idField5.setFont(new Font("serif",Font.PLAIN,15));
        gbc5.gridx=1; gbc5.gridy=1;
        p5.add(idField5,gbc5);
        
        JButton fetch5=new JButton("Fetch");
        fetch5.setBackground(Color.black);
        fetch5.setForeground(Color.white);
        gbc5.gridx=2; gbc5.gridy=1;
        p5.add(fetch5,gbc5);
        
        
        gbc5.fill=GridBagConstraints.BOTH;
        JTable table5=new JTable();
        JScrollPane pane5=new JScrollPane(table5);
        gbc5.gridx=0; gbc5.gridy=2;
        gbc5.gridwidth=3;
        gbc5.weightx=1;
//        gbc5.weighty=1;
        gbc5.weighty=5000;    
        p5.add(pane5,gbc5);
        
        JLabel lTotal5=new JLabel("Total:     ");
        lTotal5.setOpaque(true);
        lTotal5.setFont(new Font("serif",Font.BOLD,15));
        lTotal5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);        
        gbc5.fill=GridBagConstraints.HORIZONTAL;
        gbc5.insets=new Insets(5, 15, 20, 15);
        gbc5.anchor=GridBagConstraints.PAGE_END;
        gbc5.weighty=1;
        gbc5.gridx=0; gbc5.gridy=3;
        p5.add(lTotal5,gbc5);
        fetch5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String string=idField5.getText();
                if(string.isBlank()){
                    JOptionPane.showMessageDialog(null,"Enter a valid student ID.");
                }
                else{
                    try {
                        ResultSet rs=c1.s.executeQuery("select name,Programme,email, phone,gender,rollno from student where stuid='"+string+"'");
                        if (rs.next()) {
                            rs=c1.s.executeQuery("select courseid from enrollment where stuid='"+string+"'");
                            String query="select course.courseid,course.name,course.duration,department.name,employee.name from course join department on course.deptid=department.deptid join employee on course.facultyid=employee.empid where courseid in (";
                            int count=0;
                            while(rs.next()){
                                count++;
                                query=query+"'"+rs.getString("courseid")+"',";
                            }
                            query=query.substring(0,query.length()-1);
                            query=query+")";
                            System.out.println(query);
                    
                            rs=c1.s.executeQuery(query);
                            table5.setModel(DbUtils.resultSetToTableModel(rs));
                            ((DefaultTableModel)table5.getModel()).setColumnIdentifiers(new Object[]{"Course ID","Name","Duration (in months)","Deparment","Faculty"});
                            lTotal5.setText("Total:  "+String.valueOf(count));
                        } else {
                            JOptionPane.showMessageDialog(null,"Enter a valid student ID.");                    
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });        
        
        GridBagConstraints gbc6=new GridBagConstraints();
        gbc6.insets=new Insets(0, 25, 5, 25);
        JPanel p6=new JPanel();
        p6.setBackground(Color.orange);
        p6.setLayout(baglayout);
        
        JLabel title6=new JLabel("Department Students");
        title6.setFont(new Font("serif",Font.BOLD,25));
        title6.setForeground(Color.black);
        gbc6.gridx=0; gbc6.gridy=0;
//        gbc2.gridwidth=3;
        p6.add(title6,gbc6);
              
        gbc6.insets=new Insets(0, 15, 5, 15);        
        JLabel lTotal6=new JLabel("Total:     ");
        lTotal6.setOpaque(true);
        lTotal6.setFont(new Font("serif",Font.BOLD,15));
        lTotal6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        
        gbc6.fill=GridBagConstraints.BOTH;
        JTable table6=new JTable(new DefaultTableModel());
        try {
            ResultSet rs=c1.s.executeQuery("select stuid,name,age,gender,Programme,phone,email from student where deptid='"+OurDepartment+"'");
            table6.setModel(DbUtils.resultSetToTableModel(rs));
            ((DefaultTableModel)table6.getModel()).setColumnIdentifiers(new String[]{"Student ID","Name","Age","Gender","Programme","Mobile","Email"});
            rs=c1.s.executeQuery("select count(stuid) from student where deptid='"+OurDepartment+"'");
            rs.next();
            lTotal6.setText("Total:  "+rs.getString(1));
        } catch (Exception e) {
            e.printStackTrace();
        }          
        JScrollPane pane6=new JScrollPane(table6);
        gbc6.gridx=0; gbc6.gridy=1;
//        gbc2.gridheight=2;
        gbc6.weightx=1;
        gbc6.weighty=5000;    
        p6.add(pane6,gbc6);
        
        gbc6.fill=GridBagConstraints.HORIZONTAL;
        gbc6.insets=new Insets(5, 15, 20, 15);
        gbc6.anchor=GridBagConstraints.PAGE_END;
        gbc6.weighty=1;
        gbc6.gridx=0; gbc6.gridy=3;
        p6.add(lTotal6,gbc6);        
                
        l2.add(p2,"1");
        l2.add(p3,"2");
        l2.add(p4,"3");
        l2.add(p5,"4");
        l2.add(p6,"5");      
        gbc1.insets=new Insets(5,10,5,10);
        gbc1.gridx=1; gbc1.gridy=0;
        p1.add(l2,gbc1);
        
        

        l1.setLayout(baglayout);
        GridBagConstraints gbc = new GridBagConstraints();        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        
        gbc.gridx=0; gbc.gridy=0;
        gbc.weightx=1.5;
        gbc.anchor=GridBagConstraints.PAGE_START;
        gbc.weighty=1;
        l1.add(menubar,gbc);
        
        gbc.gridx=0; gbc.gridy=1;
        gbc.weightx=0;
        gbc.fill=GridBagConstraints.NONE;
//        gbc.anchor=GridBagConstraints.NONE;
        l1.add(p1,gbc);
        add(l1);        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==logout){
            dispose();
            new Administrator();
        }
    }
    
    public static void main(String[] args ){
        new Dept("2001");
    }
}
