package bankPackage;
import java.util.Date;

public class TransactionDeposit extends Transaction {
	private long toAccount;
	private String sender;

	public TransactionDeposit(Double amount, Date date, String description, String pesel, String bankName,
			long transactionNumber, long toAccount, String sender) {
		super(amount, date, description, pesel, bankName, transactionNumber);
		this.toAccount = toAccount;
		this.sender = sender;
	}

	public long getToAccount() {
		return toAccount;
	}

	@Override
	public String toString() {
		return "TransactionDeposit: toAccount=" + toAccount + "sender= " + sender + " " + super.toString();
	}
	
}
