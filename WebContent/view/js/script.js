function age_create() {
	var $age_cb = $('#age');
		for (var i = 1; i <= 120; i++) {
			var $o = $('<option>').html(i.toString());
			$age_cb.append($o);
		}
}

function check() {
	var nickname = document.getElementById("nickname").value;
	var age = document.getElementById("age").value;
	
	if(nickname == ''){
		alert('닉네임을 입력해주세요');
	}
	else if(age == '나이'){
		alert('나이를 선택해주세요');
	}
}