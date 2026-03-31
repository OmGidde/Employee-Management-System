//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package employee.management.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login;
    JButton back;

    Login() {
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        this.add(username);
        this.tusername = new JTextField();
        this.tusername.setBounds(150, 20, 150, 30);
        this.add(this.tusername);
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        this.add(password);
        this.tpassword = new JPasswordField();
        this.tpassword.setBounds(150, 70, 150, 30);
        this.add(this.tpassword);
        this.login = new JButton("LOGIN");
        this.login.setBounds(150, 140, 150, 30);
        this.login.setBackground(Color.black);
        this.login.setForeground(Color.WHITE);
        this.login.addActionListener(this);
        this.add(this.login);
        this.back = new JButton("BACK");
        this.back.setBounds(150, 180, 150, 30);
        this.back.setBackground(Color.black);
        this.back.setForeground(Color.WHITE);
        this.back.addActionListener(this);
        this.add(this.back);
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, 1);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(350, 10, 600, 400);
        this.add(imgg);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, 1);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        this.add(img);
        this.setSize(600, 300);
        this.setLocation(450, 200);
        this.setLayout((LayoutManager)null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login) {
            try {
                String username = this.tusername.getText();
                String password = this.tpassword.getText();
                conn conn = new conn();
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    this.setVisible(false);
                    new Main_class();
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Invalid username or password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == this.back) {
            System.exit(90);
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
