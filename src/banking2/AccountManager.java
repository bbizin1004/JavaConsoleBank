package banking2;

import java.util.Scanner;

public class AccountManager {

	private Account[] accounts;
	private int index;

	public AccountManager(int num) {
		accounts = new Account[num];
		index = 0;
	}

	public void makeAccount(int menu) {
		Scanner scan = new Scanner(System.in);

		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");

		System.out.print("계좌번호: ");
		String accountNum = scan.nextLine();

		System.out.print("이름: ");
		String name = scan.nextLine();

		System.out.print("잔고: ");
		int balance = scan.nextInt();

		if (menu == 1) {
			System.out.print("기본이자%(정수형태로 입력):");
			int interest = scan.nextInt();
			NormalAccount normal = new NormalAccount(accountNum, name, balance, interest);
			accounts[index++] = normal;
		} else if (menu == 2) {
			System.out.print("기본이자%(정수형태로 입력):");
			int interest = scan.nextInt();
			System.out.print("신용등급(A,B,C등급:");
			String grade = scan.next();
			HighCreditAccount high = 
					new HighCreditAccount(accountNum, name, balance, interest, grade);
			accounts[index++] = high;
		}

		System.out.println("계좌개설이 완료되었습니다.");
	}

	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);

		boolean isFind = false;
		System.out.print("계좌번호: ");
		String searchNum = scan.nextLine();

		for (int i = 0; i < index; i++) {
			if (searchNum.compareTo(accounts[i].accountNum) == 0) {
				System.out.print("입금액: ");
				int addMoney = scan.nextInt();
				accounts[i].balance += addMoney;
				isFind = true;
				System.out.println("입금이 완료되었습니다.");
			}
		}
		if (isFind == false)
			System.out.println("해당계좌가 존재하지 않습니다.");
	}

	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		Scanner scan = new Scanner(System.in);

		boolean isFind = false;
		System.out.print("계좌번호: ");
		String searchNum = scan.nextLine();

		for (int i = 0; i < index; i++) {
			if (searchNum.compareTo(accounts[i].accountNum) == 0) {
				System.out.print("출금액: ");
				int minusMoney = scan.nextInt();
				accounts[i].balance -= minusMoney;
				isFind = true;
				System.out.println("출금이 완료되었습니다.");
			}
		}
		if (isFind == false)
			System.out.println("해당계좌가 존재하지 않습니다.");
	}

	public void showAccinfo() {
		System.out.println("***계좌정보출력***");
		for (int i = 0; i < index; i++) {
			accounts[i].showAccinfo();
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
}