	
	



function populate(s1,s2){
			var s1=document.getElementById(s1);
			var s2 =document.getElementById(s2);
			s2.innerHTML="";
			if(s1.value == "fci"){
		var optionArray = ["|","level 1|level 1","level 2|level 2","level 3|level 3",,"level 4|level 4"];
	} else if(s1.value == "engineering"){
		var optionArray = ["|","general|general","level 1|level 1","level 2|level 2","level 3|level 3",,"level 4|level 4"];
	} else if(s1.value == "medicine"){
		var optionArray = ["|","level 1|level 1","level 2|level 2","level 3|level 3",,"level 4|level 4","level 5|level 5","level 6|level 6","level 7|level 7",];
	}
	for(var option in optionArray){
		var pair = optionArray[option].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		s2.options.add(newOption);
	}

	
}



function populateee(s3,s34,s4){
	
	
		var s3=document.getElementById(s3);
		var s34 =document.getElementById("selectType");
			var s4 =document.getElementById(s4);
			
			s4.innerHTML="";
			if(s3.value == "level 3" & s34.value == "fci"){
		var optionArray = ["|","se|se","it|it","cs|cs",,"is|is"];
	
			}
	else if(s3.value == "level 4" & s34.value == "fci"){
		var optionArray = ["|","se|se","it|it","cs|cs",,"is|is"];
	
			}
	
	
	for(var option in optionArray){
		var pair = optionArray[option].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		s4.options.add(newOption);
	}
	
	
	
	
	
	
}
	






function stusignup(){
		var namee=document.getElementById("stuusername").value;
		var code=document.getElementById("code").value;
	    var phonenumber=document.getElementById("phonenumber").value;
	    var userpassword=document.getElementById("userpassword").value;
var passwordconfirm=document.getElementById("confirmpassword").value;
var email=document.getElementById("email").value;

		var facultyname=document.getElementById("selectType").value;
		var  facultylevel=document.getElementById("facultylevels").value;
		var  facultydepartment=document.getElementById("facultydepartment").value;
		
		
		if(namee==""){
			window.alert("please enter name");
		return false;
	
	}
	if(code==""){
		window.alert("please enter code");
		return false;
		
	}
	if(phonenumber==""){
		window.alert("please enter phonenumber");
		return false;
		
	}
	
	if(userpassword==""){
		window.alert("please enterpassword");
		return false;
		
	}
	
	if(passwordconfirm==""){
		window.alert("please passwordconfirm");
		return false;
		
	}
	if(userpassword!=passwordconfirm){
		window.alert("password and confirmpassword is not matching");
		return false;
	}
	if(facultyname==""){
		window.alert("please enter facultyname");
		return false;
		
	}
	if(facultylevel==""){
		window.alert("please select facultylevel");
		return false;
		
	}
	if(email==""){
		window.alert("please select email");
		return false;
		
	}
		
		
		
		
		
		
		
		
		
var firebaseRef = firebase.database().ref('student/'+code);


firebaseRef.set({studentName:namee ,studentCode:code ,phonenumber:phonenumber ,studentpassword:userpassword ,facultyname:facultyname , facultylevel:facultylevel ,facultydepartment:facultydepartment,Email:email });

		
		
		alert("done");
		
		
		
	
		
		

}








function stlogin(){
	
	var scode=document.getElementById("scode").value;
	var logstudentpass=document.getElementById("logstudentpass").value;
	
	
	
	
	
		
									
var userRefa=firebase.database().ref('student/'+scode).on("value", function(snapshot) {
	if (snapshot.exists()) {

var pass=snapshot.val().studentpassword;
if(logstudentpass==pass){
	
	
	var sname=snapshot.val().studentName;
	localStorage.setItem("studentcode",scode);

	
	window.location="read.html";
	}
	}
	

else{
	
	alert("please enter correct information");
}

});


}

















/////////////////////////////////////////////quiz body//////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////
// select all elements




  // Initialize Firebase
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
/////////////////////////////////////////////////////




function create(){
	
var studentcod=	localStorage.getItem("studentcode");

var database=firebase.database();

var userRef=database.ref('student/'+studentcod);

userRef.once('value',function(snapshot){
	
	
	localStorage.setItem("studentcodd",snapshot.val().studentCode);

		document.getElementById("studentname").innerHTML=snapshot.val().studentName;
		
		    	document.getElementById("phone").innerHTML="phone : "+snapshot.val().phonenumber;
		document.getElementById("email").innerHTML="email : "+snapshot.val().Email+".";

				document.getElementById("faculty").innerHTML="faculty : "+snapshot.val().facultyname+".";
				document.getElementById("level").innerHTML="facultylevel : "+snapshot.val().facultylevel+".";
				document.getElementById("department").innerHTML="facultydepartment : "+snapshot.val().facultydepartment+".";


			//	localStorage.setItem("docuname",snapshot.val().doctorName);

	
	
});



}

  
  
  
  

function showfollow(){
	var code=localStorage.getItem("studentcodd");
	
	

var database=firebase.database();

var userRef=database.ref('student/'+code);

userRef.once('value',function(snapshot){
	
	var faculty=snapshot.val().facultyname;
	var level=snapshot.val().facultylevel;
	var department=snapshot.val().facultydepartment;
	
	
	
	
	var task=firebase.database().ref("Subjects");
	
	task.on("child_added",function(data){
	
	var sfaculty=data.val().facultyUsername;
	var slevel=data.val().levelName;
	var sdepartment=data.val().depName;
	
	if(sfaculty==faculty && slevel==level &&sdepartment==department){
		var subjectname=data.val().name;
		var professorname=data.val().proName;
		var key=data.val().key;
			document.getElementById("showfollowers").innerHTML+='<div><p><img src="subject.png " class="patientimage">'+subjectname+'</p><h9 style="color:#fff">dr :'+professorname+'</h9> <br> <input type="button" class="deletef" id="'+key+'" onclick="openexam(this.id)" style=" color:#FFFFFF;width:100px;"value="exam"> <hr></div>';

	}
		
		
		
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});


}
	
	
	//////////////////////////////////////////btn exam///////////////////
	
	
	
	function openexam(id){
		
	
		var subkey=id;
		
		
var userRef=firebase.database().ref('Subjects/'+id);

userRef.once('value',function(snapshot){
	
var subnmaeee=snapshot.val().name;
localStorage.setItem("subbbbnnn",subnmaeee);


});

		
		var snnnn=localStorage.getItem("subbbbnnn");
		console.log(snnnn);
localStorage.setItem("subkkey",subkey);
	var studentcod=	localStorage.getItem("studentcodd");
	var mmmmaaaxx= studentcod+snnnn;
	localStorage.setItem("mmaxxxaa",mmmmaaaxx);
	console.log(mmmmaaaxx);
	
var database=firebase.database();
	
var userReff=database.ref('studentResult/'+mmmmaaaxx);		
userReff.once('value',function(snapshot){


	
		if(snapshot.exists()){
			console.log("workingggg");
					
					var sub=snapshot.val().subjectKey;
				
							localStorage.setItem("coood",snapshot.val().studentCode);
					window.location="currentresult.html"
				
				
				
				
		
				
				
					
					}
					
					
					
	

		
		
		else{
		
			
var task=firebase.database().ref("Choose Question");
	task.orderByChild("subjectKey").equalTo(id).on("child_added", function(data) {
	

					
	window.location="question.html";
				
		
				
				});

		
		}
		});
		
		
		



		
		
		
	}
	
	////////////////////////////////////////////////////show result page
	
	
	
	
	
	
	
	
	
	function createress(){
		var maxxcod=localStorage.getItem("mmaxxxaa");

		var scode=localStorage.getItem("studentcodd");
		
		console.log(scode);
		
var userRefaa=firebase.database().ref('studentResult/'+maxxcod).on("value", function(snapshot) {
	if (snapshot.exists()) {
					
				var resultt=snapshot.val().result;
								var subname=snapshot.val().subjectName;

				console.log(resultt);
	
		  var gameOverHTML = "<h1>Result for "+subname+"</h1>";
   gameOverHTML += "<h2 id='score'> Your scores: " + resultt + "</h2>";
   
    var element = document.getElementById("quiz");
   element.innerHTML = gameOverHTML;
	}		
		
	});
		
		
		
		
		

		
	}
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////question part//////////////////////
	
	
	
	
	
	
	
	
	
	


function populatee() {
    if(quiz.isEnded()) {
        showScores();
    }
    else {
        // show question
        var element = document.getElementById("question");
        element.innerHTML = quiz.getQuestionIndex().text;

        // show options
        var choices = quiz.getQuestionIndex().choices;
        for(var i = 0; i < choices.length; i++) {
            var element = document.getElementById("choice" + i);
            element.innerHTML = choices[i];
            guess("btn" + i, choices[i]);
        }

        showProgress();
    }
};

function guess(id, guess) {
    var button = document.getElementById(id);
    button.onclick = function() {
        quiz.guess(guess);
        populatee();
    }
};


function showProgress() {
    var currentQuestionNumber = quiz.questionIndex + 1;
    var element = document.getElementById("progress");
    element.innerHTML = "Question " + currentQuestionNumber + " of " + quiz.questions.length;
};

function showScores() {
    var gameOverHTML = "<h1>Result</h1>";
    gameOverHTML += "<h2 id='score'> Your scores: " + quiz.score + "</h2>";
    var element = document.getElementById("quiz");
    element.innerHTML = gameOverHTML;
	
	///
	
	
	
	var studentcod=	localStorage.getItem("studentcodd");


var userRefa=firebase.database().ref('student/'+studentcod).on("value", function(snapshot) {
	if (snapshot.exists()) {

var studentname=snapshot.val().studentName;

	var subke=localStorage.getItem("subkkey");

	
var userRefaa=firebase.database().ref('Subjects/'+subke).on("value", function(snapshot) {
	if (snapshot.exists()) {
var subname=snapshot.val().name;
var maxin=studentcod+subname;

var firebaseRef = firebase.database().ref('studentResult/'+maxin);


firebaseRef.set({studentName:studentname ,code:maxin,studentCode:studentcod ,subjectName:subname,subjectKey:subke,result:quiz.score});


	}
});


	}
});
	
	
	
	
	
	console.log(quiz.score);
};
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

 var max = 5;
    var random = [];
    for(var i = 0;i<max ; i++){
        var temp = Math.floor(Math.random()*max);
        if(random.indexOf(temp) == -1){
            random.push(temp);
        }
        else
         i--;
    }
   
 

var subskey=localStorage.getItem("subkkey");


	var task=firebase.database().ref("Choose Question");
	task.orderByChild("subjectKey").equalTo(subskey).on("child_added", function(data) {
	
	//task.on("child_added",function(data){
				var subkeyid=data.val().subjectKey;

		
			var nu=data.val().questionNumber;

			
			
			
			if(nu==random[0]){
				
	var taskvalue=data.val();
	var text=data.val().question;
		var ch1=data.val().a;
				var ch2=data.val().b;

		var ch3=data.val().c;
				var ch4=data.val().d;

		var corr=data.val().correctAnswer;

			localStorage.setItem("tttt",text);
			localStorage.setItem("chosi1",ch1);
			localStorage.setItem("chosi2",ch2);
		    localStorage.setItem("chosi3",ch3);
			 localStorage.setItem("chosi4",ch4);

			localStorage.setItem("correc",corr);
			console.log(text);
		
			
			}
			if(nu==random[1]){
				
	var taskvalue=data.val();
	var texta=data.val().question;
		var ch1a=data.val().a;
				var ch2a=data.val().b;

		var ch3a=data.val().c;
				var ch4a=data.val().d;

		var corra=data.val().correctAnswer;

			localStorage.setItem("tttta",texta);
			localStorage.setItem("chosi1a",ch1a);
			localStorage.setItem("chosi2a",ch2a);
		    localStorage.setItem("chosi3a",ch3a);
			 localStorage.setItem("chosi4a",ch4a);

			
			localStorage.setItem("correca",corra);
			console.log(texta);
		
			
			}
				if(nu==random[2]){
				
	var taskvalue=data.val();
	var text2=data.val().question;
		var ch1b=data.val().a;
				var ch2b=data.val().b;

		var ch3b=data.val().c;
				var ch4b=data.val().d;

		var corrb=data.val().correctAnswer;

			localStorage.setItem("tttt2",text2);
			localStorage.setItem("chosi1b",ch1b);
			localStorage.setItem("chosi2b",ch2b);
		    localStorage.setItem("chosi3b",ch3b);
			 localStorage.setItem("chosi4b",ch4b);

			
			localStorage.setItem("correcb",corrb);
		
		
			
			}
			if(nu==random[3]){
				
	var taskvalue=data.val();
	var text3=data.val().question;
		var ch1c=data.val().a;
		var ch2c=data.val().b;

		var ch3c=data.val().c;
				var ch4c=data.val().d;

		var corrc=data.val().correctAnswer;

			localStorage.setItem("tttt3",text3);
			localStorage.setItem("chosi1c",ch1c);
			localStorage.setItem("chosi2c",ch2c);
		    localStorage.setItem("chosi3c",ch3c);
			 localStorage.setItem("chosi4c",ch4c);

			
			localStorage.setItem("correcc",corrc);
		
		
			
			}
				if(nu==random[4]){
				
	var taskvalue=data.val();
	var text4=data.val().question;
		var ch1d=data.val().a;
		var ch2d=data.val().b;

		var ch3d=data.val().c;
				var ch4d=data.val().d;

		var corrd=data.val().correctAnswer;

			localStorage.setItem("tttt4",text4);
			localStorage.setItem("chosi1d",ch1d);
			localStorage.setItem("chosi2d",ch2d);
		    localStorage.setItem("chosi3d",ch3d);
			 localStorage.setItem("chosi4d",ch4d);

			
			localStorage.setItem("correcd",corrd);
		
		
			
			}
				
			
	

	});
		 var x=localStorage.getItem("tttt");
 var ch1=localStorage.getItem("chosi1");
 var ch2=localStorage.getItem("chosi2");
 var ch3=localStorage.getItem("chosi3");
  var ch4=localStorage.getItem("chosi4");

 
 var corr=localStorage.getItem("correc");
 
			//////////////
  var xa=localStorage.getItem("tttta");
 var ch1a=localStorage.getItem("chosi1a");
 var ch2a=localStorage.getItem("chosi2a");
 var ch3a=localStorage.getItem("chosi3a");
  var ch4a=localStorage.getItem("chosi4a");

 var corra=localStorage.getItem("correca");

////////////////////

  var x2=localStorage.getItem("tttt2");
 var ch1b=localStorage.getItem("chosi1b");
 var ch2b=localStorage.getItem("chosi2b");
 var ch3b=localStorage.getItem("chosi3b");
  var ch4b=localStorage.getItem("chosi4b");

 var corrb=localStorage.getItem("correcb");


///////////////////////////////////
		
 var x3=localStorage.getItem("tttt3");
 var ch1c=localStorage.getItem("chosi1c");
 var ch2c=localStorage.getItem("chosi2c");
 var ch3c=localStorage.getItem("chosi3c");
  var ch4c=localStorage.getItem("chosi4c");

 var corrc=localStorage.getItem("correcc");
	
		
		/////////////////////////////////////////////////////////
		var x4=localStorage.getItem("tttt4");
 var ch1d=localStorage.getItem("chosi1d");
 var ch2d=localStorage.getItem("chosi2d");
 var ch3d=localStorage.getItem("chosi3d");
  var ch4d=localStorage.getItem("chosi4d");

 var corrd=localStorage.getItem("correcd");
		
		
		
		
		////////////////true false question////////////////////
		
		 var max = 2;
    var randomm = [];
    for(var i = 0;i<max ; i++){
        var temp = Math.floor(Math.random()*max);
        if(randomm.indexOf(temp) == -1){
            randomm.push(temp);
        }
        else
         i--;
    }
		
		

	var taskt=firebase.database().ref("True Or False Questions");
	
	taskt.on("child_added",function(data){
			var subskey=localStorage.getItem("subkkey");
				var subkeyid=data.val().subjectKey;
			

		
			var nu=data.val().questionNumber;

			
			
			
			if(nu==randomm[0]){
				
	var taskvalue=data.val();
	var texttf=data.val().question;
		var corrtf=data.val().correctAnswer;

			localStorage.setItem("ttttf",texttf);
			localStorage.setItem("correctf",corrtf);
		
		
			
			}
		
			if(nu==randomm[1]){
				
	var taskvalue=data.val();
	var texttf1=data.val().question;
		var corrtf1=data.val().correctAnswer;

			localStorage.setItem("ttttf1",texttf1);
			localStorage.setItem("correctf1",corrtf1);
		
		
			
			}
			
		//	if(nu==randomm[2]){
				
	//var taskvalue=data.val();
//	var texttf2=data.val().question;
	//	var corrtf2=data.val().correctAnswer;

		//	localStorage.setItem("ttttf2",texttf2);
		//	localStorage.setItem("correctf2",corrtf2);
		
		
			
			
		
		
			//	}
		
		});
		
		
			
 var xtf=localStorage.getItem("ttttf");
 var corrctf=localStorage.getItem("correctf");
 ////////////////////////////////
 		
 var xtf1=localStorage.getItem("ttttf1");
 var corrctf1=localStorage.getItem("correctf1");
 /////////////////////////
 		
 //var xtf2=localStorage.getItem("ttttf2");
 //var corrctf2=localStorage.getItem("correctf2");
 ///////////////		
 //var xtf3=localStorage.getItem("ttttf3");
 //var corrctf3=localStorage.getItem("correctf3");
		
		
		
		
		
// create questions
var questions = [
    new Question(x, [ch1, ch2,ch3,ch4], corr),
    new Question(xa, [ch1a, ch2a, ch3a,ch4a], corra),
    new Question(x2, [ch1b, ch2b,ch3b, ch4b], corrb),
    new Question(x3, [ch1c,ch2c,ch3c,ch4c],corrc),
	    new Question(x4, [ch1d,ch2d,ch3d,ch4d],corrd),

     new Question(xtf, ["True","False","",""],corrctf),
	      new Question(xtf1, ["True","False","",""],corrctf1),

   // new Question(xtf2, ["True","False","",""],corrctf2),
 //new Question(xtf3, ["True","False","",""],corrctf3)

];
	
// create quiz
var quiz = new Quiz(questions);

// display quiz
populatee();









//////////////////////////////timer //////////

			//////////////////////////	
			///////





function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
			showScores();
        }
    }, 1000);
}

window.onload = function () {
	var subkk=localStorage.getItem("subkkey");
				
var task=firebase.database().ref("Exams");
	task.orderByChild("subjectKey").equalTo(subkk).on("child_added", function(data) {
		
		var t=data.val().examTime;
		localStorage.setItem("tt",t);
	});
	var tim=localStorage.getItem("tt");
    var fiveMinutes = 60 * tim,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
 




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////
	
	
	
	
	/////////////////////////update ///////////////////
	function updatebtn(){
	
	window.location = 'studentupdate.html';
	
}
	
	



///////////////////////////////////////////udate student///////////


function updateinfo(){
	var namee=document.getElementById("stuusername").value;
		var code=document.getElementById("code").value;
	    var phonenumber=document.getElementById("phonenumber").value;
	    var userpassword=document.getElementById("userpassword").value;
var passwordconfirm=document.getElementById("confirmpassword").value;
var email=document.getElementById("email").value;

		var facultyname=document.getElementById("selectType").value;
		var  facultylevel=document.getElementById("facultylevels").value;
		var  facultydepartment=document.getElementById("facultydepartment").value;
		
		
		if(namee==""){
			window.alert("please enter name");
		return false;
	
	}
	if(code==""){
		window.alert("please enter code");
		return false;
		
	}
	if(phonenumber==""){
		window.alert("please enter phonenumber");
		return false;
		
	}
	
	if(userpassword==""){
		window.alert("please enterpassword");
		return false;
		
	}
	
	if(passwordconfirm==""){
		window.alert("please passwordconfirm");
		return false;
		
	}
	if(userpassword!=passwordconfirm){
		window.alert("password and confirmpassword is not matching");
		return false;
	}
	if(facultyname==""){
		window.alert("please enter facultyname");
		return false;
		
	}
	if(facultylevel==""){
		window.alert("please select facultylevel");
		return false;
		
	}
	if(email==""){
		window.alert("please select email");
		return false;
		
	}
		
		
		
		
		
		
		
		
		
var firebaseRef = firebase.database().ref('student/'+code);


firebaseRef.set({studentName:namee ,studentCode:code ,phonenumber:phonenumber ,studentpassword:userpassword ,facultyname:facultyname , facultylevel:facultylevel ,facultydepartment:facultydepartment,Email:email });

		
		
		alert("updated");
		window.location="read.html";
		
		
		
	
		
		

}



		
	 
///////////////////////////////////resetpassword////////////////////

	function labrestpass(){
			
			
			
				var emaillab=document.getElementById("emaillab").value;
	
var task=firebase.database().ref("student");
	
	task.on("child_added",function(data){
	
		var emails=data.val().Email;
		var usernamee=data.val().username;
		if(emails==emaillab){
			
		var passwordd=data.val().studentpassword;
			
			Email.send({
   // Host : "smtp.gmail.com",
   // Username : "lightlight123311311@gmail.com",
   // Password : "lightlight123123",
	  SecureToken : "01dee693-eca3-4dae-825d-2874def47003",
    To : emails,
    From : "lightlight123311311@gmail.com",
    Subject : "Rcover YOur password From MIS",
    Body : "YOur Passwor is : "+passwordd
}) .then(function (message) {
                    alert("Password sent successfully")
                });
        
			
		}
		else{
			document.getElementById("wwarn").style.visibility="visible"
			
		}
		
		
		
		
		
	
		
		});
		
	

	
			
			
			
		}
		
		
		




////////////////////////////////////////////////compliant/////////////////

function put(){
	
	
	
	
	console.log("connection");
	var code=document.getElementById("code");
	var contactName=document.getElementById("contactName");
		var subject=document.getElementById("contactSubject");
var message=document.getElementById("contactMessage");


var scode=code.value;

	var docsubject=subject.value;
	var docmessage=message.value;
	
	var sname=contactName.value;
	
	

	
	if(sname==""){
		return false;
	}
	if(docsubject==""){
		return false;
	}
	if(docmessage==""){
		return false;
	}
	if(scode==""){
		return false;
	}
	


var firebaseuser = firebase.database().ref('student/'+scode);
firebaseuser.once('value',function(snapshot){
	if (snapshot.exists()) {
var firebaseRef = firebase.database().ref('complaintorinquiry/'+sname);


firebaseRef.set({studentname:sname ,studentcode:scode ,message:docmessage ,subject:docsubject });

				document.getElementById("message-successs").style.visibility = "visible";

 
	}
	else{
		
						document.getElementById("message-warningg").style.visibility = "visible";

	}
});

				
	
	
}















