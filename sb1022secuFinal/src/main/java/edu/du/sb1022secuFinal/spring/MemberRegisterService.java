package edu.du.sb1022secuFinal.spring;

import edu.du.sb1022secuFinal.entity.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MemberRegisterService {
	private MemberDao memberDao;

	private PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = Member.builder()
				.name(req.getName())
				.password(passwordEncoder().encode(req.getPassword()))
				.email(req.getEmail())
				.regdate(LocalDateTime.now())
				.build();

//		Member newMember = new Member(
//				req.getEmail(), req.getPassword(), req.getName(),
//				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
