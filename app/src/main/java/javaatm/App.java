package javaatm;

public class App {

    public static void main(String[] args) {

        Atm atm = new Atm();
        // No login implemented, using name on existing customer on list, "Keanu"
        // (others are Bob and/or Stina)
        atm.run("Trinity");
    }
}
