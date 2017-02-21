package bankPackage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
	private Double amount;
	private Date date;
	private String description;
	private String pesel;
	private String bankName;
	private long transactionNumber;
	private String type;
	
	public Transaction(Double amount, Date date, String description, String pesel, String bankName,
			long transactionNumber) {
		super();
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.pesel = pesel;
		this.bankName = bankName;
		this.transactionNumber = transactionNumber;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}
	public Date getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
	public String getPesel() {
		return pesel;
	}
	public String getBankName() {
		return bankName;
	}
	public long getTransactionNumber() {
		return transactionNumber;
	}
	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return "amount=" + amount + ", date=" + dateFormat.format(date) + ", description=" + description + ", pesel=" + pesel
				+ ", bank Name=" + bankName + ", transaction Number=" + transactionNumber;
	}
	
	
}
