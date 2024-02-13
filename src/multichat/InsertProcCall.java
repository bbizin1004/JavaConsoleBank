package multichat;

import java.sql.SQLException;
import java.sql.Types;

public class InsertProcCall extends MyConnection {

	public InsertProcCall() {
		super("study", "1234");
	}
	
	@Override
	public void dbExecute() {
		try {
			csmt = con.prepareCall("{call chat_talking(?,?,?)}");
			//인파라미터 설정. 사용자로부터 입력받은 값을 세팅한다.
			//csmt.setString(1, );  //어떻게 대화명을 가져올지 고민
			//csmt.setString(2, );  //어떻게 대화내용을 가져올지 고민
			csmt.registerOutParameter(3, Types.NUMERIC);
			csmt.execute();
			int affected = csmt.getInt(3);
			if (affected == 0)
				System.out.println("오류발생:입력실패");
			else
				System.out.println(affected + "행 입력성공");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new InsertProcCall().dbExecute();

	}

}
