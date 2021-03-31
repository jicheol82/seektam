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
// 화면에 표시된 식당정보
var resData;
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
	resData = data;
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
				var tags="";
				for (var i=0; i<data.length; i++) {
					// db에서 평점 정보 가져와 인포윈도우에 뿌려줌
		            displayMarker(data[i]);
					// 지도에 표시된 식당정보 테이블 생성
					tags+=('<tr id='+data[i].id+'>');
					tags+='<td><a href=# onclick="getComments('+ data[i].id +')">' + data[i].place_name + '</a></td>';
					tags+='<td>' + (data[i].point!=null ? data[i].point:'평가없음') + '</td>';
					tags+='<td>' + data[i].category_name + '</td>';
					tags+='<td>' + data[i].phone + '</td>';
					tags+='<td>' + data[i].road_address_name + '</td>';
					tags+='</tr>';
      			}
				// 생성된 테이블을 home.jsp의 resTbBody에 삽입
				$("#resTbBody").append(tags);
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

// #resTbBody에 생성된 식당명을 클릭하면 실행 (52행의 a태그)
function getComments(resId){
	// 이전에 열려 있는 행 삭제
	$(".extendedrow").remove();
	// 식당평가를 할 수 있는 textarea생성
	var tags="";
	tags+='<tr class="extendedrow writeform">';
	tags+='<td colspan="5"><textarea class="form-control col-sm-5" id="comment"></textarea><br><br><br>';
	tags+='<input type="hidden" id="resId" value="'+resId+'">';
	tags+='맛 : <input type="text" id="taste" placeholder="1-5"/>'
	tags+='가격 : <input type="text" id="price" placeholder="1-5"/>'
	tags+='친철 : <input type="text" id="kindness" placeholder="1-5"/>'
	tags+='위생 : <input type="text" id="hygiene" placeholder="1-5"/>'
	tags+='전체공개<input type="radio" name="open" id="open" value="0" checked="checked">';
	tags+='그룹공개<input type="radio" name="open" id="open" value="1">';
	tags+='<input type="button" class="btn btn-primary pull-right" value="글쓰기" id="writecomment"/></td>';
	tags+='</tr>';
	$('#'+resId).after(tags); //ajax가 가장 나중에 실행되므로
	// 식당평가글 불러오기
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
			// 글 삽입 행을 삽입한다
			var tags="";
			console.log(result.comment.length);
			for (var i=0; i<result.comment.length; i++) {
				var agreerate = result.comment[i].agree/result.comment[i].num_of_vote;
				var disagreerate = result.comment[i].disagree/result.comment[i].num_of_vote;
				tags+='<tr class="extendedrow">';
				tags+='<td>'+result.comment[i].writer+'</td>'
				tags+='<td colspan="3"><textarea class="form-control col-sm-5" disabled>'+result.comment[i].comments+'</textarea>';
				tags+='</td>' ;
				tags+='<td>' ;
				tags+='인정 : '+result.comment[i].agree+' 불인정 : '+result.comment[i].disagree;
				tags+='</td>';
				tags+='</tr>';
  			}
			$('#'+resId).after(tags); //ajax가 가장 나중에 실행되므로
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
			$(".writeform").remove();
		}
	});
}

//글쓰기 버튼 누르면 글 등록하기
//객체로 보낼때는 application/x-www-form-urlencoded; charset=utf-8
$(document).on('click', '#writecomment',function(){
	var data = new Object();
	data.res_num = $("#resId").val();
	data.comments = $("#comment").val();
	data.open = $("#open").val();
	data.taste =$("#taste").val();
	data.price =$("#price").val();
	data.kindness =$("#kindness").val();
	data.hygiene =$("#hygiene").val();
	//뭐였지?
	for(var i=0;i<resData.length;i++){
		if(data.res_num==resData[i].id){
			$.ajax({
				url : "/seektam/restaurant/addrestaurant",
				type : "POST",
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				data : resData[i],
				dataType : "json",
				success : function(){
					//break;
				}
			});
		}
	}
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
});
