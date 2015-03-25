<%@page import="com.videothegathering.vo.PlayitemVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.videogathering.dao.Initialize"%>
<%@page import="com.videogathering.dao.VtgDAO"%>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="http://cfs.tistory.com/custom/blog/167/1671933/skin/images/jwplayer.js"></script>
<script>
	jwplayer.key="UJxp6f8mbFLdWdIuTOOGqV8LgwBkjnJZpXi9uA==";</script>
<title>Video The Gathering</title>

<%
	VtgDAO dao = new VtgDAO();

Connection conn = Initialize.getConnection();

dao.setConnection(conn);
%>

</head>
<body background="KINGSMAN_SECRET_SERVICE_action_adventure_comedy_spy_crime_kingsman_secret_service_weapon_gun_1920x1376.jpg">
	<font color="#FFFF66"> <br> <font size=50, face=a옛날목욕탕B>
			<center>Video The Gathering</center>
	</font>

		<form action="URLHandlingServlet">
			<br> <br>
<center>
<font face=a옛날목욕탕B>
			<div>
				<label for="URL">URL</label> <input type="text" id="URL" name="user_URL" size="100"
					placeholder="Enter the URL, you want to get video from. Vimeo, Daum, Youtube would be possible.">
			</div>
			<br>
			<div>
				<label for="title">Title</label> <input type="text" id="title"
					name="user_title" size="100"
					placeholder="Enter Title in English."/> <input type="hidden" name="ie"
					value="utf8">
			</div>
				</font>
			
<br> <br>


<input  TYPE="IMAGE" src="submit.png" name="Submit" value="Submit"  align="absmiddle" width="160" height="35">
			<!-- 
			<div class="button">
				<button type="submit">Add Playlist!</button>
			</div>
			 -->
			 
			<br> <br> <br>
			
			</center>
		</form>

		<center>
			<div id='container'></div>
		</center> <script type="text/javascript">

  	jwplayer("container").setup({
    playlist: [
    
<%ArrayList<PlayitemVO> playitemArrayList = (ArrayList)dao.selectList();%>
<%for(PlayitemVO e: playitemArrayList) {%>
{ file: "<%=e.getRealMP4()%>",
title: "<%=e.getTitle()%>"
} 
<%if(playitemArrayList.indexOf(e) != playitemArrayList.size()-1) {%>
,
<%}%>
<%}%> 
    ],

    height: 720,
    width: 1280,
    autostart: true,

    listbar: {
    position: 'right',
    size: 260,
    }
  	
  });
</script>
	</font>
</body>
</html>

