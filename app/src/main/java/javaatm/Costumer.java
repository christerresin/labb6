package javaatm;

public class Costumer {
  private long balance;
  private String name;

  public Costumer(String name) {
    this.balance = 0;
    this.name = name;
  }

  private void setBalance(long amount) {
    balance = this.balance + amount;
  }

  public long getBalance() {
    return this.balance;
  }

  public boolean depositMoney(long amount) {
    setBalance(amount);
    return true;
  }

  public void whitdrawMoney(long amount) {
    balance -= this.balance - amount;
  }

}
