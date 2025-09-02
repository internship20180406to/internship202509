const submitButton = document.getElementById("submit")
    submitButton.addEventListener('click', (e) => {
    var result = window.confirm('送信しても宜しいですか？')
    if(result){
    }
    else{
        e.preventDefault();
    }
    })