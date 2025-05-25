package test;
import task.*;
public class Stranger {
    public void displayDetails(){
        Person p1 = new Person();
        System.out.println(p1.age);//Not acessible
        System.out.println(p1.name);
        System.out.println(p1.city);//Not acessible
        System.out.println(p1.ssn);//Not acessible
    }
}
