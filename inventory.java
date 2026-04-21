import java.util.*;

class Product {
    String name;
    int quantity;
    double price;

    Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("Product Name : " + name);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : " + price);
    }
}

public class inventory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    
        HashMap<Integer, Product> inventory = new HashMap<>();

        try {

            System.out.print("Enter number of products: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {

                System.out.println("\nEnter Product Detail of "+ i+1);

                System.out.print("Product ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Product Name: ");
                String name = sc.nextLine();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                if (quantity < 0 || price < 0) {
                    throw new Exception("Quantity or Price cannot be negative");
                }

                Product p = new Product(name, quantity, price);

                
                inventory.put(id, p);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n----- INVENTORY STOCK -----");

        
        for (Map.Entry<Integer, Product> entry : inventory.entrySet()) {

            System.out.println("Product ID: " + entry.getKey());
            entry.getValue().display();
            System.out.println("----------------------------");
        }

        sc.close();
    }
}