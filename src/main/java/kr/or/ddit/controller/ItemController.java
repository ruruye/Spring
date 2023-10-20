package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.service.ItemService;
import kr.or.ddit.util.FileUploadUtils;
import kr.or.ddit.vo.Item3VO;
import kr.or.ddit.vo.ItemAttachVO;
import kr.or.ddit.vo.ItemVO;
import lombok.extern.slf4j.Slf4j;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Slf4j
@RequestMapping("/item")
@Controller
public class ItemController {
	
	//DI, IoC
	@Autowired
	ItemService itemService;
	
	@GetMapping("/itemRegist")
	public String itemRegist() {
		//forwarding
		return "item/itemRegist";
	}
	
	/*
	요청URI : /item/registPost
	요청파라미터 : {itemName=태블릿&price=12000&description=설명글&pictures=파일객체}
	요청방식 : post
	 */
	@ResponseBody
	@PostMapping("/registPost")
	public String registPost(ItemVO itemVO) {
		/*
		itemVO : ItemVO(itemId=0, itemName=태블릿, price=12000, description=<p>설명</p>,
		pictureURL=/2023/08/10/asddf_개똥이.jsp, pictures=org.springframework...
		 */
		log.info("itemVO : " + itemVO);
		
		int result = this.itemService.itemRegist(itemVO);
		log.info("registPost->result : " + result);//1행

		return "SUCCESS";
	}
	
	@GetMapping("/itemMultiRegist")
	public String itemMultiRegist() {
		//forwarding
		return "item/itemMultiRegist";
	}
	/*
	요청URI : /item/registMultiPost
	요청파라미터 : {itemName=태블릿&price=12000&description=설명글&pictures=파일객체들}
	요청방식 : post
	 */
	@ResponseBody
	@PostMapping("/registMultiPost")
	public String registMultiPost(Item3VO item3VO) {
		log.info("item3VO : " + item3VO);
		
		int result = this.itemService.registMultiPost(item3VO);
		log.info("registMultiPost->result : " + result);
		//뷰경로가 아닌 데이터
		return "SUCCESS";
		
	}
	
}
