














function populate() {
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
        populate();
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
	
	
	
	console.log(quiz.score);
};
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////

 var max = 4;
    var random = [];
    for(var i = 0;i<max ; i++){
        var temp = Math.floor(Math.random()*max);
        if(random.indexOf(temp) == -1){
            random.push(temp);
        }
        else
         i--;
    }
   
 



	var task=firebase.database().ref("Choose Question");
	
	task.on("child_added",function(data){
		
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
		
		
		
		
		
		////////////////true false question////////////////////
		
		
		
		

	var taskt=firebase.database().ref("True Or False Questions");
	
	taskt.on("child_added",function(data){
		
			var nu=data.val().questionNumber;

			
			
			
			if(nu==random[0]){
				
	var taskvalue=data.val();
	var texttf=data.val().question;
		var corrtf=data.val().correctAnswer;

			localStorage.setItem("ttttf",texttf);
			localStorage.setItem("correctf",corrtf);
		
		
			
			}
		
			if(nu==random[1]){
				
	var taskvalue=data.val();
	var texttf1=data.val().question;
		var corrtf1=data.val().correctAnswer;

			localStorage.setItem("ttttf1",texttf1);
			localStorage.setItem("correctf1",corrtf1);
		
		
			
			}
			
			if(nu==random[2]){
				
	var taskvalue=data.val();
	var texttf2=data.val().question;
		var corrtf2=data.val().correctAnswer;

			localStorage.setItem("ttttf2",texttf2);
			localStorage.setItem("correctf2",corrtf2);
		
		
			
			}
		
			if(nu==random[3]){
				
	var taskvalue=data.val();
	var texttf3=data.val().question;
		var corrtf3=data.val().correctAnswer;

			localStorage.setItem("ttttf3",texttf3);
			localStorage.setItem("correctf3",corrtf3);
		
		
			
			}
		
		
		});
		
		
			
 var xtf=localStorage.getItem("ttttf");
 var corrctf=localStorage.getItem("correctf");
 ////////////////////////////////
 		
 var xtf1=localStorage.getItem("ttttf1");
 var corrctf1=localStorage.getItem("correctf1");
 /////////////////////////
 		
 var xtf2=localStorage.getItem("ttttf2");
 var corrctf2=localStorage.getItem("correctf2");
 ///////////////		
 var xtf3=localStorage.getItem("ttttf3");
 var corrctf3=localStorage.getItem("correctf3");
		
		
		
		
		
// create questions
var questions = [
    new Question(x, [ch1, ch2,ch3,ch4], corr),
    new Question(xa, [ch1a, ch2a, ch3a,ch4a], corra),
    new Question(x2, [ch1b, ch2b,ch3b, ch4b], corrb),
    new Question(x3, [ch1c,ch2c,ch3c,ch4c],corrc),
     new Question(xtf, ["true","False","",""],corrctf),
	      new Question(xtf1, ["true","False","",""],corrctf1),

     new Question(xtf2, ["true","False","",""],corrctf2),
 new Question(xtf3, ["true","False","",""],corrctf3)

];
	
// create quiz
var quiz = new Quiz(questions);

// display quiz
populate();









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
    var fiveMinutes = 60 * 1,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
 












/////////////////////////////////    const scorePerCent = Math.round(100 * score/questions.length);


