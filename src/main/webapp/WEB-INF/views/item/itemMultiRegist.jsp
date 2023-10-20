<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<div class="card card-primary">
	<div class="card-header">
		<h3 class="card-title">Item 등록</h3>
	</div>
	<!-- 
	요청URI : /item/registMultiPost
	요청파라미터 : {itemName=태블릿&price=12000&description=설명글&pictures=파일객체들}
	요청방식 : post
	 -->

	<form id="frm" action="/item/registMultiPost" method="post"
			enctype="multipart/form-data">
		<div class="card-body">
			<div class="form-group">
				<label for="itemName">아이템 명</label> 
				<input type="text" class="form-control" 
					id="itemName"
					name="itemName" placeholder="아이템 명" />
			</div>
			<div class="form-group">
				<label for="price">가격</label>
				<input type="number" class="form-control" 
					id="price"
					name="price" placeholder="가격" />
			</div>
			<div class="form-group">
				<label for="description">설명</label>
				<textarea class="form-control" 
					id="description"
					name="description"
					rows="3" cols="10" placeholder="설명"></textarea>
			</div>
			<div class="form-group">
				<label for="pictures">아이템 이미지</label>
				<div class="input-group">
					<div class="custom-file">
						<input type="file" class="custom-file-input" 
						id="pictures" name="pictures" multiple />
						<label class="custom-file-label" for="pictures">Choose
							file</label>
					</div>
				</div>
			</div>
		</div>

		<div class="card-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
<script type="text/javascript">
	CKEDITOR.replace("description");
</script>