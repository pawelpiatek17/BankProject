package bankPackage;
import java.util.HashSet;
import java.util.Set;

public class BankAccountNumbers {
	private BankAccountNumbers(){
	}
	private static BankAccountNumbers instance = null;
	public static BankAccountNumbers getInstance() {
		if(instance == null){
			instance = new BankAccountNumbers();
		}
			return instance;
	}
	private Set<Long> bankAccountNumbersList = new HashSet<Long>();
	public long getNewBankAccountNumber(){
		long random15digitnumber = (long) Math.floor(Math.random() * 900_000_000_000_000L) + 100_000_000_000_000L;
		while(bankAccountNumbersList.contains(random15digitnumber)){
			random15digitnumber = (long) Math.floor(Math.random() * 900_000_000_000_000L) + 100_000_000_000_000L;
		}
		bankAccountNumbersList.add(random15digitnumber);
		return random15digitnumber;
	}
}