/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaatm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class AppTest {
    Customer customerUnderTest = new Customer("Test");
    Atm atmUnderTest = new Atm();
    Bank bankUnderTest = new Bank();

    List<Customer> customersListUnderTest = new ArrayList<>();

    @Test
    void checkCostumerDeposit() {
        assertTrue(customerUnderTest.depositMoney(500));
        assertEquals(500, customerUnderTest.getBalance());
    }

    @Test
    void checkCostumerWhitdrawal() {
        customerUnderTest.depositMoney(100);
        customerUnderTest.whitdrawMoney(50);
        assertEquals(50, customerUnderTest.getBalance());
    }

    @Test
    void checkBalanceOfNewCostumer() {
        assertEquals(0, customerUnderTest.getBalance());
    }

    @Test
    void checkAtmDeposit() {
        atmUnderTest.makeDeposit(customerUnderTest, 100);
        assertEquals(100, customerUnderTest.getBalance());
    }

    @Test
    void checkAtmWhitdrawal() {
        customerUnderTest.depositMoney(100);
        assertEquals(true, atmUnderTest.makeWhitdrawal(customerUnderTest, 50));
        assertEquals(true, atmUnderTest.makeWhitdrawal(customerUnderTest, 50));
        assertEquals(false, atmUnderTest.makeWhitdrawal(customerUnderTest, 5));
    }

    @Test
    void checkIfCustomerWithNameIsCreated() {
        Customer john = bankUnderTest.createNewCustomer("John");
        assertEquals("John", john.name);
    }

    @Test
    void checkIfCustomerWithNameAndBalanceIsCreated() {
        Customer neo = bankUnderTest.createNewCustomerWithBalance("Neo", 101);
        assertEquals("Neo", neo.name);
        assertEquals(101, neo.getBalance());
    }

}
