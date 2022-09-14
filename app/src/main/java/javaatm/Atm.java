package javaatm;

import java.util.Scanner;

public class Atm {
  private Scanner sc;
  private int response = 9;
  private Costumer currentCostumer;

  public Atm(Costumer costumer) {
    this.currentCostumer = costumer;

    sc = new Scanner(System.in);
    System.out.println("Welcome to World Bank ATM.");

    while (response != 0) {
      System.out.println("1. Check your balance");
      System.out.println("2. Deposit money");
      System.out.println("3. Whitdraw money");
      System.out.println("0. Exit");
      System.out.print("Please enter your choise: ");

      response = sc.nextInt();

      switch (response) {
        case 1:
          sc.nextLine();
          break;
        case 2:
          sc.nextLine();
          System.out.print("Please enter amount to deposit: ");
          double amount = sc.nextDouble();
          makeDeposit(currentCostumer, amount);
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

    if (costumerCurrentBalance > amount) {
      System.out.println("Whitdrawal of " + amount + " was successful.");
      return true;
    }
    System.out.println("Unable to whitdraw that amount. Check your balance.");
    return false;
  }

}
