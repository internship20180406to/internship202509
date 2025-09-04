const submitButton = document.getElementById("submit")
    submitButton.addEventListener('click', (e) => {
    var result = window.confirm('申込しても宜しいですか？')
    if(result){
    }
    else{
        e.preventDefault();
    }
    })