package task;

public class Person {
    public String name;
    protected int age;
    String city;
    private String ssn;

    public void printInfo(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(city);
        System.out.println(ssn);
    }
}
