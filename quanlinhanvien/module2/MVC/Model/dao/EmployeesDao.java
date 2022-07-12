package quanlinhanvien.module2.MVC.Model.dao;

// contains methods to add, remove, edit, delete, read, write

import quanlinhanvien.module2.MVC.Model.Entity.Employees;

import java.util.ArrayList;
import java.util.List;

import static quanlinhanvien.module2.MVC.Model.ReadWrite.ReadWriteUser.readEmployeesByFile;
import static quanlinhanvien.module2.MVC.Model.ReadWrite.ReadWriteUser.writeEmployeesToFile;

public class EmployeesDao {
    private List<Employees> listEmployees;
    public static final String FILE_EMPLOYEES = "FILE_EMPLOYEES.txt";

    public EmployeesDao() {
        this.listEmployees = new ArrayList<>(readEmployeesByFile(FILE_EMPLOYEES));
    }

    public void add(Employees employees) {
        listEmployees.add(employees);   // them vao list
        writeEmployeesToFile(listEmployees, FILE_EMPLOYEES);
    }

    public boolean delete(String id) {
        boolean statusDelete = false;
        Employees employees = new Employees();
        for (Employees e : listEmployees) {
            if (e.getIdEmployees().equals(id)) {
                employees = e;
                statusDelete = true;
                break;
            }
        }
        if (statusDelete) {
            listEmployees.remove(employees);
            writeEmployeesToFile(listEmployees, FILE_EMPLOYEES);
            return true;
        } else {
            System.out.println("khong tim thay employees co id la " + id);
            return false;
        }

    }

    public List<Employees> findId(String id) {
        List<Employees> list = new ArrayList<Employees>();
        for (Employees e : listEmployees) {
            if (e.getIdEmployees().equals(id)) {
                list.add(e);
            }
        }
        return list;
    }

    public List<Employees> findName(String name) {
        List<Employees> list = new ArrayList<Employees>();
        for (Employees e : listEmployees) {
            if (e.getNameEmployees().equals(name)) {
                list.add(e);
            }
        }
        return list;
    }

    public List<Employees> findIdName(String id, String name) {
        List<Employees> list = new ArrayList<Employees>();
        for (Employees e : listEmployees) {
            if (e.getNameEmployees().equals(name) && e.getIdEmployees().equals(id)) {
                list.add(e);
            }
        }
        return list;
    }

    public Employees edit(String id) {
        for (Employees e : listEmployees) {
            if (e.getIdEmployees().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void update(Employees employees) {
        String id = employees.getIdEmployees();
        for (Employees e : listEmployees) {
            if (id.equals(e.getIdEmployees())) {
                e.setNameEmployees(employees.getNameEmployees());
                e.setStatusEmployees(employees.getStatusEmployees());
                e.setSalaryEmployees(employees.getSalaryEmployees());
                e.setTypesEmployees(employees.getTypesEmployees());
                writeEmployeesToFile(listEmployees, FILE_EMPLOYEES);
            }
        }
    }

    public List<Employees> unWorking(){
        List<Employees> list = new ArrayList<Employees>();
        for(Employees e: listEmployees){
                System.out.println(e.getStatusEmployees());
            if(e.getStatusEmployees().equals("Not Working")){
                list.add(e);
            }
        }
        return list;
    }

    public List<Employees> working(){
        List<Employees> list = new ArrayList<Employees>();
        for(Employees e: listEmployees){
            System.out.println(e.getStatusEmployees());
            if(e.getStatusEmployees().equals("Working")){
                list.add(e);
            }
        }
        return list;
    }

    public List<Employees> getListEmployees() {
        return listEmployees;
    }

    public void setListStudents(List<Employees> listEmployees) {
        this.listEmployees = listEmployees;
    }

}
