package banking6;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
	HashSet<Account> accounts;// 필드에 선언해야 다른 메소드에서 쓸수 있음

	public AccountManager() {
		accounts = new HashSet<Account>();
	}

	// 메뉴 출력
	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.프로그램종료");
		System.out.print("선택:");
	}

	// 계좌 개설
	public void makeAccount() {
//		Scanner scan = new Scanner(System.in);

		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");

		int choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine(); // 버퍼 날림

		System.out.print("계좌번호: ");
		String accountNum = BankingSystemMain.scan.nextLine();

		System.out.print("이름: ");
		String name = BankingSystemMain.scan.nextLine();

		System.out.print("잔고: ");
		int balance = BankingSystemMain.scan.nextInt();

		if (choice == 1) {
			System.out.print("기본이자%(정수형태로 입력):");
			int interest = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine(); // 버퍼 날림
			NormalAccount normal = new NormalAccount(accountNum, name, balance, interest);
			if (accounts.add(normal) == false) {
				System.out.println("중복계좌 발견됨. 덮어쓸까요? (y or n)");
				String dup = BankingSystemMain.scan.nextLine();
				if (dup.equals("y")) {
					accounts.remove(normal);
					accounts.add(normal);
				} else if (dup.equals("n")) {
					return;
				}
			} else if (accounts.add(normal) == true) {
				accounts.add(normal);
			}

		} else if (choice == 2) {
			System.out.print("기본이자%(정수형태로 입력):");
			int interest = BankingSystemMain.scan.nextInt();
			System.out.print("신용등급(A,B,C등급:");
			String grade = BankingSystemMain.scan.next();
			HighCreditAccount high = new HighCreditAccount(accountNum, name, balance, interest, grade);

			if (accounts.add(high) == false) {
				System.out.println("중복계좌 발견됨. 덮어쓸까요? (y or n)");
				String dup = BankingSystemMain.scan.nextLine();
				if (dup.equals("y")) {
					accounts.remove(high);
					accounts.add(high);
				} else if (dup.equals("n")) {
					return;
				}
			} else if (accounts.add(high) == true) {
				accounts.add(high);
			}

		}
		System.out.println("계좌개설이 완료되었습니다.");
	}

	// 입금
	public void depositMoney() {
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");

		boolean isFind = false;
		System.out.print("계좌번호: ");
		String searchNum = BankingSystemMain.scan.nextLine();

		// 확장 for문으로 변경( hashset은 인덱스가 없기때문에)// 일반for문으로는 안되는지??
		for (Account ac : accounts) {
			if (searchNum.compareTo(ac.accountNum) == 0) {
				System.out.print("입금액: ");

				try {
					int addMoney = BankingSystemMain.scan.nextInt();
					if (addMoney > 0) {
						if (addMoney % 500 == 0) {
							ac.deposit(addMoney);
							isFind = true;
							System.out.println("입금이 완료되었습니다.");

						} else {
							System.out.println("500원 단위로만 입금하실수 있습니다.");
							return;
						}
					} else {
						System.out.println("음수를 입력할 수 없습니다.");
						return;
					}

				} catch (InputMismatchException e) {
					System.out.println("문자를 입력할 수 없습니다.");
					return;
				}
			}
		}
		if (isFind == false)
			System.out.println("해당계좌가 존재하지 않습니다.");
	}

	// 출 금
	public void withdrawMoney() {
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");

		boolean isFind = false;
		System.out.print("계좌번호: ");
		String searchNum = BankingSystemMain.scan.nextLine();

		for (Account ac : accounts) {
			if (searchNum.compareTo(ac.accountNum) == 0) {
				System.out.print("출금액: ");

				try {
					int minusMoney = BankingSystemMain.scan.nextInt();
					if (minusMoney > 0) {
						if (ac.balance > minusMoney) {
							if (minusMoney % 1000 == 0) {
								ac.balance -= minusMoney;
								isFind = true;
								System.out.println("출금이 완료되었습니다.");
							} else {
								System.out.println("1000원 단위로만 출금이 가능합니다.");
								return;
							}
						} else {
							System.out.println("잔고가 부족합니다. 금액 전체를 출금할까요?");
							System.out.println("y:금액전체 출금처리 or n:출금요청취소 ");
							BankingSystemMain.scan.nextLine();
							String allMoney = BankingSystemMain.scan.nextLine();

							if (allMoney.equals("y")) {
								ac.balance -= ac.balance;
								System.out.println("출금이 완료되었습니다.");
							} else if (allMoney.equals("n")) {
								return;
							}
						}

					} else {
						System.out.println("음수를 입력할수 없습니다.");
						return;
					}

				} catch (InputMismatchException e) {
					System.out.println("문자는 입력할수 없습니다.");
					return;
				}
			}
		}
		if (isFind == false)
			System.out.println("해당계좌가 존재하지 않습니다.");
	}

	// 계좌 정보 출력
	public void showAccinfo() {
		System.out.println("***계좌정보출력***");
		for (Account ac : accounts) {
			ac.showAccinfo();
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}

	// 계좌 삭제
	public void deleteAccount() {
		BankingSystemMain.scan.nextLine(); // 버퍼 날림
		System.out.println("삭제할 계좌를 입력하세요");

		boolean isFind = false;

		System.out.println("계좌번호:");
		String delete = BankingSystemMain.scan.nextLine();

		for (Account ac : accounts) {
			if (delete.equals(ac.accountNum)) {
				accounts.remove(ac);
				isFind = true;
				break;
			}
		}
		if (isFind == false)
			System.out.println("해당계좌가 존재하지 않습니다.");
		else
			System.out.println("데이터가 삭제되었습니다.");
	}

	// 파일 저장
	public void saveAccountInfo() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/banking5/AccountInfo.obj"));

			for (Account ac : accounts) {
				out.writeObject(ac);
			}
			out.close();

		}
		catch (Exception e) {
			 System.out.println("저장완료");
		}

	}

	// 파일 복원
	public void readAccountInfo() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(
					"src/banking5/AccountInfo.obj"));

			while (true) {
				Account ac = (Account)in.readObject();
				accounts.add(ac);
			}
			
		}
		catch (FileNotFoundException e) {
			System.out.println("[예외]obj파일이 없습니다.");
		} 
		catch (EOFException e) {
			System.out.println("[예외]파일의 끝까지 모두 복원했습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("복원 중 알수없는 예외발생");
		} 
		finally {
			
			try {
				if(!(in==null)) {
					in.close();
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}