package quanlinhanvien.module2.MVC.Model.dao;

import quanlinhanvien.module2.MVC.Model.Entity.User;

import java.util.List;

// check validate
public class UserDao {
    private AdminDao adminDao;

    public UserDao(AdminDao adminDao) {
        this.adminDao = new AdminDao();
    }

    // tai khoan mac dinh co name va pass la admin, admin
    public boolean checkUser(User user) {
        System.out.println("Call check User");
        List<User> listAdmin = adminDao.getListAdmin();
        if (user != null) {
//            if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())) {
//                System.out.println("Invalid username or password.");
//                return true;
//            }

            for (User u : listAdmin) {
                if (u.getUserName().equals(user.getUserName())
                        && u.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
