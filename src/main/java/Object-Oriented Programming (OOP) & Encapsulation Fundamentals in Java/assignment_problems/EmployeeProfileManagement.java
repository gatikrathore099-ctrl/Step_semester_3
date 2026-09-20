class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Primary constructor for permanent employees
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor chaining via this(...) for interns
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileManagement {
    public static void main(String[] args) {
        Employee permEmp = new Employee("E-101", "Divya", 65000);
        Employee internEmp = new Employee("E-102", "Arjun");

        permEmp.printProfile();
        internEmp.printProfile();
    }
}
