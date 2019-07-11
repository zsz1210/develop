$(function() {showSysinfo();})

function osInfo(ctx) {
  ctx.append("<h3>Operation System</h3>");
  ctx.append($("<div class='os-info'></div>")
      .append($("<table class='table'></table>")
        .append($("<thread></thread>")
          .append("<tr></tr>"))
      .append("<tbody></tbody>")
  ));

  var tr = ctx.find(".os-info .table > thread > tr");
  //tr.append("<th class='shrink-xs'>ID</th>");

  var tby = $("#right-content .os-info .table > tbody");
  tby.append($("<tr></tr>").append("<td>#0001</td>").append("<td class='shrink-xs'>TEST1</td>").append("<td class='shrink-xs shrinkable'>TEST1</td>").append("<td class='shrink-md'>TEST2</td>").append("<td class='shrink-lg'>TEST3</td>"));
  tby.append($("<tr></tr>").append("<td>#0002</td>").append("<td class='shrink-xs'>TEST1</td>").append("<td class='shrink-xs shrinkable'>TEST1</td>").append("<td class='shrink-md'>TEST2</td>").append("<td class='shrink-lg'>TEST3</td>"));
  tby.append($("<tr></tr>").append("<td>#0003</td>").append("<td class='shrink-xs'>TEST1</td>").append("<td class='shrink-xs shrinkable'>TEST1</td>").append("<td class='shrink-md'>TEST2</td>").append("<td class='shrink-lg'>TEST3</td>"));

  options = {
    useZebra: false,
    useObserver: false,
    showToggler: true,
    customToggler: ['<span>+</span>','<span>-</span>']
  };

  $(".table").tableShrinker(options);
}

function showSysinfo() {
  var content = $("#right-content #sysinfo");
  content.empty();
  osInfo(content);
}


