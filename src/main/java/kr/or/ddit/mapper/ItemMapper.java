package kr.or.ddit.mapper;

import java.util.List;

import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemAttachVO;
import kr.or.ddit.vo.ItemVO;

//골뱅이Repository 안씀
public interface ItemMapper {
	
	//아이템 등록
	public int itemRegist(ItemVO itemVO);
	
	//아이템 등록
	//<insert id="registMultiPost" parameterType="item3VO">
	public int registMultiPost(Item3VO item3VO);
	
	//파일 다중 입력
	//<update id="registMultiAttach" parameterType="java.util.List">
	public int registMultiAttach(List<ItemAttachVO> itemAttachVOList);
}
