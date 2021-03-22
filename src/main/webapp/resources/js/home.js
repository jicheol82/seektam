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
		    // 카테고리로 은행을 검색합니다
			ps.categorySearch('fd6', placesSearchCB, {useMapBounds:true}); 
	    });
	}
	    
	// 키워드 검색 완료 시 호출되는 콜백함수 입니다
	function placesSearchCB (data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {
			var resIdList = new Array();
	        for (var i=0; i<data.length; i++) {
				//ajax로 db에서 평점 가져오기 
				resIdList.push(data[i].id);
	            displayMarker(data[i]);   
	        }
/* 추후 구현할 것
			$.ajax({
				url : "/seektam/restaurant/getReputation",
				type : "get",
				data : resIdList,
				dataType : "json",
				success : function(result){
					console.log(result);
				}
			});
*/
	    }
	}
	
	// 지도에 마커를 표시하는 함수입니다
	function displayMarker(place) {
	    // 마커를 생성하고 지도에 표시합니다
	    var marker = new kakao.maps.Marker({
	        map: map,
	        position: new kakao.maps.LatLng(place.y, place.x) 
	    });
	
	    // 마커에 클릭이벤트를 등록합니다
	    kakao.maps.event.addListener(marker, 'click', function() {
	        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
	        infowindow.open(map, marker);
	    });
	}
	
	
	
	
	//위 검색 결과로 테이블 만들기
	