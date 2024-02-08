package chat4;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MultiClient {

	public static void main(String[] args) {
		System.out.println("이름을 입력하세요:");
		Scanner scanner = new Scanner(System.in);
		String s_name = scanner.nextLine();

		PrintWriter out = null;
		// BufferedReader in = null;

		try {
			String ServerIp = "localhost";
			if (args.length > 0) {
				ServerIp = args[0];
			}
			Socket socket = new Socket(ServerIp, 9999);
			System.out.println("서버와 연결되었습니다...");

			Thread receiver = new Receiver(socket);
			receiver.start();

			out = new PrintWriter(socket.getOutputStream(), true);
			out.println(s_name);

			while (out != null) {
				try {
					String s2 = scanner.nextLine();
					if (s2.equals("q") || s2.equals("Q")) {
						break;
					} else {
						out.println(s2);
					}
				} catch (Exception e) {
					System.out.println("예외:" + e);
				}
			}
			out.close();
			socket.close();

		} catch (Exception e) {
			System.out.println("예외발생[MultiClient]" + e);
		}

	}

}
