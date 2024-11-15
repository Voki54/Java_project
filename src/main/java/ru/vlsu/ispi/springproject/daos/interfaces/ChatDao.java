package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.beans.Chat;

import java.util.List;

public interface ChatDao {
    void addChat(Chat chat);
    Chat getChatById(long id);
    List<Chat> getAllChats();
    void updateChat(Chat chat);
    void deleteChat(long id);
}
