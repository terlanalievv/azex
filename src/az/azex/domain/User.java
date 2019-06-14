package az.azex.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User  extends BaseDomain implements Serializable, HttpSessionBindingListener {

    private static final long serialVersionUID = 4907455784263812365L;

    private String email;
    private String password;
    private String name;
    private String surname;
    private List<Role> roles;

    public User() {
        this.roles = new ArrayList<>();
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", roles=" + roles +
                ", status=" + status +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("------------------------------------------");
        System.out.println(event.getSession().getId() + " sessiyasina yeni user obyekti elave olundu");
        System.out.println("atribut adi = " + event.getName());
        System.out.println("user obyekti = " + event.getValue());
        System.out.println("------------------------------------------");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("------------------------------------------");
        System.out.println(event.getSession().getId() + " sessiyasindan user obyekti silindi");
        System.out.println("atribut adi = " + event.getName());
        System.out.println("user obyekti = " + event.getValue());
        System.out.println("------------------------------------------");
    }
}
