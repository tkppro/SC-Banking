package vnuk.cse.scbanking.pattern.cardbridge;

import vnuk.cse.scbanking.entity.Card;
import vnuk.cse.scbanking.repositories.CardRepository;
import vnuk.cse.scbanking.service.CardService;

public class BasicConnector implements Connector{
    protected Card card;
    protected CardService cardService;

    public BasicConnector() {
    }

    public BasicConnector(Card card, CardService cardService) {
        this.card = card;
        this.cardService = cardService;
    }

    public void saveCard() {
        this.cardService.saveCard(card);
    }

    public void deleteCard() {
        this.cardService.deleteCard(card);
    }

    @Override
    public String getPaymentName() {
        return card.getPaymentName();
    }

    @Override
    public String getCardNumber() {
        return card.getCardNumber();
    }
}
