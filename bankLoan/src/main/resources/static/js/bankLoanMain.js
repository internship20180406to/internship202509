
    // セレクトボックスの値が変更されたときに呼ばれる関数
        function handlePlaceChange() {
            // セレクトボックスの選択された値を取得
            var selectedBank = document.getElementById("bank").value;
            var selectedBankKinds = document.getElementById("bankKinds").value;
            var selectedHousingKinds = document.getElementById("housingKinds").value;

            // バリデーション処理
            if (selectedBank !== "選択してください" && selectedBankKinds !== "選択してください" && selectedHousingKinds !== "選択してください") {
            　　　　　　　// 「選択してください」以外が選ばれた場合はボタンを有効化
                        document.getElementById("submitButton").disabled = false;
                    } else {
                        // 「選択してください」が選ばれた場合はボタンを無効化
                        document.getElementById("submitButton").disabled = true;
                    }
        }

        function