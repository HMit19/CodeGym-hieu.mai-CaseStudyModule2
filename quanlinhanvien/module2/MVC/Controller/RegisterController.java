package quanlinhanvien.module2.MVC.Controller;

import quanlinhanvien.module2.MVC.View.LoginView;
import quanlinhanvien.module2.MVC.View.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {

    private RegisterView registerView;

    private LoginView loginView;
    public RegisterController(RegisterView registerView){
        this.registerView = registerView;
//        this.loginView = loginView;
        registerView.addCancelListener(new CancelListener());
    }

    class CancelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("cancel");
            registerView.setVisible(false);
        }
    }
}
