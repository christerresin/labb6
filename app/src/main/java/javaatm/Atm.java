package javaatm;

import java.util.Scanner;

public class Atm {
  private Scanner sc;
  private int response = 9;
  private Customer currentCustomer;
  private Bank bank;

  /**
   * Creates instance of Bank.class, loads customer data and presents ATM/Bank
   * options"
   *
   * @param customerName
   */
  public void run(String customerName) {
    bank = new Bank();
    bank.run();
    currentCustomer = bank.getCustomer(customerName);
    sc = new Scanner(System.in);

    System.out.println(currentCustomer.name + ", Welcome to World Bank ATM!");

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

  public void makeDeposit(Customer customer, double amount) {
    if (customer.depositMoney(amount)) {
      System.out.println("Deposit of " + amount + " was successful.");
      double newBalance = customer.getBalance();
      System.out.println("New balance: " + newBalance);
    }
  }

  public boolean makeWhitdrawal(Customer customer, double amount) {
    double customerCurrentBalance = customer.getBalance();

    if (customerCurrentBalance >= amount) {
      customer.whitdrawMoney(amount);
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
    double currentBalance = currentCustomer.getBalance();
    System.out.println("Current balance: " + currentBalance);
    clearWindow();
  }

  public void makeCostumerDeposit() {
    sc.nextLine(); // clear Scanner
    System.out.print("Please enter amount to deposit: ");
    double depositAmount = sc.nextDouble();
    makeDeposit(currentCustomer, depositAmount);
    bank.updateCurrentCustomerData(currentCustomer);
    clearWindow();
  }

  public void makeCostumerWhitdrawal() {
    sc.nextLine(); // clear Scanner
    System.out.print("Please enter amount to whitdrawal: ");
    double whitdrawalAmount = sc.nextDouble();
    makeWhitdrawal(currentCustomer, whitdrawalAmount);
    bank.updateCurrentCustomerData(currentCustomer);
    clearWindow();
  }

}
