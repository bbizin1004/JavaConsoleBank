package banking6;

import java.io.BufferedWriter;
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
			BufferedWriter out = new BufferedWriter(
					new FileWriter("src/banking6/AutoSaveAccount.txt"));
			
			while (true) {
				
				for(Account ac : accounts) {
					if(ac instanceof NormalAccount) {
						out.write("[보통계좌]");
					}else if (ac instanceof HighCreditAccount) {
						out.write("[신용계좌]");
					}
				}
				
				
				
				
				sleep(5000);

			}

		} catch (InterruptedException e) {
			System.out.println("자동저장시 오류발생");
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
