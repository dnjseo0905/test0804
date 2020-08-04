package Main.service;

import java.util.Collection;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;

public class MemberListPrinter {
	private MemberDAO memberDao;
	private MemberPrinter printer;
	public MemberListPrinter(MemberDAO memberDao, MemberPrinter printer) {//생성자를 이용한 의존객체 주입
		this.memberDao = memberDao;
		this.printer = printer;
	}
	public void printAll() {
		// TODO Auto-generated method stub
		Collection<MemberDTO> lists = memberDao.selectAll();
		System.out.println("총 회원 수는 : " + lists.size());
		for(MemberDTO dto : lists) {
			printer.print(dto);
		}
	}
	
}
