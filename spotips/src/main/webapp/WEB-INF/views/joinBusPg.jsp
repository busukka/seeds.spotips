<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="resources/js/jquery.serializeObject.js"></script>
<script src="resources/js/NameMailCertNoCheck.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> 
<script src="resources/js/searchAddr.js"></script> 
<head>
<meta charset="UTF-8">
<style>
table,tr,td {
border: 1px solid black;
border-collapse: collapse;
}
#sendCertificationNo{
	display: none;
} 
#sendCertificationNo.open{
	display: block;
} 
#inputCertNo{
	 display: none; 
}
#inputCertNo.open{
	 display: block; 
}
html, body{height:100%;margin:0}
  #joinSuccess_layer {
   display:none;position:fixed;
   position:absolute;top:0;left:0;
   width:100%;height:100%}
  #joinSuccess_layer.open {display:block;color:red}
  #joinSuccess_layer #bg_layer {
      position:absolute;top:0;left:0;
      width:100%;height:100%;background:#000;
      opacity:.5;filter:alpha(opacity=50);z-index:100}
  #contents_layer { position:absolute;top:40%;left:40%;
     width:400px;height:400px;margin:-150px 0 0 -194px;
      padding:28px 28px 0 28px;border:2px solid #555;
        background:#fff;font-size:12px;z-index:200;
     color:#767676;line-height:normal;white-space:normal;
     overflow:scroll}
</style>
</head>
<body>

<h1>joinBusPg.jsp</h1>

<form action="insertBm" method="post" name="joinForm"  >
	<table border="1">
	
		<tr>
			<td colspan="2" class="subject">기업회원가입</td>
		</tr>
	
		<tr>
			<td width="100">기업형태 </td>
			<td><select name="mb_busform" size='1'>				
				<option value="기업">기업</option>
				<option value="단체">단체</option>
				<option value="개인">개인</option>
				<option value="기타">기타</option>
				<option></option>
			</select></td>
		</tr>
		
		<tr>
			<td width="100">ID </td>
			<td><input type="text" name="mb_id" id="mb_id"/></td>
			<td><input type="button" value="중복체크" onclick="mailCheck()" 
			onMouseOver="this.style.backgroundColor='red'"
		onMouseOut="this.style.backgroundColor='white'"/></td>
		</tr>
		
		<!-- 세션에 certCode가 담김 클라이언트가 폼에 입력한 값과 전송한 certCode가 일치하는지 확인하기위해서-->
<!-- 		세션에 ("certStatus", false)가 담김 인증여부 확인을 위해서.. false시 가입안됨 -->
		<tr id="sendCertificationNo">
			<td colspan="2" ><input type="button" value="인증메일발송" onclick="sendCerMail()"/></td>
		</tr>
		
		<!-- 인증완료시 ("certStatus", false) >> ("certStatus", true)로 바뀌고 가입가능 -->
		<tr id="inputCertNo">
			<td align="center" colspan="2"><input type="text" id="certNo" placeholder="인증번호 입력란"/></td>
			<td><input type="button" value="인증완료" onclick=" certNoCheck()" 
			onMouseOver="this.style.backgroundColor='purple'"
		onMouseOut="this.style.backgroundColor='white'"/></td>
		</tr>
		
		<tr>
			<td width="100">PW </td>
			<td><input type="password" name="mb_pw"/></td>
		</tr>
		
		<tr>
			<td width="100">Name </td>
			<td><input type="text" name="mb_name" id="mb_name"/></td>
			<td><input type="button" value="중복체크" onclick="nameCheck()" 
			onMouseOver="this.style.backgroundColor='red'"
			onMouseOut="this.style.backgroundColor='white'" /></td>
		</tr>
		
		<tr>
			<td width="100">기업번호 </td>
			<td><input type="text" name="mb_busno"/></td>
		</tr>
		<tr>
			<td width="100">기업대표 </td>
			<td><input type="text" name="mb_busrepre"/></td>
		</tr>
		
		<tr>
			<td width="100">기업연락처 </td>
			<td><input type="text" name="mb_bustel"/></td>
		</tr>
		
		<tr>
			<td width="100">addr</td>
			<td><input type="text" name="addr1" id="addr1" placeholder="우편번호"></td>
			<td><input type="text" name="addr2" id="addr2" placeholder="도로명주소"></td>
			<td><input type="text" name="addr3" id="addr3" placeholder="지번주소"></td>
			<td><input type="button" onclick=" searchAddr()" value="우편번호 찾기"><br></td>
		</tr>
		<tr>
			<td width="100">전문분야</td>
			<td>
			 	 ${FLCheckBoxHTML}  
			</td>
		</tr>
<!-- @SessionAttributes("mb")가 적용되어 회원가입시에 session에 mb가 담김 폼에 serial은 없어서 서비스단에서 별도로 mb빈의 serial=2설정 먼저 해놓음-->
		<tr>
			<td colspan="2"><input type="submit" value="회원가입"/> </td>
		</tr>
</table>
</form>
<span id="guide" style="color:#999"></span>

<div id="joinSuccess_layer">
	<div id="bg_layer"></div>
	<div id="contents_layer"></div>
</div>

</body>
<script>
	
</script>

</html>