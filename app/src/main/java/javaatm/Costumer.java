package javaatm;

import java.io.Serializable;

public class Costumer implements Serializable {
  private double balance;
  public String name;

  public Costumer(String name) {
    this.balance = 0;
    this.name = name;
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
