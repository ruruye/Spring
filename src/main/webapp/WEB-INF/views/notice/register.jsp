<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>  
<h3>Notice REGISTER : 로그인 한 관리자만 접근 가능 </h3>
<form action="/logout" method="post">
	<button type="submit">로그아웃</button>
	<sec:csrfInput/>
</form>