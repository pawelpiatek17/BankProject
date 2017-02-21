package bankPackage;
import java.util.HashMap;

public class Client {
	private String name;
	private String surname;
	private String pesel;
	private int wireOutNumberPerClient = 0;
	HashMap<Long,BankAccount> clientBankAccounts = new HashMap<Long,BankAccount>();
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPesel() {
		return pesel;
	}
	public int getWireOutNumberPerClient() {
		return wireOutNumberPerClient;
	}
	public void setWireOutNumberPerClient() {
		this.wireOutNumberPerClient += 1;
	}
	
	public Client(String name, String surname, String pesel) {
		super();
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}
	@Override
	public String toString() {
		String output = "Client Name=" + name + ", Surname=" + surname + ", PESEL=" + pesel + " Bank Account(s)= ";
		for (Long key : clientBankAccounts.keySet()) {
			output = output.concat(Long.toString(key));
		}
		return output;
	}
	public long addBankAccountToClient(){
		BankAccount bankAccount = new BankAccount();
		BankAccountNumbers bankAccountNumbers = BankAccountNumbers.getInstance();
		long accountNumber = bankAccountNumbers.getNewBankAccountNumber();
		bankAccount.setAccountNumber(accountNumber);
		clientBankAccounts.put(accountNumber, bankAccount);
		return accountNumber;
	}
	public BankAccount getBankAccount(long accountNumber){
		BankAccount bankAccount = clientBankAccounts.get(accountNumber);
		return bankAccount;
	}
}
