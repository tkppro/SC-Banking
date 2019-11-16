package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Transaction;
import vnuk.cse.scbanking.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> findAll()
    {
        return transactionRepository.findAll();
    }
}
