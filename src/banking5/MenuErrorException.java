package banking5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuErrorException extends Exception {
	public MenuErrorException() {
		super("1~5사이의 정수를 입력하세요");
	}



}
