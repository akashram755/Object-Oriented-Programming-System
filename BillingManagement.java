import java.util.*;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotal() {
        return price * quantity;
    }
}

public class BillingManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        ArrayList<Item> bill = new ArrayList<Item>();

        try {

            System.out.print("Enter number of items: ");
            int n = sc.nextInt();
            sc.nextLine();

            for(int i = 1; i <= n; i++) {

                System.out.println("\nEnter details for item " + i);

                System.out.print("Item name: ");
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();

                if(price < 0 || quantity < 0) {
                    throw new Exception("Price and Quantity cannot be negative");
                }

                
                bill.add(new Item(name, price, quantity));
            }

        }
        catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n------ BILL RECEIPT ------");

        double grandTotal = 0;

        for(Item i : bill) {
            System.out.println("Item: " + i.name +
                               " Price: " + i.price +
                               " Quantity: " + i.quantity +
                               " Total: " + i.getTotal());

            grandTotal += i.getTotal();
        }

        System.out.println("--------------------------");
        System.out.println("Grand Total: " + grandTotal);

        sc.close();
    }
}