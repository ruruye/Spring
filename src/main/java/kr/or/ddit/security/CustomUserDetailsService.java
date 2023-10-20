package kr.or.ddit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.ddit.mapper.MemberMapper;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	
	//DI(Dependency Injection)의존성 주입
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		//1) 사용자 정보를 검색 
		MemberVO memberVO = this.memberMapper.detail(username);
		log.info("memberVO : " + memberVO);
		
		//CustomUser : 사용자 정의 유저 정보, extends User를 상속받고 있음
		//User : 스프링 시큐리티에서 제공해주는 사용자 정보를 담고 있는 클래스
		return memberVO==null?null:new CustomUser(memberVO);
	}

}
