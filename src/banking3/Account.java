package banking3;

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

}





