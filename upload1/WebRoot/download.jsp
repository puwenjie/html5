
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
   <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
   <script type='text/javascript' src='/upload1/leedwr/engine.js'></script>
  <script type='text/javascript' src='/upload1/leedwr/interface/fileList.js'></script>
    <script type='text/javascript' src='/upload1/leedwr/util.js'></script>
  <script>

   function cd(data){
     //alert("nihaodata");
    // alert(data[1]);
  }
       
     $(document).ready(function()
       {
     // alert("nihao");
      fileList.getFileName("d:/jexo",cd);  
       // alert("nihao1");
    });
    
  
   </script>
</head>
<body >
 <c:forEach items="${data}" var="u" varStatus="status">
            <tr>
                <td>${u}</td>
             
                </tr>
         </c:forEach>
<form action="FileUtilsTest" method="get" enctype="multipart/form-data">
   


<input type="submit" value="下载"></input>

</form>



</body>
</html>