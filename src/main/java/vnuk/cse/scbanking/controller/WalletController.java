package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.WalletService;
import java.util.List;


@Controller
public class WalletController {
    @Autowired
    WalletService walletService;

    @GetMapping("/wallets")
    public ModelAndView wallet() {
        ModelAndView modelAndView = new ModelAndView("/pages/wallets");
        List<Wallet> wallets = walletService.findAll();
        modelAndView.addObject("wallets", wallets);
        return modelAndView;
    }
}
