package javaatm;

import java.util.Scanner;

public class Atm {
  private Scanner sc;
  private int response = 9;
  private Costumer currentCostumer;
  private Bank bank;

  public Atm() {

  }

  public void run(Costumer costumer) {
    this.currentCostumer = costumer;
    bank = new Bank();

    sc = new Scanner(System.in);
    System.out.println("Welcome to World Bank ATM.");

    while (response != 0) {
      presentOptionsMessage();

      response = sc.nextInt();

      switch (response) {
        case 1:
          getCostumerBalance();
          break;
        case 2:
          makeCostumerDeposit();
          break;
        case 3:
          makeCostumerWhitdrawal();
          break;
      }
    }
  }

  public void makeDeposit(Costumer costumer, double amount) {
    if (costumer.depositMoney(amount)) {
      System.out.println("Deposit of " + amount + " was successful.");
      double newBalance = costumer.getBalance();
      System.out.println("New balance: " + newBalance);
    }
  }

  public boolean makeWhitdrawal(Costumer costumer, double amount) {
    double costumerCurrentBalance = costumer.getBalance();

    if (costumerCurrentBalance >= amount) {
      costumer.whitdrawMoney(amount);
      System.out.println("Whitdrawal of " + amount + " was successful.");
      return true;
    }
    System.out.println("Unable to whitdraw that amount. Check your balance.");
    return false;
  }

  public void clearWindow() {
    System.out.println();
    for (int i = 0; i <= 25; i++) {
      System.out.print("$");
    }
    System.out.println();
    System.out.println();
  }

  public void presentOptionsMessage() {
    System.out.println("1. Check your balance");
    System.out.println("2. Deposit money");
    System.out.println("3. Whitdraw money");
    System.out.println("0. Exit");
    System.out.println("--------------------------");
    System.out.print("Please enter your choice: ");
  }

  public void getCostumerBalance() {
    sc.nextLine(); // clear Scanner
    double currentBalance = currentCostumer.getBalance();
    System.out.println("Current balance: " + currentBalance);
    clearWindow();
  }

  public void makeCostumerDeposit() {
    sc.nextLine(); // clear Scanner
    System.out.print("Please enter amount to deposit: ");
    double depositAmount = sc.nextDouble();
    makeDeposit(currentCostumer, depositAmount);
    clearWindow();
  }

  public void makeCostumerWhitdrawal() {
    sc.nextLine(); // clear Scanner
    System.out.print("Please enter amount to whitdrawal: ");
    double whitdrawalAmount = sc.nextDouble();
    makeWhitdrawal(currentCostumer, whitdrawalAmount);
    clearWindow();
  }

}
