/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaatm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    Costumer costumerUnderTest = new Costumer("Test test");
    Atm atmUnderTest = new Atm();

    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void checkCostumerDeposit() {
        assertTrue(costumerUnderTest.depositMoney(500));
        assertEquals(500, costumerUnderTest.getBalance());
    }

    @Test
    void checkCostumerWhitdrawal() {
        costumerUnderTest.depositMoney(100);
        costumerUnderTest.whitdrawMoney(50);
        assertEquals(50, costumerUnderTest.getBalance());
    }

    @Test
    void checkBalanceOfNewCostumer() {
        assertEquals(0, costumerUnderTest.getBalance());
    }

    @Test
    void checkAtmDeposit() {
        atmUnderTest.makeDeposit(costumerUnderTest, 100);
        assertEquals(100, costumerUnderTest.getBalance());
    }

    @Test
    void checkAtmWhitdrawal() {
        costumerUnderTest.depositMoney(100);
        assertEquals(true, atmUnderTest.makeWhitdrawal(costumerUnderTest, 50));
        assertEquals(true, atmUnderTest.makeWhitdrawal(costumerUnderTest, 50));
        assertEquals(false, atmUnderTest.makeWhitdrawal(costumerUnderTest, 5));
    }
}
