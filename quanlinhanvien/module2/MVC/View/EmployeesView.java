package quanlinhanvien.module2.MVC.View;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;

import static javax.swing.BorderFactory.createEmptyBorder;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import quanlinhanvien.module2.MVC.Model.Entity.Employees;

public class EmployeesView extends JFrame implements ActionListener, ListSelectionListener {

    private JButton findEmployeesBtn;
    private JButton addEmployeesBtn;
    private JButton deleteEmployeesBtn;
    private JButton editEmployeesBtn;
    private JButton showEmployeesBtn;
    private JButton updateEmployeesBtn;
    private JButton showWorkingEmployeesBtn;
    private JButton showUnworkingEmployeesBtn;
    private JButton sortBySalaryEmployeesBtn;

    private JLabel nameFrame;
    private JLabel idEmployees;
    private JLabel nameEmployees;
    private JLabel salaryEmployees;
    private JLabel typeEmployees;
    private JLabel statusEmployees;

    private ButtonGroup buttonStatus;
    private ButtonGroup buttonType;
    private JScrollPane jScrollPaneEmployeesTable;
    private JTable employeesTable;

    private JTextField idField;
    private JTextField nameField;
    private JTextField salaryField;
    private JRadioButton onStatus;
    private JRadioButton offStatus;
    private JRadioButton fulltimeEmployees;
    private JRadioButton parttimeEmployees;

    // định nghĩa các cột của bảng employees
    private String[] columnNames = new String[]{
            "ID", "Name", "Status", "Salary", "Type"};

    // định nghĩa dữ liệu mặc định của bẳng employees là rỗng
    private Object data = new Object[][]{
    };

    public EmployeesView() {
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        findEmployeesBtn = new JButton("Find");
        addEmployeesBtn = new JButton("Add");
        deleteEmployeesBtn = new JButton("Delete");
        editEmployeesBtn = new JButton("Edit");
        showEmployeesBtn = new JButton("Show");
        updateEmployeesBtn = new JButton("Save");
        showWorkingEmployeesBtn = new JButton("Working");
        showUnworkingEmployeesBtn = new JButton("UnWorking");
        updateEmployeesBtn.setEnabled(false);
        buttonStatus = new ButtonGroup();
        buttonType = new ButtonGroup();

        // khởi tạo bảng employees  
        jScrollPaneEmployeesTable = new JScrollPane();
        employeesTable = new JTable();

        // khởi tạo các label
        nameFrame = new JLabel("Quản Lý Nhân Viên");
        idEmployees = new JLabel("Mã nhân viên:");
        nameEmployees = new JLabel("Họ và tên:");
        statusEmployees = new JLabel("Trạng thái:");
        typeEmployees = new JLabel("Loại nhân viên:");
        salaryEmployees = new JLabel("Tiền lương:");

        // khởi tạo các trường nhập dữ liệu cho employees
        idField = new JTextField(25);
        nameField = new JTextField(25);
        onStatus = new JRadioButton("Working");
        offStatus = new JRadioButton("Not Working");
        salaryField = new JTextField(25);
        fulltimeEmployees = new JRadioButton("Fulltime");
        parttimeEmployees = new JRadioButton("Parttime");

        // cài đặt các cột và data cho bảng employees
        employeesTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneEmployeesTable.setViewportView(employeesTable);
        jScrollPaneEmployeesTable.setPreferredSize(new Dimension(790, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        GridLayout layoutButton = new GridLayout(3, 3);
        layoutButton.setHgap(10);
        layoutButton.setVgap(35);

        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Employees
        JPanel panel = new JPanel();
        JPanel panelButton = new JPanel(layoutButton);
        panelButton.setSize(300, 200);
//        panelButton.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setSize(850, 470);
        panel.setLayout(layout);
        panel.add(jScrollPaneEmployeesTable);

        panelButton.add(findEmployeesBtn);
        panelButton.add(addEmployeesBtn);
        panelButton.add(deleteEmployeesBtn);
        panelButton.add(editEmployeesBtn);
        panelButton.add(showEmployeesBtn);
        panelButton.add(updateEmployeesBtn);
        panelButton.add(showWorkingEmployeesBtn);
        panelButton.add(showUnworkingEmployeesBtn);
        panel.add(panelButton);

        panel.add(nameFrame);
        panel.add(idEmployees);
        panel.add(nameEmployees);
        panel.add(salaryEmployees);
        panel.add(typeEmployees);
        panel.add(statusEmployees);

        // nhóm button
        panel.add(idField);
        panel.add(nameField);
        panel.add(salaryField);
        idField.setBorder(BorderFactory.createCompoundBorder(idField.getBorder(), createEmptyBorder(0, 3, 2, 0)));
        nameField.setBorder(BorderFactory.createCompoundBorder(nameField.getBorder(), createEmptyBorder(0, 3, 2, 0)));
        salaryField.setBorder(BorderFactory.createCompoundBorder(salaryField.getBorder(), createEmptyBorder(0, 3, 2, 0)));
        employeesTable.setBorder(BorderFactory.createCompoundBorder(salaryField.getBorder(), createEmptyBorder(0, 4, 4, 0)));
        employeesTable.setEnabled(false);

        buttonStatus.add(onStatus);
        buttonStatus.add(offStatus);
        buttonType.add(fulltimeEmployees);
        buttonType.add(parttimeEmployees);
//
        panel.add(onStatus);
        panel.add(offStatus);
        panel.add(fulltimeEmployees);
        panel.add(parttimeEmployees);

        // set font for element
        Font font = new Font("Cormorant", Font.BOLD, 15);
        Font fontField = new Font("Oswald", Font.PLAIN, 13);
        nameFrame.setFont(new Font("BioRhyme", Font.ITALIC, 50));
        idEmployees.setFont(font);
        nameEmployees.setFont(font);
        statusEmployees.setFont(font);
        salaryEmployees.setFont(font);
        typeEmployees.setFont(font);
        onStatus.setFont(fontField);
        offStatus.setFont(fontField);
        fulltimeEmployees.setFont(fontField);
        parttimeEmployees.setFont(fontField);
        employeesTable.setFont(new Font("Oswald", Font.PLAIN, 14));
        idField.setFont(fontField);
        nameField.setFont(fontField);
        salaryField.setFont(fontField);

        // set position for elements
        // set position for button
        layout.putConstraint(SpringLayout.EAST, panelButton, -30, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, panelButton, 80, SpringLayout.NORTH, panel);

        // set title
        layout.putConstraint(SpringLayout.WEST, nameFrame, 195, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameFrame, 8, SpringLayout.NORTH, panel);

        // set Label
        layout.putConstraint(SpringLayout.EAST, idEmployees, -670, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, idEmployees, 85, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, nameEmployees, -670, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameEmployees, 115, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, typeEmployees, -670, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, typeEmployees, 206, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, statusEmployees, -670, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, statusEmployees, 147, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, salaryEmployees, -670, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, salaryEmployees, 176, SpringLayout.NORTH, panel);
// 

// set getValue
        layout.putConstraint(SpringLayout.EAST, idField, -380, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 85, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, nameField, -380, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 115, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, salaryField, -380, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.NORTH, salaryField, 177, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, onStatus, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, onStatus, 145, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, offStatus, 230, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, offStatus, 145, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, fulltimeEmployees, 350, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, fulltimeEmployees, 205, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, parttimeEmployees, 230, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, parttimeEmployees, 205, SpringLayout.NORTH, panel);

        // set position table list employees
        layout.putConstraint(SpringLayout.WEST, jScrollPaneEmployeesTable, 23, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.SOUTH, jScrollPaneEmployeesTable, -15, SpringLayout.SOUTH, panel);

        // set width and height for table
        employeesTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        employeesTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        employeesTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        employeesTable.getColumnModel().getColumn(3).setPreferredWidth(140);
        employeesTable.getColumnModel().getColumn(4).setPreferredWidth(190);
        employeesTable.setRowHeight(21);

        this.add(panel);
        this.pack();
        this.setResizable(false);
        this.setSize(850, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Employees Information");
    }

    // show allow message
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // get info and assign in table
    public void showListEmloyees(List<Employees> list) {
        System.out.println("show table");
        int size = list.size();
        Object[][] employees = new Object[size][5];
        for (int i = 0; i < size; i++) {
            employees[i][0] = list.get(i).getIdEmployees();
            employees[i][1] = list.get(i).getNameEmployees();
            employees[i][2] = list.get(i).getStatusEmployees();
            employees[i][3] = list.get(i).getSalaryEmployees();
            employees[i][4] = list.get(i).getTypesEmployees();
        }
        employeesTable.setModel(new DefaultTableModel(employees, columnNames));
        employeesTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        employeesTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        employeesTable.getColumnModel().getColumn(2).setPreferredWidth(130);
        employeesTable.getColumnModel().getColumn(3).setPreferredWidth(140);
        employeesTable.getColumnModel().getColumn(4).setPreferredWidth(190);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        employeesTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        employeesTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        employeesTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        employeesTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }

    // set information
    public void setInformation(Employees employees) {
        idField.setText(employees.getIdEmployees());
        nameField.setText(employees.getNameEmployees());
        salaryField.setText(employees.getSalaryEmployees());
        String status = employees.getStatusEmployees();
        String type = employees.getTypesEmployees();
        offStatus.setSelected("Not Working".equals(status) ? true : false);
        onStatus.setSelected("Working".equals(status) ? true : false);
        fulltimeEmployees.setSelected("Fulltime".equals(type) ? true : false);
        fulltimeEmployees.setSelected("Parttime".equals(type) ? true : false);
    }

    // get information by employees

    public Employees getInformation() {
        if (!validateId()) {
            System.out.println("error id");
            return null;
        } else if (!validateName()) {
            System.out.println("error name");
            return null;
        } else if (!validateStatus()) {
            System.out.printf("error status");
            return null;
        } else if (!validateSalary()) {
            System.out.println("error salary");
            return null;
        } else if (!validateType()) {
            System.out.println("error type");
            return null;
        } else {
            System.out.println("not error validate");
        }

        try {
            System.out.println("lay thong tin cua nguoi lao dong");
            Employees employees = new Employees();
            employees.setIdEmployees(idField.getText());
            employees.setNameEmployees(PacalCase(nameField.getText().toLowerCase()));
            employees.setSalaryEmployees(salaryField.getText());
            employees.setStatusEmployees(onStatus.isSelected() ? "Working" : "Not Working");
            employees.setTypesEmployees(fulltimeEmployees.isSelected() ? "Fulltime" : "Parttime");
            return employees;
        } catch (Exception exception) {
            showMessage(exception.getMessage());
        }
        return null;
    }

    public boolean checkExists(List<Employees> list) {
        String id = idField.getText();
        for (Employees e : list) {
            if (id.equals(e.getIdEmployees())) {
                showMessage("ID existed");
                return false;
            }
        }
        return true;
    }

    public String getIdEmployees() {
        if (!validateId()) {
            return null;
        }
        return idField.getText();
    }

    public String getId() {
        if (idField.getText() != null || "".equals(idField.getText())) {
            return idField.getText();
        }
        return null;
    }

    public String getNameEmployees() {
        if (!validateName()) {
            return null;
        }
        return PacalCase(nameField.getText());
    }

    //    public String getName(){
//        String name = nameField.getText();
//        if(name != null || !"".equals(name.trim())){
//            return PacalCase(name.toLowerCase());
//        }
//        return null;
//    }
    public void showEmloyees(Employees employees) {
        System.out.println(employees.getIdEmployees());
        System.out.println(employees.getNameEmployees());
        System.out.println(employees.getStatusEmployees());
        System.out.println(employees.getSalaryEmployees());
        System.out.println(employees.getTypesEmployees());
    }

    public void clearInformationEmployees() {
        idField.setText("");
        nameField.setText("");
        buttonStatus.clearSelection();
        buttonType.clearSelection();
        salaryField.setText("");
    }

    private String PacalCase(String text) {
        String a[] = text.split(" ");
        text = "";
        for (String i : a) {
            char c[] = i.toCharArray();
            c[0] -= 32;
            if (text != "") {
                text += " ";
            }
            i = String.valueOf(c);
            text = text + i;
            System.out.println(i);
        }
        System.out.println(text);
        return text;
    }

    // check validate
    private boolean validateId() {
        String id = idField.getText();
        if (id == null || "".equals(id.trim())) {
            idField.requestFocus();
            showMessage("Mã nhân viên  không được để trống!");
            return false;
        }
        String exem = "[0-9]{9}";
        if(!id.matches(exem)){
            showMessage("Nhập mã nhân viên từ 9 số từ 0-9!");
            return false;
        }
        return true;
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Tên không được trống!");
            return false;
        }
        String exem = "[^0-9][a-zA-Z]{5,35}";
        if(!name.matches(exem)){
            showMessage("Nhập tên không chứa ký tự và số!");
            return false;
        }
        return true;
    }

    private boolean validateSalary() {
        String salary = salaryField.getText();
        if (salary == null || "".equals(salary.trim())) {
            salaryField.requestFocus();
            showMessage("Tiền lương không được trống!");
            return false;
        }
        String exem = "[^0][0-9]{5,15}";
        if(!salary.matches(exem)){
            showMessage("Nhập lương >= số từ 100,000!");
            return false;
        }
        return true;
    }

    private boolean validateStatus() {
        if (onStatus.isSelected() || offStatus.isSelected()) {
            System.out.println("check status successfull");
            return true;
        } else {
            System.out.println("check status not successfull");
            showMessage("Status không được để trống!");
            return false;
        }
    }

    private boolean validateType() {
        if (fulltimeEmployees.isSelected() || parttimeEmployees.isSelected()) {
            System.out.println("check type successfully");
            return true;
        } else {
            System.out.println("check type not successfull");
            showMessage("Type không được để trống!");
            return false;
        }
    }

    // ----------------------------------set enable and disable button------------------------------------
    public void setUpdateBtnEnable() {
        updateEmployeesBtn.setEnabled(true);
    }

    public void setUpdateBtnDisable() {
        updateEmployeesBtn.setEnabled(false);
    }

    public void setEditBtnEnable() {
        editEmployeesBtn.setEnabled(true);
    }

    public void setEditBtnDisable() {
        editEmployeesBtn.setEnabled(false);
    }

    public void setFindBtnEnable() {
        findEmployeesBtn.setEnabled(true);
    }

    public void setFindBtnDisable() {
        findEmployeesBtn.setEnabled(false);
    }

    public void setAddBtnEnable() {
        addEmployeesBtn.setEnabled(true);
    }

    public void setAddBtnDisable() {
        addEmployeesBtn.setEnabled(false);
    }

    public void setIdFieldEnable() {
        idField.setEditable(true);
    }

    public void setIdFieldDisable() {
        idField.setEditable(false);
    }

//    ------------------------------------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    public void addListEmployeesSelectionListener(ListSelectionListener listener) {
        employeesTable.getSelectionModel().addListSelectionListener(listener);
    }

    public void addFindEmployeesListener(ActionListener e) {
        findEmployeesBtn.addActionListener(e);
    }

    public void addAddEmployeesListener(ActionListener e) {
        addEmployeesBtn.addActionListener(e);
    }

    public void addEditEmployeesListener(ActionListener e) {
        editEmployeesBtn.addActionListener(e);
    }


    public void addShowEmployeesListener(ActionListener e) {
        showEmployeesBtn.addActionListener(e);
    }

    public void addUpdateEmployeesListener(ActionListener e) {
        updateEmployeesBtn.addActionListener(e);
    }

    public void addDeleteEmployeesListener(ActionListener e) {
        deleteEmployeesBtn.addActionListener(e);
    }

    public void addShowByWorkingEmployeeListener(ActionListener e){
        showWorkingEmployeesBtn.addActionListener(e);
    }

    public void addShowByUnWorkingEmployeeListener(ActionListener e){
        showUnworkingEmployeesBtn.addActionListener(e);
    }
}
