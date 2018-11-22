<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>导航菜单</title>
		<%@include file="/WEB-INF/jsp/public/header.jsp" %>
		<script language="JavaScript" src="${pageContext.request.contextPath }/script/menu.js"></script>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/menu.css" />
	</head>
<body style="margin: 0">
		<div id="Menu">
		    <ul id="MenuUl">
		    	<s:iterator value="#application.privilegeList">
			        <s:if test="#session.loginUser.hasPermission(priName)">
				        <li class="level1">
				            <div onClick="menuClick(this)" class="level1Style"><img src="style/images/MenuIcon/FUNC2000${priId }.gif" class="Icon" />${priName }</div>
					            <ul style="display: none;" class="MenuLevel2">
					                <s:iterator value="priChildren">
					                	
							                <li class="level2">
							                	<div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" />
		
							                	<a href="${pageContext.request.contextPath }${priUrl}.do" target="right">${priName }</a>
							                	</div>
							                </li>
						              
					                </s:iterator>
					            </ul>
				        </li>
		       		</s:if>
		        </s:iterator>  
		    </ul>
		</div>
</body>
	
	
	
	
	

</html>
