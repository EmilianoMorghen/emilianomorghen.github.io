var scroll = {
  init : function () {
    $('[data-scroll]').click(function(){
      scroll.scroll($(this));
    });
  },
  scroll : function ($ele) {
    var target = $ele.data('target'),
        offset = $(target).offset().top;
    $('html, body').stop().animate({
      'scrollTop': offset - 20
    }, 900, 'swing');
  }
}
