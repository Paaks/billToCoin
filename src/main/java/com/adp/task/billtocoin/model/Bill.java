package com.adp.task.billtocoin.model;

import javax.persistence.*;

@Entity
@Table(name = "Bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Value")
    private String billValue;

    public Bill() {
    }

    public Bill(String billValue) {
        this.billValue = billValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillValue() {
        return billValue;
    }

    public void setBillValue(String billValue) {
        this.billValue = billValue;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billValue='" + billValue + '\'' +
                '}';
    }
}
