
// ----------------------------------GUI REGISTER------------------------------------------//
package quanlinhanvien.module2.MVC.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterView extends JFrame implements ActionListener, MouseListener {
    private JLabel registerLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel confirmLabel;
    private JLabel haveAccount;
    private JLabel loginLabel;
    private JLabel passwordAdminLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField confirmField;
    private JTextField passwordAdminField;
    private JButton confirmAccount;

    public RegisterView() {
        CreateComponents();
    }

    private void CreateComponents() {

        // --------------------------------------declare components--------------------------------//
        registerLabel = new JLabel("Sign up");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        confirmLabel = new JLabel("Retype pass");
        passwordAdminLabel = new JLabel("Admin pass");
        haveAccount = new JLabel("I have an account?");
        loginLabel = new JLabel("Sign in");
        confirmAccount = new JButton("Confirm");
        usernameField = new JTextField(17);
        passwordField = new JPasswordField(17);
        confirmField = new JPasswordField(17);
        passwordAdminField = new JPasswordField(17);
        //-------------------------------------------------------------------------------------------//


        //------------------------------------declare & add layout------------------------------------//
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel(layout);
        //-------------------------------------------------------------------------------------------//

        //-------------------------------------add component in panel-------------------------------//
        panel.add(registerLabel);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmLabel);
        panel.add(confirmField);
        panel.add(passwordAdminLabel);
        panel.add(passwordAdminField);
        panel.add(haveAccount);
        panel.add(loginLabel);
        panel.add(confirmAccount);
        loginLabel.addMouseListener(this);
        confirmAccount.addActionListener(this);
        //----------------------------------------------------------------------------------------//

        //--------------------------------------set position components----------------------------//
        layout.putConstraint(SpringLayout.WEST, registerLabel, 116, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, registerLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, usernameLabel, 35, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameLabel, 83, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, usernameField, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, usernameField, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordLabel, 35, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordLabel, 113, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordField, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordField, 110, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, confirmLabel, 35, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, confirmLabel, 143, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, confirmField, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, confirmField, 140, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordAdminLabel, 35, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordAdminLabel, 173, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, passwordAdminField, 115, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, passwordAdminField, 170, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, confirmAccount, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, confirmAccount, 200, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, haveAccount, 135, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, haveAccount, 237, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, loginLabel, 243, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, loginLabel, 235, SpringLayout.NORTH, panel);
        //-------------------------------------------------------------------------------------------//


        //---------------------------------set font, color, size--------------------------------------//
        Font font = new Font("Arial", Font.PLAIN, 13);
        registerLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 44));
        haveAccount.setFont(new Font("Candara Light", Font.PLAIN, 14));
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        confirmLabel.setFont(font);
        passwordAdminLabel.setFont(font);
        confirmAccount.setBackground(new Color(37, 150, 190));
        confirmAccount.setForeground(Color.white);
        confirmAccount.setPreferredSize(new Dimension(123, 25));
        //------------------------------------------------------------------------------------------//


        //------------------------------add component & set position jframe------------------------//
        this.add(panel);
        this.setSize(370, 300);
        this.setResizable(false);
        this.setTitle("Sign up");
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        //----------------------------------------------------------------------------------------//
    }


    //--------------------------------method show message-----------------------------------------//
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    //--------------------------------------------------------------------------------------------//


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
    //------------------------------------------------------------------------------------------------//

    //-----------------------------------clear and reset user admin---------------------------------//
    public void clearInformationAdmin() {
        usernameField.setText("");
        passwordField.setText("");
        confirmField.setText("");
        confirmField.setText("");
        passwordAdminField.setText("");
        usernameField.requestFocus();
    }

    public void resetPassword() {
        passwordField.setText("");
        confirmField.setText("");
        confirmField.setText("");
        passwordAdminField.setText("");
        passwordField.requestFocus();
    }
    //------------------------------------------------------------------------------------------------//


    //----------------------------------------Validate Register----------------------------------------//
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

    //----------------------------------------------------------------------------------------------//


    //------------------------------------Action for register---------------------------------------//
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public void addConfirmListener(ActionListener e) {
        confirmAccount.addActionListener(e);
        System.out.println("call confirm");
    }

    public void addBackLoginListener(MouseListener listener) {
        loginLabel.addMouseListener(listener);
        System.out.println("call sign in");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        loginLabel.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        loginLabel.setForeground(Color.black);
    }

    //----------------------------------------------------------------------------------------------//
}
