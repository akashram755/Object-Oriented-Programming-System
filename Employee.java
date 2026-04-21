import java.util.Scanner;

interface Payroll {
    void displayPayroll();
}

class Salary {

    private double basicPay;
    private double allowance;
    private double deduction;

    Salary(double basic, double allow, double deduct) {
        basicPay = basic;
        allowance = allow;
        deduction = deduct;
    }

    double calculateSalary() {
        return basicPay + allowance - deduction;
    }
}

public class Employee implements Payroll {

    private int employeeId;
    private String employeeName;
    private Salary salary;

    Employee(int id, String name, Salary sal) {
        employeeId = id;
        employeeName = name;
        salary = sal;
    }

    public void displayPayroll() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Net Salary: " + salary.calculateSalary());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Pay: ");
        double basic = sc.nextDouble();

        System.out.print("Enter Allowance: ");
        double allow = sc.nextDouble();

        System.out.print("Enter Deduction: ");
        double deduct = sc.nextDouble();

        Salary sal = new Salary(basic, allow, deduct);
        Employee emp = new Employee(id, name, sal);

        emp.displayPayroll();

        sc.close();
    }
}