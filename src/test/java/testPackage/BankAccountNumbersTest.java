package testPackage;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bankPackage.BankAccount;
import bankPackage.BankAccountNumbers;

public class BankAccountNumbersTest {

	int i;
	BankAccountNumbers bankAccountNumbers;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BankAccountNumbers bankAccountNumbers;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bankAccountNumbers = BankAccountNumbers.getInstance();
		i=0;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNewBankAccountNumber() {
		long number;
		int length;
		while(i<10000){
			number = bankAccountNumbers.getNewBankAccountNumber();
			length = String.valueOf(number).length();
			if(length != 15)
			{
				fail("bank account number must have 15 digits and it has "+ length + " digits");
			}
			i+=1;
		}
	}

}
