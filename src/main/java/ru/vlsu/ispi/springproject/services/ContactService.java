package ru.vlsu.ispi.springproject.services;

import ru.vlsu.ispi.springproject.daos.interfaces.BlockedUserDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;
import ru.vlsu.ispi.springproject.models.BlockedUser;
import ru.vlsu.ispi.springproject.models.Person;

public class ContactService {
    private final BlockedUserDao blockedUserDao;
    private final PersonDao personDao;

    public ContactService(BlockedUserDao blockedUserDao, PersonDao personDao) {
        this.blockedUserDao = blockedUserDao;
        this.personDao = personDao;
    }

    public String blockContact(long personId, long blockedUserId) {
        Person person = personDao.getPersonById(personId);
        Person blockedPerson = personDao.getPersonById(blockedUserId);
        if (person != null && blockedPerson != null)
            blockedUserDao.addBlockedUser(new BlockedUser(personId, blockedUserId));
        return "/api/chats";
    }

    public String unblockContact(long personId, long blockedUserId) {
        Person person = personDao.getPersonById(personId);
        Person blockedPerson = personDao.getPersonById(blockedUserId);
        if (person != null && blockedPerson != null)
            blockedUserDao.deleteBlockedUser(new BlockedUser(personId, blockedUserId));
        return "/api/settings/blacklist";
    }
}
