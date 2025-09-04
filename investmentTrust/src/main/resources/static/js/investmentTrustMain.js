const bankoptions = ["N銀行", "E銀行", "W銀行", "S銀行"];

const brandOptions = {
  "N銀行": ["N銘柄A", "N銘柄B", "N銘柄C"],
  "E銀行": ["E銘柄A", "E銘柄B"],
  "W銀行": ["W銘柄A", "W銘柄B", "W銘柄C"],
  "S銀行": ["S銘柄A", "S銘柄B"]
};

const shopoptions = {
        "N銀行": ["N1支店", "N2支店", "N3支店", "N4支店"],
        "E銀行": ["E1支店", "E2支店", "E3支店", "E4支店"],
        "W銀行": ["W1支店", "W2支店", "W3支店", "W4支店"],
        "S銀行": ["S1支店", "S2支店", "S3支店", "S4支店"],
    };


const selectbankName = document.getElementById('bank');

// 初期化
selectbankName.innerHTML = ''; // 一旦空にする

// プレースホルダー追加
const placeholder = document.createElement('option');
placeholder.value = '';
placeholder.innerText = '--金融機関名を選択してください--';
//selectbankName.innerHTML = '<option disabled selected>--金融機関名を選択してください--</option>';

placeholder.disabled = true;
placeholder.selected = true;
selectbankName.appendChild(placeholder);

// 銀行名の選択肢追加
bankoptions.forEach((bank) => {
  const option = document.createElement('option');
  option.value = bank;
  option.innerText = bank;
  selectbankName.appendChild(option);
});


const setShopOptions = function(selectedbank){
      const selectshopName = document.getElementById('shop-name');

       // 初期化
//       selectshopName.innerHTML = ''; // 一旦空にする

//        プレースホルダー追加
//       const placeholder = document.createElement('option');
//       placeholder.value = '';
      selectshopName.innerHTML = '<option disabled selected>--支店名を選択してください--</option>';
//        selectshopName.innerText = '--支店名を選択してください--';
      selectshopName.disabled = false;

//      placeholder.disabled = true;
//      placeholder.selected = true;
//      selectshopName.appendChild(placeholder);

      shopoptions[selectedbank].forEach((shop) => {
        const option = document.createElement('option');
        option.value = shop;
        option.innerHTML = shop;
        selectshopName.appendChild(option);
      });

    }

const setBrandOptions = function(selectedBank) {
  const selectBrandName = document.getElementById('BrandName');
  selectBrandName.innerHTML = '<option disabled selected>--銘柄名を選択してください--</option>';
  selectBrandName.disabled = false;

  brandOptions[selectedBank].forEach((brand) => {
    const option = document.createElement('option');
    option.value = brand;
    option.innerText = brand;
    selectBrandName.appendChild(option);
  });
};


const bankSelect = document.getElementById("bank");
    bankSelect.addEventListener('change', (e) => {

    setShopOptions(e.target.value);
    setBrandOptions(e.target.value);
    })

document.addEventListener("DOMContentLoaded", function () {
const bankSelect = document.getElementById("bank");
    const selectedBank = bankSelect.getAttribute("data-selected") || bankSelect.value;

    if (selectedBank) {
        // 支店と銘柄の選択肢を再生成
        setShopOptions(selectedBank);
        setBrandOptions(selectedBank);

        // 選択済みの支店名と銘柄名を復元
        const shopSelect = document.getElementById("shop-name");
        const brandSelect = document.getElementById("BrandName");

        const selectedShop = shopSelect.getAttribute("data-selected");
        const selectedBrand = brandSelect.getAttribute("data-selected");

        if (selectedShop) shopSelect.value = selectedShop;
        if (selectedBrand) brandSelect.value = selectedBrand;

        if (bankSelect.getAttribute("data-selected")) {
                    bankSelect.value = bankSelect.getAttribute("data-selected");
                }
    }

    // クリアボタン押下時の処理
//    const resetBtn = document.querySelector('button[type="reset"]');
//    resetBtn.addEventListener("click", function (e) {
//            // ほんの少し待ってから実行（フォームのreset後に行う）
//            setTimeout(() => {
//                const selectbankName = document.getElementById("bank");
//                const selectshopName = document.getElementById("shop-name");
//                const selectBrandName = document.getElementById("BrandName");
//
//                // 金融機関セレクトを初期化
//                selectbankName.innerHTML = '';
//
//                const placeholder = document.createElement('option');
//                placeholder.value = '';
//                placeholder.innerText = '--金融機関名を選択してください--';
//                placeholder.disabled = true;
//                placeholder.selected = true;
//                selectbankName.appendChild(placeholder);
//
//                bankoptions.forEach((bank) => {
//                    const option = document.createElement('option');
//                    option.value = bank;
//                    option.innerText = bank;
//                    selectbankName.appendChild(option);
//                });
//
//                // 支店・銘柄も初期化
////                selectshopName.innerHTML = '<option disabled selected>--支店名を選択してください--</option>';
//                selectshopName.disabled = true;
//
////                selectBrandName.innerHTML = '<option disabled selected>--銘柄名を選択してください--</option>';
//                selectBrandName.disabled = true;
//
//                // その他項目のエラー表示削除
//                document.querySelectorAll(".error-message").forEach(el => el.remove());
//                document.querySelectorAll(".error-input").forEach(el => el.classList.remove("error-input"));
//            }, 10); // resetの直後に実行させる
//        });

    const form = document.querySelector("form");
    const confirmBtn = document.getElementById("confirm");

    confirmBtn.addEventListener("click", function (e) {
        // 初期化
        document.querySelectorAll(".error-message").forEach(el => el.remove());
        document.querySelectorAll(".error-input").forEach(el => el.classList.remove("error-input"));

        let hasError = false;

        // 各入力欄の取得
        const bankName = document.getElementById("bank");
        const shopName = document.getElementById("shop-name");
        const subject = document.getElementById("Subject");
        const bankAccountNum = document.getElementById("bankAccountNum");
        const purchaser = document.getElementById("Purchaser");
        const brandName = document.getElementById("BrandName");
        const amount = document.getElementById("amount");

        // エラー表示関数
        function showError(input, message) {
            const error = document.createElement("div");
            error.className = "error-message";
            error.innerText = message;
            input.classList.add("error-input");
            input.parentNode.appendChild(error);
            hasError = true;
        }

        // バリデーションチェック
        if (!bankName.value || bankName.selectedIndex === 0) showError(bankName, "金融機関名を選択してください");
        if (!shopName.value || shopName.selectedIndex === 0) showError(shopName, "支店名を選択してください");
        if (!subject.value || subject.selectedIndex === 0) showError(subject, "科目名を選択してください");

        if (!bankAccountNum.value.trim()) {
            showError(bankAccountNum, "口座番号を入力してください");
        } else if (bankAccountNum.value.length !== 7) {
            showError(bankAccountNum, "口座番号は7桁で入力してください");
        }

        if (!purchaser.value.trim()) showError(purchaser, "購入者名を入力してください");
        if (!brandName.value || brandName.selectedIndex === 0 ) showError(brandName, "銘柄を選択してください");

        if (!amount.value.trim()) {
            showError(amount, "購入金額を入力してください");
        } else if (parseInt(amount.value) <= 0) {
            showError(amount, "金額は1以上で入力してください");
        }

        // エラーがあれば送信を止める
        if (hasError) {
            e.preventDefault();
        }
    });
});
document.getElementById("reset").addEventListener("click", function () {
    // 初期化処理をここに書く（上記の内容）
    const resetBtn = document.getElementById("reset");
    resetBtn.addEventListener("click", function (e) {
        e.preventDefault(); // 送信を防ぐ

        // セレクトボックスの初期化
        const bankSelect = document.getElementById("bank");
        const shopSelect = document.getElementById("shop-name");
        const brandSelect = document.getElementById("BrandName");

        // 銀行名を --選択-- に戻す
        bankSelect.value = "";
        shopSelect.innerHTML = '<option value="" disabled selected>--支店名を選択してください--</option>';
        brandSelect.innerHTML = '<option value="" disabled selected>--銘柄名を選択してください--</option>';

        // その他のフィールドも空にする
        document.getElementById("Subject").value = "";
        document.getElementById("bankAccountNum").value = "";
        document.getElementById("Purchaser").value = "";
        document.getElementById("amount").value = "";

        // エラー表示削除
        document.querySelectorAll(".error-message").forEach(el => el.remove());
        document.querySelectorAll(".error-input").forEach(el => el.classList.remove("error-input"));
    });

});



