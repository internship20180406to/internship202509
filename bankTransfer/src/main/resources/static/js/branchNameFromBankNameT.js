window.onload = function() {
    bank = document.getElementById("bank");
    branch = document.getElementById("branch");

    bank.onchange = changeBank;
}

function changeBank() {
    var changedBank = bank.value;
    branch.textContent = null;
    if(changedBank == "山陰共同銀行") {
        var bank1 = [
            {cd:"a支店", label:"a支店"},
            {cd:"b支店", label:"b支店"}
        ];
        bank1.forEach(function(value) {
            var op = document.createElement("option");
            op.value = value.cd;
            op.text = value.label;
            branch.appendChild(op);
        });
    } else if (changedBank == "海光共同銀行") {
        var bank1 = [
                {cd:"c支店", label:"c支店"},
                {cd:"d支店", label:"d支店"}
        ];
        bank1.forEach(function(value) {
            var op = document.createElement("option");
            op.value = value.cd;
            op.text = value.label;
            branch.appendChild(op);
        });
    }
}
