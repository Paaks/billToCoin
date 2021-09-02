package com.adp.task.billtocoin.repository;

import com.adp.task.billtocoin.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillToCoinRepository extends JpaRepository<Coin,Long> {
}
