package kr.or.ddit.mapper;

import kr.or.ddit.vo.MemberVO;

public interface MemberMapper {
	//로그인
	//<select id="detail" parameterType="String" resultMap="memberDetailMap">
	public MemberVO detail(String userNo);
}
