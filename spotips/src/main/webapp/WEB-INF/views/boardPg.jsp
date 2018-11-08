<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<head>
<meta charset="UTF-8">
<style>

         #container {
        width: 940px;
        margin: 0px auto;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      #header {
        width: 680px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        height: 80px;
        border: 1px solid #bcbcbc;
      }
      #sideheader {
        width: 160px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        height: 80px;
        border: 1px solid #bcbcbc;
      }
      #content {
        width: 580px;
         height: 195px;
        padding: 20px;
        margin-bottom: 20px;
        float: left;
        border: 1px solid #bcbcbc;
      }
      #sidebar {
        width: 260px;
        height: 195px;
        padding: 20px;
        margin-bottom: 20px;
        float: right;
        border: 1px solid #bcbcbc;
      }
      #footer {
        clear: both;
        padding: 20px;
        border: 1px solid #bcbcbc;
      }
      #date{
          float: right;  
      }
      #flno{
          text-align: right;  
      }
    
</style>


</head>

<body>

			${makeBList}
			
</body>


<script>
	
</script>

</html>