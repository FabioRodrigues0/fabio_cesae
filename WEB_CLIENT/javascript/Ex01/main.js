

// Criar uma função para calcular
function calcular(params) {
    // Variavel Valor A
    let valorA = parseInt(document.getElementById("inputValorA").value)  // -> "10"

    // Variavel Valor B
    let valorB = parseInt(document.getElementById("inputValorB").value)  // -> "10"

    // Variavel Resultado
    let resultado = operacao(valorA, valorB)

    document.getElementById("textoResultado").innerHTML = resultado
}

// Função para determinar qual operaçao a executar
function operacao(valorA, valorB) {
    // Opção da Operação
    let opcao = document.getElementById("inputOperacao").value

    // Calcular o Resultado
    if (opcao === "+") {
        return "O resultado é " + (valorA + valorB)
    }
    if (opcao === "-") {
        return "O resultado é " + (valorA - valorB)
    }
    if (opcao === "*") {
        return "O resultado é " + (valorA * valorB)
    }
    if (opcao === "/" && (valorA > 0 || valorB > 0)) {
        return "O resultado é " + (valorA / valorB)
    } else {
        return "O numero " + valorA + " nao pode ser dividido por " + valorB
    }
}

