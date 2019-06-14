package az.azex.repository;

import az.azex.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    List<Person> getPersonList();
    Optional<Person> getPersonById(long id);
    Person addPerson(Person person);
    boolean updatePerson(Person person);
    boolean deletePerson(Person person);
}
