package kr.or.ddit.service;

import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemVO;

public interface ItemService {
	//메소드 시그니처
	
	//아이템 등록
	public int itemRegist(ItemVO itemVO);
	
	//아이템등록 + 다중파일
	public int registMultiPost(Item3VO item3VO);

}
