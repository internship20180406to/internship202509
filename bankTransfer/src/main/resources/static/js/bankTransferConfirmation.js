const submitButton = document.getElementById("submit")
    submitButton.addEventListener('click', (e) => {
     var result = confirm('ボタンをクリック！');
    if(result){
    }
    else{
        e.preventDefault() ;
    }

}