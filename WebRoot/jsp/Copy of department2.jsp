<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="./css/main.css"/>
<link type="text/css" rel="stylesheet" href="./js/zTree/zTreeStyle.css"/>
</head>
<body>
	<div>
		<ul id="tree" class="tree" style="overflow:auto;"></ul>
	</div>
	
	<script type="text/javascript" src="./js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="./js/zTree/jquery.ztree-2.6.min.js"></script>
	
	<script type="text/javascript">
		$().ready(function(){
			var setting = {
			    showLine: true,
			    checkable: true
			};
		
			var nodes = [
							{id:1, pId:0, name: "公司"},
							{id:11, pId:1, name: "移动应用组"},
							{id:13, pId:11, name: "移动应用组子部门1"},
							{id:12, pId:1, name: "人事部"},
							{id:14, pId:12, name: "人事部子部门1"},
							{id:15, pId:12, name: "人事部子部门2"}
						];
			var zn = '${zTreeNodes}';
			var zTreeNodes = eval(zn);
			var zTree = $("#tree").zTree(setting, nodes);
		});
	</script>
</body>
</html>