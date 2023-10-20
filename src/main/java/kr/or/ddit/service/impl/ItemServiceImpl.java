package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.mapper.ItemMapper;
import kr.or.ddit.service.ItemService;
import kr.or.ddit.util.FileUploadUtils;
import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemAttachVO;
import kr.or.ddit.vo.ItemVO;

@Service
public class ItemServiceImpl implements ItemService{
	
	//DI, IoC
	@Autowired
	ItemMapper itemMapper;
	
	//아이템 등록
	@Override
	public int itemRegist(ItemVO itemVO) {
		//MultipartFile : 스프링 파일객체 인터페이스
		MultipartFile picture = itemVO.getPictures();
		
		//파일업로드
		String pictureUrl = FileUploadUtils.singleUpload(picture);
		
		itemVO.setPictureUrl(pictureUrl);
		
		//아이템 insert
		int result = this.itemMapper.itemRegist(itemVO);
		
		return result;
	}
	
	//아이템등록 + 다중파일
	//요청파라미터 : {itemName=태블릿&price=12000&description=설명글&pictures=파일객체들}
	//Transactional : 클래스나 메서드의 스프링의 트랜잭션 처리를 적용
	@Transactional
	@Override
	public int registMultiPost(Item3VO item3VO) {
		//1) item3VO -> ITEM3테이블에 insert
		int result = this.itemMapper.registMultiPost(item3VO);
		
		MultipartFile[] pictures = item3VO.getPictures();
		
		//파일업로드
		/*
		 itemAttachList[
			 itemAttachVO[fullname=/2023/08/10/asdf1_개똥이.jsp,itemId=0,regdate=null],
			 itemAttachVO[fullname=/2023/08/10/qeret_박명수.jsp,itemId=0,regdate=null],
			 itemAttachVO[fullname=/2023/08/10/asewf_홍길동.jsp,itemId=0,regdate=null]
		 ]
		 */
		List<ItemAttachVO> itemAttachVOList 
			= FileUploadUtils.multiUpload(pictures);
		
		//ITEM_ATTACH테이블을 위한 itemId=0을 ITEM3테이블에 insert된 itemId값으로 보정
		for(ItemAttachVO vo : itemAttachVOList) {
			vo.setItemId(item3VO.getItemId());
		}
		
		item3VO.setItemAttachVOList(itemAttachVOList);
		
		//2) ItemAttach(fullname, itemId, regdate) -> ITEM_ATTACH 테이블에 insert
		//public int registMultiAttach(List<ItemAttachVO> itemAttachVOList)
		result += this.itemMapper.registMultiAttach(itemAttachVOList);
		
		return result;
	}
		
		
		
		
	
}
