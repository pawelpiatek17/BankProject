package bankPackage;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

public class Bank {
	final Logger logger = Logger.getLogger(Bank.class);
	public static final String BANK_NAME = "Bank";
	public static final String TRANSACTION_DEPOSIT = "deposit";
	public static final String TRANSACTION_TRANSFER = "transfer";
	public static final String TRANSACTION_WIREOUT = "wire-out";
	HashMap<String,Client> ClientMap = new HashMap<String,Client>();
	public Client addClient(String name, String surname, String pesel){
		if(ClientMap.containsKey(pesel)){
			logger.debug("Client already has an account");
			Client client = ClientMap.get(pesel);
			return client;
		}
		else{
			Client newClient = new Client(name,surname,pesel);
			ClientMap.put(pesel, newClient);
			return newClient;
		}
		
	}
	public Client getClient(String pesel) {
		Client client = ClientMap.get(pesel);
		return client;
	}
	
	private BankAccount getAccount(long account) {
		Iterator<Entry<String, Client>> iterator = ClientMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Client> pair = (Entry<String, Client>) iterator.next();
			if (pair.getValue().getBankAccount(account) != null) {
				return pair.getValue().getBankAccount(account);
			}
		}
		return null;
	}
	public String doTransactionDeposit(String pesel, String sender, long toAccount, Double amount, String description, String bankName){
		Date date = new Date();
		BankAccount bankAccountTo = getAccount(toAccount);
		if (bankAccountTo == null) {
			return "Specified account does not exist. Account number : " + String.valueOf(toAccount);
		}
		bankAccountTo.setTransactionNumberPerBankAccount(TRANSACTION_DEPOSIT);
		int transactionNumber = bankAccountTo.getTransactionNumberPerBankAccount(TRANSACTION_DEPOSIT);
		TransactionDeposit transactionDeposit = new TransactionDeposit(amount, date, description, pesel, bankName, transactionNumber, toAccount, sender);
		transactionDeposit.setType(TRANSACTION_DEPOSIT);
		History h = History.getInstance();
		h.setTransactionHistoryPerBankAccount(toAccount, transactionDeposit);
		bankAccountTo.updateBalance(amount);
		return "transaction was successful";
	}
	public String doTransactionTransfer(String pesel, long fromAccount, long toAccount, Double amount, String description, String bankName){
		Date date = new Date();
		Client client = getClient(pesel);
		if(client == null ){
			return "Specified Client does not exist";
		}
		BankAccount bankAccountFrom = client.getBankAccount(fromAccount);
		if(bankAccountFrom == null ){
			return "Specified account does not exist";
		}
		BankAccount bankAccountTo = getAccount(toAccount);
		if (bankAccountTo == null) {
			return "Specified account does not exist. Account number : " + String.valueOf(toAccount);
		}
		if (bankAccountFrom.getBalance() < amount) {
			return "Insufficient funds in account";
		}
		bankAccountFrom.setTransactionNumberPerBankAccount(TRANSACTION_TRANSFER);
		int transactionNumber = bankAccountFrom.getTransactionNumberPerBankAccount(TRANSACTION_TRANSFER);
		TransactionTransfer transactionTransfer = new TransactionTransfer(amount, date, description, pesel, bankName, transactionNumber, fromAccount);
		transactionTransfer.setType(TRANSACTION_TRANSFER);
		History h = History.getInstance();
		h.setTransactionHistoryPerBankAccount(toAccount, transactionTransfer);
		bankAccountTo.updateBalance(amount);
		bankAccountFrom.updateBalance(-amount);
		return "transaction was successful";
	}
	public String doTransactionWireOut(String pesel, long fromAccount, long toAccount, Double amount, String description, String bankName, String country, long swift){
		Date date = new Date();
		Client client = getClient(pesel);
		if(client == null ){
			return "Specified Client does not exist";
		}
		BankAccount bankAccountFrom = client.getBankAccount(fromAccount);
		if (bankAccountFrom == null) {
			return "Specified account does not exist. Account number : " + String.valueOf(fromAccount);
		}
		if (bankAccountFrom.getBalance() < amount) {
			return "Insufficient funds in account";
		}
		BankAccount bankAccountTo = getAccount(toAccount);
		if (bankAccountTo != null) {
			bankAccountTo.updateBalance(amount);
		}
		client.setWireOutNumberPerClient();
		int transactionNumber = client.getWireOutNumberPerClient();
		TransactionWireOut transactionWireOut = new TransactionWireOut(amount, date, description, pesel, bankName, transactionNumber, country, swift, toAccount);
		transactionWireOut.setType(TRANSACTION_WIREOUT);
		History h = History.getInstance();
		h.setTransactionHistoryPerBankAccount(fromAccount, transactionWireOut);
		bankAccountFrom.updateBalance(-amount);
		return "transaction was successful";
	}
}
