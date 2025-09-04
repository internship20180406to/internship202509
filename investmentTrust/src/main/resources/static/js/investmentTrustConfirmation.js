//const submitButton = document.getElementById("submit")
//    submitButton.addEventListener('click', (e) => {
//  const result = confirm("注文を確定してよろしいでしょうか？"
//        if (!result) {
//          e.preventDefault(); // キャンセル時に送信を止める
//        }
//    })

    const form = document.getElementById("myForm");
    form.addEventListener("submit", function (e) {
      const result = confirm("注文を確定してよろしいでしょうか？");
      if (!result) {
        e.preventDefault();
      }
    });
