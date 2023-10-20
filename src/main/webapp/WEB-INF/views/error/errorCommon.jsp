<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- model.addAttribute("exception", e); -->
<section class="content">
	<div class="error-page">
		<h2 class="headline text-danger">${exception.getMessage()}</h2>
		<div class="error-content">
			<c:forEach var="stack" items="${exception.getStackTrace()}">
			<h3>
				<i class="fas fa-exclamation-triangle text-danger"></i> 
				${stack.toString()}
			</h3>
			</c:forEach>
			<p>
				We will work on fixing that right away. Meanwhile, you may <a
					href="/">return to dashboard</a> or try using the
				search form.
			</p>
		</div>
	</div>
</section>
