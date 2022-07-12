package quanlinhanvien.module2.MVC.Controller;

import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.View.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private RegisterView registerView;

    private LoginView loginView;

    public RegisterController(RegisterView registerView, LoginView loginView) {
        this.loginView = loginView;
        this.registerView = registerView;
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
            String name = info[0];
            String pass = info[1];
            String confirm = info[2];
            String passAdmin = info[3];
            if (!registerView.validateName()) {
                registerView.showMessage("Invalid name");
            }


            System.out.println("size " + a.length);
            for (String s : registerView.getInformationAdmin()) {
                System.out.println(s);
            }
        }
    }
}
