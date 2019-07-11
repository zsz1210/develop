$(function() {
  $("#fullPage").click(function() {
    $("#rightWrapper").toggleClass("full-page");
    $("#header").toggleClass("full-page");
  });
})

$(function() {
  $("#listView li").click(function () {
    if ( $("#listView li").hasClass("list-item-active") ) {
      $("#listView li").removeClass("list-item-active");
    }
    $(this).addClass("list-item-active");
  });
});

$(function() {
  $("#listView #home").click(function() {
    console.log("home");
    $("#rightWrapper #right-content #home").show();
    $("#rightWrapper #right-content #sysinfo").hide();
  });

  $("#listView #sysinfo").click(function() {
    console.log("sysinfo");
    $("#rightWrapper #right-content #sysinfo").show();
    $("#rightWrapper #right-content #home").hide();
  });
});
