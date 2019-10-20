package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.WalletService;

import java.util.List;

@Controller
public class TransferController {
    @Autowired
    WalletService walletService;

    @GetMapping("/transfer")
    public ModelAndView transfer() {
        ModelAndView modelAndView = new ModelAndView("pages/transfer");
        List<Wallet> wallets = walletService.findAll();
        modelAndView.addObject("wallets",wallets);
        return modelAndView;
    }

    @PostMapping("/transfer")
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
