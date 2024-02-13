package multichat;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static void main(String[] args) {
		
		/*
		 JDBC 프로그래밍의 절차
		 
		 1.오라클용 JDBC 드라이버를 메모리에 로드한다.
		: new를 사용하지 않고 클래스명으로 직접 인스턴스를 생성한 후
		메모리에 로드하는 forName() 이라는 정적메서드를 사용한다.
		메모리에 로드된 드라이버가 DriverManager라는 클래스에 등록한다.
		
		2.오라클 연결을 위한 커넥션URL, 계정아이디, 패스워드를 준비한다.
		커넥션URL =>
		 jdbc:oracle:thin:@오라클서버의 IP주소:포트번호:SID명
		※서버환경에 따라 IP주소, 포트번호, SID는 변경될 수 있다.
		
		3.DriverMaNager 클래스의 정적메서드인 getConnection()을
		통해 데이터베이스에 연결을 시도하고, 연결에 성공하면, Connection 
		인스턴스를 반환한다.
		
		4.우리는 반환된 Connection 인스턴스를 통해 CRUD와 같은
		DB작업을 하게 된다.
		*/
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "study";
			String pass = "1234";
			
			/*
			◈ Connection 인터페이스
			Connection 객체는 특정 데이터 원본과 연결된 커넥션을 나타낸다. 
			SQL 문장을 정의하고 실행시킬 수 있는 Statement 객체를 생성할 때 
			Connection 객체를 사용한다.*/
			Connection con = 
					/*DriverManager 클래스 는 데이터 원본에 JDBC 드라이버를
					 통해 커넥션을 만드는 역활을 한다.
					 Class.forName() 메소드를 통해서 생성된다.*/
					DriverManager.getConnection(url,id,pass);
			if(con!=null) {
				System.out.println("Oracle 연결성공");
			}
			else {
				System.out.println("Oracle 연결실패");
			}
		}
		catch(Exception e) {
			System.out.println("Oracle 연결시 예외발생");
			e.printStackTrace();
		}
	
		
	}

}
