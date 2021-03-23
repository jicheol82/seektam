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
	        for (var i=0; i<data.length; i++) {
	            displayMarker(data[i]);   
	        }
	    }
		// ajax가 나중에 실행되고 displayMarker가 먼저 실행되기 때문에
		// db에서 받아온 point를 인포윈도우에 뿌릴수가 없다
		// 
		$.ajax({
			url : "/seektam/restaurant/getPoint",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(result){
				console.log(result.length);
				// db에서 평점 정보 가져와 인포윈도우에 뿌려줄것!(미작성)
				
				for(var j=0;j<result.length;j++){
					console.log("result : ", result[j].id);
					for(var i=0;i<data.length;i++){
						if(data[i].id==result[j].id){
							data[i].point=result[j].point;
						}	
					}
				}
			}
		});
		/*
		$.ajax({
			url : "/seektam/restaurant/getComment",
			type : "POST",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : "json",
			success : function(result){
				// db에서 평점 정보 가져와 인포윈도우에 뿌려줄것!(미작성)
				
			}
		});
		*/
	}
	
	// 지도에 마커를 표시하는 함수입니다
	function displayMarker(place) {
	    // 마커를 생성하고 지도에 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: new kakao.maps.LatLng(place.y, place.x) 
	    });
		console.log(place);
	    // 마커에 클릭이벤트를 등록합니다
	    kakao.maps.event.addListener(marker, 'click', function() {
	        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + ' ' + place.point +'점' + '</div>');
	        infowindow.open(map, marker);
	    });
	}
	
	
	
	
	//위 검색 결과로 테이블 만들기
	