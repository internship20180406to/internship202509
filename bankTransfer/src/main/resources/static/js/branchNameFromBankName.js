window.onload = function() {
    bank = document.getElementById("bank");
    branch = document.getElementById("branch");
    const currentScript = document.currentScript;
    const bankBranch = currentScript.dataset.mapBB;
    const keys = map.keys(bankBranch);

    bank.onchange = changeBank;
}

function changeBank() {
    var changedBank = bank.value;
    branch.textContent = null;
    for (const getBankName of keys) {
        if(changedBank == getBankName) {
            var branchNames = bankBranch.get(getBankName);
            for (const branchName of branchNames) {
                const op = document.createElement("option");
                op.value = branchName;
                op.text = branchName;
                document.getElementById("branchSelect").appendChild(op);
            }
        }
    }
}



