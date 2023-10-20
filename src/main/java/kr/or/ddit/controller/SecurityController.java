package kr.or.ddit.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class SecurityController {
	//웹화면 접근 정책
	
	//요청URI : /freeboard/list
	//회원게시판의 목록
	//누구나 접근 가능
	@GetMapping("/freeboard/list")
	public String freeboardList() {
		//forwarding
		return "freeboard/list";
	}
	
	//요청URI : /freeboard/register
	//회원게시판의 등록
	//로그인한 회원 중에서 ROLE_ADMIN 또는 ROLE_MEMBER 권한을 가진 경우 접근 가능
	//골뱅이PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	//골뱅이Secured({"ROLE_ADMIN","ROLE_MEMBER"})
	//골뱅이PreAuthorize("hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
	@PreAuthorize("hasRole('ROLE_MEMBER') and hasRole('ROLE_ADMIN')")
	@GetMapping("/freeboard/register")
	public String freeboardRegister() {
		//forwarding
		return "freeboard/register";
	}
	

	//요청URI : /notice/list
	//공지사항게 게시판의 목록
	//누구나 접근 가능 -> ROLE_MEMBER 권한 또는 ROLE_ADMIN 권한에 상관없이 로그인 한 경우만 접근 가능
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/notice/list")
	public String noticeList() {
		//forwarding
		return "notice/list";
	}
	
	//요청URI : /notice/register
	//공지사항게 게시판의 등록
	//로그인한 관리자만 접근 가능 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/notice/register")
	public String noticeRegister() {
		//forwarding
		return "notice/register";
	}
	
	//접근 거부 처리자의 URI를 지정
	@GetMapping("/security/accessError")
	public String accessError(Authentication auth, Model model) {
		//auth : 로그인이 시도된 정보를 담고 있음, auth.getName() : 계정아이디
		log.info("access Denied : " + auth.getName());
		
		model.addAttribute("msg", "Access Denied");
		
		//forwarding
		return "security/accessError";
	}
}
