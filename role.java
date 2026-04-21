class User {

    protected String name;
    protected int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void showRole() {
        System.out.println("General User");
    }

    public void showDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Employee extends User {

    public Employee(String name, int id) {
        super(name, id);
    }

    public void showRole() {
        System.out.println("Role: Employee");
    }

    public void doWork() {
        System.out.println(name + " is doing office work.");
    }
}

class Course extends User {

    private String courseName;

    public Course(String name, int id, String courseName) {
        super(name, id);
        this.courseName = courseName;
    }

    public void showRole() {
        System.out.println("Role: Course Manager");
    }

    public void manageCourse() {
        System.out.println(name + " manages the course: " + courseName);
    }
}

class Account extends User {

    public Account(String name, int id) {
        super(name, id);
    }

    public void showRole() {
        System.out.println("Role: Account Manager");
    }

    public void handleAccounts() {
        System.out.println(name + " handles company accounts.");
    }
}

public class role {

    public static void main(String[] args) {

        Employee emp = new Employee("Akash", 101);
        Course course = new Course("Ravi", 102, "Java");
        Account acc = new Account("Meena", 103);

        emp.showDetails();
        emp.showRole();
        emp.doWork();

        course.showDetails();
        course.showRole();
        course.manageCourse();

        acc.showDetails();
        acc.showRole();
        acc.handleAccounts();
    }
}