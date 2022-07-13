package quanlinhanvien.module2.MVC.Model.Entity;

public class Employees {

    // property by Employees
    private String idEmployees;
    private String nameEmployees;
    private String statusEmployees;
    private String typesEmployees;
    private String salaryEmployees;

    public static final double FULLTIME = 3.14;
    public static final double PARTTIME = 2.1;

    // method by Employees  
    public Employees() {
    }

    public Employees(String idEmployees, String nameEmployees, String statusEmployees, String salary, String typesEmployees) {
        this.idEmployees = idEmployees;
        this.nameEmployees = nameEmployees;
        this.statusEmployees = statusEmployees;
        this.salaryEmployees = salary;
        this.typesEmployees = typesEmployees;
    }

    //-----------------------setter and getter--------------------------------------//
    public String getIdEmployees() {
        return idEmployees;
    }

    public String getNameEmployees() {
        return nameEmployees;
    }

    public String getStatusEmployees() {
        return statusEmployees;
    }

    public String getTypesEmployees() {
        return typesEmployees;
    }

    public String getSalaryEmployees() {
        return salaryEmployees;
    }

    public static double getFULLTIME() {
        return FULLTIME;
    }

    public static double getPARTTIME() {
        return PARTTIME;
    }


    public void setIdEmployees(String idEmployees) {
        this.idEmployees = idEmployees;
    }

    public void setNameEmployees(String nameEmployees) {
        this.nameEmployees = nameEmployees;
    }

    public void setStatusEmployees(String statusEmployees) {
        this.statusEmployees = statusEmployees;
    }

    public void setTypesEmployees(String typesEmployees) {
        this.typesEmployees = typesEmployees;
    }

    public void setSalaryEmployees(String salary) {
        this.salaryEmployees = salary;
    }
    //-----------------------------------------------------------------------------------//
    @Override
    public String toString() {
        return this.idEmployees + "-" + this.nameEmployees + "-" + this.statusEmployees + "-" + this.salaryEmployees + "-" + this.typesEmployees + "\n";
    }

    public <Employees> Comparable<Employees> getLastNameEmployees() {

        return null;
    }
}
