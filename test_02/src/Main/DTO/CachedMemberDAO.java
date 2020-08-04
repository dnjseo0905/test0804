package Main.DTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CachedMemberDAO {
	private static long nextId = 0;
	private static Map<String, MemberDTO> map = new HashMap<String, MemberDTO>();

	public void insert(MemberDTO dto) {
		dto.setId(++nextId);// 아이디가 1씩 증가한다. 즉, jsp에서 만든 테이블명_넘버 와 일치한다.
		map.put(dto.getEmail(), dto);
	}

	public MemberDTO selectByEmail(String email) {
		return map.get(email);
	}

	public Collection<MemberDTO> selectAll() {
		// TODO Auto-generated method stub
		return map.values();
	}

	public void update(MemberDTO dto) {
		// TODO Auto-generated method stub
		map.put(dto.getEmail(), dto);
	}
}
