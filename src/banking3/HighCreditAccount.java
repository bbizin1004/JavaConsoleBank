package banking3;

public class HighCreditAccount extends NormalAccount {
	String grade;
	
	public HighCreditAccount(String accountNum, String name, int balance,
			int interest,String grade) {
		super(accountNum,name,balance,interest);
		this.grade = grade;
	}
	
	@Override
	public void deposit(int addMoney) {
		if(this.grade.equalsIgnoreCase("A")) {
			balance += (balance * interest/100)+ (balance * 7/100)+addMoney;
		}
		else if(this.grade.equalsIgnoreCase("B")) {
			balance += (balance * interest/100)+ (balance * 4/100)+addMoney;
		}
		else if(this.grade.equalsIgnoreCase("C")) {
			balance += (balance * interest/100)+ (balance * 2/100)+addMoney;
		}
	}
	
	@Override
	public void showAccinfo() {
		super.showAccinfo();
		System.out.println("신용등급:" + grade);
	}
}
