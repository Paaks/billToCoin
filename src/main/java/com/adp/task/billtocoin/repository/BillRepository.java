package com.adp.task.billtocoin.repository;

import com.adp.task.billtocoin.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill,Long> {
    Bill findByBillValue(String billvalue);
}
