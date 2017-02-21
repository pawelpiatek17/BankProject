package bankPackage;

import org.apache.log4j.Logger;

public class Main {

	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(Main.class);
		Bank testBank = new Bank();
		testBank.addClient("Janusz","Kowalski","12345678901");
		testBank.addClient("Andzej", "Kopyto", "98767564391");
		Client client1 = testBank.getClient("12345678901");
		Client client2 = testBank.getClient("98767564391");
		long ac1 = client1.addBankAccountToClient();
		long ac2 = client2.addBankAccountToClient();
		logger.debug(client1.toString());
		logger.debug(client2.toString());
		logger.debug(client1.getBankAccount(ac1).toString());
		logger.debug(client2.getBankAccount(ac2).toString());
		logger.debug(testBank.doTransactionDeposit("7485959442", "Janusz Kowalski", ac1, 200d, "aaa", Bank.BANK_NAME));
		logger.debug(client1.getBankAccount(ac1).toString());
		logger.debug(client2.getBankAccount(ac2).toString());
		logger.debug(testBank.doTransactionTransfer(client1.getPesel(), ac1, ac2, 111d, "bbb", Bank.BANK_NAME));
		logger.debug(testBank.doTransactionWireOut(client1.getPesel(), ac1, ac2, 200d, "ccc", Bank.BANK_NAME, "DE", 123452343253223l));
		logger.debug(client1.getBankAccount(ac1).toString());
		logger.debug(client2.getBankAccount(ac2).toString());
		History h = History.getInstance();
		h.getTransactionHistoryPerBankAccount(ac2);
	}

}
