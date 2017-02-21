package bankPackage;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.util.HashMap;

public class History {
	private History(){
	}
	private static History instance = null;
	final static Logger logger = Logger.getLogger(History.class);

	public static History getInstance() {
		if(instance == null){
			instance = new History();
		}
		return instance;
	}
	private HashMap<Long,ArrayList<Transaction>> transactionHistoryPerBankAccount = new HashMap<Long,ArrayList<Transaction>>();
	
	public void getTransactionHistoryPerBankAccount(long bankAccountNr) {
		if(transactionHistoryPerBankAccount.containsKey(bankAccountNr)){
			ArrayList<Transaction> l = new ArrayList<Transaction>();
			l = transactionHistoryPerBankAccount.get(bankAccountNr);
			for (Transaction t : l) {
				logger.debug(t.toString());
			}
			
		}
		else{
			logger.debug("this bank account doesnt exists or has no history");
		}
	}
	public void setTransactionHistoryPerBankAccount(long bankAccountNr,Transaction t) {
		ArrayList<Transaction> l = new ArrayList<Transaction>();
		if(transactionHistoryPerBankAccount.containsKey(bankAccountNr)){
			l = transactionHistoryPerBankAccount.get(bankAccountNr);
			l.add(t);
			transactionHistoryPerBankAccount.put(bankAccountNr, l);
		}
		else{
			l.add(t);
			transactionHistoryPerBankAccount.put(bankAccountNr, l);
		}
	}
	
	
}
