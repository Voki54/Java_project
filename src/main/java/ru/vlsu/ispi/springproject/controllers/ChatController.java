package ru.vlsu.ispi.springproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.dto.ChatEditRequestDto;
import ru.vlsu.ispi.springproject.dto.ChatRequestDto;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    @PostMapping("/create")
    public String createChat(@RequestBody ChatRequestDto chatRequest) {
        // Логика создания чата
        return "/api/chats";
    }

    @PostMapping("/{chatId}/add")
    public String addUsersToChat(@PathVariable Long chatId, @RequestBody List<Long> userIds) {
        // Логика добавления пользователей в чат
        return "/api/chats/" + chatId;
    }

    @PostMapping("/{chatId}/exit")
    public String exitChat(@PathVariable Long chatId) {
        // Логика выхода из чата
        return "/api/chats";
    }

    @GetMapping("/{chatId}/members")
    public String viewChatMembers(@PathVariable Long chatId) {
        // Логика просмотра участников чата
        return "/api/chats/" + chatId + "/members";
    }

    @PutMapping("/{chatId}/edit")
    public String editChat(@PathVariable Long chatId, @RequestBody ChatEditRequestDto editRequest) {
        // Логика редактирования чата
        return "/api/chats/" + chatId;
    }

    @DeleteMapping("/{chatId}")
    public String deleteChat(@PathVariable Long chatId) {
        // Логика удаления чата
        return "/api/chats";
    }
}
