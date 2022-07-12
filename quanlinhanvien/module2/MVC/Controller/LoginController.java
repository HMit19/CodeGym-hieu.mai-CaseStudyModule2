package quanlinhanvien.module2.MVC.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import quanlinhanvien.module2.MVC.Model.Entity.User;
import quanlinhanvien.module2.MVC.View.EmployeesView;
import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.Model.dao.UserDao;
import quanlinhanvien.module2.MVC.View.RegisterView;

public class LoginController {

    private UserDao userDao;
    private LoginView loginView;
    private EmployeesView employeesView;
    private RegisterView registerView;

    public LoginController(LoginView loginView) {
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

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterController registerController = new RegisterController(registerView);
            registerView.setVisible(true);
        }
    }
}
