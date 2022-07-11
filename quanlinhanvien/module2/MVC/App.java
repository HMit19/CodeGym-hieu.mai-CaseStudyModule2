package quanlinhanvien.module2.MVC;

import java.util.Scanner;

import quanlinhanvien.module2.MVC.Controller.LoginController;
import quanlinhanvien.module2.MVC.View.LoginView;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LoginView view = new LoginView();
//         hien thi man hinh login
        LoginController controller = new LoginController(view);
        controller.showLoginView();
    }
}
