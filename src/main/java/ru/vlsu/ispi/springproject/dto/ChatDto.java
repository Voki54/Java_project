package ru.vlsu.ispi.springproject.dto;

import ru.vlsu.ispi.springproject.beans.Chat;

public class ChatDto {
    private String name;

    public ChatDto(String name) {
        this.name = name;
    }

    public ChatDto(Chat chat) {
        this.name = chat.getName();
    }

    public Chat ToChat(){
        Chat chat = new Chat(0L, this.getName());
        return chat;
    }

    public String getName() {
        return name;
    }
}
