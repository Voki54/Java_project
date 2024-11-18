package ru.vlsu.ispi.springproject.controllers.settings.confidentiality;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vlsu.ispi.springproject.services.ConfidentialityService;

@Controller
@RequestMapping("/settings")
public class ChangePasswordController {
    private ConfidentialityService confidentialityService;

    public ChangePasswordController(ConfidentialityService confidentialityService) {
        this.confidentialityService = confidentialityService;
    }

    @GetMapping("/confidentiality/changePassword")
    public String showChangePasswordPage() {
        return "settings/confidentiality/changePassword";
    }

    @PostMapping("/confidentiality/changePassword")
    public String changePassword(@RequestParam long personId, @RequestParam String newPassword) {
        confidentialityService.changePersonPassword(personId, newPassword);
        return "redirect:/settings";
    }
}
