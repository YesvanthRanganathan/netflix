let accordian = document.getElementsByClassName("FAQ_title");

for(var i=0;i<accordian.length;i++)
{
    accordian[i].addEventListener("click",function(){
        if(this.childNodes[1].classList.contains("fa-plus"))
        {
            this.childNodes[1].classList.remove("fa-plus");
            this.childNodes[1].classList.add("fa-times");
        }
        else{
            this.childNodes[1].classList.remove("fa-times");
            this.childNodes[1].classList.add("fa-plus");
        }

        let content = this.nextElementSibling;

        if(content.style.maxHeight)/*nan max-height 0 than kudthu erkan so false agidum */
        {
            content.style.maxHeight = null;
        }
        else{
            content.style.maxHeight = content.scrollHeight+"px"
        }
    })
}

//for that anchor link
document.getElementById('learn-more').addEventListener('click', function(event) {
    event.preventDefault(); // Prevent the default link behavior
    var hiddenPara = this.nextElementSibling;
    if (hiddenPara.style.display === 'none' || hiddenPara.style.display === '') {
        hiddenPara.style.display = 'block';
    } else {
        hiddenPara.style.display = 'none';
    }
});