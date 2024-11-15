package ru.vlsu.ispi.springproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vlsu.ispi.springproject.beans.Chat;
import ru.vlsu.ispi.springproject.beans.Person;
import ru.vlsu.ispi.springproject.daos.interfaces.ChatDao;
import ru.vlsu.ispi.springproject.daos.interfaces.PersonDao;
import ru.vlsu.ispi.springproject.dto.PersonDto;
import ru.vlsu.ispi.springproject.services.ChatService;

import java.util.ArrayList;

public class SpringprojectTest {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            PersonDao personDao = (PersonDao) context.getBean("personDao");
            ChatDao chatDao = (ChatDao) context.getBean("chatDao");
            ChatService chatService = (ChatService) context.getBean("chatService");

            String personEmail = "ddff@m.c";

            Person person = personDao.getPersonByEmail(personEmail);
            String message1 = new PersonDto(person) + " состоит в чате ";
            ArrayList<Chat> personChats = (ArrayList<Chat>) chatService.getAllPersonChats(person.getId());
            for (Chat chat : personChats) {
                System.out.println(message1 + chat.getName());
            }

            System.out.println("-----------");

            Chat chat = chatDao.getChatById(1);
            String message2 = " состоит в чате " + chat.getName();
            ArrayList<Person> people = (ArrayList<Person>) chatService.getPeopleInChat(chat.getId());
            for (Person personInChat : people) {
                System.out.println(new PersonDto(personInChat) + message2);
            }
        }
    }
}
