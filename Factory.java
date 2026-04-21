import javax.swing.*;
import java.awt.*;


interface Vehicle {
    String getType();
    int getRate();
}


class Car implements Vehicle {
    public String getType() { return "Car"; }
    public int getRate() { return 10; }
}

class Bike implements Vehicle {
    public String getType() { return "Bike"; }
    public int getRate() { return 5; }
}

class Truck implements Vehicle {
    public String getType() { return "Truck"; }
    public int getRate() { return 15; }
}


class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        switch (type) {
            case "Car": return new Car();
            case "Bike": return new Bike();
            case "Truck": return new Truck();
            default: return null;
        }
    }
}


class RentalService {
    private int totalCost;

    public void calculateCost(Vehicle v, int time) {
        totalCost = v.getRate() * time;
    }

    public int getTotalCost() {
        return totalCost;
    }
}


class RentalTimer extends Thread {
    private int time;
    private Runnable onFinish;
    private JLabel timerLabel;

    public RentalTimer(int time, JLabel timerLabel, Runnable onFinish) {
        this.time = time;
        this.onFinish = onFinish;
        this.timerLabel = timerLabel;
    }

    public void run() {
        try {
            while (time > 0) {
                int t = time;
                SwingUtilities.invokeLater(() -> {
                    timerLabel.setText("Time left: " + t);
                });
                Thread.sleep(1000);
                time--;
            }
            onFinish.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RentalUI {
    private JFrame frame;
    private JComboBox<String> vehicleBox;
    private JLabel resultLabel, timerLabel;

    public RentalUI() {
        frame = new JFrame("Vehicle Rental System");
        frame.setSize(400, 250);
        frame.setLayout(new FlowLayout());

        String[] vehicles = {"Car", "Bike", "Truck"};
        vehicleBox = new JComboBox<>(vehicles);

        JButton rentBtn = new JButton("Start Rental");

        resultLabel = new JLabel("Select vehicle and start");
        timerLabel = new JLabel("Time: 0");

        rentBtn.addActionListener(e -> startRental());

        frame.add(vehicleBox);
        frame.add(rentBtn);
        frame.add(timerLabel);
        frame.add(resultLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void startRental() {
        String type = (String) vehicleBox.getSelectedItem();
        Vehicle vehicle = VehicleFactory.getVehicle(type);

        RentalService service = new RentalService();
        int duration = 5;

        RentalTimer timer = new RentalTimer(duration, timerLabel, () -> {
            service.calculateCost(vehicle, duration);

            SwingUtilities.invokeLater(() -> {
                resultLabel.setText("Total Cost: " + service.getTotalCost());
            });
        });

        timer.start();
    }
}


public class Factory {
    public static void main(String[] args) {
        new RentalUI();
    }
}