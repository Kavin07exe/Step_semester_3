package week6.assigment_problems;

public class EmployeeCompanyInfo {

    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {

        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    static void printCompanyInfo() {

        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeCompanyInfo employee1 =
                new EmployeeCompanyInfo("Divya", 65000);

        EmployeeCompanyInfo employee2 =
                new EmployeeCompanyInfo("Arjun", 45000);

        EmployeeCompanyInfo employee3 =
                new EmployeeCompanyInfo("Ravi", 55000);

        System.out.println("3 Employee objects created");

        EmployeeCompanyInfo.printCompanyInfo();
    }
}