package banking1;

import java.util.Scanner;

public class Account {
	
	private String accountNum;
	private String name;
	private int balance;
	
	public Account() {
		
	}
	
	public Account (String accountNum,String name,int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance=balance;
	}
	
	
	static Account[] accounts = new Account[50];
	static int index = 0;
	
	public static void makeAccount() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***신규계좌개설***");
		
		System.out.print("계좌번호: ");
		String accountNum = scan.nextLine();
		
		System.out.print("계좌번호: ");
		String name = scan.nextLine();
		
		System.out.print("계좌번호: ");
		int balance = scan.nextInt();
		
		accounts[index]= new Account(accountNum,name,balance);
		index++;
	}
	
	public static void depositMoney() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("계좌번호: ");
		String accountNum = scan.nextLine();
	}
	
	public static void withdrawMoney() {
		
	}
	
	public static void showAccinfo() {
		System.out.println("***계좌정보출력***");
		for(int i = 0; i < index; i++ ) {
			System.out.println("계좌번호:" + accounts[i].accountNum);
			System.out.println("고객이름:" + accounts[i].name);
			System.out.println("잔고:" + accounts[i].balance);
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	

	 
}
