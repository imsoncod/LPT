/*나이 자동 생성 */
function age_create() {
	var $age_cb = $('#age');
		for (var i = 1; i <= 120; i++) {
			var $o = $('<option>').html(i.toString());
			$age_cb.append($o);
		}
}

/*이름 및 나이 체크 */
function check() {
	var nickname = document.getElementById("nickname").value;
	var age = document.getElementById("age").value;
	if(nickname == ''){
		alert('닉네임을 입력해주세요');
	}
	else if(age == '나이'){
		alert('나이를 선택해주세요');
	}else{
		document.getElementById("index").submit();
	}
}

/*다음 페이지로 넘어갈지 체크*/
function nextpage() {
	var go = true; //submit여부를 결정하는 변수
	for(var i = 1; i <= 10; i++) {
		var check = document.getElementsByName('q'+i);
		var temp = false;
		for(var j = 0; j < check.length; j++){
			if(check[j].checked == true){
				temp = true; //문항 응답여부를 결정하는 변수
			}
		}
		if(temp == false){ //문항에 응답하지 않았을 경우
			alert(i+'번째 문항에 응답해주세요');
			go = false;
			break;
		}
	}
	if(go==true){
		document.getElementById("test1").submit();
	}
}

/*다음 페이지로 넘어갈지 체크*/
function resultpage() {
	var go = true; //submit여부를 결정하는 변수
	for(var i = 11; i <= 20; i++) {
		var check = document.getElementsByName('q'+i);
		var temp = false;
		for(var j = 0; j < check.length; j++){
			if(check[j].checked == true){
				temp = true; //문항 응답여부를 결정하는 변수
			}
		}
		if(temp == false){ //문항에 응답하지 않았을 경우
			alert(i+'번째 문항에 응답해주세요');
			go = false;
			break;
		}
	}
	if(go==true){
		document.getElementById("test2").submit();
	}
}