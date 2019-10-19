package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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

    ModelAndView modelAndView = new ModelAndView("/pages/wallets");

    @GetMapping("/wallets")
    public ModelAndView wallet() {
        Wallet wallet = new Wallet();
        List<Wallet> wallets = walletService.findAll();
        modelAndView.addObject("wallets", wallets);
        modelAndView.addObject("wallet", wallet);
        return modelAndView;
    }

    @PostMapping(value = "/wallets")
    public ModelAndView saveWallet(@ModelAttribute("wallet") @Valid Wallet wallet, BindingResult result) {
        if (!result.hasErrors()) {
            walletService.save(wallet);
            ModelAndView redirectView = new ModelAndView();
            redirectView.setViewName("redirect:/dashboard");
            return redirectView;
        }
        ModelAndView errorView = new ModelAndView();
        List<Wallet> wallets = walletService.findAll();
        errorView.addObject("wallets",wallets);
        errorView.setViewName("/pages/wallets");
        return errorView;
    }

    @PostMapping("/wallets/transfer")
    public ModelAndView transfer(@RequestParam("from-wallet") int fromWalletId,
                                 @RequestParam("to-wallet") int toWalletId,
                                 @RequestParam("amount") double amount)
    {
        ModelAndView modelAndView = new ModelAndView();
        if(walletService.transfer(fromWalletId, toWalletId, amount))
        {
            modelAndView.setViewName("redirect:/dashboard");

            return modelAndView;
        }

        modelAndView.setViewName("redirect:/transfer");

        return modelAndView;
    }
}
