const submitButton = document.getElementById("submit")
    submitButton.addEventListener('click', (e) => {
//    ダイヤログ表示するためのデータ取得
//    https://qiita.com/hemmhemm/items/1e07d20c330fe8ce53c7
        const bankName = document.getElementById("bankName").value;
        const shopName = document.getElementById("ShopName").value;
        const subject = document.getElementById("Subject").value;
        const bankAccountNum = document.getElementById("bankAccountNum").value;
        const purchaser = document.getElementById("Purchaser").value;
        const brandName = document.getElementById("BrandName").value;
        const amount = document.getElementById("amount").value;

//    文字列に変数埋め込み
//    https://developer.mozilla.org/ja/docs/Learn_web_development/Core/Scripting/Strings
        const message = `
        以下の内容で申込をしてもよろしいですか？
        金融機関名: ${bankName}
        支店名: ${shopName}
        科目名: ${subject}
        口座番号: ${bankAccountNum}
        購入者: ${purchaser}
        銘柄名: ${brandName}
        購入金額: ${amount}
            `;
//      console.log(confirm(message))
        var result = window.confirm(message)

//      最終確認ダイヤログでOKが押されたとき
        if(result){
            window.alert("申込を確認しました")
        }
//      最終確認ダイヤログでキャンセルが押されたとき
        else{
//        ページ遷移阻止
//        https://kasumiblog.org/html-form-preventdefault
            event.preventDefault();
            window.alert("申込がキャンセルされました");

        }
    })

