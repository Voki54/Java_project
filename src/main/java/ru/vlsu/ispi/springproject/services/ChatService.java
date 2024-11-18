package ru.vlsu.ispi.springproject.services;

import ru.vlsu.ispi.springproject.models.Chat;
import ru.vlsu.ispi.springproject.models.Person;
import ru.vlsu.ispi.springproject.daos.interfaces.ChatDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PeopleInChatsDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;

import java.util.ArrayList;
import java.util.List;

public class ChatService {
    private ChatDao chatDao;
    private PersonDao personDao;
    private PeopleInChatsDao peopleInChatsDao;


    public void setChatDao(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void setPeopleInChatsDao(PeopleInChatsDao peopleInChatsDao) {
        this.peopleInChatsDao = peopleInChatsDao;
    }

    public List<Person> getPeopleInChat(long chatId) {
        List<Person> peopleInChat = new ArrayList<>();
        for (long personId : peopleInChatsDao.getAllPeopleIdInChat(chatId)) {
            peopleInChat.add(personDao.getPersonById(personId));
        }
        return peopleInChat;
    }

    public List<Chat> getAllPersonChats(long personId) {
        List<Chat> personChats = new ArrayList<>();
        for (long chatId : peopleInChatsDao.getAllChatIdByPersonId(personId)) {
            personChats.add(chatDao.getChatById(chatId));
        }
        return personChats;
    }
}
