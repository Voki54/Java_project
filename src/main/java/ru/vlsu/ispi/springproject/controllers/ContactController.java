package ru.vlsu.ispi.springproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.dto.BlockContactRequestDto;
import ru.vlsu.ispi.springproject.dto.ContactDto;
import ru.vlsu.ispi.springproject.dto.ContactRequestDto;
import ru.vlsu.ispi.springproject.dto.UnblockContactRequestDto;

import java.util.List;

@RestController
@RequestMapping("/api/chats/{chatId}")
public class ContactController {

    @PostMapping("/share")
    public String shareContact(@RequestBody ContactRequestDto contactRequest) {
        // Логика отправки контакта
        return "/api/chats/{chatId}";
    }

    @PostMapping("/block")
    public String blockContact(@RequestBody BlockContactRequestDto blockRequest) {
        // Логика блокировки контакта
        return "/api/chats";
    }

    @PostMapping("/unblock")
    public String unblockContact(@RequestBody UnblockContactRequestDto unblockRequest) {
        // Логика разблокировки контакта
        return "/api/chats/{chatId}";
    }
}
