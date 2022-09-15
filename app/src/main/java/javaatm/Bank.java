package javaatm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
  private List<Customer> updatedCustomersList = new ArrayList<>();
  private List<Customer> customersList = new ArrayList<>();
  private String fileName = "data.bin";

  public void run() {

    // addNewCustomer("Keanu");
    // addNewCustomerWithBalance("Bob", 200);
    // addNewCustomer("Stina");

    // saveCustomersData();

    readCustomersData();
  }

  public void saveCustomersData() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
      os.writeObject(updatedCustomersList);
      os.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    }
    System.out.println("Done writing");

  }

  public void readCustomersData() {
    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
      customersList = (ArrayList) ois.readObject();
      ois.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    } catch (ClassNotFoundException er) {
      er.printStackTrace();
    }

  }

  private void addNewCustomer(String name) {
    Customer newCustomer = new Customer(name);
    updatedCustomersList.add(newCustomer);
  }

  private void addNewCustomerWithBalance(String name, double balance) {
    Customer newCustomer = new Customer(name, balance);
    updatedCustomersList.add(newCustomer);
  }

  private void updateCustomersList(List<Customer> updatedList) {
    this.updatedCustomersList = updatedList;
  }

  public Customer getCustomer(String customerName) {
    Optional<Customer> foundCustomer = customersList.stream().filter((c) -> c.name.equals(customerName)).findFirst();
    return foundCustomer.get();

  }

  public int getPositionOfCustomer(Customer currentCustomer) {
    if (customersList.indexOf(currentCustomer) >= 0) {

      return customersList.indexOf(currentCustomer);
    }
    return -1;
  }

  public void updateCurrentCustomerData(Customer currentCustomer) {
    int position = getPositionOfCustomer(currentCustomer);
    customersList.set(position, currentCustomer);
    updateCustomersList(customersList);
    saveCustomersData();

  }

}