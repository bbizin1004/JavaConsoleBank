package banking1;

import java.util.Scanner;

public class Account {

	String accountNum;
	String name;
	int balance;

	public Account(String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}

	public void showAccinfo() {
		System.out.println("계좌번호:" + accountNum);
		System.out.println("고객이름:" + name);
		System.out.println("잔고:" + balance);
	}

}

class AccountManager {

	private Account[] accounts;
	private int index;

	public AccountManager(int num) {
		accounts = new Account[num];
		index = 0;
	}

	public void makeAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.println("***신규계좌개설***");

		System.out.print("계좌번호: ");
		String accountNum = scan.nextLine();

		System.out.print("이름: ");
		String name = scan.nextLine();

		System.out.print("잔고: ");
		int balance = scan.nextInt();

		accounts[index] = new Account(accountNum, name, balance);
		index++;
	}

	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.print("계좌번호: ");
		String searchNum = scan.nextLine();
		
		for (int i = 0; i < index; i++) {
			if(searchNum.compareTo(accounts[i].accountNum)==0) {
				System.out.print("입금액: ");
				int addMoney = scan.nextInt();
				accounts[i].balance += addMoney;
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("해당계좌가 없습니다.");
	}

	public void withdrawMoney() {

	}

	public void showAccinfo() {
		System.out.println("***계좌정보출력***");
		for (int i = 0; i < index; i++) {
			accounts[i].showAccinfo();
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}