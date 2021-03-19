function check(){
	var inputs = document.inputForm;
	// 필수기입란 기입했는지 
	if(!inputs.id.value) {
		alert("아이디를 입력하세요");
		return false;
	}
	if(!inputs.pw.value) {
		alert("비밀번호를 입력하세요");
		return false;
	}
	if(!inputs.pwCh.value) {
		alert("비밀번호 확인란을 입력하세요");
		return false;
	}
	if(!inputs.name.value) {
		alert("이름을 입력하세요");
		return false;
	}
	// pw, pwCh 동일한지 
	if(inputs.pw.value != inputs.pwCh.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	}
}
// id중복 확인 함수
function openConfirmId(inputForm){ // <- this.form 
	console.log(inputForm.id.value); 
	if(inputForm.id.value == ""){ 
		alert("아이디를 입력하세요.");
		return; 
	}
	var url = "/spring/member/confirmId.do?id="+inputForm.id.value;
	open(url, "confirm", "toolbars=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, width=300, height=300");
}
// jquery 이용하여 id 삭제
$(document).ready(function(){
	$("#id").change(function(){
		var idval = $("#id").val();
		$.ajax({
			type : "post",
			url : "/spring/member/ajaxIdAvail.do",
			dataType : "text",
			data : {id : idval},
			success : function(result){
				console.log(result);
				$("#idChRes").val(result);
			}
		});
	})
})