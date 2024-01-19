package banking1;

import java.util.Scanner;

public class BankingSystemMain {

	public static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager account = new AccountManager(50);
		
		while (true) {
			showMenu();
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				account.makeAccount();
				break;
			case 2:
				account.depositMoney();
				break;
			case 3:
				account.withdrawMoney();
				break;
			case 4:
				account.showAccinfo();
				break;
			case 5:
				System.out.println("프로그램종료");
				return;
			}

		}
	}
}