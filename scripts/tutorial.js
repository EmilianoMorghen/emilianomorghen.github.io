tutorial = {
    tips : {},
    tip : {},
    timer : {},
    filler : {},
    revealing : false,
    hiding : false,
    queueReveal : [],
    idTBR : [],
    msgs : [
        ["Nice to see you", false],
        ["You can still click on every link", false],
        ["Sometimes things break", false],
        ["Too many items? Drag them to the bin", false],
        ["Sometimes we just need some empty space", false]
    ],
    animationEvent : "animationend",
    whichAnimationEvent : () => {
        var t,
            el = document.createElement("fakeelement");
      
        var animations = {
            "animation"      : "animationend",
            "OAnimation"     : "oAnimationEnd",
            "MozAnimation"   : "animationend",
            "WebkitAnimation": "webkitAnimationEnd"
        }
      
        for (t in animations){
            if (el.style[t] !== undefined){
                return animations[t];
            }
        }
    },
    wordsHide : () => {
        var toBeHidden = tutorial.tip.children("span");
        var i = 0;
        var hiding = window.setInterval(() => {

            if(i<toBeHidden.length){
                toBeHidden[i].classList.add('hide');
                toBeHidden[i].classList.remove('reveal');
                i++;
            }else{
                tutorial.timer.classList.remove('reveal');
                tutorial.timer.classList.add('hide');

                tutorial.timer.addEventListener(tutorial.animationEvent, () => {
                    i = 0;

                    tutorial.filler.classList.remove("fill");
                    tutorial.filler.classList.add("empty");

                    window.clearInterval(hiding);
                    tutorial.hiding = false;
                    tutorial.revealing = false;
                });
            }
            }, 150);
    },
    wordsReveal : (next) => {

        if(tutorial.msgs[next][1] === false)
        {
            var html = "";
            msg = tutorial.msgs[next][0].split(" ");

            tutorial.msgs[next][1] = true;

            msg.forEach((element, i) => {
                if(i--<msg.length)
                    html += "<span>"+element+"&nbsp</span>";
                else
                    html += "<span>"+element+"</span>";
            });

            tutorial.timer.classList.remove('hide');
            tutorial.timer.classList.add('reveal');
            tutorial.tip.html(html);

            var toBeRevealed = tutorial.tip.children("span");
            var i = 0;
            var revealing = window.setInterval(() => {

                tutorial.revealing = true;

                if(i<toBeRevealed.length){
                    toBeRevealed[i].classList.add('reveal');
                    i++;
                }else{
                    tutorial.filler.classList.remove('empty');
                    tutorial.filler.classList.add('fill');
                    tutorial.wordsHide(tutorial.tip);
                    i = 0;
                    window.clearInterval(revealing);
                    tutorial.hiding = true;
                    tutorial.revealing = false;
                }
            }, 150);
        }
        
    },
    reveal : (next) => {
        let flag = false;

        if(!(tutorial.revealing) && !(tutorial.hiding)){
            tutorial.wordsReveal(next);
        }

        else {
            tutorial.idTBR.forEach((e) => {
                if(e == next) flag = true;
            });
    
            if (flag === false) {
    
                tutorial.idTBR.push(next);
                tutorial.queueReveal.push(
                    setInterval(() => {
                        if(!(tutorial.revealing) && !(tutorial.hiding)){
                            tutorial.wordsReveal(tutorial.idTBR[0]);
                            tutorial.idTBR.splice(0, 1);
                            clearInterval(tutorial.queueReveal[0]);
                            tutorial.queueReveal.splice(0, 1);
                        }
                    }, 100)
                );
            }
        }
        
    },
    init : () => {
        tutorial.animationEvent = tutorial.whichAnimationEvent();

        tutorial.timer = document.getElementById("timer");
        tutorial.filler = document.getElementById('filler');
        tutorial.tip = $('#tip');

        tutorial.reveal(0);

        var mousemoved = false;
        window.addEventListener('mousemove', () => {
            if(!(mousemoved)) {
                tutorial.reveal(1);
                mousemoved = true;
            }
        });
    }
}