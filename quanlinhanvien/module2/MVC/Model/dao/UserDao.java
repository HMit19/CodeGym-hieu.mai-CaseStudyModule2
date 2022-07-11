package quanlinhanvien.module2.MVC.Model.dao;

import quanlinhanvien.module2.MVC.Model.Entity.User;

// check validate
public class UserDao {

    // tai khoan mac dinh co name va pass la admin, admin
    public boolean checkUser(User user) {
        System.out.println("check duoc goi");
        if (user != null) {
            if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
                System.out.println("show");
                return true;
            }
        }
        return false;
    }
}
