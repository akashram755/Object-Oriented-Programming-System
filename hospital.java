interface Hospital{ 
    void getDetails(); 
    void getRole(); 
} 
 
class Person implements Hospital{ 
    protected String name; 
    protected final String hospitalName="City Hospital"; 
    static int count=0; 
 
    Person(String name){ 
        this.name=name; 
        count++; 
    } 
 
    static void showCount(){ 
       System.out.println("Total Persons: "+count); 
    } 
 
    public void getDetails(){ 
        System.out.println("Name: "+name); 
    } 
 
    public void getRole(){ 
        System.out.println("Person of hospital"); 
    } 
 
    public final void showHospital(){ 
        System.out.println("Hospital: "+hospitalName); 
    } 
} 
 
class Doctor extends Person{ 
    private String specialization; 
 
    Doctor(String name,String specialization){ 
        super(name); 
        this.specialization=specialization; 
    } 
 
    public void getRole(){ 
        System.out.println("Role: Doctor"); 
        System.out.println("Specialization: "+specialization); 
    } 
} 
 
class Patient extends Person{ 
    private String disease; 
 
    Patient(String name,String disease){ 
        super(name); 
        this.disease=disease; 
    } 
 
    public void getRole(){ 
        System.out.println("Role: Patient"); 
        System.out.println("Disease: "+disease); 
    } 
} 
 
public class hospital{ 
    public static void main(String[] args){ 
        Hospital h1=new Doctor("Dr.Smith","Cardiology"); 
        Hospital h2=new Patient("John","Fever"); 
 
        h1.getDetails(); 
        h1.getRole(); 
        System.out.println(); 
        h2.getDetails(); 
        h2.getRole(); 
Person p=new Doctor("Dr.Alex","Neurology"); 
p.showHospital(); 
Person.showCount(); 
}
}