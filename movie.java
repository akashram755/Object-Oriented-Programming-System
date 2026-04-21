import java.util.*;

class Show {
    String movieName;
    int availableSeats;

    Show(String movieName, int seats) {
        this.movieName = movieName;
        this.availableSeats = seats;
    }
}

class Customer {
    String name;
    int seatsBooked;

    Customer(String name, int seatsBooked) {
        this.name = name;
        this.seatsBooked = seatsBooked;
    }
}

public class movie {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        HashMap<String, Show> shows = new HashMap<>();
        ArrayList<Customer> customers = new ArrayList<>();

        
        shows.put("Avengers", new Show("Avengers", 10));
        shows.put("Batman", new Show("Batman", 8));
        shows.put("Spiderman", new Show("Spiderman", 5));

        try {

            System.out.println("Available Shows:");
            for (String s : shows.keySet()) {
                System.out.println(s);
            }

            System.out.print("Enter show name: ");
            String showName = sc.nextLine();

            if (!shows.containsKey(showName)) {
                throw new Exception("Show not available");
            }

            Show selectedShow = shows.get(showName);

            System.out.print("Enter customer name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of seats: ");
            int seats = sc.nextInt();

            if (seats > selectedShow.availableSeats) {
                throw new Exception("Not enough seats available");
            }

            
            selectedShow.availableSeats -= seats;

            customers.add(new Customer(name, seats));

            System.out.println("Booking successful!");

        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        
        System.out.println("\nRemaining Seats:");
        for (Show s : shows.values()) {
            System.out.println(s.movieName + " : " + s.availableSeats);
        }

        sc.close();
    }
}