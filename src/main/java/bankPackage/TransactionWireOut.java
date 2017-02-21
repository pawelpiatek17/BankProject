package bankPackage;
import java.util.Date;

public class TransactionWireOut extends Transaction{
	private String country;
	private long swift;
	private long toAccount;
	public TransactionWireOut(Double amount, Date date, String description, String pesel, String bankName,
			long transactionNumber, String country, long swift, long toAccount) {
		super(amount, date, description, pesel, bankName, transactionNumber);
		this.country = country;
		this.swift = swift;
		this.toAccount = toAccount;
	}
	public String getCountry() {
		return country;
	}
	public long getSwift() {
		return swift;
	}
	public long getToAccount() {
		return toAccount;
	}
	@Override
	public String toString() {
		return "TransactionWireOut: country=" + country + ", swift=" + swift + ", toAccount=" + toAccount
				 + " " + super.toString();
	}
	
	
}
