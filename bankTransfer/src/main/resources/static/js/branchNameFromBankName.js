window.onload = function() {
    const bank = document.getElementById("bank");
    const branch = document.getElementById("branch");

    bank.onchange = changeBank;
}

function changeBank() {
    const scriptTag = document.getElementById("bank-branch-script");
    const bbScript = scriptTag.dataset.mapBB;
    const bankBranches = JSON.parse(bbScript);
    console.log(bankBranches);
    var changedBank = bank.value;
    branch.textContent = null;
    for (const [key, value] of Object.entries(bankBranches)) {
        if(changedBank == key) {
            value.forEach(function(value) {
                var op = document.createElement("option");
                op.value = value;
                op.text = value;
                branch.appendChild(op);
            });
        }
    }
}
