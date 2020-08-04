package test_02;

import java.util.Scanner;

import Main.DTO.RegisterRequest;
import Main.service.MemberListPrinter;
import Main.service.MemberRegisterService;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("명령어를 입력하세요.");
			String command = sc.nextLine();// 명령어가 URL이라고 생각하기 때문에 변수명을 command라고함
			if (command.startsWith("new ")) {
				// 의존 객체 dependency object
				String[] arg = command.split(" ");
				if (arg.length != 5) {
					printHelp();
					System.out.println();
					continue;
				}
				RegisterRequest req = new RegisterRequest();
				req.setConfrimPassword(arg[1]);
				req.setEmail(arg[2]);
				req.setName(arg[3]);
				req.setPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if (!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				//dependency object가된다.
				MemberRegisterService mrs = new MemberRegisterService();
				mrs.regist(req);
			} else if (command.startsWith("change ")) {
			} else if (command.startsWith("list ")) {
				//dependency object가된다.
				MemberListPrinter listPrint = new MemberListPrinter();
				listPrint.printAll();
			} else if (command.startsWith("info ")) {
			} else if (command.startsWith("exit")) {
				System.exit(0);

			}
		}

	}

	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("chage 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("exit 프로그램 종료");
	}
}
