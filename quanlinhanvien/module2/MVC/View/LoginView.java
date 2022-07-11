package quanlinhanvien.module2.MVC.View;

import quanlinhanvien.module2.MVC.Model.Entity.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

public class LoginView extends JFrame implements ActionListener {

    private JLabel loginLabel;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginView() {
        createComponents();
    }

    private void createComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginLabel = new JLabel("Admin Login");
        userNameLabel = new JLabel("Username:");
        passwordlabel = new JLabel("Password:");
        userNameField = new JTextField(18);
        passwordField = new JPasswordField(18);
        passwordField.addActionListener(this);

        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        loginButton.setPreferredSize(new Dimension(86, 25));
        registerButton.setPreferredSize(new Dimension(86, 25));
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();

        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(380, 290);
        panel.setLayout(layout);
        panel.add(loginLabel);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, loginLabel, 135, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginLabel, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 80, SpringLayout.WEST, userNameLabel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginButton, 80, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, registerButton, 175, SpringLayout.WEST, passwordlabel);
        layout.putConstraint(SpringLayout.NORTH, registerButton, 130, SpringLayout.NORTH, panel);

        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // cài đặt các thuộc tính cho JFrame
        this.setTitle("Login");
        this.setVisible(true);
        this.setSize(370, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public User getUser() {
        System.out.println(userNameField.getText() + "  " + passwordField.getPassword());
        return new User(userNameField.getText(),
                String.copyValueOf(passwordField.getPassword()));
    }

    public void resetUser() {
        userNameField.setText("");
        passwordField.setText("");
        userNameField.requestFocus();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Active Button Login");
    }

    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
    }

    public void addRegisterListener(ActionListener listener) {
        registerButton.addActionListener(listener);
    }
}
