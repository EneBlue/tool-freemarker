<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/simple">测试模板</a>
<a href="${pageContext.request.contextPath}/create">创建模板</a>
<br>

<select id="markerName">

<c:forEach var="name" items="${names}">
<option>${name }</option>
</c:forEach>

</select>
<input id="name" type="text" /> <button onclick="createMarker();">创建</button>
<button onclick="myPrint(document.getElementById('marker_content'));">打印</button>
<div id="marker_content"></div>

${marker }

<script type="text/javascript">
function createMarker(){
  var value = $("#name").val();
  var marker = $("#markerName").val();
  
  $.ajax({
	  url: "${pageContext.request.contextPath}/simple/name",
	  data: {name: value, marker: marker},
	  success: function (data){
		  $("#marker_content").prepend(data);
	  }
  });
}

function myPrint(obj){
    var newWindow=window.open("打印窗口","_blank");//打印窗口要换成页面的url
    var docStr = obj.innerHTML;
    newWindow.document.write(docStr);
    newWindow.document.close();
    newWindow.print();
    newWindow.close();
}
</script>
</body>
</html>