<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=08f590179f524480972edb3bfcf8fcd8&libraries=services"></script>

</head>
<body>

	<!-- header -->

	<nav class="navbar navbar-expand-lg rounded" style="top: 5px;">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Title -->
			<div class="collapse navbar-collapse d-lg-flex">
				<a class="navbar-brand col-lg-3 me-0" href="/main.do"
					style="padding-left: 20px; font-family: 'AppleSDGothicNeoEB'; font-size:30px;"><img src="../images/pet.png"
						style="max-width: 48px;width: 40%;padding: 5px;margin-right: 8px;margin-top: 0px;">PETMAP</a>
				<ul class="navbar-nav col-lg-6 justify-content-lg-center">
					<li class="nav-item"><a class="nav-link active"
						href="/p_hospital.do" style="font-family: 'AppleSDGothicNeoM';margin-right: 30px; font-size:20px;">동물 병원</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/p_food.do" style="font-family: 'AppleSDGothicNeoM';margin-right: 30px; font-size:20px;">식당 / 카페</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/p_hair.do" style="font-family: 'AppleSDGothicNeoM'; font-size:20px;">동물 미용실</a></li>
				</ul>
				<div class="d-lg-flex col-lg-3 justify-content-lg-end"
					style="padding-right: 20px;">
					<a  href="/p_register.do"><img src="../images/menu-burger.png"
						style="width: 30px;padding: 5px;margin-right: 8px;margin-top: 0px;"></a>
				</div>
			</div>
		</div>
	</nav>

	<hr style="margin-top: 13px; margin-bottom: 0px;">

<style type="text/css">
@font-face {
	src: url("/font/AppleSDGothicNeoB.ttf");
	font-family: "AppleSDGothicNeoB";
}

@font-face {
	src: url("/font/AppleSDGothicNeoM.ttf");
	font-family: "AppleSDGothicNeoM";
}

@font-face {
	src: url("/font/AppleSDGothicNeoEB.ttf");
	font-family: "AppleSDGothicNeoEB";
}
</style>

	<!-- JavaScript -->

	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>