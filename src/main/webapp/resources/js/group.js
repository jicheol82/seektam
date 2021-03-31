//활동지역/그룹명으로 검색하고 결과 화면에 생성하기
$(document).on('click', '#searchExe',function(){
	var data = new Object();
	data.search =$("#search").val();
	data.keyword =$("#keyword").val();
	
	$.ajax({
		url : "/seektam/group/search",
		type : "POST",
		contentType : "application/json",
		data :  JSON.stringify(data),
		dataType : "json",
		success : function(result){
			var tags = "";
			for(var i=0; i<result.length;i++){
				tags+='<tr>';
				tags+='<td>'+result[i].name+'</td>';
				tags+='<td>'+result[i].area+'</td>';
				tags+='<td>'+result[i].group_leader+'</td>';
				tags+='<td>'+result[i].num_of_mem+'</td>';
				tags+='<td>'+result[i].activity_score+'</td>';
				tags+='<td>'+result[i].open+'</td>';
				tags+='<td><input type="button" id="joinRq" value="가입신청"></td>';
			}
			$('#searchResult').append(tags);
		}
	});
});

//내 그룹 생성하기 1-생성하기 버튼 누르면 입력창 띄우기
$(document).on('click', '#makeMyGr', function(){
	$.ajax({
		//servle-context.xml에 있는 설정(view-controller)로 바로 페이지로 이동
		url : "/seektam/makeMyGr",
		success : function(result){
			$('#mine').html(result);
		}
	});
});

//내 그룹 생성하기 2- 위에서 만들어진 버튼(#makeMyGrExe)으로 만들기 실행시
$(document).on('click', '#makeMyGrExe', function(){
	var data = new Object();
	data.name = $('#grName').val();
	data.area = $('#grArea').val();
	data.open = $('#grOpen').val();
	// 생성정보 서버로 보내기
	$.ajax({
		url : "/seektam/group/makemygr",
		type : "POST",
		contentType :"application/json",
		data : JSON.stringify(data),
		dataType : "json",
		success : function(result){
			// 생성 성공하면 group.jsp화면 다시 부르기
			$.ajax({
				url : "/seektam/group",
				success : function(result){
					location="/seektam/group";
				}
			});
			
		}
	});
});