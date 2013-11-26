// Generated by CoffeeScript 1.6.3
var game_modal_template;

$(function() {
  $.stellar({
    horizontalScrolling: false,
    verticalOffset: 40
  });
  $('flippant-back flippant-modal-dark flipper flipped').blurjs({
    source: 'body',
    radius: 5
  });
  return $('.flippable img').on("click", function() {
    var back, gameId;
    back = flippant.flip($(this).get(0), game_modal_template, "modal");
    gameId = $(this).parents('div.flippable').data("id");
    $.getJSON("/game.do?api=true&id=" + gameId, function(data) {
      return console.log(data);
    });
    return $(".close-flippant").on("click", function(e) {
      e.preventDefault();
      return back.close();
    });
  });
});

game_modal_template = "<div class=\"container\">\n<h1>Game Title</h1>\n<hr />\n<p>Description\n</p>\n<button class=\"btn btn-default btn-danger close-flippant\"><span class=\"glyphicon glyphicon-remove\"></span></span>\n</div>";
