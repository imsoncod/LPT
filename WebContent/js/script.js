/*facebook*/
function facebook(){
	window.open('http://www.facebook.com/sharer/sharer.php?u=http://lolpt.site');
}

/*kakao*/
function kakao(){
	 Kakao.init("7c9dd3736a9b7447af27693340fc2398");      // 사용할 앱의 JavaScript 키를 설정
     Kakao.Link.sendDefault({
           objectType:"feed"
         , content : {
               title:"LPT : 롤 포지션 테스트"   // 콘텐츠의 타이틀
             , description:"나에게 맞는 롤 포지션 찾기!"   // 콘텐츠 상세설명
             , imageUrl:"http://lolpt.site/LPT/img/share.png"   // 썸네일 이미지
             , link : {
                   mobileWebUrl:"http://lolpt.site"   // 모바일 카카오톡에서 사용하는 웹 링크 URL
                 , webUrl:"http://lolpt.site" // PC버전 카카오톡에서 사용하는 웹 링크 URL
             }
         }
         , social : {
               likeCount:0      // LIKE 개수
             , commentCount:0    // 댓글 개수
             , sharedCount:0     // 공유 회수
         }
         , buttons : [
             {
                   title:"나도 해볼까?"    // 버튼 제목
                 , link : {
                     mobileWebUrl:"http://lolpt.site"   // 모바일 카카오톡에서 사용하는 웹 링크 URL
                   , webUrl:"http://lolpt.site" // PC버전 카카오톡에서 사용하는 웹 링크 URL
                 }
             }
         ]
     });
}

/*naver*/
function naver(){
	window.open('http://share.naver.com/web/shareView.nhn?url='+encodeURIComponent('http://lolpt.site')+'&title='+encodeURIComponent('롤 포지션 테스트'));
}


/*Ad*/
function Ad(){
	(function(cl,i,c,k,m,o,n){m=cl.location.protocol+c;o=cl.referrer;m+='&mon_rf='+encodeURIComponent(o);
	n='<'+i+' type="text/javascript" src="'+m+'"></'+i+'>';cl.writeln(n);
	})(document,'script','//tab2.clickmon.co.kr/pop/wp_ad_300_up_js.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207');
	
	if (/android|webos|iphone|ipad|ipod|blackberry|windows phone/i.test(navigator.userAgent))
	{(function(){document.writeln('<iframe width="320" height="100" allowtransparency="true" src="https://mtab.clickmon.co.kr/pop/wp_m_320_100.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207&mon_rf=REFERRER_URL" frameborder="0" scrolling="no"></iframe>');})();}
	else{(function(){document.writeln('<iframe width="728" height="90" allowtransparency="true" src="https://tab2.clickmon.co.kr/pop/wp_ad_728.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207&mon_rf=REFERRER_URL" frameborder="0" scrolling="no"></iframe>');})();}
}

function Ad2(){
	(function(cl,i,c,k,m,o,n){m=cl.location.protocol+c;o=cl.referrer;m+='&mon_rf='+encodeURIComponent(o);
	n='<'+i+' type="text/javascript" src="'+m+'"></'+i+'>';cl.writeln(n);
	})(document,'script','//mtab.clickmon.co.kr/pop/wp_m_pop.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207&iveiw=no');
	
	(function(cl,i,c,k,m,o,n){m=cl.location.protocol+c;o=cl.referrer;m+='&mon_rf='+encodeURIComponent(o);
	n='<'+i+' type="text/javascript" src="'+m+'"></'+i+'>';cl.writeln(n);
	})(document,'script','//tab2.clickmon.co.kr/pop/wp_ad_300_up_js.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207');
	
	if (/android|webos|iphone|ipad|ipod|blackberry|windows phone/i.test(navigator.userAgent))
	{(function(){document.writeln('<iframe width="320" height="100" allowtransparency="true" src="https://mtab.clickmon.co.kr/pop/wp_m_320_100.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207&mon_rf=REFERRER_URL" frameborder="0" scrolling="no"></iframe>');})();}
	else{(function(){document.writeln('<iframe width="728" height="90" allowtransparency="true" src="https://tab2.clickmon.co.kr/pop/wp_ad_728.php?PopAd=CM_M_1003067%7C%5E%7CCM_A_1070653%7C%5E%7CAdver_M_1046207&mon_rf=REFERRER_URL" frameborder="0" scrolling="no"></iframe>');})();}
}

/*나이 자동 생성 */
function age_create() {
	var $age_cb = $('#age');
		for (var i = 1; i <= 120; i++) {
			var $o = $('<option>').html(i.toString());
			$age_cb.append($o);
		}
}

/*공지 닫기*/
function cancel(){
	document.getElementById("notice_box").style.display = 'none';
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
/*도메인 넣을것*/
function mainpage() {
	location.href='index.html';
}

/*그래프 스크립트*/
function graph(a, b, c, d, e) {
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['LPT', 'Positon'],
        ['미드', c],
        ['원딜', d],
        ['정글', b],
        ['서포터', e],
        ['탑', a]
      ]);
      
    var options = {
    	chartArea:{
    		    left:10,
    		    right:10,
    		    bottom:10,
    		    top:10
    	},
    	legend: 'none',
    	pieSliceText: 'label',
    	pieStartAngle: 100,
    };

      var chart = new google.visualization.PieChart(document.getElementById('graph'));
      chart.draw(data, options);
    }
}