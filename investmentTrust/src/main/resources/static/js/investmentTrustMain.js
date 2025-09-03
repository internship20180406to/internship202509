const bankSelect = document.getElementById('bankSelect');
const branchSelect = document.getElementById('branchSelect');

bankSelect.addEventListener('change', function() {
    const selectedBank = this.value;
    branchSelect.innerHTML = '<option value="">読み込み中...</option>';

    if (selectedBank) {
        fetch(`/getBranches?bankName=${encodeURIComponent(selectedBank)}`)
            .then(response => response.json())
            .then(branches => {
                branchSelect.innerHTML = '<option value="">選択してください</option>';

                branches.forEach(branch => {
                    const option = document.createElement('option');
                    option.value = branch;
                    option.textContent = branch;
                    branchSelect.appendChild(option);
                });
            })
            .catch(error => {
                console.error('Error:', error);
                branchSelect.innerHTML = '<option value="">エラーが発生しました</option>';
            });
    } else {
        branchSelect.innerHTML = '<option value="">金融機関を選択してください</option>';
    }
});