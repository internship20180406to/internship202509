const submitButton = document.getElementById("submit")
    submitButton.addEventListener('click', (e) => {
      if (!confirm('操作を実行しますか？')) {
          e.preventDefault();
          e.stopPropagation();
        }
    })
