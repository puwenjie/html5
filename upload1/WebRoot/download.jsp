
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
   <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
   <script type='text/javascript' src='/upload1/leedwr/engine.js'></script>
  <script type='text/javascript' src='/upload1/leedwr/interface/fileList.js'></script>
    <script type='text/javascript' src='/upload1/leedwr/util.js'></script>
    <!--  
  <script>
//这是一种方法，或者第二种方法用后台setAttribute("data", list);返回给data，前台用foreach去遍历
   function cd(data){
     //alert("nihaodata");
     alert(data[1]);
  }
       
     $(document).ready(function()
       {
     // alert("nihao");
      fileList.getFileName("d:/jexo",cd);  
       // alert("nihao1");
    });
    
  
   </script>-->
   
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
 <c:forEach items="${data}" var="u" varStatus="status">
            <tr>
                <td>${u}</td>
             
                </tr>
         </c:forEach>
<form action="FileUtilsTest" method="get" enctype="multipart/form-data">
   


<input type="submit" value="下载"></input>

</form>
<form action="FileImg" method="get" enctype="multipart/form-data">
   


<input type="submit" value="下载"></input>

</form>


</body>
</html>