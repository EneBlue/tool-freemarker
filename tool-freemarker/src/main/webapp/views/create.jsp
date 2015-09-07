<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.11.2.min.js"></script>

<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js">
	
</script>


<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<style type="text/css">
div {
	width: 100%;
}
</style>
<title>创建模板</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/simple">测试模板</a>
<a href="${pageContext.request.contextPath}/create">创建模板</a>
<br>
	<div class="container">

		<form action="${pageContext.request.contextPath}/create_marker" method="post" class="from">
			<fieldset>
				<div id="legend" class="">
					<legend class="">表单名</legend>
				</div>
				<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">模板名称</label>
					<div class="controls">
						<input type="text" name="title" placeholder="模板英文名称" class="input-xlarge">
					</div>
				</div>
				<div class="control-group">

					<!-- Textarea -->
					<label class="control-label">模板类容</label>
					<div class="controls">
						<div class="textarea">
							<textarea id="editor" name="marker" style="width: 800px; height: 600px;"></textarea>
						</div>
					</div>
				</div>
				<div class="control-group">
					<!-- Button -->
					<div class="controls">
						<button class="btn btn-success">提交</button>
					</div>
				</div>
			</fieldset>
		</form>

	</div>


	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');

		/*  ue.ready(function() {
		     ue.execCommand('${pageContext.request.contextPath}/upload', function(editor) {
		             return {
		                 'key': 'value'
		             };
		     });
		 }); */
	</script>
</body>
</html>