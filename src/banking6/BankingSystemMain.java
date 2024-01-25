package banking6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		AccountManager account = new AccountManager();
		
		account.readAccountInfo();
		
		while (true) {
			account.showMenu();
			int menu = readMenu();
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
			case DELETE:
				account.deleteAccount();
				break;
			case SAVE:
				account.autoSave();
				break;
			case EXIT:
				account.saveAccountInfo();
				System.out.println("프로그램종료");
				return;

			}

		}
	}

	public static int readMenu() {

		int inputMenu = 0;

		try {
			inputMenu = scan.nextInt();
			if (!(inputMenu > 0 && inputMenu < 8)) {
				MenuErrorException ex = new MenuErrorException();
				throw ex;
			}
		} catch (InputMismatchException e) {
			System.out.println("메뉴입력 예외발생됨.");
			System.out.println("문자는 입력할수 없습니다.");
		} catch (MenuErrorException e) {
			System.out.println("메뉴입력 예외발생됨.");
			System.out.println(e.getMessage());
		}
		return inputMenu;

	}

}