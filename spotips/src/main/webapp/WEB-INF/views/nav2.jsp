<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>

</head>
 
<body align="center" marginwidth="0" marginheight="10">
    <embed src="넌 행복해.mp3">
    <form name="f" method="post" onsubmit="return sendIt();"
        action="mailto:rmlfa96@naver.com">
        <table width="800" height="250" border="1" align="center">
            <tr align="left">
                <td align="center" colspan="2" bgcolor="pink"><B>회원 기본 정보</B></td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>아이디:</b></td>
                <td><input type="text" name="my_id" id="my_id" size="20"
                    maxlength="12">4~12자의 영문 대소문자와 숫자로만 입력</td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>비밀번호:</b></td>
                <td><input type="password" name="my_pwd" id="my_pwd" size="20"
                    maxlength="12">4~12자의 영문 대소문자와 숫자로만 입력</td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>비밀번호 확인:</b></td>
                <td><input type="password" name="my_pwd1" size="20"
                    maxlength="12"></td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>메일 주소:</b></td>
                <td><input type="text" name="my_add" id="my_add" size="20">예>id@domain.com</td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>이름:</b></td>
                <td><input type="text" name="my_name" id="my_name" size="20"
                    maxlength="7"></td>
            </tr>
            <tr>
                <td align="center" colspan="2" bgcolor="skyblue"><B>개인 신상정보</B></td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>주민등록번호:</b></td>
                <td><input type="text" name="my_num" size="20" maxlength="13">예)1234561234567</td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>생일:</b></td>
                <td><input type="text" name="my_year" size="4" maxlength="4">
               	 년<select
                    name="my_month" id="my_month">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                </select>
				월<select name="my_date" id="my_date">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                </select>일</td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>관심분야:</b></td>
                <td><input type="checkbox" name="hobby">컴퓨터 <input
                    type="checkbox" name="hobby">인터넷 <input type="checkbox"
                    name="hobby">여행 <input type="checkbox" name="hobby">영화감상
                    <input type="checkbox" name="hobby">음악감상</td>
            </tr>
            <tr align="left">
                <td align="center" bgcolor="lightgreen"><b>자기소개:</b></td>
                <td><textarea name="my_intro" id="my_intro" cols="80" rows="5"></textarea></td>
            </tr>
        </table>
        <br> <br> <input type="submit" value="회원가입"
            onclick="sendit()"> <input type="reset" value="다시 입력">
    </form>
</body>
<script type="text/javascript">
    function sendIt() {
        var email = document.f.my_add.value;
        var han = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
        var hann = /[^가-힣]/g;
        var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
         var jumin1 = document.f.my_num.value.substr(0,6);
          var jumin2 =document.f.my_num.value.substr(6,7);
          var yy     = jumin1.substr(0,2);        // 년도
          var mm     = jumin1.substr(2,2);        // 월
          var dd     = jumin1.substr(4,2);        // 일
          var genda  = jumin2.substr(0,1);        // 성별
          var msg, ss, cc;
        //아이디 입력여부 검사
        if (f.my_id.value == "") {
            alert("아이디를 입력하지 않았습니다.")
            f.my_id.focus()
            return false;
        }
        //아이디 유효성 검사 (영문소문자, 숫자만 허용)
        for (i = 0; i < document.f.my_id.value.length; i++) {
            ch = document.f.my_id.value.charAt(i)
            if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                alert("아이디는 대소문자, 숫자만 입력가능합니다.")
                document.f.my_id.focus()
                document.f.my_id.select()
                return false;
            }
        }
        //아이디에 공백 사용하지 않기
        if (document.f.my_id.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            document.f.my_id.focus()
            document.f.my_id.select()
            return false;
        }
        //아이디 길이 체크 (4~12자)
        if (document.f.my_id.value.length<4 || document.f.my_id.value.length>12) {
            alert("아이디를 4~12자까지 입력해주세요.")
            document.f.my_id.focus()
            document.f.my_id.select()
            return false;
        }
        //비밀번호 입력여부 체크
        if (document.f.my_pwd.value == "") {
            alert("비밀번호를 입력하지 않았습니다.")
            document.f.my_pwd.focus()
            return false;
        }
        if (f.my_pwd.value == f.my_id.value) {
            alert("아이디와 비밀번호가 같습니다.")
            document.f.my_pwd.focus()
            return false;
        }
        //비밀번호 길이 체크(4~8자 까지 허용)
        if (document.f.my_pwd.value.length<4 || document.f.my_pwd.value.length>12) {
            alert("비밀번호를 4~12자까지 입력해주세요.")
            document.f.my_pwd.focus()
            document.f.my_pwd.select()
            return false;
        }
 
        //비밀번호와 비밀번호 확인 일치여부 체크
        if (document.f.my_pwd.value != document.f.my_pwd1.value) {
            alert("비밀번호가 일치하지 않습니다")
            document.f.my_pwd1.value = ""
            document.f.my_pwd1.focus()
            return false;
        }
 
        if (document.f.my_add.value == "") {
            alert("이메일을 입력하지 않았습니다.")
            document.f.my_add.focus()
            return false;
        }
        
 
        if (regex.test(email) === false) {
            alert("잘못된 이메일 형식입니다.");
            document.f.my_add.value=""
            document.f.my_add.focus()
            return false;
        }
        if (document.f.my_name.value == "") {
            alert("이름을 입력하지 않았습니다.")
            document.f.my_name.focus()
            return false;
        }
        if(document.f.my_name.value.length<2){
            alert("이름을 2자 이상 입력해주십시오.")
            document.f.my_name.focus()
            return false;
        }
        
        if (document.f.my_num.value == "") {
            alert("주민번호를 입력하지 않았습니다.")
            document.f.my_num.focus()
            return false;
        }
        if (document.f.my_num.value.length<13||document.f.my_num.value.length>13) {
            alert("주민번호 길이가 맞지 않습니다.")
            document.f.my_num.value = ""
            document.f.my_num.focus()
            return false;
        }
    
          // 숫자가 아닌 것을 입력한 경우
          if (!isNumeric(jumin1)) {
            alert("주민번호는 숫자로 입력하세요.");
            document.f.my_num.value = ""
            document.f.my_num.focus()
            return false;
          }
          
          // 첫번째 자료에서 연월일(YYMMDD) 형식 중 기본 구성 검사
          if (yy < "00" 
              || yy > "99" 
              || mm < "01" 
              || mm > "12" 
              || dd < "01" 
              || dd > "31") {
            alert("주민등록번호다시 입력하세요.");
            document.f.my_num.value = ""
                document.f.my_num.focus()
            return false;
          }
          
          // 숫자가 아닌 것을 입력한 경우
          if (!isNumeric(jumin2)) {
            alert("주민등록번호는 숫자로 입력하세요.");
            document.f.my_num.value = ""
                document.f.my_num.focus()
            return false;
          }
          
          // 성별부분이 1 ~ 4 가 아닌 경우
          if (genda < "1" || genda > "4") {
            alert("주민등록번호 다시 입력하세요.");
            document.f.my_num.value = ""
                document.f.my_num.focus()
            return false;
          }
          
          // Check Digit 검사
          if (!isSSN(jumin1, jumin2)) {
            alert("존재하는 주민번호가 아닙니다.");
            document.f.my_num.value = ""
                document.f.my_num.focus()
            return false;
          }
          f.my_year.value ="19" +jumin1.charAt(0) + jumin1.charAt(1);
            f.my_month.value = parseInt(jumin1.charAt(2))+parseInt(jumin1.charAt(3));
            f.my_date.value = parseInt(jumin1.charAt(4)+jumin1.charAt(5));
            
          if(document.f.hobby[0].checked==false && 
                    document.f.hobby[1].checked==false && 
                    document.f.hobby[2].checked==false && 
                    document.f.hobby[3].checked==false && 
                    document.f.hobby[4].checked==false){
                 alert("관심분야를 체크해 주세요");
                 return false;
              }
          
          if(document.f.my_intro.value== ""){
              alert("자기소개를 입력해주십시오.");
              document.f.my_intro.focus()
              return false;
          }
          if(document.f.my_intro.length>100){
              alert("자기소개는 100자 이내입니다.");
              document.f.my_intro.focus()
              return false;
          }
        }
 
         
        function isNumeric(s) { 
          for (i=0; i<s.length; i++) { 
            c = s.substr(i, 1); 
            if (c < "0" || c > "9") return false; 
          } 
          return true; 
        }
         
        function isSSN(s1, s2) {
          n = 2;
          sum = 0;
          for (i=0; i<s1.length; i++)
            sum += parseInt(s1.substr(i, 1)) * n++;
          for (i=0; i<s2.length-1; i++) {
            sum += parseInt(s2.substr(i, 1)) * n++;
            if (n == 10) n = 2;
          }
          
          c = 11 - sum % 11;
          if (c == 11) c = 1;
          if (c == 10) c = 0;
          if (c != parseInt(s2.substr(6, 1))) return false;
          else return true;
 
        document.f.submit()
    }
</script>
</html>