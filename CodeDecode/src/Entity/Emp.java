package Entity;

public class Emp {
    private String name;
    private String city;

    private String salary;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Emp(String name, String city, String salary) {
        this.name = name;
        this.city = city;
        this.salary = salary;
    }
}
