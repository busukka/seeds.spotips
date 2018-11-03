/**
 * 
 */
function mailCheck() {
	var mail=document.getElementById("mb_id").value
	console.log(mail);
	console.log($('#sendCertificationNo').value);
	$.ajax({
		type : 'post',
		url : 'ajax/mailCheck',
		data : {mail:mail},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			
			 if(data.mailCheckNo==2){
				alert('중복!');
				$('#sendCertificationNo').removeClass('open');
				$('#mb_id').focus();
			}else {
				alert('중복없음!')
				$('#sendCertificationNo').addClass('open');
			}  
			
			
		},
		error : function(xhr,status) {
			alert("error");
			alert(xhr);
			alert(status);
			
		}
	})
	
}//mailCheck() End

function sendCerMail() {
	var mail=document.getElementById('mb_id').value;
	console.log(mail);

	$.ajax({
		type : 'post',
		url : 'sendCertMail',
		data : {mail:mail},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			if(data){
			alert('인증번호가'+mail+'로 발송되었습니다.');
			$('#inputCertNo').addClass('open');
			}else{
				alert('이메일을 다시 확인해주세요.')
			}
		},
		error : function(xhr,status) {
			/* alert("error");
			alert(xhr);
			alert(status); */
			alert('이메일을 다시 확인해주세요.')
	
		}
	})
}//sendCerMail() End

function certNoCheck() {
	var certNo = document.getElementById('certNo').value;
	console.log(certNo);
	$.ajax({
		type : 'post',
		url : 'certNoCheck',
		data : {certNo:certNo},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			if(data){ //session영역상태 : setAttribute("certStatus", true)
			alert('인증이가 완료.');
			$('#inputCertNo').removeClass('open');
			$('#sendCertificationNo').removeClass('open');
			}else{
				alert('인증번호가 틀렸습니다.')
				$('#certNo').focus();
			}
		},
		error : function(xhr,status) {
			 alert("error");
			alert(xhr);
			alert(status); 
			
	
		}
	})
	
}//certNoCheck() End

function nameCheck() {
	var name=document.getElementById("mb_name").value
	console.log(name);
	$.ajax({
		type : 'post',
		url : 'ajax/nameCheck',
		data : {name:name},
		dataType : 'JSON',
		success: function(data,status,xhr){
			console.log(data)
			console.log(status)
			console.log(xhr)
			
			 if(data){
				alert('중복없음!')
			}else {
				alert('중복!');
				$('#mb_name').focus();
				
			}  
			
			
		},
		error : function(xhr,status) {
			alert("error");
			alert(xhr);
			alert(status);
			
		}
	})
	
}//mailCheck() End