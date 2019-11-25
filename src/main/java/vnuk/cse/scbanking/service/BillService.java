package vnuk.cse.scbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnuk.cse.scbanking.entity.Bill;
import vnuk.cse.scbanking.repositories.BillRepository;
import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    public Bill findBillById(int id) {
        return billRepository.findBillById(id);
    }

    public Bill save(Bill bill)
    {
        return billRepository.save(bill);
    }

    public void delete(Bill bill)
    {
        billRepository.delete(bill);
    }
}