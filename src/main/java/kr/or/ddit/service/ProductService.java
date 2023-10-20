package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.ProductVO;

public interface ProductService {

	//메소드 시그니처
	//상품 등록
	public int processAddProduct(ProductVO productVO);

	//상품 목록
	public List<ProductVO> products();

	//상품 상세정보
	public ProductVO product(String productId);
	
}
