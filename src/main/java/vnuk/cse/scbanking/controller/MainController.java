package vnuk.cse.scbanking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "/base";
    }
    @GetMapping("/login")
    public String login() {
        return "/pages/login";
    }
    @GetMapping("/dashboard")
    public String dashboard() {
        return "/pages/dashboard";
    }

    @GetMapping("/topup")
    public String topup() {
        return "/pages/topup";
    }

    @GetMapping("/wallets")
    public String wallet() {
        return "/pages/wallets";
    }

    @GetMapping("/payments")
    public String payments() {
        return "/pages/bill";
    }
}
