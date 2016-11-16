<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
	<base href="<%=basePath%>">
	
	<title>文件上传</title>
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
</head>

<body>

	<form action="FileUtilsTest" method="post" enctype="multipart/form-data">
		<div>
			<input type="file"  id="fileUpload1" name="fileUpload1"  style="display: none; " onchange="fileName1.value=this.value"/>
			<input id="fileName1" readonly style="width: 200px; height: 30px; border: 1px solid #666; border-radius:3px" placeholder="上传的文件"/>
			<input type="button" value="浏览文件..." style="width: 100px; height: 32px; background: green; color: #fff; border: 0; border-radius: 3px" onclick="fileUpload1.click();"/>
			</br>
			<input type="file"  id="fileUpload" name="fileUpload"  style="display: none; " onchange="fileName.value=this.value"/>
			<input id="fileName" readonly style="width: 200px; height: 30px; border: 1px solid #666; border-radius:3px" placeholder="请选择要上传的文件"/>
			<input type="button" value="浏览文件..." style="width: 100px; height: 32px; background: green; color: #fff; border: 0; border-radius: 3px" onclick="fileUpload.click();"/>
		</div>
		<div>
			<input type="submit" value="开始上传" style="margin: 30px 0;width: 200px; height: 30px; background: green; color: #fff; border: 0; border-radius: 33px"/>
		</div>
	</form>

</body>
</html>
