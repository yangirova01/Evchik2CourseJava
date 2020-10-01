package Third_homework;
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    public User(Long id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return id.toString() + " " + firstName + " " + lastName + " "+ age.toString();
    }
}
