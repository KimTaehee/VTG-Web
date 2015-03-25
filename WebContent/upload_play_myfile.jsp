<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="jwplayer.js"></script>
</head>
<body>
    <div><!-- 동영상 영역 -->
        <div id="myElement">동영상이 재생되는 부분</div>
        <script type="text/javascript">
            jwplayer("myElement").setup({  //옵션에서 스트리밍 주소 받아오는 거 있는지 알아보라
                flashplayer: "play.swf",
                file: "sec01.mp4",  // 업로드한 파일
                image: "bg1234.jpg",
                title: "EC",
                description: "olleh",
                controlbar: "bottom",
                width: "1280",
                height: "720",
            });
        </script>
    </div><!-- //동영상 영역 -->
</body>
</html>