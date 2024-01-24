package banking4;

import java.util.Objects;

public class NormalAccount extends Account {
	int interest;

	public NormalAccount(String accountNum, String name, int balance, int interest) {
		super(accountNum, name, balance);
		this.interest = interest;

	}

	@Override
	public void deposit(int addMoney) {
		balance += (balance * interest / 100) + addMoney;
	}

	@Override
	public void showAccinfo() {
		super.showAccinfo();
		System.out.println("기본이자:" + interest);
	}

	
//	
//	방법2 : Objects 클래스의 정적메서드인 hash()를 사용할수 있다. 
//		멤버변수의 갯수만큼 인수로 전달하면 방법1과 동일하게 고유한
//		참조값을 정수형으로 반환해준다. 
//	
//	@Override
//	public int hashCode() {
//	int returnCode2 = Objects.hash(super.getAge(), 
//			this.subject);
//	
//	return returnCode2;
//}
	
	
	
	
	@Override
	public int hashCode() {
		return super.accountNum.hashCode();
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		Account aObj = (Account) obj;
		if (aObj.accountNum.equals(super.accountNum)) {
			return true;
		} else {
			return false;
		}
	}

}