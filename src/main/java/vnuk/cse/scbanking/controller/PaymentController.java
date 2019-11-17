package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vnuk.cse.scbanking.pattern.paymentstrategy.CardPaymentStrategy;
import vnuk.cse.scbanking.pattern.paymentstrategy.PaymentContext;
import vnuk.cse.scbanking.pattern.paymentstrategy.WalletPaymentStrategy;
import vnuk.cse.scbanking.service.CardService;
import vnuk.cse.scbanking.service.PaymentService;
import vnuk.cse.scbanking.service.WalletService;

import java.util.Map;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentContext paymentContext;
    @Autowired
    WalletService walletService;
    @Autowired
    CardService cardService;
    
    @PostMapping("/payments")
    public ResponseEntity<String> savePayment(@RequestBody Map<String, String> json) {
        String message = "";
        if(json.get("card_id") != null)
        {
            paymentContext.setPaymentStrategy(new CardPaymentStrategy(cardService));
        }

        if(json.get("wallet_id") != null)
        {
            paymentContext.setPaymentStrategy(new WalletPaymentStrategy(walletService));
        }

        if(paymentService.payment(json, paymentContext))
        {
            message = "{\"msg\":\"Paid bill successfully\"}";

            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        else
        {
            message = "{\"msg\":\"Not enough money in wallet\"}";

            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
    }
}
