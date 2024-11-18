package ru.vlsu.ispi.springproject.services;

import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;
import ru.vlsu.ispi.springproject.models.Person;

public class ConfidentialityService {
    private PersonDao personDao;

    public ConfidentialityService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void changePersonPassword(long personId, String newPassword) {
        Person person = personDao.getPersonById(personId);
        personDao.updatePerson(new Person(personId, person.getName(), person.getSurname(),
                person.getBirthday(), person.getEmail(), newPassword));
    }
}
