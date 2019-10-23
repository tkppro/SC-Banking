package vnuk.cse.scbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vnuk.cse.scbanking.service.PaymentService;

import java.util.Map;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<String> savePayment(@RequestBody Map<String, String> json) {
        String message = "";

        if(paymentService.payment(json))
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
