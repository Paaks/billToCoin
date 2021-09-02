package com.adp.task.billtocoin.model;

import javax.persistence.*;

@Entity
@Table(name = "Coins")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "Deno")
    private double denomination;
    @Column(name = "Count")
    private int count;

    public Coin() {
    }

    public Coin(double denomination, int count) {
        this.denomination = denomination;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDenomination() {
        return denomination;
    }

    public void setDenomination(double denomination) {
        this.denomination = denomination;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "denomination=" + denomination +
                ", count=" + count +
                '}';
    }
}
