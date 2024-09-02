var coll = document.getElementsByClassName("collapsible"); /* For more information on the collapsible: https: //www.w3schools.com/howto/howto_js_collapsible.asp*/
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}