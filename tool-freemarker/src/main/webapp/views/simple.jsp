<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<input id="name" type="text" /> <button onclick="createMarker();">创建</button>

<div id="marker_content"></div>

${marker }

<script type="text/javascript">
function createMarker(){
  var value = $("#name").val();
  console.log(value);
  $.ajax({
	  url: "${pageContext.request.contextPath}/simple/name",
	  data: {name: value},
	  success: function (data){
		  $("#marker_content").prepend(data);
	  }
  })
}
</script>
</body>
</html>