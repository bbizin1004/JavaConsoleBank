package banking2;

public class NormalAccount extends Account {
	int interest;

	public NormalAccount(String accountNum, String name, int balance, int interest) {
		super(accountNum, name, balance);
		this.interest = interest;

	}

	@Override
	public void showAccinfo() {
		super.showAccinfo();
		System.out.println("기본이자:" + interest);
	}

}