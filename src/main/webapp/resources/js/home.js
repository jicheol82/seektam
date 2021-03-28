// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  
// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(null); 

if(navigator.geolocation){
    navigator.geolocation.getCurrentPosition(function(position) {
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        var locPosition = new kakao.maps.LatLng(lat, lon);
		map.setCenter(locPosition);
		ps.setMap(map);
	    // 카테고리로 음식점을 검색합니다
		ps.categorySearch('fd6', placesSearchCB, {useMapBounds:true}); 
    });
}
    
// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {
		// 식당 data를 서버로 보내 평점 data 가져와 'data'에 추가하기
		$.ajax({
			url : "/seektam/restaurant/getPoint",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(result){
				// db에 평점이 있는 식당'data'에 평점정보 추가
				for(var j=0;j<result.length;j++){
					for(var i=0;i<data.length;i++){
						if(data[i].id==result[j].id){
							data[i].point=result[j].point;
						}	
					}
				}
				var tags=[];
				// db에서 평점 정보 가져와 인포윈도우에 뿌려줌
				for (var i=0; i<data.length; i++) {
		            displayMarker(data[i]);
					tags.push('<tr id="'+data[i].id+'">');
					tags.push('<td><a href=# onclick="getComments('+ data[i].id +')">' + data[i].place_name + '</a></td>');
					tags.push('<td>' + (data[i].point!=null ? data[i].point:'평가없음') + '</td>');
					tags.push('<td>' + data[i].category_name + '</td>');
					tags.push('<td>' + data[i].phone + '</td>');
					tags.push('<td>' + data[i].road_address_name + '</td>');
					tags.push('</tr>');
      			}
				// 화면 생성
				$("#resTbBody").append(tags);
				// 상홍/전번/주소/평점 -> 클릭하면 평가글 불러오기
			}
		});
    }
}

// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });
	var point = '';
    if(place.point!=null){
		point=place.point+'점';
	}
	// 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + ' ' + point + '</div>');
        infowindow.open(map, marker);
    });
}

// 식당 id로 식당평가 data를 가져와 화면에 생성한다
function getComments(resId){
	// 사용자 id와 식당 id 필요
	var jsonData = new Object();
	jsonData.id = resId;
	$.ajax({
		url : "/seektam/restaurant/getcomments",
		type : "POST",
		contentType : "application/json",
		data : JSON.stringify(jsonData),
		dataType : "json",
		success : function(result){
			console.log(result);
			console.log(result.comment);
			console.log(result.comment.res_num);
			var tags=[];
			// 글 삽입 행을 삽입한다
			/*
			for (var i=0; i<result.comment.length; i++) {
					tags.push('<tr id="'+data[i].id+'">');
					tags.push('<td><a href=# onclick="getComments('+ data[i].id +')">' + data[i].place_name + '</a></td>');
					tags.push('<td>' + (data[i].point!=null ? data[i].point:'평가없음') + '</td>');
					tags.push('<td>' + data[i].category_name + '</td>');
					tags.push('<td>' + data[i].phone + '</td>');
					tags.push('<td>' + data[i].road_address_name + '</td>');
					tags.push('</tr>');
      			}
				// 화면 생성
				$("#resTbBody").append(tags);
			// 선택된 식당의 평가글이 화면에 보여진다
			tags.push()
			*/
		}
	});
}

// 인정/불인정 처리
function agreeOrNot(num, myDecide){
	var jsonData = new Object();
	jsonData.res_id = '1118826861';
	jsonData.com_num = '14';
	jsonData.decision = 'agree';
	$.ajax({
		url : "/seektam/restaurant/agree",
		type : "POST",
		contentType : "application/json",
		data : JSON.stringify(jsonData),
		dataType : "json",
		success : function(result){
			// 투표결과가 화면에 표시된다
		}
	});
}

//식당평가 글쓰기(res_id와 글내용 포함)
function writeComment(comment){
	// 테스트용 코드
	var commentDTO = new Object();
	commentDTO.res_num = '1118826861';
	commentDTO.comments = '얀녕 맛있는 집이었어요';
	commentDTO.img = null;
	commentDTO.open = '0'; //0:전체 1:그룹
	console.log(commentDTO);
	data = {
		num : 12,
		res_num : 1118826861,
		writer : "admin",
		comments : "맛있다요",
		img : null,
		num_of_vote : 3, 
		open : 0,
		reg : "2021-03-27 15:55:20",
		taste:3,
		price:1,
		kindness:3,
		hygiene:5
	};
	console.log(data);
	// 테스트용 코드
	
	
	$.ajax({
		url : "/seektam/restaurant/writeComment",
		type : "POST",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		data : data,
		dataType : "json",
		success : function(result){
			// 새글이 리스트에 표시된다
		}
	});
}