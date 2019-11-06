package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.repositories.CardTypeRepository;
import vnuk.cse.scbanking.service.CardService;
import vnuk.cse.scbanking.service.WalletService;

import java.util.List;

@Controller
public class TopUpController {
    @Autowired
    WalletService walletService;
    @Autowired
    CardService cardService;
    @Autowired
    CardTypeRepository cardTypeRepository;

    @GetMapping("/topup")
    public ModelAndView topup() {
        ModelAndView modelAndView = new ModelAndView("/pages/topup");
        List<Wallet> wallets = walletService.findAll();
        List<Card> cards = cardService.findCardByUserId(1);
        List<CardType> cardTypes = cardTypeRepository.findAll();
        modelAndView.addObject("wallets",wallets);
        modelAndView.addObject("cards",cards);
        modelAndView.addObject("cardTypes",cardTypes);
        return modelAndView;
    }

    @PostMapping("/topup")
    public  ModelAndView createNewTopup(@RequestParam("cardId") int cardId ,@RequestParam("wallet") int walletId, @RequestParam("amount") double amount) {
        ModelAndView modelAndView = new ModelAndView();
        if(walletService.topup(walletId, amount, cardId, 1))
        {
            modelAndView.setViewName("redirect:/dashboard");
            modelAndView.addObject("successMessage", "Wallet has been topup successfully");
            return modelAndView;
        }
        else {
            modelAndView.addObject("errorMessage", "Please valid your information");
            modelAndView.setViewName("redirect:/topup");

        }
        return modelAndView;
    }
}
