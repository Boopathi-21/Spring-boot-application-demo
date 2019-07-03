function myFunction() {
  var inputUserame= document.getElementById("inputUserame").value;
  var inputEmail= document.getElementById("inputEmail").value;
  var inputPassword= document.getElementById("inputPassword").value;
  var inputConfirmPassword= document.getElementById("inputConfirmPassword").value;
var bodyParam ={
		'name':inputUserame,
		'mailId':inputEmail,
		'password':inputPassword,
		'confirmPassword':inputConfirmPassword
} ;

var myJSON = JSON.stringify(bodyParam);
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
	  if(this.response !="2"){
   window.location.href = "http://localhost:8080/failed";
	  }
	  else {
	  window.location.href = "http://localhost:8080/success"; 
	  }
}
};
xhttp.open("POST", "http://localhost:8080/checkData",false);
xhttp.setRequestHeader('Content-Type', 'application/json');
xhttp.send(myJSON);

}