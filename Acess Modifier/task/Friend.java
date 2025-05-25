package task;

public class Friend {
    public void displayInfo(){
        Person p1 = new Person();
        System.out.println(p1.name);
        System.out.println(p1.age);
        System.out.println(p1.city);
        System.out.println(p1.ssn);// Not acessed
    }
}
