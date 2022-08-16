package unit9;

public class Student {
    private int id;
    private int age;
    private String name;

    public Student() {

    }

    public Student(String name, int age) {
        id = (int) (Math.random()*1000);
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id: " + id + " || " + "Name: " + name + " || " + "Age: " + age;
    }
}
