package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.entity.Wallet;
import vnuk.cse.scbanking.service.BillService;
import vnuk.cse.scbanking.service.WalletService;

import java.util.List;

@Controller
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    WalletService walletService;

    @GetMapping("/payments")
    public ModelAndView bills()
    {
        ModelAndView modelAndView = new ModelAndView("/pages/bill");
        List<Bill> bills = billService.findAll();
        List<Wallet> wallets = walletService.findAll();
        modelAndView.addObject("wallets",wallets);
        modelAndView.addObject("bills",bills);
        return modelAndView;
    }
}
