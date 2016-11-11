<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
	<script type="text/javascript" src="js/jquery-1.7.2.js" ></script>
	<script type="text/javascript">
		var uploadid="";
		var action="";
		var obj;
		var isOk=true;
		var total=0;
		var uped=0;
		var msg="";
		var path="<%=path %>/upload";
		function upload(){
			uploadid=Math.floor(Math.random()*10000+1);
			document.forms["myform"].action=path+"?upid="+uploadid;
			document.forms["myform"].submit();
			total=0;
			uped=0;
			msg="";
			isOk=true;
			ajaxBackState();
		}
		function ajaxBackState(){
			 $.get(path,{upid:uploadid,Time:Math.random()},function(result){
			 	if(result!=null&&result.length>0){
					obj = eval('(' + result + ')');
					if(obj!=null){
						total=obj.totalsize;
						uped=obj.uploadsize;
						msg=obj.errormsg;
						if(obj.state!=0){
	  						isOk=false;
	  					}
					}
				}
				if(total>0){
					updateProgress(uped,total,isOk,msg);
				}
				if(isOk){
		  			ajaxBackState();
		  		}
  			});
		}
		function updateProgress(currentsize,totalsize,state,msg){
			document.getElementById("total").style.visibility="visible";
			var c=document.getElementById("prog");
			var cwidth=0;
			cwidth=(currentsize/totalsize)*100;
			var w=cwidth+"%";
			c.style.width=w;
			document.getElementById("pvalue").innerHTML=w;
			if(!state){
				setTimeout("initProg()",500);
			}
		}
		
		function initProg(){
			alert(msg);
			document.getElementById("total").style.visibility="hidden";
			document.getElementById("pvalue").innerHTML="";
			c.style.width="0%";
		}
		
	</script>
  </head>
  
  <body style="font-family:yaHei Consolas Hybrid;font-size:14px;">
  	<iframe name="uploadIfr" ></iframe><br/><br/>
  	
	<br/><br/>
	<span id="total" style="border:1px black solid;display:inline;visibility:hidden;width:200px;height:21px;text-align:center;position:relative;align:center;">
			<b id="pvalue" style="position:absolute;left:0;z-index:2;"></b>
			<span id="prog" style="width:0px;background-color:#09F;height:19px;position:absolute;left:0;z-index:1;"></span>
	</span>
    <form id="myform" name="myform" action="<%=path %>/upload" method="post" enctype="multipart/form-data" target="uploadIfr" >
    	解压路径:<input id="unpkpath" name="unpkpath" type="text" /><br />
    	选择文件:<input id="myfile" name="myfile" type="file" ></input><input id="btn_sub" name="btn_sub" type="button" value="上传" onclick="upload();" />
    </form>
  </body>
</html>
