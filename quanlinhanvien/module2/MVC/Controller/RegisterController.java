package quanlinhanvien.module2.MVC.Controller;

import quanlinhanvien.module2.MVC.Model.Entity.User;
import quanlinhanvien.module2.MVC.Model.dao.AdminDao;
import quanlinhanvien.module2.MVC.Model.dao.UserDao;
import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.View.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        registerView.addCancelListener(new CancelListener());
    }

    class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cancel");
            registerView.clearInformationAdmin();
            registerView.setVisible(false);
            loginView.setVisible(true);
        }
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
                } else if (checkInfo == PASS_NOT_MATCH) {
                    registerView.showMessage("Password does not match!");
                } else if (checkInfo == PASS_ADMIN_WRONG) {
                    registerView.showMessage("Admin password is wrong!");
                } else if(checkInfo == ACCEPT_USER){
                    registerView.showMessage("successful registration!");
                }
                User user = new User(info[0], info[1]);
                adminDao.add(user);
                System.out.println("new admin is " + user.toString());
            }else{
                System.out.println("info null");
            }
        }
    }
}
