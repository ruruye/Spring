<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery-3.6.0.js"></script>
<title>도서목록</title>
</head>
<body>
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">목록</h3>
		</div>
		<div class="card-body">
			<div id="example1_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12">
						<table id="example1"
							class="table table-bordered table-striped dataTable dtr-inline"
							aria-describedby="example1_info">
							<thead>
								<tr>
									<th onclick="event.cancelBubble=true">번호</th>
									<th onclick="event.cancelBubble=true">제목</th>
									<th onclick="event.cancelBubble=true">카테고리</th>
									<th onclick="event.cancelBubble=true">가격</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="bookVO" items="${list}" varStatus="stat">
									<tr>
										<td>${stat.count}</td>
										<td><a href="/detail?bookId=${bookVO.bookId}">${bookVO.title}</a></td>
										<td>${bookVO.category}</td>
										<td>${bookVO.price}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
<script>
$(function () {
	$("#example1").DataTable({
						"responsive" : true,
						"lengthChange" : false,
						"autoWidth" : false,
						"buttons" : [ "copy", "csv", "excel", "pdf", "print",
								"colvis" ]
					}).buttons().container().appendTo(
					'#example1_wrapper .col-md-6:eq(0)');
		});
</script>
</body>
</html>