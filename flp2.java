import java.util.*; 
class Device { 
protected String name; 
public Device(String name) { 
this.name = name; 
} 
public void turnOn() { 
System.out.println(name + " is turned on"); 
} 
} 
class Light extends Device { 
public Light(String name) { 
super(name); 
    } 
 
    @Override 
    public void turnOn() { 
        System.out.println(name + " light is glowing      "); 
    } 
} 
 
class Fan extends Device { 
    public Fan(String name) { 
        super(name); 
    } 
 
    @Override 
    public void turnOn() { 
        System.out.println(name + " fan is rotating  "); 
    } 
} 
 
class Room { 
    private List<Device> devices; 
 
    public Room() { 
        devices = new ArrayList<>(); 
    } 
 
    public void addDevice(Device d) { 
        devices.add(d); 
    } 
 
    public void activateDevices() { 
        for (Device d : devices) { 
            d.turnOn(); // polymorphism 
        } 
    } 
} 
 
public class flp2 { 
    public static void main(String[] args) { 
        Room room = new Room(); 
 
        Device d1 = new Light("Living Room"); 
        Device d2 = new Fan("Bedroom"); 
 
room.addDevice(d1); 
room.addDevice(d2); 
room.activateDevices(); 
} 
} 