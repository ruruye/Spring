<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="content">
	<div class="error-page">
		<h2 class="headline text-danger">Access Denied Page</h2>
		<div class="error-content">
			<h3>
				<i class="fas fa-exclamation-triangle text-danger"></i> Oops!
				<!--model.addAttribute("msg", "Access Denied"); -->
				${msg}
			</h3>
			<p>
				${SPRING_SECURITY_403_EXCEPTION.getMessage()}
				We will work on fixing that right away. Meanwhile, you may <a
					href="/">return to dashboard</a> or try using the
				search form.
			</p>
		</div>
	</div>
</section>
