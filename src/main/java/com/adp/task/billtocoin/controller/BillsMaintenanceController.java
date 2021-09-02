package com.adp.task.billtocoin.controller;

import com.adp.task.billtocoin.exception.InvalidBillException;
import com.adp.task.billtocoin.model.Bill;
import com.adp.task.billtocoin.services.BillMaintenaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class BillsMaintenanceController {

    @Autowired
    private BillMaintenaceService billMaintenaceService;

    @GetMapping("/allBills")
    public List<Bill> getAllBills(){

       return billMaintenaceService.findAllBills();
    }

    @PostMapping("/addBill")
    public Bill addBill(@RequestBody Bill bill){

        return billMaintenaceService.addBill(bill);
   }
    @PutMapping("/updateBill/{billType}")
    public void updateBill(@PathVariable final String billType){
        throw new InvalidBillException("Test");
    }
    @DeleteMapping ("/deleteBill/{billType}")
    public void deleteBill(@PathVariable final String billType){

        billMaintenaceService.deleteBill(billType);
    }
}
