package quanlinhanvien.module2.MVC.Model.ReadWrite;

import quanlinhanvien.module2.MVC.Model.Entity.Employees;
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

    public static void main(String[] args) {
        List<Employees> a = new ArrayList<>(readEmployeesByFile(EmployeesDao.FILE_EMPLOYEES));
        for (Employees i : a) {
            System.out.println(i.toString());
            writeEmployeesToFile(a, EmployeesDao.FILE_EMPLOYEES);
        }

    }
}
