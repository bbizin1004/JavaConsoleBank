package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {

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

			try {

				int menu = scan.nextInt();

				switch (menu) {
				case MAKE:
					account.makeAccount();
					break;
				case DEPOSIT:
					account.depositMoney();
					break;
				case WITHDRAW:
					account.withdrawMoney();
					break;
				case INQUIRE:
					account.showAccinfo();
					break;
				case EXIT:
					System.out.println("프로그램종료");
					return;

				}

			} catch (InputMismatchException e) {
				System.out.println("메뉴입력 예외발생됨.");
				System.out.println("문자는 입력할수 없습니다.");
			}

		}
	}
}