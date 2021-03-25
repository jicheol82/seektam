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

	// 평점
	var point;

	if(navigator.geolocation){
	    navigator.geolocation.getCurrentPosition(function(position) {
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        var locPosition = new kakao.maps.LatLng(lat, lon);
			map.setCenter(locPosition);
			ps.setMap(map);
		    // 카테고리로 은행을 검색합니다
			ps.categorySearch('fd6', placesSearchCB, {useMapBounds:true}); 
	    });
	}
	    
	// 키워드 검색 완료 시 호출되는 콜백함수 입니다
	function placesSearchCB (data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {
			console.log(data);
			// 식당 data를 서버로 보내 평점 data 가져와 'data'에 추가하기
			/*
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
					// db에서 평점 정보 가져와 인포윈도우에 뿌려줌
					for (var i=0; i<data.length; i++) {
			            displayMarker(data[i]);   
	      			}
					// 화면 생성
					// 상홍/전번/주소/평점 -> 클릭하면 평가글 불러오기
				}
			});*/
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
	function callComment(resId){
		console.log(resId);
		var jsonData = new Object();
		jsonData.id = resId;
		// 사용자 id와 식당 id 필요
		$.ajax({
			url : "/seektam/restaurant/getComment",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(jsonData),
			dataType : "json",
			success : function(result){
				//화면에 뿌려주기
			}
		});
	}