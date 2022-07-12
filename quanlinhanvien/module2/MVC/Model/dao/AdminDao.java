package quanlinhanvien.module2.MVC.Model.dao;

import quanlinhanvien.module2.MVC.Model.Entity.Employees;
import quanlinhanvien.module2.MVC.Model.Entity.User;

import java.util.ArrayList;
import java.util.List;

import static quanlinhanvien.module2.MVC.Model.ReadWrite.ReadWriteUser.readListAdmin;
import static quanlinhanvien.module2.MVC.Model.ReadWrite.ReadWriteUser.writeListAdmin;

public class AdminDao {
    public static final String FILE_EMPLOYEES = "FILE_EMPLOYEES.txt";
    private List<User> listAdmin;
    private AdminDao adminDao;
    public static final String FILE_ADMIN = "FILE_ADMIN.txt";

    public AdminDao() {
        this.listAdmin = new ArrayList<>(readListAdmin(FILE_ADMIN));
    }

    public void add(User user) {
        listAdmin.add(user);
        writeListAdmin(listAdmin, FILE_ADMIN);
    }

    public List<User> getListAdmin() {
        return listAdmin;
    }
}
