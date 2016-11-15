
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>

<html>
<head>
   <script type='text/javascript' src='/upload3/leedwr/engine.js'></script>
  <script type='text/javascript' src='/upload3/leedwr/interface/fileList.js'></script>
    <script type='text/javascript' src='/upload3/leedwr/util.js'></script>
  <script>

   function cd(data){
   // alert("nihaodata");
     alert(data);
  }
       window.onload=function (){
   // alert("nihao");
    fileList.getFileName("d:/jexo",cd);
    
 
   }
    
 
  </script>
</head>
<body >

</body>
</html>