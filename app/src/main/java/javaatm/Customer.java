package javaatm;

import java.io.Serializable;

public class Customer implements Serializable {
  private double balance;
  public String name;

  public Customer(String name) {
    this.balance = 0;
    this.name = name;
  }

  public Customer(String name, double balance) {
    this.name = name;
    this.balance = balance;
  }

  private void setBalance(double amount) {
    balance = this.balance + amount;
  }

  public double getBalance() {
    return this.balance;
  }

  public boolean depositMoney(double amount) {
    setBalance(amount);
    return true;
  }

  public void whitdrawMoney(double amount) {
    balance = this.balance - amount;
  }

}
