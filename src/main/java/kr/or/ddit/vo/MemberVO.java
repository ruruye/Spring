package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

//MEMBER테이블 : 회원
//PoJo에 위반되지만 편의에 의해서 사용
@Data
public class MemberVO {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private int coin;
	private Date regDate;
	private Date updDate;
	private String enabled;
	
	//중첩된 자바빈즈
	//MemberVO : MemberAuthVO = 1:N
	private List<MemberAuthVO> memberAuthVOList;
	
}
