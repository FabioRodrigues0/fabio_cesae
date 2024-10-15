let inputNum1 = document.getElementById('num1');
let inputNum2 = document.getElementById('num2');
let operation = document.getElementById('operation');
let result = document.getElementById('result');
let btn = document.getElementById('btn-submit');

btn.addEventListener('click', function(){
    let num1 = parseInt(inputNum1.value);
    let num2 = parseInt(inputNum2.value);
    switch (operation.value) {
        case 'sum':
            result.innerText = `${num1 + num2}`;
            break
        case 'sub':
            result.innerText = `${num1 - num2}`;
            break
        case 'multi':
            result.innerText = `${num1 * num2}`;
            break
        case 'div':
            result.innerText = `${num1 / num2}`;
            break
    }
    inputNum1.value = "";
    inputNum2.value = "";
})