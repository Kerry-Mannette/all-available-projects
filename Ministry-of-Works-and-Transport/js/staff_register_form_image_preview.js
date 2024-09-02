const chooseFile = document.getElementById("uimage"); /*For more information on image preview: https://w3collective.com/preview-selected-img-file-input-js/*/
const imgPreview = document.getElementById("img-preview");


chooseFile.addEventListener("change", function () {
  getImgData();
});



function getImgData() {
  const files = chooseFile.files[0];
  if (files) {
    const fileReader = new FileReader();
    fileReader.readAsDataURL(files);
    fileReader.addEventListener("load", function () {
      profile_image_before.innerHTML = "";
      imgPreview.style.display = "block";
      imgPreview.innerHTML = '<img src="' + this.result + '" />';
    });    
  }
}