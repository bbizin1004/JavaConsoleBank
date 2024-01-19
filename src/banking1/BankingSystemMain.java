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

		boolean exit = false;

		do {
			Scanner scan = new Scanner(System.in);
			showMenu();
			int menu = scan.nextInt();

			switch (menu) {
			case 1:
//				makeAccount();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
//				showAccinfo();
				break;
			case 5:
				exit = true;
				break;
			}

		} while (!exit);

	}
}