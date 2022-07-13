package quanlinhanvien.module2.MVC.Controller;

import quanlinhanvien.module2.MVC.Model.Entity.User;
import quanlinhanvien.module2.MVC.Model.DAO.AdminDao;
import quanlinhanvien.module2.MVC.Model.DAO.UserDao;
import quanlinhanvien.module2.MVC.View.EmployeesView;
import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.View.RegisterView;

import java.awt.event.*;

public class RegisterController {
    private final byte NAME_USED = 1;
    private final byte PASS_NOT_MATCH = 2;
    private final byte PASS_ADMIN_WRONG = 3;
    private final byte ACCEPT_USER = 0;
    private RegisterView registerView;

    private LoginView loginView;
    private UserDao userDao;
    private AdminDao adminDao;

    public RegisterController(RegisterView registerView, LoginView loginView) {
        this.loginView = loginView;
        this.registerView = registerView;
        this.adminDao = new AdminDao();
        this.userDao = new UserDao();
        registerView.addConfirmListener(new ConfirmListener());
        registerView.addBackLoginListener(new BackLoginListener());
        registerView.addEnterListener(new EnterListener());
    }

    class ConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("confirm");
            String info[] = registerView.getInformationAdmin();
            if (info != null) {
                byte checkInfo = userDao.checkRegister(info);
                System.out.println("check info = " + checkInfo);
                if (checkInfo == NAME_USED) {
                    registerView.showMessage("Username already exists!");
                    registerView.clearInformationAdmin();
                } else if (checkInfo == PASS_NOT_MATCH) {
                    registerView.showMessage("Password does not match!");
                    registerView.resetPassword();
                } else if (checkInfo == PASS_ADMIN_WRONG) {
                    registerView.showMessage("Admin password is wrong!");
                    registerView.resetPassword();
                } else if (checkInfo == ACCEPT_USER) {
                    registerView.showMessage("successful registration!");
                    registerView.clearInformationAdmin();
                }
                User user = new User(info[0], info[1]);
                adminDao.add(user);
                System.out.println("new admin is " + user.toString());
            } else {
                System.out.println("info null");
            }
        }
    }

    class EnterListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("keyTyped");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("confirm");
            String info[] = registerView.getInformationAdmin();
            if (info != null) {
                byte checkInfo = userDao.checkRegister(info);
                System.out.println("check info = " + checkInfo);
                if (checkInfo == NAME_USED) {
                    registerView.showMessage("Username already exists!");
                    registerView.clearInformationAdmin();
                } else if (checkInfo == PASS_NOT_MATCH) {
                    registerView.showMessage("Password does not match!");
                    registerView.resetPassword();
                } else if (checkInfo == PASS_ADMIN_WRONG) {
                    registerView.showMessage("Admin password is wrong!");
                    registerView.resetPassword();
                } else if (checkInfo == ACCEPT_USER) {
                    registerView.showMessage("successful registration!");
                    registerView.clearInformationAdmin();
                }
                User user = new User(info[0], info[1]);
                adminDao.add(user);
                System.out.println("new admin is " + user.toString());
            } else {
                System.out.println("info null");
            }
        }
    }

    class BackLoginListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("sign in");
            registerView.clearInformationAdmin();
            registerView.setVisible(false);
            loginView.setVisible(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
