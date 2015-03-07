var w = Snap("#svg");
var audio = new Audio("../sound/2background.m4a");
var backgroundSound = new Sound(audio);
backgroundSound.play();
backgroundSound.volume(0.01);
backgroundSound.loop(true);
var elementHeight = parseInt($("#svg").height()); //Altezza elemento
var elementWidth = parseInt($("#svg").width()); //Larghezza elemento
var flag = true;

var rain = new Waves();
rain.play();

setTimeout(function () {
  rain.stop();
  rain.slow();
}, 60*1000);

function Waves() {
  intervalID = [];
  
  this.play = function () {
    if (flag) {
        intervalID[0] = setInterval(function () {
        createWave();
        
      }, 300);
      setTimeout(function () {
        flag == false;
      }, 4000);
    }
    setTimeout(function () {
        intervalID[1] = setInterval(function () {
        createWave();
      }, 50);
    }, 5000);
  }
  
  this.stop = function () {
    for(var i = 0; i<intervalID.length; i++){
      window.clearInterval(intervalID[i]);
    }
  }
  
  this.slow = function () {
    var audio = new Audio("../sound/endingStorm.mp3");
    var endingStorm = new Sound(audio);
    endingStorm.play();
    endingStorm.volume(0.01);
    backgroundSound.slowDown();
    intervalID[2] = setInterval(function () {
        createWave();
      }, 300);
  }
}

function Sound(audioObj){
  this.play = function () {
    audioObj.play();
  }
  this.stop = function () {
    audioObj.pause();
  }
  this.volume = function (val) {
    audioObj.volume = val;
  }
  this.loop = function (stat) {
    audioObj.loop = stat;
  }
  this.slowDown = function () {
    for(var i = 100; i>0; i--){
      setTimeout(function () {
        audioObj.volume = parseFloat(0.0+""+i);
        console.log('ok');
        audioObj.pause();
      },1000);
    }
  }
}

function createWave() {
  var x = 500 + randomizeInt()[1],
    y = 2000 + randomizeInt()[0]; //Prendo i due numeri random (ma controllati) che ho generato con randomizeInt
  var wave = w.circle(y, x, 0); //Creo l'onda con grandezza 0
  
  wave.attr({
    stroke: "#fafafa",
    "fill-opacity": 0
  }); //Modifico i suoi attributi
  wave.animate({
    r: 50,
    "stroke-opacity": 0
  }, 800); //Lo animo facendolo ingrandire
}

function randomizeInt() {
  var temp = [Math.floor(Math.random() * 3000) + 1, Math.floor(Math.random() * 1000) + 1]; //Genero due numeri random

  //Li controllo
  while (temp[0] >= elementWidth) {
    temp[0] = Math.floor(Math.random() * 3000) + 1;
  }
  while (temp[1] >= elementHeight) {
    temp[1] = Math.floor(Math.random() * 1000) + 1;
  }

  //Restituisco l'array con i numeri
  return (temp);
}

function randomInt() {
  var temp = Math.floor(Math.random() * 10);
  while (temp > dropSoundSource.length) {
    temp = Math.floor(Math.random() * 10);
  }

  return (temp);
}