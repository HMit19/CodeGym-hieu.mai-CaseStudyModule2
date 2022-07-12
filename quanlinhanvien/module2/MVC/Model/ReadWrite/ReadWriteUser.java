package quanlinhanvien.module2.MVC.Model.ReadWrite;

import quanlinhanvien.module2.MVC.Model.Entity.Employees;
import quanlinhanvien.module2.MVC.Model.Entity.User;
import quanlinhanvien.module2.MVC.Model.dao.AdminDao;
import quanlinhanvien.module2.MVC.Model.dao.EmployeesDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReadWriteUser {


    public static void writeEmployeesToFile(List<Employees> list, String FILE_EMPLOYEES) {
        try {
            PrintWriter write = new PrintWriter(FILE_EMPLOYEES, "UTF-8");
            for (Employees i : list) {
                write.print(i.toString());
            }
            System.out.println("Write succesful");
            write.flush();
            write.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void writeListAdmin(List<User> list, String FILE_ADMIN) {
        try {
            PrintWriter write = new PrintWriter(FILE_ADMIN, "UTF-8");
            for (User i : list) {
                write.print(i.toString());
            }
            System.out.println("Write succesful");
            write.flush();
            write.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static ArrayList<Employees> readEmployeesByFile(String FILE_EMPLOYEES) {
        List<Employees> list = new ArrayList<Employees>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(FILE_EMPLOYEES));
            String line = null;
            while (true) {
                line = read.readLine();
                if (line == null) {
                    break;
                } else {
                    String arr[] = line.split("-");
                    Employees employees = new Employees(arr[0], arr[1], arr[2], arr[3], arr[4]);
                    list.add(employees);
                }
            }
//            read.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return (ArrayList<Employees>) list;
    }

    public static ArrayList<User> readListAdmin(String FILE_ADMIN) {
        List<User> adminList = new ArrayList<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader(FILE_ADMIN));
            String line = null;
            while (true) {
                line = read.readLine();
                if (line == null) {
                    break;
                } else {
                    String arr[] = line.split("-");
                    User admin = new User(arr[0], arr[1]);
                    adminList.add(admin);
                }
            }
//            read.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return (ArrayList<User>) adminList;
    }

    public static void main(String[] args) {
        List<User> a = new ArrayList<>(readListAdmin(AdminDao.FILE_ADMIN));
        for (User i : a) {
            System.out.println(i.toString());
            writeListAdmin(a, AdminDao.FILE_ADMIN);
        }

    }
}
