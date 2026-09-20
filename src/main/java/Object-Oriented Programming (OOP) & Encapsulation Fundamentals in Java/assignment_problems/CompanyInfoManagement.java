class CompanyEmployee {
    String empName;
    double salary;

    // Shared static fields across all instances
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // Increment count on every object instantiation
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyInfoManagement {
    public static void main(String[] args) {
        // Instantiate 3 Employee objects
        CompanyEmployee emp1 = new CompanyEmployee("Aarav", 50000);
        CompanyEmployee emp2 = new CompanyEmployee("Bhavna", 60000);
        CompanyEmployee emp3 = new CompanyEmployee("Chetan", 55000);

        // Call static method through class name, NOT through instance
        CompanyEmployee.printCompanyInfo();
    }
}