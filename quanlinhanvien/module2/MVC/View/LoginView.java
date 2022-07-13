// Giao diện login
package quanlinhanvien.module2.MVC.View;

import quanlinhanvien.module2.MVC.Model.Entity.User;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginView extends JFrame implements ActionListener, MouseListener {

    private JLabel loginLabel;
    private JLabel userNameLabel;
    private JLabel passwordlabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginButton;
    private JLabel dontAccount;
    private JLabel registerLabel;

    public LoginView() {
        createComponents();
    }

    private void createComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginLabel = new JLabel("Admin");
        userNameLabel = new JLabel("Username");
        passwordlabel = new JLabel("Password");
        userNameField = new JTextField(22);
        passwordField = new JPasswordField(22);
        loginButton = new JButton("Sign in");
        registerLabel = new JLabel("Sign up");
        dontAccount = new JLabel("Don't have an account?");
        registerLabel.addMouseListener(this);
        loginButton.addActionListener(this);

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();

        // set width
        loginButton.setPreferredSize(new Dimension(123, 25));
        userNameField.setPreferredSize(new Dimension(100, 25));
        passwordField.setPreferredSize(new Dimension(100, 25));


        // tạo đối tượng panel để chứa các thành phần của màn hình login
        panel.setSize(380, 290);
        panel.setLayout(layout);
        panel.add(loginLabel);
        panel.add(userNameLabel);
        panel.add(passwordlabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerLabel);
        panel.add(dontAccount);

        // set font for label
        Font font = new Font("Arial", Font.PLAIN, 13);
        loginLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 44));
        userNameLabel.setFont(font);
        passwordlabel.setFont(font);
        dontAccount.setFont(new Font("Candara Light", Font.PLAIN, 14));


        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, loginLabel, 116, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginLabel, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameLabel, 65, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameLabel, 88, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordlabel, 65, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordlabel, 133, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, userNameField, 65, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, userNameField, 103, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 65, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 148, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginButton, 113, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginButton, 185, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, dontAccount, 85, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, dontAccount, 228, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, registerLabel, 227, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, registerLabel, 226, SpringLayout.NORTH, panel);

        // set color
        loginButton.setBackground(new Color(37, 150, 190));
        loginButton.setForeground(Color.white);

//

        // add panel tới JFrame
        this.add(panel);
        this.pack();
        // set option for JFrame
        this.setTitle("Admin Login");
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

    public void addRegisterListener(MouseListener listener) {
        registerLabel.addMouseListener(listener);
    }

    public void addEnterListener(KeyListener e) {
        loginButton.addKeyListener(e);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        registerLabel.setForeground(Color.black);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        registerLabel.setForeground(Color.red);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        registerLabel.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        registerLabel.setForeground(Color.black);
    }
}
