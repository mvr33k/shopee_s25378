package com.example.shopee_s25378;

public class Client {
    public Client(double saldo) {
        this.id = ++idCount;
        this.saldo = saldo;
    }

    public Client(double saldo, int id) {
        this.id = id;
        this.saldo = saldo;
    }

    private int id;

    private static int idCount = 0;
    private double saldo;

    public Integer getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getClientData() {
        return "ID: " + getId() + "\n Saldo: " + getSaldo();
    }
}

