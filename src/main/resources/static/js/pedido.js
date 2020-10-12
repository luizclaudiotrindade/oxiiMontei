var itemList = [];

$(":checkbox").click(function (){
  var colorID = $(this).attr("id");
  var colorBox = $(".color-" + colorID);
  var compareSumm = $("#compare-summary");
  var compareBox = $("#compare-corral");

  if (itemList.indexOf(colorID) < 0){
    itemList.push(colorID);
    colorBox.clone().hide().appendTo(compareBox).fadeIn(500);
  } else {
    itemList.splice(itemList.indexOf(colorID), 1);
    
    if (itemList.length == 0){
      compareSumm.addClass("hide");
    }
    
    compareBox.find(".color-" + colorID).remove();
  }
  
  if (itemList.length > 0){
    compareSumm.removeClass("hide");
  } else {
    compareSumm.addClass("hide");
  }
});

$("#clear").click(function(){
  itemList.length = 0;
  $("#compare-summary").addClass("hide");
  $("#compare-corral").empty(); 
  $(":checkbox").each(function(){
    this.checked = false;
  });
});