package test;
import task.*;

public class Employee extends Person{
    public void display(){
        Person p1 = new Person();
        System.out.println(p1.name);
        System.out.println(p1.age);//Not acessible
        System.out.println(p1.city);//Not accessible
        System.out.println(p1.ssn);//Not accessible
    }
}
