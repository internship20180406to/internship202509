const bankSelect = document.getElementById('bankSelect');
const branchSelect = document.getElementById('branchSelect');

bankSelect.addEventListener('change', function() {
    const selectedBank = this.value;
    branchSelect.innerHTML = '<option value="">読み込み中...</option>';

    if (selectedBank) {
        fetch(`getBranches?bankName=${encodeURIComponent(selectedBank)}`)
            .then(response => {
                console.log('レスポンス status:', response.status);

                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(branches => {
                console.log('取得した支店データ:', branches);

                branchSelect.innerHTML = '<option value="">選択してください</option>';

                if (branches && branches.length > 0) {
                    branches.forEach(branch => {
                        const option = document.createElement('option');
                        option.value = branch;
                        option.textContent = branch;
                        branchSelect.appendChild(option);
                    });
                } else {
                    branchSelect.innerHTML = '<option value="">支店が見つかりません</option>';
                }
            })
            .catch(error => {
                console.error('Error:', error);
                branchSelect.innerHTML = '<option value="">エラーが発生しました</option>';
            });
    } else {
        branchSelect.innerHTML = '<option value="">銀行を選択してください</option>';
    }
});