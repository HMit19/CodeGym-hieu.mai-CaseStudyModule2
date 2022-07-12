// giao diện đăng kí

package quanlinhanvien.module2.MVC.View;

import quanlinhanvien.module2.MVC.Controller.RegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame implements ActionListener {
    private JLabel registerLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmLabel;
    private JLabel passwordAdminLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField confirmField;
    private JTextField passwordAdminField;

    private JButton Confirm;
    private JButton Cancel;

    public RegisterView() {
        CreateComponents();
    }

    private void CreateComponents() {

        // -------------declare components----------------//
        registerLabel = new JLabel("REGISTER");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        confirmLabel = new JLabel("Confirm password");
        passwordAdminLabel = new JLabel("Password Admin");
        usernameField = new JTextField(15);
        passwordField = new JTextField(15);
        confirmField = new JTextField(15);
        passwordAdminField = new JTextField(15);
        Confirm = new JButton("Confirm");
        Cancel = new JButton("Cancel");
        //------------------------------------------------------//

        // ----------------declare layout------------------------//
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        //----------------------------------------------------//

        panel.add(registerLabel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmLabel);
        panel.add(confirmField);
        panel.add(passwordAdminLabel);
        panel.add(passwordAdminField);
        panel.add(Confirm);
        panel.add(Cancel);
        Cancel.addActionListener(this);

        //-------------------set position components------------//
        layout.putConstraint(SpringLayout.WEST, registerLabel, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, registerLabel, 15, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, usernameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameLabel, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, usernameField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 110, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 110, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, confirmLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, confirmLabel, 140, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, confirmField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, confirmField, 140, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, passwordAdminLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordAdminLabel, 170, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordAdminField, 130, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordAdminField, 170, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, Confirm, 50, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, Confirm, 210, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, Cancel, 230, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, Cancel, 210, SpringLayout.NORTH, panel);

        //-----------------------------------------------------//

        //--------------------set font components----------------//
        registerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        Font font = new Font("Arial", Font.PLAIN, 14);
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        confirmLabel.setFont(font);
        passwordAdminLabel.setFont(font);
        //--------------------------------------------------------

        //---------------add component in jframe--------------//
        this.add(panel);
        this.setSize(370, 300);
        this.setResizable(false);
        this.setTitle("Register");
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        //-------------------------------------------------------//
    }

    public static void main(String[] args) {
        new RegisterView();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void addCancelListener(ActionListener e) {
        Cancel.addActionListener(e);
        System.out.println("call register");
    }

    //----------------------------Validate Register-------------------------------------//
    private boolean validateName() {
        String salary = usernameField.getText();
        if (salary == null || "".equals(salary.trim())) {
            usernameField.requestFocus();
            showMessage("!");
            return false;
        }
        return true;
    }
}
