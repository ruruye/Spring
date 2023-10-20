package kr.or.ddit.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//자바빈클래스
@Data
public class Item3VO {
	private int itemId;
	private String itemName;
	private int price;
	private String description;
	//다중파일
	private MultipartFile[] pictures;
	//Item3VO : ItemAttachVO = 1: N
	private List<ItemAttachVO> itemAttachVOList;
}
