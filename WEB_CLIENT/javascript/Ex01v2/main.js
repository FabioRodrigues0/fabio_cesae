
// variaveis
let valorA = null
let valorB = null
let comand = null
let operation = null

function botao(tipo, valor) {
    if (tipo === "operacao") {
        operation = valor
    }

    if (tipo === "comand") {
        comand = valor
        command(valorA, valorB, comand, operation)
    }

    if (tipo === "number") {
        if (valorA === null) {
            valorA = parseInt(valor)
            document.getElementById("textResultado").innerHTML = valorA
        } else {
            valorB = parseInt(valor)
            document.getElementById("textResultado").innerHTML = valorB
        }
    }
}

function calc(valorA, valorB, opcao) {
    console.log(valorA, valorB, opcao)
    if (opcao === "+") {
        console.log((valorA + valorB))
        document.getElementById("textResultado").innerHTML = (valorA + valorB)
    }
    if (opcao === "-") {
        document.getElementById("textResultado").innerHTML = (valorA - valorB)
    }
    if (opcao === "*") {
        document.getElementById("textResultado").innerHTML = (valorA * valorB)
    }
    if (opcao === "/") {
        document.getElementById("textResultado").innerHTML = (valorA / valorB)
    }
}

function command(valorA, valorB, comand, operation) {
    if (comand === "result") {
        calc(valorA, valorB, operation)
    }
    if (comand === "clean") {
        document.getElementById("textResultado").innerHTML = 0
        valorA = null
        valorB = null
    }

}

