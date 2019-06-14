package az.azex.repository.implementation;

import az.azex.domain.Person;
import az.azex.repository.DatabaseUtility;
import az.azex.repository.PersonDao;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoPostgreSqlImpl implements PersonDao {
    private DataSource dataSource;

    public PersonDaoPostgreSqlImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Person> getPersonList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs =  null;
        List<Person> personList = new ArrayList<>();

        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(SqlQueries.GET_PERSON_LIST);
            rs = ps.executeQuery();
            while(rs.next()) {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setStatus(rs.getInt("status"));
                personList.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting person list", e);
        } finally {
            DatabaseUtility.close(rs, ps, connection);
        }
        return personList;
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return Optional.empty();
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(Person person) {
        return false;
    }
}
