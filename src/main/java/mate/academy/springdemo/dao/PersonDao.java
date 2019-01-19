package mate.academy.springdemo.dao;

import mate.academy.springdemo.model.Person;

public interface PersonDao {
    Person getById(int id);

    Integer createPerson(Person person);
}
