package banking5;

import java.util.Scanner;

abstract public class Account {

	String accountNum;
	String name;
	int balance;

	public Account(String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}

	abstract void deposit(int addMoney);

	public void showAccinfo() {
		System.out.println("계좌번호:" + accountNum);
		System.out.println("고객이름:" + name);
		System.out.println("잔고:" + balance);
	}

	@Override
	public int hashCode() {
		return accountNum.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Account aObj = (Account) obj;
		if (aObj.accountNum.equals(accountNum)) {
			return true;
		} else {
			return false;
		}
	}

}
