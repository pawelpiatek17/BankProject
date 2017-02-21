package bankPackage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class BankAccount {
	final Logger logger = Logger.getLogger(BankAccount.class);
	private long accountNumber;
	private double balance;
	private String description;
	private HashMap<String,Integer> transactionNumberPerBankAccount = new HashMap<String,Integer>();
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getDescription() {
		return description;
	}
	public Double getBalance() {
		return round(balance);
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTransactionNumberPerBankAccount(String transactionType) {
			return transactionNumberPerBankAccount.get(transactionType);
	}
	public void setTransactionNumberPerBankAccount(String transactionType) {
		if(transactionNumberPerBankAccount.containsKey(transactionType)){
			transactionNumberPerBankAccount.put(transactionType, transactionNumberPerBankAccount.get(transactionType)+1);
		}
		else{
			switch(transactionType){
				case Bank.TRANSACTION_DEPOSIT :{
					transactionNumberPerBankAccount.put(Bank.TRANSACTION_DEPOSIT, 101);
					break;
				}
				case Bank.TRANSACTION_TRANSFER :{
					transactionNumberPerBankAccount.put(Bank.TRANSACTION_TRANSFER, 1001);
					break;
				}
				default: {
					logger.debug("wrong transaction type");
					break;
				}
			}
		}
	}
	@Override
	public String toString() {
		return "BankAccount accountNumber=" + accountNumber + ", balance= " + balance +  ", description=" + description + " ";
	}
	public static double round(double value) {

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	public void updateBalance(Double amount) {
		this.balance += amount;
		
	}
}
