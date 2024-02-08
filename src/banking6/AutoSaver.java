package banking6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class AutoSaver extends Thread {

	String autosave;
	HashSet<Account> accounts;

	public AutoSaver(HashSet<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public void run() {
		System.out.println("자동저장을 실행합니다.");

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("src/banking6/AutoSaveAccount.txt"));

			while (true) {

				for (Account ac : accounts) {
					if (ac instanceof NormalAccount) {
						out.write("[보통계좌]");
					} else if (ac instanceof HighCreditAccount) {
						out.write("[신용신뢰계좌]");
					}
					out.write("계좌번호:");
					out.write(ac.accountNum);
					out.write(" ,고객이름:");
					out.write(ac.name);
					out.write(" ,잔고:");
					out.write(ac.balance);
					out.write(" ,기본이자:");
//					out.write(ac.interest);
					
					out.write(" ,신용등급:");
//					out.write(ac.grade);

					out.newLine();

				}
				System.out.println("자동저장 완료.");
				
				sleep(5000);

			}

		} catch (InterruptedException e) {
			System.out.println("자동저장시 오류발생");
		} catch (FileNotFoundException e) {
			System.out.println("파일없음");
		} catch (IOException e) {
			System.out.println("IO 오류");
		}

	}

}
