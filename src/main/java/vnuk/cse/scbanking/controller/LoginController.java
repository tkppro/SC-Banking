package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import vnuk.cse.scbanking.entity.User;
import vnuk.cse.scbanking.service.UserService;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email) {
        ModelAndView redirectView = new ModelAndView();
        List<User> lists = userService.findUserByEmail(email);
        String errorMessage = "Could not login to this account";

        if(!lists.isEmpty()) {
            redirectView.setViewName("redirect:/dashboard");
            return redirectView;
        }

        return new ModelAndView("/pages/login", "errorMessage", errorMessage);
    }

    @GetMapping("/login")
    public String login() {
        return "/pages/login";
    }
}
