package banking6;

import java.util.HashSet;

public class AutoSave extends Thread{
	
	String autosave;
	HashSet<Account> accounts;
	
	public AutoSave(HashSet<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	
	
}
