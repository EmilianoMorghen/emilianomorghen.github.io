var b = Snap("#backgroundSvg");

Snap.load("../emilianomorghen.github.io/img/landscape.svg", function(f){
  b.append(f);
  polygon = f.selectAll("polygon");
  polygon.attr({"fill-opacity": 0});
  polygon.forEach(function(e,i){
    if(!(e.node.id=="backgroundSvg1" || e.node.id=="backgroundSvg" || e.node.id=="backgroundSvg2")){
      setTimeout(function (){
        e.animate({
          "fill-opacity":1
        }, 800, mina.easein);
      },i*50);
    }
  });
  setTimeout(function(){polygon.animate({"fill-opacity":1}, 500, mina.easein);}, (polygon.length-3)*50);
});