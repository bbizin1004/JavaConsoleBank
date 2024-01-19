package banking2;

public class HighCreditAccount extends NormalAccount {
	String grade;
	
	public HighCreditAccount(String accountNum, String name, int balance,int interest,String grade) {
		super(accountNum,name,balance,interest);
		this.grade = grade;
	}
	@Override
	public void showAccinfo() {
		super.showAccinfo();
		System.out.println("신용등급:" + grade);
	}
}
