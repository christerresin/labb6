/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaatm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test
    void checkCostumerDeposit() {
        Costumer costumerUnderTest = new Costumer("Test test");
        assertTrue(costumerUnderTest.depositMoney(500));
        assertEquals(500, costumerUnderTest.getBalance());
    }

    @Test
    void checkCostumerWhitdrawal() {
        Costumer costumerUnderTest = new Costumer("Test test");
        costumerUnderTest.depositMoney(100);
        costumerUnderTest.whitdrawMoney(50);
        assertEquals(50, costumerUnderTest.getBalance());
    }

    @Test
    void checkBalanceOfNewCostumer() {
        Costumer costumerUnderTest = new Costumer("Test test");
        assertEquals(0, costumerUnderTest.getBalance());
    }
}
