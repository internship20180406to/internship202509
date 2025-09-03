<!--    const bankoptions = [-->
<!--        "N銀行", "E銀行", "W銀行", "S銀行"-->
<!--    ]-->

const shopoptions = {
        "N銀行": ["N1支店", "N2支店", "N3支店", "N4支店"],
        "E銀行": ["E1支店", "E2支店", "E3支店", "E4支店"],
        "W銀行": ["W1支店", "W2支店", "W3支店", "W4支店"],
        "S銀行": ["S1支店", "S2支店", "S3支店", "S4支店"],
    };

<!--    const selectbankName = document.getElementById('bank');-->
<!--          selectbankName.innerHTML = '<option disabled selected>金融機関名を選択してください</option>';-->
<!--          selectbankName.disabled = false;-->

<!--          bankoptions.forEach((bank) => {-->
<!--            const option = document.createElement('option');-->
<!--            option.value = bank;-->
<!--            option.innerHTML = bank;-->
<!--            selectbankName.appendChild(option);-->
<!--          });-->
<!--        }-->

const setShopOptions = function(selectedbank){
      const selectshopName = document.getElementById('shop-name');


      selectshopName.innerHTML = '<option disabled selected>支店名を選択してください</option>';
      selectshopName.disabled = false;

      shopoptions[selectedbank].forEach((shop) => {
        const option = document.createElement('option');
        option.value = shop;
        option.innerHTML = shop;
        selectshopName.appendChild(option);
      });

    }

const bankSelect = document.getElementById("bank");
    bankSelect.addEventListener('change', (e) => {

    setShopOptions(e.target.value);
    })



const confirmButton = document.getElementById("confirm")
confirmButton.addEventListener('click', (e) => {
//    ダイヤログ表示するためのデータ取得
//    https://qiita.com/hemmhemm/items/1e07d20c330fe8ce53c7
        const bankName = document.getElementById("bank").value;
        const shopName = document.getElementById("shop-name").value;
        const subject = document.getElementById("Subject").value;
        const bankAccountNum = document.getElementById("bankAccountNum").value;
        const purchaser = document.getElementById("Purchaser").value;
        const brandName = document.getElementById("BrandName").value;
        const amount = document.getElementById("amount").value;

        console.log(bankName, shopName, subject, bankAccountNum, purchaser, brandName, amount)

//    console.log(typeof(bankName), typeof(shopName), typeof(subject), typeof(bankAccountNum), typeof(purchaser), typeof(brandName), typeof(amount))
//    全部string型

//    文字列に変数埋め込み
//    https://developer.mozilla.org/ja/docs/Learn_web_development/Core/Scripting/Strings
//       if( bankName === null || bankName === "" || shopName === null || shopName === ""
//        || Subject === null || Subject === "" || bankAccountNum === null || bankAccountNum === ""
//        || Purchaser === null || Purchaser === "" || BrandName === null || BrandName === ""
//        || amount === null || amount === "" ){
//            window.alert("空欄が存在します")
//            e.preventDefault();
//        }
//       if(amount <= 0){
//            window.alert("入力する金額は0以上")
//            e.preventDefault();
//       }
//       if( String(bankAccountNum).length != 7){
//            window.alert("口座番号は7桁")
//            e.preventDefault();
//       }
       }
       )

