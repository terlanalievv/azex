package az.azex.domain;

public class Person {
    private long id;
    private String name;
    private String surname;
    private int status;

    public Person(long id, String name, String surname, int status) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    public Person() {
        this(0, "", "", 0);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
