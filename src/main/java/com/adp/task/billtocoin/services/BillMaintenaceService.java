package com.adp.task.billtocoin.services;

import com.adp.task.billtocoin.model.Bill;
import com.adp.task.billtocoin.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillMaintenaceService {
    @Autowired
    private BillRepository billRepository;

    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    public Bill addBill(Bill bill) {
        billRepository.save(bill);
        return bill;
    }

    public void deleteBill(String billType) {
        Bill bill = billRepository.findByBillValue(billType);
        billRepository.delete(bill);
    }

    public void initBills(){

    }
}
