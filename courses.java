import java.util.Scanner;

class Course {

    private int courseId;
    private String courseName;
    private String instructor;
    private int enrolledStudents;

    public void setCourseDetails(int id, String name, String teacher, int students) {
        courseId = id;
        courseName = name;
        instructor = teacher;
        enrolledStudents = students;
    }

    public void displayCourseDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled Students: " + enrolledStudents);
    }

    public void addStudent() {
        enrolledStudents++;
        System.out.println("Student added successfully!");
    }
}

public class courses {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Course course = new Course();

        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Instructor Name: ");
        String instructor = sc.nextLine();

        System.out.print("Enter Number of Students: ");
        int students = sc.nextInt();

        course.setCourseDetails(id, name, instructor, students);

        int choice;

        do {
            System.out.println("\n1. View Course Details");
            System.out.println("2. Add Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    course.displayCourseDetails();
                    break;

                case 2:
                    course.addStudent();
                    break;

                case 3:
                    System.out.println("Exiting Course Management System");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}