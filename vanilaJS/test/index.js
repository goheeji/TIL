const title = document.querySelector("#title");
const CLCICKED_CLASS = "clicked"; 
function handleClick(){
    // const hasClass = title.classList.contains(CLCICKED_CLASS);
    // if(hasClass){
    //     title.classList.remove(CLCICKED_CLASS);
    // }else{
    //     title.classList.add(CLCICKED_CLASS);
    // }
    title.classList.toggle(CLCICKED_CLASS);
}
function init(){
  title.addEventListener("click", handleClick);
}
init();