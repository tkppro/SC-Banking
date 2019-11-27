package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.CardType;
import vnuk.cse.scbanking.repositories.CardTypeRepository;

import java.util.List;

@Service
public class CardTypeService {
    @Autowired
    CardTypeRepository cardTypeRepository;

    public List<CardType> findAll() {
        return cardTypeRepository.findAll();
    }
}
