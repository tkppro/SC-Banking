package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.CardService;
import vnuk.cse.scbanking.service.WalletService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TopUpController {
    @Autowired
    WalletService walletService;
    CardService cardService;

    @GetMapping("/topup")
    public ModelAndView topup() {
        ModelAndView modelAndView = new ModelAndView("/pages/topup");
        List<Wallet> wallets = walletService.findAll();
        modelAndView.addObject("wallets",wallets);
        return modelAndView;
    }
    @PostMapping("/topup")
    public  ModelAndView createNewTopup(@Valid Wallet wallet, @Valid Card card , BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Card cardExists = (Card) cardService.findCardByCard_number(card.getCardNumber());
        if(cardExists == null) {
            bindingResult
                    .rejectValue("card", "error.card",
                            "This card is invalid");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            walletService.save(wallet);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
}
