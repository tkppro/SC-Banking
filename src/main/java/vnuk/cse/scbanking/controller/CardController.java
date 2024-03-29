package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.service.CardService;
import vnuk.cse.scbanking.service.CardTypeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CardController {
    @Autowired
    CardService cardService;
    @Autowired
    CardTypeService cardTypeService;

    @GetMapping("/cards")
    public ModelAndView wallet() {
        List<Card> cards = cardService.findCardByUserId(1);
        List<CardType> cardTypes = cardTypeService.findAll();

        ModelAndView modelAndView = new ModelAndView("/pages/card");
        modelAndView.addObject("cards", cards);
        modelAndView.addObject("cardTypes", cardTypes);
        return modelAndView;
    }

    @PostMapping(path = "/card")
    public ModelAndView saveWallet(@ModelAttribute("cardNumber") @Valid String cardNumber, @ModelAttribute("expiredDay") @Valid String expiredDay, @ModelAttribute("cardTypeId") @Valid int cardTypeid, @ModelAttribute("cvv") @Valid int cvv) {

        if (cardService.findCardByCardNumber(cardNumber) == null) {
            cardService.card(cardNumber, cardTypeid, cvv, expiredDay);
            ModelAndView redirectView = new ModelAndView();
            redirectView.setViewName("redirect:/dashboard");
            return redirectView;
        } else {
            ModelAndView redirectView = new ModelAndView();
            return redirectView;
        }
    }
}
