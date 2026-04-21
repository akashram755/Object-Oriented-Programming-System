interface Vehicle {
    void start();
    void stop();
    void fuelType();
}

class MotorVehicle implements Vehicle {

    protected String brand;
    protected final int maxSpeed = 180;
    static int vehicleCount = 0;

    MotorVehicle(String brand) {
        this.brand = brand;
        vehicleCount++;
    }

    static void showVehicleCount() {
        System.out.println("Total Vehicles Created: " + vehicleCount);
    }

    public void start() {
        System.out.println(brand + " vehicle is starting...");
    }

    public void stop() {
        System.out.println(brand + " vehicle is stopping...");
    }

    public void fuelType() {
        System.out.println("This is a motor vehicle.");
    }

    public final void displayMaxSpeed() {
        System.out.println("Maximum Speed: " + maxSpeed + " km/h");
    }
}

class Car extends MotorVehicle {

    Car(String brand) {
        super(brand);
    }

    public void fuelType() {
        System.out.println(brand + " Car uses Petrol/Diesel.");
    }
}

class Bike extends MotorVehicle {

    Bike(String brand) {
        super(brand);
    }

    public void fuelType() {
        System.out.println(brand + " Bike uses Petrol.");
    }
}

public class vehicle {

    public static void main(String[] args) {

        Vehicle v1 = new Car("Toyota");
        Vehicle v2 = new Bike("Yamaha");

        v1.start();
        v1.fuelType();
        v1.stop();

        System.out.println();

        v2.start();
        v2.fuelType();
        v2.stop();

        MotorVehicle mv = new Car("Honda");
        mv.displayMaxSpeed();

        MotorVehicle.showVehicleCount();
    }
}