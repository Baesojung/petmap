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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=08f590179f524480972edb3bfcf8fcd8&libraries=services"></script>

</head>
<body>

	<!-- header -->
	<jsp:include page="../include/header.jsp"></jsp:include>

	<!-- main -->
	<div class="bg-body-tertiary" style="height: 30px;"></div>
	<div class="bg-body-tertiary" style="height: 130px;">
		<div class="container"
			style="background-color: #ffff; border-radius: 20px; height: 110px;">
			<h1
				style="font-family: 'AppleSDGothicNeoB'; padding-top: 20px; padding-left: 20px; margin-bottom: 0px;">
				동물 미용실 찾기</h1>
			<a style="font-family: 'AppleSDGothicNeoM'; padding-left: 20px;">아래
				입력창에 찾고싶은 지역을 입력후 버튼을 눌러 그 지역의 동물 미용실을 찾아보세요.</a>
		</div>
	</div>
	<div class="bg-body-tertiary"
		style="background-color: #f8f8fb; height: 100%;">
		<div class="container"
			style="background-color: #ffff; border-radius: 20px; height: 630px;">
			<div class="row">
				<div class="col" style="margin-top: 20px; padding-left: 40px;">
					<!-- 지역 입력 부분 -->
					<div class="input-group"
						style="font-family: 'AppleSDGothicNeoM'; height: 60px; width: 100%; padding-left: 0px; padding-right: 15px;">
						<input type="text" class="form-control" placeholder="지역명 입력"
							id="input_address" style="padding-left: 25px; font-size: 20px">
						<button class="btn btn-outline-secondary" type="button"
							id="searchbtn">검색</button>
					</div>

					<!-- 리스트 출력 부분 -->
					<div style="margin-top: 20px;">

						<table class="table table-sm">
							<tbody class="table-group-divider" id="insert">
							<!--  
								<tr>
									<th scope="row" style="width: 15%;">병원이름</th>
									<td style="width:35%;">Mark</td>
									<th scope="row" style="width: 15%;">전화번호</th>
									<td style="width: 35%;">@mdo</td>
								</tr>
								<tr>
									<th scope="row">지번주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
								<tr>
									<th scope="row">도로명주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
								<tr><td colspan="4"></td></tr>
								<tr>
									<th scope="row" style="width: 15%;">병원이름</th>
									<td style="width:35%;">Mark</td>
									<th scope="row" style="width: 15%;">전화번호</th>
									<td style="width: 35%;">@mdo</td>
								</tr>
								<tr>
									<th scope="row">지번주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
								<tr>
									<th scope="row">도로명주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
									<tr><td colspan="4"></td></tr>
								<tr>
									<th scope="row" style="width: 15%;">병원이름</th>
									<td style="width:35%;">Mark</td>
									<th scope="row" style="width: 15%;">전화번호</th>
									<td style="width: 35%;">@mdo</td>
								</tr>
								<tr>
									<th scope="row">지번주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
								<tr>
									<th scope="row">도로명주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
									<tr><td colspan="4"></td></tr>
								<tr>
									<th scope="row" style="width: 15%;">병원이름</th>
									<td style="width:35%;">Mark</td>
									<th scope="row" style="width: 15%;">전화번호</th>
									<td style="width: 35%;">@mdo</td>
								</tr>
								<tr>
									<th scope="row">지번주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
								<tr>
									<th scope="row">도로명주소</th>
									<td colspan="3">Larry the Bird</td>
								</tr>
								<tr><td colspan="4"></td></tr>
								-->
							</tbody>
						</table>
						
						<div id="insertPagging">
						</div>
					</div>

				</div>
				<div class="col" style="margin-top: 20px; padding-right: 20px;">

					<!-- 카카오 맵 -->
					<div id="map"
						style="width: flex; height: 580px; border-radius: 20px;"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="bg-body-tertiary" style="height: 100px;"></div>

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


td {
	font-family: AppleSDGothicNeoM;
	color: rgba(0, 0, 0, 0.4);
	font-size: 15px;
}
th {
	font-family: AppleSDGothicNeoM;
	color: #5b5b5b;
	font-size: 15px;
}
#pageGroup > ul > li > a{
	color: #999;
	border: none;
	font-family: AppleSDGothicNeoEB;
  	font-size: 15px;
	width: 30px;
  	height: 30px;
  	margin-right: 10px;
  	margin-left: 10px;
}
#pagging {
  	height: 33px;
  	margin: 0px 64px 0 57px;
  	padding: 0px 25px 0px;
  	border-radius: 5px;
  	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.16);
  	background-color: #fff;
	max-width: 555px;
 	text-align: center;
}
li #pageli {
	display: inline-block;
}
</style>

<!-- JavaScript -->
<script type="text/javascript">

// 카카오 맵 설정
let container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
let options = { //지도를 생성할 때 필요한 기본 옵션
	center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level : 3
//지도의 레벨(확대, 축소 정도)
};

let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

// 마우스 드래그로 지도 이동 가능여부를 설정합니다
function setDraggable(draggable) {
	map.setDraggable(draggable);
}

// 주소-좌표 변환 객체를 생성합니다
let geocoder = new kakao.maps.services.Geocoder();

// 전체 마을 위치 마커를 담을 배열
let markers = [];

let infowindows = [];

let positions = [ {
	h_name : '이효순애견미용전문샵',
	latlng : '인천광역시 구월로 364'
}, {
	h_name : '은영민애견미용샾',
	latlng : '인천광역시 만수3동 862'
} ];

// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
let bounds = new kakao.maps.LatLngBounds();

positions.forEach(function(position) {
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(position.latlng,function(result, status) {

		// 정상적으로 검색이 완료됐으면
		if (status === kakao.maps.services.Status.OK) {

		let coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		let imageSrc = '../images/zoo.png', // 마커이미지의 주소입니다    
	    imageSize = new kakao.maps.Size(55, 55), // 마커이미지의 크기입니다
	    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
	      
		 // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
	    let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
		
		// 결과값으로 받은 위치를 마커로 표시합니다
		let marker = new kakao.maps.Marker(
		{
			map : map,
			position : coords,
			image: markerImage
		});
		//console.log(marker);

		marker.setMap(map); //추가한 코드
		
		// 생성된 마커를 배열에 추가합니다
	    markers.push(marker);

		
		// LatLngBounds 객체에 좌표를 추가합니다
		bounds.extend(coords); //추가한 코드, 현재 코드에서 좌표정보는 point[i]가 아닌 coords이다.

		// 인포윈도우로 장소에 대한 설명을 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
		content : '<div style="width:150px;text-align:center;padding:6px 0;font-family: AppleSDGothicNeoM;">'
				+ position.h_name + '</div>'
		});
		infowindow.open(map, marker);
		infowindows.push(infowindow);
		
		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		setBounds(); //추가한 코드
		
		//markers.push(marker);
		
		}
	});
		  
});

function setBounds() { //추가한 함수
	// LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
	// 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
	map.setBounds(bounds);	
}

// 지도에 마커 표시
function setMarkers(map) {
    for(var i=0; i<markers.length; i++) {
    	markers[i].setMap(map);
    }            
}

// 지도에서 마커 숨기기
function hideAllMarkers() {
	setMarkers(null);
	markers = [];
}


$(document).ready(function() {
		
			// 검색 버튼 눌렀을 때
			$('#searchbtn').click(function() {
				let input_address = $('#input_address').val().trim();
				if (input_address.length < 2) {
					alert("두글자이상 입력해주세요.");
				} else {
					
					markers.forEach(function (marker) { marker.setMap(null); });
				    markers.length = 0; // 마커 배열 초기화
				    
				    infowindows.forEach(function (infowindow) { infowindow.setMap(null); });
				    infowindows.length = 0; // 오버레이 배열 초기화

				    
					// 검색후 리스트출력 + 페이징처리
					HospitalSearchAjax(1, input_address);
					
					// 검색후 마커찍기
					//hideAllMarkers();
					HospitalAllAjax(input_address);
				
				}
			});
			
			
		});

		
		// 리스트 + 페이징 가져오는 함수 만들기
		function HospitalSearchAjax(page, input_address) {
			$.ajax({
				url : 'SearchListAjax.do',
				type : 'get',
				dataType : 'json',
				data : {
					'cpage' : page,
					'input_address' : input_address
				},
				success : function(jsonData) {
					
					if(jsonData[0].addressLists.length==0 ){
						alert("해당지역의 찾으려는 병원이 없거나 잘못 입력하였습니다.");
					} else {
					//console.log("성공");
					//console.log(jsonData[0].addressLists[0].h_name);
					let cpage = jsonData[0].cpage;
					let recordPerPage = jsonData[0].recordPerPage;
					let blockPerPage = jsonData[0].blockPerPage;
					let totalPage = jsonData[0].totalPage;
					let totalRecord = jsonData[0].totalRecord;
					let startBlock = jsonData[0].startBlock;
					let endBlock = jsonData[0].endBlock;
						
					$(insert).html('');
					
					let ajaxHtml = '';
					
					for(let i=0; i<jsonData[0].addressLists.length; i++){	
						ajaxHtml += `
							<tr>
								<th scope="row" style="width: 15%;">병원이름</th>
								<td style="width:35%; font-family: 'AppleSDGothicNeoB';">\${jsonData[0].addressLists[i].h_name}</td>
								<th scope="row" style="width: 15%;">전화번호</th>
								<td style="width: 35%;">\${jsonData[0].addressLists[i].h_phone}</td>
							</tr>
							<tr>
								<th scope="row">지번주소</th>
								<td colspan="3">\${jsonData[0].addressLists[i].h_old_address}</td>
							</tr>
							<tr>
								<th scope="row">도로명주소</th>
								<td colspan="3">\${jsonData[0].addressLists[i].h_new_address}</td>
							</tr>
							<tr><td colspan="4"></td></tr>
							`;
						}
					
						$(insert).append(ajaxHtml);
						
						$('#insertPagging').html('');
						let page = '';
						
						page += `
						<div style="display: inline-block;" id="pageGroup">
						<ul class="pagination" id="pagging">`;
						
						if( cpage == 1 ){
							page += `<li id="pageLi" class="page-item disabled"><a class="page-link"> <span aria-hidden="true">&laquo;</span>
							</a></li>`;
						} else {
							page += `<li id="pageLi" class="page-item"><a class="goBackPage page-link"> <span aria-hidden="true">&laquo;</span>
							</a></li>`;
						}
						
						for( let i = startBlock ; i <= endBlock ; i ++ ){
							if( cpage == i ){
								page += '	<li id="pageLi" class="page-item disabled"><a class="page-link">' + i + '</a></li>';
							} else {
								page += '	<li id="pageLi" class="page-item"><a class="goPage page-link" data-page="' + i +  '">' + i + '</a></li>';
							}
						}
						
						if( cpage == totalPage ){
							page += `<li id="pageLi" class="page-item disabled"><a class="page-link"><span aria-hidden="true">&raquo;</span></a></li>`;
						} else {
							page += `<li id="pageLi" class="page-item"><a class="goNextPage page-link"><span aria-hidden="true">&raquo;</span></a></li>`;
						}
						
						page += `
								</ul>
							</div>`;
							
							$('#insertPagging').append(page);
							
							$(".goBackPage").click(function(){
						      	page = (cpage - 1);
						      	HospitalSearchAjax(page, input_address);
					        });
							
							$(".goPage").click(function(){
								page = $(this).attr("data-page");
								HospitalSearchAjax(page, input_address);
							});
							$(".goNextPage").click(function(){
						      	page = (cpage + 1);
						      	HospitalSearchAjax(page, input_address);
					        });
							}
				},
				error : function(e) {
					console.log(e.status);
				}
			});
		}
		
		// 검색 리스트를 맵에 마커로 찍는 함수
		function HospitalAllAjax(input_address) {
			//let markers = [];
			//marker.setMap(null);
			//setMarkers(null);
			//markers = [];
			
			
			// 주소입력한 데이터들만 출력
			$.ajax({
				url : 'SearchAllAjax.do',
				type : 'get',
				dataType : 'json',
				data : {
					'input_address' : input_address
				},
				success : function(jsonData) {
					
						//hideAllMarkers();
						
						$.each(jsonData, function(index, value){
							geocoder.addressSearch(jsonData[index].h_new_address, function(result, status) {
								// 정상적으로 검색이 완료됐으면 
								if (status === kakao.maps.services.Status.OK) {

									let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
									
									let imageSrc = '../images/hospital.png', // 마커이미지의 주소입니다    
								    imageSize = new kakao.maps.Size(55, 55), // 마커이미지의 크기입니다
								    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
								      
									 // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
								    let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
									
									// 결과값으로 받은 위치를 마커로 표시합니다
									let marker = new kakao.maps.Marker(
									{
										map : map,
										position : coords,
										image: markerImage
									});
									
									// 지도에 마커생성;
									marker.setMap(map); //추가한 코드
									markers.push(marker);
									
									// 인포윈도우로 장소에 대한 설명을 표시합니다
									var infowindow = new kakao.maps.InfoWindow({
									content : '<div style="width:150px;text-align:center;padding:6px 0; border-radius: 5px;font-family: AppleSDGothicNeoM; ">'
											+ jsonData[index].h_name + '</div>'
									});
									infowindow.open(map, marker);

									infowindows.push(infowindow);

									// LatLngBounds 객체에 좌표를 추가합니다
									bounds.extend(coords); //추가한 코드, 현재 코드에서 좌표정보는 point[i]가 아닌 coords이다.
									setBounds();	
								}
									
								}) 
							});
				},
				error : function(e) {
					console.log(e.status);
				}
			});
			
		} //
</script>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>