// Generated by CoffeeScript 1.3.3
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
    var back;
    back = flippant.flip($(this).get(0), game_modal_template, "modal");
    return $(".close-flippant").on("click", function(e) {
      e.preventDefault();
      return back.close();
    });
  });
});

game_modal_template = "<div class=\"container\">\n<h1>Game Title</h1>\n<hr />\n<p>\nInteger porta nulla eget enim tincidunt, in suscipit velit ultrices. Morbi at massa ligula. Cras scelerisque molestie eros sit amet scelerisque. Cras tempus accumsan vestibulum. Nullam congue vestibulum justo, sed tempus felis ornare id. Sed tristique et justo non molestie. Aliquam libero dui, rutrum quis interdum a, facilisis posuere diam. Nam sit amet sapien enim. Morbi viverra laoreet magna, sit amet interdum ligula suscipit et. Nunc molestie nisi vitae orci mattis laoreet. Praesent rutrum nibh vel orci commodo, a dapibus magna blandit. Vivamus tincidunt quam dolor, vitae pellentesque felis dignissim vel. Ut placerat rutrum dui, id fermentum nibh vehicula ut. Cras accumsan tellus in nisi rutrum, eget placerat diam adipiscing.\n</p>\n<p>\nSuspendisse eget dolor elit. Pellentesque congue ante vel mattis auctor. Suspendisse mollis nisl sem. Donec placerat sed turpis eget rutrum. In eu felis et leo semper aliquet. Proin id ante venenatis lectus interdum elementum. Etiam nec libero nunc.\n</p>\n<button class=\"btn btn-default btn-danger close-flippant\"><span class=\"glyphicon glyphicon-remove\"></span></span>\n</div>";
