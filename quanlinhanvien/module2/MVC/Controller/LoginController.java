package quanlinhanvien.module2.MVC.Controller;

import java.awt.event.*;

import quanlinhanvien.module2.MVC.Model.Entity.User;
import quanlinhanvien.module2.MVC.Model.dao.AdminDao;
import quanlinhanvien.module2.MVC.View.EmployeesView;
import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.Model.dao.UserDao;
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
                System.out.println("login thanh cong");
            } else {
                System.out.println("that bai");
                loginView.resetUser();
                loginView.showMessage("Invalid username or password.");
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
