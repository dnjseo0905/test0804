package Main.service;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberInfoPrinter {
	private MemberDAO memberDao = new MemberDAO();
	private MemberPrinter printer = new MemberPrinter();
	public void setMemberDAO(MemberDAO memberDao) {//setter를 이용한 의존객체 주입
		this.memberDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {//setter를 이용한 의존객체 주입
		this.printer = printer;
	}
	public void printMemberInfo(String email) {
		// TODO Auto-generated method stub
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(dto);
	}

}
