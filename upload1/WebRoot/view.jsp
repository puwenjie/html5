
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
   <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">

var xmlrequest;
function createXMLHttpRequest(){

if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
}
 $(document).ready(function(){
 alert("hahahh");
 
 createXMLHttpRequest();
 var uri="view.jsp"
 xmlrequest.open("POST",uri,true);
 xmlrequest.onreadystatechange=processResponse;
 xmlrequest.send(null);
 })
 
 
 function processResponse(){
 if(xmlrequest.readyState==4){
 if(xmlrequest.status==200){
 var text=xmlrequest.responseText;
 alert(text);
 }
 
 }
 
 
 }
  
  
  </script>
</head>
<body >
 <c:forEach items="${requestScope.data}" var="u" varStatus="status">
            <tr>
                <td>${u.key}</td>
             
                </tr>
                  <tr>
                <td>${u.value}</td>
             
                </tr>
         </c:forEach>

<form action="FileImg" method="get" enctype="multipart/form-data">
   


<input type="submit" value="下载"></input>

</form>


</body>
</html>