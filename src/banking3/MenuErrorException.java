package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuErrorException extends Exception {
	public MenuErrorException() {
		super("1~5사이의 정수를 입력하세요");
	}

	public static int readMenu() {
		Scanner sc = new Scanner(System.in);

		int inputMenu = 0;// 이걸 꼭 넣어야 하는지??

		try {
			inputMenu = sc.nextInt();
			if (!(inputMenu > 0 && inputMenu < 6)) {
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
