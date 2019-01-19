package mate.academy.springdemo.dao;

import mate.academy.springdemo.model.Person;
import mate.academy.springdemo.model.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class PersonDaoImpl implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Person getById(int id) {
        String sqlFindById = "SELECT * FROM persons WHERE id = ?";
        return jdbcTemplate.queryForObject(sqlFindById, new Object[]{id},
                new PersonMapper());
    }

    public Integer createPerson(Person person) {
        String sqlCreate = "INSERT INTO persons (firstName, lastName, age) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sqlCreate,
               person.getFirstName(), person.getLastName(), person.getAge());
    }

}
