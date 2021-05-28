package junitproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
	
	@Test
	void notEnoughFunds() {
	    // Create an object for BankAccount class
	    Bankaccount account = new Bankaccount(9);

	    // Assertion for exception
	    assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
	}
	@Test
    void enoughFunds() {
        // Create an object for BankAccount class
        Bankaccount account = new Bankaccount(100);
    
        // Assertion for no exceptions
        assertDoesNotThrow(() -> account.withdraw(100));
    }

}
