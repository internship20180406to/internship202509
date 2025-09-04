
const confirmationButton = document.getElementById("submitButton")
    confirmationButton.addEventListener('click', (e) => {
        const incomeInput = document.querySelector("[name='borrowingIncome']");
        const loanInput   = document.querySelector("[name='loanAmount']");

        const borrowingIncome = Number(incomeInput.value);
        const loanAmount = Number(loanInput.value);

      if ((borrowingIncome*6) < loanAmount) {
          e.preventDefault();  // ← submitを止める
          alert("借入金額は借入年収の6倍以下の金額にしてください")
        }
    })
