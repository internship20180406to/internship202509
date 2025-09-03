const branchData = {
    '山陰共同銀行': ['山支店', '陰支店', '北支店'],
    '山陽共同銀行': ['陽支店', '南支店', '西支店'],
    '山中共同銀行': ['川支店', '中支店', '東支店']
};

const bankSelect = document.getElementById('bankSelect');
const branchSelect = document.getElementById('branchSelect');

bankSelect.addEventListener('change', function() {
    const selectedBank = this.value;

    branchSelect.innerHTML = '<option value="">選択してください</option>';

    if (selectedBank && branchData[selectedBank]) {
        branchData[selectedBank].forEach(function(branch) {
            const option = document.createElement('option');
            option.value = branch;
            option.textContent = branch;
            branchSelect.appendChild(option);
        });
    }
});