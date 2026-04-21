import java.util.*;

class MobilePhone {

    String brand;
    String model;
    int ram;
    int storage;
    double price;

    MobilePhone(String brand, String model, int ram, int storage, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
    }

    void display() {
        System.out.println("Brand   : " + brand);
        System.out.println("Model   : " + model);
        System.out.println("RAM     : " + ram + " GB");
        System.out.println("Storage : " + storage + " GB");
        System.out.println("Price   : " + price);
    }
}

public class mobile {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of mobile phones: ");
        int n = sc.nextInt();
        sc.nextLine();

        MobilePhone mobile[] = new MobilePhone[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details of phone " + (i + 1));

            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("RAM (GB): ");
            int ram = sc.nextInt();

            System.out.print("Storage (GB): ");
            int storage = sc.nextInt();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            if (ram < 0 || storage < 0 || price < 0) {
                System.out.println("Invalid Input");
            } 
            else {
                mobile[i] = new MobilePhone(brand, model, ram, storage, price);
                mobile[i].display();
            }
        }

        sc.close();
    }
}