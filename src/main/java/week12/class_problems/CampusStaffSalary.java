package week12.class_problems;

import java.util.Scanner;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }
}

class Teacher extends Staff {
    Teacher(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher"))
                staff[i] = new Teacher(name, salary);
            else if (type.equals("LabAssistant"))
                staff[i] = new LabAssistant(name, salary);
            else
                staff[i] = new Staff(name, salary);
        }

        for (Staff s : staff) {
            double bonus = s.getBonus();
            double total = s.baseSalary + bonus;
            grandTotal += total;

            System.out.println(s.name + " (" + s.getType()
                    + "): base " + s.baseSalary
                    + ", bonus " + bonus + ", total " + total);
        }

        System.out.println("Grand Total Salary: " + grandTotal);

        sc.close();
    }
}