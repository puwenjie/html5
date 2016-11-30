
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
   <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
$(document).ready(function(){
alert("nihao");
$.ajax({
    url:'FileImg',
    type:'GET', //GET
    async:true, 
    dataType: 'json',     //或false,是否异步
    timeout:5000,    //超时时间
    
    beforeSend:function(xhr){
        console.log(xhr)
      
        console.log('发送前')
    },
    success:function(data){
        console.log(data)
      
   
for(var p in data){
    var str =data[p];
      
        alert(str.fileName);
        alert(str.urlName);
        alert(str.filezip)
      
}
        
  
       
      
    }

    
    })

})

  
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