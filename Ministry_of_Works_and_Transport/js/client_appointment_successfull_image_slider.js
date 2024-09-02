var slideIndex = 0;
setTimeout(showSlides, 2500);  /*For more information on Slideshow:  https://www.w3schools.com/howto/howto_js_slideshow.asp, https://www.w3schools.com/jsref/met_document_queryselectorall.asp */
function showSlides() {
  var i;
  const image = document.querySelectorAll("img");
  for (i = 0; i < image.length; i++) {
    image[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > image.length) {
  slideIndex = 1
  }   

  image[slideIndex-1].style.display = "block";  
  
}
showSlides();