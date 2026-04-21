import java.util.Scanner;

interface Restaurant {
    String getName();
    int getPrice();
}

class FastFood implements Restaurant {
    public String getName() { return "Fast Food"; }
    public int getPrice() { return 100; }
}

class VegRestaurant implements Restaurant {
    public String getName() { return "Veg Restaurant"; }
    public int getPrice() { return 150; }
}

class PremiumRestaurant implements Restaurant {
    public String getName() { return "Premium Restaurant"; }
    public int getPrice() { return 250; }
}


class RestaurantFactory {
    public static Restaurant getRestaurant(int choice) {
        switch (choice) {
            case 1: return new FastFood();
            case 2: return new VegRestaurant();
            case 3: return new PremiumRestaurant();
            default: return null;
        }
    }
}

class DeliveryThread extends Thread {
    public void run() {
        try {
            System.out.println("\nOrder placed... Preparing food 🍳");
            Thread.sleep(2000);

            System.out.println("Out for delivery 🚚");
            Thread.sleep(2000);

            System.out.println("Delivered! Enjoy your meal 🍽️\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class OrderService {
    public int calculateBill(Restaurant r, int quantity) {
        return r.getPrice() * quantity;
    }
}

public class Food {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Food Delivery App ===");
        System.out.println("1. Fast Food");
        System.out.println("2. Veg Restaurant");
        System.out.println("3. Premium Restaurant");

        System.out.print("Choose restaurant: ");
        int choice = sc.nextInt();
        sc.nextLine(); 

        Restaurant restaurant = RestaurantFactory.getRestaurant(choice);

        if (restaurant == null) {
            System.out.println("Invalid choice!");
            return;
        }

       
        System.out.print("Enter food item name: ");
        String foodName = sc.nextLine();

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        OrderService service = new OrderService();
        int total = service.calculateBill(restaurant, qty);

        System.out.println("\n=== ORDER DETAILS ===");
        System.out.println("Restaurant: " + restaurant.getName());
        System.out.println("Food Item: " + foodName);
        System.out.println("Quantity: " + qty);
        System.out.println("Total Bill: ₹" + total);

        DeliveryThread dt = new DeliveryThread();
        dt.start();

        sc.close();
    }
}