// Global Variables
let printBox = document.querySelector(".box-print");

// Função para remover todas as tags dentro da secção box-print
function removeChildrens() {
    if (printBox.children.length > 0) {
        for (let child of printBox.children) {
            printBox.removeChild(child);
        }
        while (printBox.children.length > 0) {
            const first = printBox.firstElementChild;
            printBox.removeChild(first);
        }
    }
}

function isShortsWeather(value) {
    return value > 25;
}

// Recebe dois numeros retorna a multiplicação dos mesmos
function multiply(num1, num2) {
    console.log(num1 * num2);
    return num1 * num2;
}

function sumArray(array) {
    return array.reduce((total, i) => {
        return parseInt(total) + parseInt(i)
    }, 0);
}

// Função que chama o multiply retirando os numeros do form
function formEx4() {
    let firstField = document.getElementById("firstField");
    let secondField = document.getElementById("secondField");

    let result = multiply(firstField.value, secondField.value);
    let spanResult = document.createElement('input')
    spanResult.value = result;
    spanResult.readOnly = true;
    printBox.appendChild(spanResult);
}

// Função que chama o multiply retirando os numeros do form
function formEx5() {
    let tempCelcius = document.getElementById("celcius");
    let spanResult = document.createElement('input')

    if (tempCelcius != null) {
        spanResult.value = isShortsWeather(tempCelcius.value) ? "Esta bom para ir de Calções" : "Não está bom para ir de Calções";

        spanResult.readOnly = true;
        printBox.appendChild(spanResult);
    }
}

function formEx6() {
    let nameUser = document.getElementById("name");
    let spanResult = document.createElement('input')

    if (nameUser != null) {
        spanResult.value = `Olá, ${nameUser.value}!`;

        spanResult.readOnly = true;
        printBox.appendChild(spanResult);
    }
}

function formEx7() {
    let numbersInput = document.getElementById("numbers").trim();
    let spanResult = document.createElement('input')

    if (numbersInput != null) {
        spanResult.value = sumArray(numbersInput.value.split(" "));

        spanResult.readOnly = true;
        printBox.appendChild(spanResult);
    }
}

function addTask() {
    let task = document.getElementById("add-task")
    let listTask = document.getElementById("list-tasks");

    createLi({label: task.value, valueLabel: {type: "button", text: "aprendido"}}, listTask)
}

function createLi(span, ul) {
    let newLi = document.createElement("Li");
    createSpan([{
        text: `${span.label} `, parent: newLi
    }])
    if (span.valueLabel.type === "button") {
        createButton([{
            show: true, id: "button-todo", text: span.valueLabel.text, parent: newLi, onClick: (event) => {
                let spanLi = newLi.getElementsByTagName("span")
                let text = spanLi[0].innerText.includes("APRENDIDO")
                spanLi[0].innerText = `${span.label}: ${(text) ? " " : "- APRENDIDO"}`;
            }
        }])
    }
    ul.appendChild(newLi)
}

function createSpan(arraySpans) {
    arraySpans.forEach(span => {
        let newSpan = document.createElement("span");
        newSpan.innerText = span.text;
        span.parent.appendChild(newSpan);
    })
}

function createUl(arrayUl) {
    let newUl = document.createElement("ul");
    newUl.id = arrayUl.ul.id;
    createSpan([{text: arrayUl.ul.text, parent: arrayUl.parent}]);
    arrayUl.list.forEach(span => {
        createLi(span, newUl)
        arrayUl.parent.appendChild(newUl);
    })
}

function createList(arrayList) {
    if (!arrayList.ul.show) {
        let arrayPrendas = arrayList.list.map(item => {
            return {
                text: `${item.text}`, parent: arrayList.parent
            };
        })
        createSpan(arrayPrendas);
    } else {
        createUl(arrayList);
    }
}

function createForm(info, arrayInput, button) {
    let form = document.createElement('form')
    if (info[0]) {
        let formHeader = document.createElement('span')
        formHeader.innerText = info[1]
        form.appendChild(formHeader)
    }
    arrayInput.forEach(element => {
        let input = document.createElement('input')
        input.placeholder = element.placeholder;
        input.type = 'text';
        input.name = element.name;
        input.id = element.name;
        form.appendChild(input)
    })

    printBox.appendChild(form)
    createButton([{
        show: true, id: "button-2", text: button.text, onClick: button.onClick, parent: printBox,
    }])
}

function createButton(arrayButtons) {
    let divButtons = document.createElement('div')
    divButtons.classList.add('box-buttons');
    arrayButtons.forEach(element => {
        let button = document.createElement('button')
        button.style.visibility = element.show ? "visible" : "hidden";
        button.innerText = element.text;
        button.id = element.id;
        button.addEventListener("click", element.onClick);
        button.classList.add('button-submit');
        divButtons.appendChild(button)
        element.parent.appendChild(divButtons)
    })
}

// --------------------- EXERCICIOS -----------------------

function ex01() {
    removeChildrens();
    let text = "A turma de Web/Mobile é dinâmica e tem as características essenciais para brilhar numa empresa"
    alert(text);

    createSpan([{
        text: "A letra W aparece pela primeira vez na " + text.indexOf("W") + " posição", parent: printBox
    }, {
        text: "A letra M aparece pela primeira vez na " + text.indexOf("M") + " posição", parent: printBox
    }]);
}

function ex02() {
    removeChildrens();
    let prendas = [{text: "boa nota"}, {text: "estagio"}, {text: "telemovel"}];

    createList({ul: {show: false, id: "list-prendas", new: true, text: ""}, list: prendas, parent: printBox});

    createSpan([{
        text: `A lista de prendas tem ${prendas.length} items`, parent: printBox
    }]);
}

function ex03() {
    removeChildrens();
    let produtos = [{label: "perfume", valueLabel: {type: "text", text: 35.99}}, {
        label: "cadeira",
        valueLabel: {type: "text", text: 19.95}
    }, {label: "vestido", valueLabel: {type: "text", text: 15.99}}, {
        label: "lasanha",
        valueLabel: {type: "text", text: 5.39}
    }, {label: "sapatilhas", valueLabel: {type: "text", text: 25.19}},];

    createList({
        ul: {show: true, id: "list-produtos", new: true, text: "Todos os Produtos: "},
        list: produtos,
        parent: printBox
    });

    let produtosFilter = produtos.filter(produto => {
        if (produto.valueLabel.text < 20) {
            return produto;
        }
    })

    createList({
        ul: {show: true, id: "list-produtos-filtered", new: true, text: "Produtos Filtrados: "},
        list: produtosFilter,
        parent: printBox
    });
}

function ex04() {
    removeChildrens();

    createForm([true, "Insira os numeros para Multiplicar: "], [{
        placeholder: "1 -> Valor",
        name: "firstField"
    }, {placeholder: "2 -> Valor", name: "secondField"}], {text: "Submit", onClick: formEx4, parent: printBox},);
}

function ex05() {
    removeChildrens();

    createForm([true, "Insira a temperatura: "], [{placeholder: "Celcius ->", name: "celcius"}], {
        text: "Submit",
        onClick: formEx5
    });
}

function ex06() {
    removeChildrens();

    createForm([false, ""], [{placeholder: "Nome ->", name: "name"}], {
        text: "Diz-me o teu nome e dir-te-ei olá",
        onClick: formEx6
    });
}

function ex07() {
    removeChildrens();

    createForm([true, "Indique os numeros que quer somar separados por espaço"], [{
        placeholder: "Numeros ->",
        name: "numbers"
    }], {text: "Submit", onClick: formEx7});
}

function ex08() {
    removeChildrens();

    createButton([{
        show: true, id: "button-1", text: "Botão 1", parent: printBox, onClick: (event) => {
            let hex = (Math.random() * 0xfffff * 1000000).toString(16);
            event.target.style.background = '#' + hex.slice(0, 6);
        }
    }, {
        show: true, id: "button-2", text: "Botão 2", parent: printBox, onClick: (event) => {
            let hex = (Math.random() * 0xfffff * 1000000).toString(16);
            event.target.style.background = '#' + hex.slice(0, 6);
        }
    }, {
        show: true, id: "button-3", text: "Botão 3", parent: printBox, onClick: (event) => {
            let hex = (Math.random() * 0xfffff * 1000000).toString(16);
            event.target.style.background = '#' + hex.slice(0, 6);
        }
    }]);
}

function ex09() {
    removeChildrens();

    createButton([{
        id: "button", show: true, text: "Click", parent: printBox, onClick: (event) => {
            let paragraph = document.createElement('p')
            let increse = document.getElementById('button-increse')
            increse.style.visibility = "visible";
            let deincrese = document.getElementById('button-deincrese')
            deincrese.style.visibility = "visible";
            paragraph.id = "paragraph-ex"
            paragraph.innerText = "É só mais um!"
            printBox.appendChild(paragraph);
        }
    }, {
        id: "button-increse", show: false, text: "+ Font Size", parent: printBox, onClick: (event) => {
            let paragraph = document.querySelectorAll('#paragraph-ex')
            paragraph.forEach(p => {
                let oldSize = parseInt(p.style.fontSize.replace("px", ""))
                p.style.textAlign = "center"
                if (isNaN(oldSize)) {
                    p.style.fontSize = "17px";
                } else {
                    p.style.fontSize = `${oldSize + 1}px`;
                }
            })
        }
    }, {
        id: "button-deincrese", show: false, text: "- Font Size", parent: printBox, onClick: (event) => {
            let paragraph = document.querySelectorAll('#paragraph-ex')
            paragraph.forEach(p => {
                let oldSize = parseInt(p.style.fontSize.replace("px", ""))
                p.style.textAlign = "right"
                if (isNaN(oldSize)) {
                    p.style.fontSize = "15px";
                } else {
                    p.style.fontSize = `${oldSize - 1}px`;
                }
            })
        }
    }]);
}

function ex12() {
    removeChildrens();
    let itemsList = [{label: "Lógica de Código JS", valueLabel: {type: "button", text: "aprendido"}}, {
        label: "Funções",
        valueLabel: {type: "button", text: "aprendido"}
    }, {label: "DOM", valueLabel: {type: "button", text: "aprendido"}}, {
        label: "Eventos",
        valueLabel: {type: "button", text: "aprendido"}
    }];
    createList({
        ul: {show: true, id: "list-tasks", new: true, text: "Para Aprender em : "}, list: itemsList, parent: printBox
    })
    createForm([true, "Adicionar A Lista"], [{placeholder: "Objetivo ->", name: "add-task"}], {
        text: "Submit",
        onClick: addTask
    });
}