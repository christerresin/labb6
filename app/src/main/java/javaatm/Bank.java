package javaatm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.google.common.base.Optional;

public class Bank {
  private List<Costumer> updatedCostumersList = new ArrayList<>();
  private List<Costumer> costumersList;
  private String fileName = "data.bin";

  public Bank() {

    addNewCostumer("Keanu");
    addNewCostumer("Bob");
    addNewCostumer("Stina");

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

  public Costumer getCostumer(String costumerName) {
    Costumer foundCostumer = costumersList.stream().filter((c) -> c.name.equals(costumerName)).collect(toSingleton());
    return foundCostumer;
  }

  public static <T> Collector<T, ?, T> toSingleton() {
    return Collectors.collectingAndThen(
        Collectors.toList(),
        list -> {
          if (list.size() != 1) {
            throw new IllegalStateException();
          }
          return list.get(0);
        });
  }

}
