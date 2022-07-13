package quanlinhanvien.module2.MVC.Controller;

import java.awt.event.*;

import quanlinhanvien.module2.MVC.Model.Entity.User;
import quanlinhanvien.module2.MVC.Model.DAO.AdminDao;
import quanlinhanvien.module2.MVC.View.EmployeesView;
import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.Model.DAO.UserDao;
import quanlinhanvien.module2.MVC.View.RegisterView;

public class LoginController {

    private UserDao userDao;
    private LoginView loginView;

    private AdminDao adminDao;
    private EmployeesView employeesView;
    private RegisterView registerView;

    public LoginController(LoginView loginView) {
        this.adminDao = new AdminDao();
        this.loginView = loginView;
        this.registerView = new RegisterView();
        this.userDao = new UserDao();
        loginView.addLoginListener(new LoginListener());
        loginView.addRegisterListener(new RegisterListener());
        loginView.addEnterListener(new EnterListener());
    }

    public void showLoginView() {
        loginView.setVisible(true);
    }

    class LoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("ActionListener duoc goi");
            User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                employeesView = new EmployeesView();
                EmployeesController employeesController = new EmployeesController(employeesView);
                employeesController.showEmployeesView();
                loginView.setVisible(false);
                employeesView.setAdmin("Admin " + user.getUsername() + " ");
                System.out.println("login thanh cong");
            } else {
                System.out.println("that bai");
                loginView.resetUser();
                loginView.showMessage("Invalid username or password.");
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
            System.out.println("keyReleased");
            User user = loginView.getUser();
            if (e.getKeyCode() == KeyEvent.VK_ENTER && user != null) {
                if (userDao.checkUser(user)) {
                    employeesView = new EmployeesView();
                    EmployeesController employeesController = new EmployeesController(employeesView);
                    employeesController.showEmployeesView();
                    loginView.setVisible(false);
                    employeesView.setAdmin("Admin: " + user.getUsername());
                    System.out.println("Login successfully!");
                } else {
                    System.out.println("login failed!");
                    loginView.resetUser();
                    loginView.showMessage("Invalid username or password.");
                }
            }
        }
    }

    class RegisterListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("call register");
            registerView.setVisible(true);
            loginView.setVisible(false);
            RegisterController registerController = new RegisterController(registerView, loginView);
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
