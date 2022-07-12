package quanlinhanvien.module2.MVC.Model.dao;

import quanlinhanvien.module2.MVC.Model.Entity.User;

import java.util.List;

// check validate
public class UserDao {
    private AdminDao adminDao;

    public UserDao() {
        this.adminDao = new AdminDao();
    }

    // tai khoan mac dinh co name va pass la admin, admin
    public boolean checkUser(User user) {
        System.out.println("Call check User");
        List<User> listAdmin = adminDao.getListAdmin();
        if (user != null) {
            for (User u : listAdmin) {
                System.out.println("admin user " + u.getUserName() + " - pass " + u.getPassword());
                if (u.getUserName().equals(user.getUserName())
                        && u.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public byte checkRegister(String info[]) {
        String name = info[0];
        String pass = info[1];
        String confirm = info[2];
        String passAdmin = info[3];
        List<User> listAdmin = adminDao.getListAdmin();
        for (User u : listAdmin) {
            if (name.equals(u.getUserName())) {
                System.out.println("Username already exists!");
                return 1;
            }

        }
        for (User u : listAdmin) {

            if (!pass.equals(confirm)) {
                System.out.println("Password does not match!");
                return 2;
            }

        }
        for (User u : listAdmin) {

            if (!passAdmin.equals("admin")) {
                System.out.println("Admin password is wrong!");
                return 3;
            }
        }

        System.out.println("successful registration!");
        return 0;
    }
}
