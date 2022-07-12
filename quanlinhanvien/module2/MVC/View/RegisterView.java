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
        registerLabel = new JLabel("SIGN UP");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        confirmLabel = new JLabel("Retype pass");
        passwordAdminLabel = new JLabel("Admin pass");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        confirmField = new JPasswordField(15);
        passwordAdminField = new JPasswordField(15);
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
        Confirm.addActionListener(this);
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
        this.setTitle("Sign up");
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

    public void addConfirmListener(ActionListener e) {
        Confirm.addActionListener(e);
        System.out.println("call confirm");
    }

    //---------------------------Get and clear information admin----------------------------------//
    public String[] getInformationAdmin() {
        if (!validateName()) {
            System.out.println("Error name!");
            return null;
        } else if (!validatePass()) {
            System.out.println("Error pass!");
            return null;
        } else if (!validateConfirm()) {
            System.out.println("Error confirm pass!");
            return null;
        } else if (!validatePassAdmin()) {
            System.out.println("Error pass admin!");
            return null;
        }
        String arrAdmin[] = {usernameField.getText(),
                passwordField.getText(), confirmField.getText(), passwordAdminField.getText()};
        return arrAdmin;
    }

    public void clearInformationAdmin() {
        usernameField.setText("");
        passwordField.setText("");
        confirmField.setText("");
        confirmField.setText("");
        passwordAdminLabel.setText("");
    }

    //---------------------------------------------------------------------------------------//

    //----------------------------Validate Register-------------------------------------//
    private boolean validateName() {
        String name = usernameField.getText();
        if (name == null || "".equals(name.trim())) {
            usernameField.requestFocus();
            showMessage("Enter user name!");
            return false;
        }
        return true;
    }

    private boolean validatePass() {
        String pass = passwordField.getText();
        if (pass == null || "".equals(pass)) {
            passwordField.requestFocus();
            showMessage("Enter password!");
            return false;
        }
        return true;
    }

    private boolean validateConfirm() {
        String confirm = confirmField.getText();
        if (confirm == null || "".equals(confirm)) {
            confirmField.requestFocus();
            showMessage("Enter confirm password!");
            return false;
        }
        return true;
    }

    private boolean validatePassAdmin() {
        String passAdmin = passwordAdminField.getText();
        if (passAdmin == null || "".equals(passAdmin)) {
            passwordAdminField.requestFocus();
            showMessage("Enter password admin!");
            return false;
        }
        return true;
    }
}
