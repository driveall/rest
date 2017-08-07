package entity;

public class Person {
    private final String name;
    private final String city;
    private final int salary;
    private final String vacancy;

    public Person(String name, String city, int salary, String vacancy) {
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.vacancy = vacancy;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getSalary() {
        return salary;
    }

    public String getVacancy() {
        return vacancy;
    }
}
