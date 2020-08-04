package Main.service;

import java.util.Date;

import Main.DTO.MemberDAO;
import Main.DTO.MemberDTO;
import Main.DTO.RegisterRequest;

public class MemberRegisterService {
	// DAO는 의존 객체가 된다.
	private MemberDAO memberDao = new MemberDAO();

	public void regist(RegisterRequest req) {
		MemberDTO dto = memberDao.selectByEmail(req.getEmail());
		// req가 받아온 값을 DTO에다가 저장한다.
		if (dto == null) {// 이렇게 쓰면 dependency 인젝션을 할 필요가 없어진다.
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록이 완료 되었습니다.");
		}else {
			System.out.println("중복 사용자 입니다.");
		}
	}
}
