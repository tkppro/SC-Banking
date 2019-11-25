package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.entity.Transaction;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.CardService;
import vnuk.cse.scbanking.service.PaymentService;
import vnuk.cse.scbanking.service.TransactionService;
import vnuk.cse.scbanking.service.WalletService;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    WalletService walletService;
    @Autowired
    CardService cardService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    TransactionService transactionService;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("/pages/dashboard");
        List<Card> cards = cardService.findAll();
        List<Wallet> wallets = walletService.findAll();
        List<Transaction> transactions = transactionService.findAll();
        float sum = 0;
        for(Wallet wallet:wallets)
        {
            sum+= wallet.getAmount();
        }
        modelAndView.addObject("cards", cards);
        modelAndView.addObject("wallets", wallets);
        modelAndView.addObject("sum", sum);
        modelAndView.addObject("transactions", transactions);
        return modelAndView;
    }


}
