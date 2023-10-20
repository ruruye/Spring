<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- 로그인 되었다면 로그인 페이지로 접근 못하도록 처리 -->
<sec:authorize access="isAuthenticated()">
<script>location.href="/";</script>
</sec:authorize>
<div style="display: flex; justify-content: center; align-items: center;">
<div class="login-box">
	<div class="login-logo">
		<a href="/member/loginMember"><b>로그인</b></a>
	</div>

	<div class="card">
		<div class="card-body login-card-body">
			<p class="login-box-msg">Sign in to start your session</p>
			<!-- 시큐리티 로그인 폼 규칙 
			1. action="/login"
			2. method="post"
			3. 아이디 : name="username"
			4. 비밀번호 : name="password"
			5. csrf : Cross Site Request Forgery(웹 애플리케이션 취약점) 공격 그리고 방어
			-->
			<form name="frm" action="/login" method="post">
				<div class="input-group mb-3">
					<input type="text" name="username" 
						class="form-control" placeholder="아이디">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-envelope"></span>
						</div>
					</div>
				</div>
				<div class="input-group mb-3">
					<input type="password" name="password" 
						class="form-control" placeholder="비밀번호">
					<div class="input-group-append">
						<div class="input-group-text">
							<span class="fas fa-lock"></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-8">
						<div class="icheck-primary">
							<input type="checkbox" id="remember" name="remember-me"> <label
								for="remember"> Remember Me </label>
						</div>
					</div>

					<div class="col-4">
						<button type="submit" class="btn btn-primary btn-block">Sign
							In</button>
					</div>

				</div>
				<sec:csrfInput/>
			</form>
		</div>

	</div>
</div>
</div>