package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.WalletService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class WalletController {
    @Autowired
    WalletService walletService;

    @GetMapping("/wallets")
    public ModelAndView wallet() {
        ModelAndView modelAndView = new ModelAndView("/pages/wallets");
        Wallet wallet = new Wallet();
        List<Wallet> wallets = walletService.findAll();
        modelAndView.addObject("wallets", wallets);
        modelAndView.addObject("wallet", wallet);
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public ModelAndView saveWallet(@ModelAttribute("wallet") Wallet wallet) {
        walletService.save(wallet);
        ModelAndView redirectView = new ModelAndView();
        redirectView.setViewName("redirect:/dashboard");
        return redirectView;
    }
}
