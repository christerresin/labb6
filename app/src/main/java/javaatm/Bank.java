package javaatm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Bank {
  private List<Costumer> costumers = new ArrayList<>();
  private List<Costumer> costumersList;
  private String fileName = "data.bin";

  public Bank() {

    Costumer keanu = new Costumer("Keanu Reeves");
    Costumer bob = new Costumer("Bob Builder");
    costumers.add(keanu);
    costumers.add(bob);

    saveCostumersData();

    readCostumersData();
  }

  public void saveCostumersData() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
      os.writeObject(costumers);
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
      for (Costumer person : costumersList) {
        System.out.println("Name: " + person.name);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException err) {
      err.printStackTrace();
    } catch (ClassNotFoundException er) {
      er.printStackTrace();
    }

  }

}
