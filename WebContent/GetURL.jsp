<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="jwplayer.js"></script>
</head>
<body>
        <div id="myElement">주소URL파라미터 가져오기</div>
<script>
getParam : function(pmParamName) {
	pmParamName = pmParamName.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	var regexS = "[\\?&]"+pmParamName+"=([^&#]*)";
	var regex = new RegExp(regexS);
	var results = regex.exec(window.location.href);


	if( results == null )
		return "";
	else
		return results[1];
}
</script>
</body>
</html>