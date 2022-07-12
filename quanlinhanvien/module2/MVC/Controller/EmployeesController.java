package quanlinhanvien.module2.MVC.Controller;

import quanlinhanvien.module2.MVC.Model.Entity.Employees;
import quanlinhanvien.module2.MVC.Model.dao.EmployeesDao;
import quanlinhanvien.module2.MVC.View.EmployeesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmployeesController {

    private EmployeesView employeesView;
    private EmployeesDao employeesDao;


    // ------------------------------constructor-------------------------------//
    public EmployeesController(EmployeesView view) {
        this.employeesView = view;
        employeesDao = new EmployeesDao();
        view.addFindEmployeesListener(new FindEmployeesListener());
        view.addAddEmployeesListener(new AddEmployeesListener());
        view.addEditEmployeesListener(new EditEmployeesListener());
        view.addDeleteEmployeesListener(new DeleteEmployeesListener());
        view.addShowEmployeesListener(new ShowEmployeesListener());
        view.addUpdateEmployeesListener(new UpdateEmployeesListener());
        view.addShowByUnWorkingEmployeeListener(new showUnworkingEmployeesListener());
        view.addShowByWorkingEmployeeListener(new showWorkingEmployeesListener());
    }
    // ---------------------------------------------------------------------------------//


    // -----------------------------show list out table-------------------------------//
    public void showEmployeesView() {
        employeesView.setVisible(true);
    }

    // ------------------------------add employees---------------------------------//
    class AddEmployeesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("call add");
            Employees employees = employeesView.getInformation();
            if (employees != null && employeesView.checkExists(employeesDao.getListEmployees())) {
                employeesDao.add(employees);
                employeesView.showEmloyees(employees);
                employeesView.showListEmloyees(employeesDao.getListEmployees());
                employeesView.showMessage("Add successfully");
            }
            employeesView.clearInformationEmployees();
        }
    }
    // ---------------------------------------------------------------------------------//

    //----------------------------------Edit employees---------------------------------//
    class EditEmployeesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("edit");
            String id = employeesView.getIdEmployees();
            if (id != null && employeesDao.edit(id) != null) {
                employeesView.setInformation(employeesDao.edit(id));
                employeesView.setFindBtnDisable();
                employeesView.setAddBtnDisable();
                employeesView.setUpdateBtnEnable();
                employeesView.setEditBtnDisable();
                employeesView.setIdFieldDisable();
                System.out.println("enable update duoc roi");
            }
        }
    }
    // ---------------------------------------------------------------------------------//


    // ---------------------------------find employees by name-----------------------------//
    class FindEmployeesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("call find");
            String name = employeesView.getNameEmployees();
            if (name != null) {
                if (employeesDao.findName(name).isEmpty()) {
                    employeesView.showMessage("Don't exits!");
                } else {
                    employeesView.showListEmloyees(employeesDao.findName(name));
                }
            }
        }
    }
    // ---------------------------------------------------------------------------------//


    // -------------------------------delete employees by id------------------------------//
    class DeleteEmployeesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("call delete");
            String id = employeesView.getIdEmployees();
            Employees employees = new Employees();
            if (id != null) {
                if (employeesDao.delete(id)) {
                    employeesView.setFindBtnEnable();
                    employeesView.setAddBtnEnable();
                    employeesView.setUpdateBtnDisable();
                    employeesView.setEditBtnEnable();
                    employeesView.setIdFieldEnable();
                    employeesView.showListEmloyees(employeesDao.getListEmployees());
                    employeesView.showMessage("Delete successfully");
                } else {
                    employeesView.showMessage(id + " Don't exits!");
                }
            }
            employeesView.clearInformationEmployees();
        }
    }
    // ---------------------------------------------------------------------------------//


    // ---------------------------------show employees----------------------------------//
    class ShowEmployeesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("Called show employees in table");
            List<Employees> employeesList = employeesDao.getListEmployees();
            employeesView.showListEmloyees(employeesList);
        }
    }
    // ---------------------------------------------------------------------------------//


    // ---------------------------save employees when edit------------------------------//
    class UpdateEmployeesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.out.println("call update");
            Employees employees = employeesView.getInformation();
            if (employees != null) {
                employeesDao.update(employees);
                employeesView.showEmloyees(employees);  // show ra thong tin tren console
                employeesView.showListEmloyees(employeesDao.getListEmployees());// show ra table
                employeesView.setFindBtnEnable();
                employeesView.setAddBtnEnable();
                employeesView.setUpdateBtnDisable();
                employeesView.setEditBtnEnable();
                employeesView.setIdFieldEnable();
                employeesView.clearInformationEmployees();
                employeesView.showMessage("Update Successfull");
            }
        }
    }
    // ---------------------------------------------------------------------------------//


    // ------------------------------show employees working--------------------------------//
    class showWorkingEmployeesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("call show working");
            if (employeesDao.working().isEmpty()) {
                employeesView.showMessage("Empty!");
            } else {
                employeesView.showListEmloyees(employeesDao.working());
            }
        }
    }
    // ----------------------------------------------------------------------------------------//


    // ---------------------------------show employees not working------------------------------//
    class showUnworkingEmployeesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("call show not Unworking");
            if (employeesDao.unWorking().isEmpty()) {
                employeesView.showMessage("Empty!");
            } else {
                employeesView.showListEmloyees(employeesDao.unWorking());
            }
        }
    }
    // ---------------------------------------------------------------------------------//
}
