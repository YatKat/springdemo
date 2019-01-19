package mate.academy.springdemo.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    public Person mapRow(ResultSet resultSet, int i) throws SQLException{
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setFirstName(resultSet.getString("firstName"));
        person.setLastName(resultSet.getString("lastName"));
        person.setAge(resultSet.getInt("age"));
        return person;
    }
}
