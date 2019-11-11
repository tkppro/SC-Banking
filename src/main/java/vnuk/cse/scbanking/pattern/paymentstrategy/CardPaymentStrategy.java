package vnuk.cse.scbanking.pattern.paymentstrategy;

import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.*;
import vnuk.cse.scbanking.pattern.paymentfactory.PaymentFactory;
import vnuk.cse.scbanking.service.CardService;

import java.util.Map;

@Service
public class CardPaymentStrategy implements PaymentStrategy {
    CardService cardService;

    public CardPaymentStrategy( CardService cardService)
    {
        this.cardService = cardService;
    }

    @Override
    public Payment pay(Map<String, String> data, PaymentFactory paymentFactory, User user, Bill bill) {
        Card card = this.cardService.findById(Integer.parseInt(data.get("card_id")));

        Payment payment = paymentFactory.createPayment(data.get("consumerNumber"), data.get("billNumber"),
                Double.parseDouble(data.get("amount")), card, user, bill);

        return payment;
    }
}
