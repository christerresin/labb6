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
  private List<Costumer> updatedCostumersList = new ArrayList<>();
  private List<Costumer> costumersList = new ArrayList<>();
  private String fileName = "data.bin";

  public void run() {

    // addNewCostumer("Keanu");
    // addNewCostumerWithBalance("Bob", 200);
    // addNewCostumer("Stina");

    // saveCostumersData();

    readCostumersData();
  }

  public void saveCostumersData() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
      os.writeObject(updatedCostumersList);
      os.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    }
    System.out.println("Done writing");

  }

  public void readCostumersData() {
    try {
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
      costumersList = (ArrayList) ois.readObject();
      ois.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    } catch (ClassNotFoundException er) {
      er.printStackTrace();
    }

  }

  private void addNewCostumer(String name) {
    Costumer newCostumer = new Costumer(name);
    updatedCostumersList.add(newCostumer);
  }

  private void addNewCostumerWithBalance(String name, double balance) {
    Costumer newCostumer = new Costumer(name, balance);
    updatedCostumersList.add(newCostumer);
  }

  private void updateCostumersList(List<Costumer> updatedList) {
    this.updatedCostumersList = updatedList;
  }

  public Costumer getCostumer(String costumerName) {
    Optional<Costumer> foundCostumer = costumersList.stream().filter((c) -> c.name.equals(costumerName)).findFirst();
    return foundCostumer.get();

  }

  public int getPositionOfCostumer(Costumer currentCostumer) {
    if (costumersList.indexOf(currentCostumer) > 0) {

      return costumersList.indexOf(currentCostumer);
    }
    return -1;
  }

  public void updateCurrentCostumerData(Costumer currentCostumer) {
    int position = getPositionOfCostumer(currentCostumer);
    costumersList.set(position, currentCostumer);
    updateCostumersList(costumersList);
    saveCostumersData();

  }

}