package bankPackage;
import java.util.Date;

public class TransactionTransfer extends Transaction{
	private long fromAccount;

	public TransactionTransfer(Double amount, Date date, String description, String pesel, String bankName,
			long transactionNumber, long fromAccount) {
		super(amount, date, description, pesel, bankName, transactionNumber);
		this.fromAccount = fromAccount;
	}

	public long getFromAccount() {
		return fromAccount;
	}

	@Override
	public String toString() {
		return "TransactionTransfer: fromAccount=" + fromAccount + " " + super.toString();
	}
	
	

}
