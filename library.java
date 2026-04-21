import java.util.*;

class ReadingLog {

    String studentName;
    String bookName;
    int daysRead;
    String status;

    ReadingLog(String studentName, String bookName, int daysRead, String status) {
        this.studentName = studentName;
        this.bookName = bookName;
        this.daysRead = daysRead;
        this.status = status;
    }

    void showInfo() {
        System.out.println("Student Name : " + studentName);
        System.out.println("Book Name    : " + bookName);
        System.out.println("Days Read    : " + daysRead);
        System.out.println("Status       : " + status);
    }

    void completed() {
        System.out.println("Book reading completed!");
    }

    void inProgress() {
        System.out.println("Reading in progress...");
    }
}

public class library {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of reading records: ");
        int n = sc.nextInt();
        sc.nextLine();

        ReadingLog[] logs = new ReadingLog[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nReading Record " + (i + 1));

            System.out.print("Student Name: ");
            String student = sc.nextLine();

            System.out.print("Book Name: ");
            String book = sc.nextLine();

            System.out.print("Days Read: ");
            int days = sc.nextInt();
            sc.nextLine();

            System.out.print("Status (Completed/InProgress): ");
            String status = sc.nextLine();

            logs[i] = new ReadingLog(student, book, days, status);
        }

        System.out.println("-----------------------------");

        for (int i = 0; i < n; i++) {

            logs[i].showInfo();

            if (logs[i].status.equalsIgnoreCase("completed")) {
                logs[i].completed();
            } 
            else {
                logs[i].inProgress();
            }

            System.out.println("-----------------------------");
        }

        sc.close();
    }
}