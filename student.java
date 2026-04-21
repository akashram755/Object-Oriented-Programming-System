import java.util.*;

class Student {

    String name;
    String isPresent;
    String mood;
    String activity;

    Student(String name, String isPresent, String mood, String activity) {
        this.name = name;
        this.isPresent = isPresent;
        this.mood = mood;
        this.activity = activity;
    }

    void showStatus() {
        System.out.println("Name: " + name);
        System.out.println("Status: " + isPresent);
    }

    void present() {
        System.out.println("Mood: " + mood);
        System.out.println("Today's Activity: " + activity);
    }

    void absent() {
        System.out.println("The student was absent");
    }
}

public class student {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Is Present: ");
            String isPresent = sc.nextLine();

            System.out.print("Mood (Happy/Normal/Tired): ");
            String mood = sc.nextLine();

            System.out.print("Today Activity: ");
            String activity = sc.nextLine();

            students[i] = new Student(name, isPresent, mood, activity);
        }

        System.out.println("--------------------------------");

        for (int i = 0; i < n; i++) {

            students[i].showStatus();

            if (students[i].isPresent.equalsIgnoreCase("absent")) {
                students[i].absent();
            } else {
                students[i].present();
            }

            System.out.println("--------------------------------");
        }

        sc.close();
    }
}