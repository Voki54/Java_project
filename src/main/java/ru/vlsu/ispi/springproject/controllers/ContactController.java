package ru.vlsu.ispi.springproject.controllers;

import org.springframework.web.bind.annotation.*;
import ru.vlsu.ispi.springproject.services.ContactService;

@RestController
@RequestMapping("/api/chats/{chatId}")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping("/block")
    public String blockContact(@RequestBody long personId, @RequestBody long blockedUserId) {
        return contactService.blockContact(personId, blockedUserId);

    }

    @PostMapping("/unblock")
    public String unblockContact(@RequestBody long personId, @RequestBody long blockedUserId) {
        return contactService.blockContact(personId, blockedUserId);
    }
}
