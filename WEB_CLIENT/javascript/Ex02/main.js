let numerosArray = new Array()
let numerosString = " "

function numeroPare() {
    // variaveis
    let inicio = parseInt(document.getElementById("inputBegin").value)
    let fim = parseInt(document.getElementById("inputEnd").value)

    let numerosPares = new Array()

    for (let index = inicio; index < fim; index++) {
        if (index % 2 === 0) {
            // numerosPares.push(index)
            numerosString += index + " "
        }
    }
    document.getElementById("textoNumerosPares").innerText = "Os numeros pares são: " + numerosString
}

function numeroImpares() {
    // variaveis
    let inicio = parseInt(document.getElementById("inputBegin").value)
    let fim = parseInt(document.getElementById("inputEnd").value)

    let numerosPares = new Array()

    for (let index = inicio; index < fim; index++) {
        if (index % 2 !== 0) {
            // numerosPares.push(index)
            numerosString += index + " "
        }
    }
    document.getElementById("textoNumerosPares").innerText = "Os numeros pares são: " + numerosString
}

function numeroFibonacci() {
    // variaveis
    let inicio = parseInt(document.getElementById("inputBegin").value)
    let fim = parseInt(document.getElementById("inputEnd").value)
    let contador = 0
    numerosString = " "

    if (inicio === 0) {
        alert("Deve inserir um numero inteiro.")
    }
    let a = 0, b = 1, nth

    while (contador <= inicio) {
        if (a <= fim) {
            numerosString += a + " "
            numerosArray.push(a)

            nth = a + b
            a = b
            b = nth
        }
        contador++
    }
    // document.getElementById("textoNumerosPares").innerText = "Os numeros pares são: " + numerosString


    document.getElementById("num1").innerText = numerosArray[8]
    document.getElementById("num2").innerText = numerosArray[7]
    document.getElementById("num3").innerText = numerosArray[6]
    document.getElementById("num4").innerText = numerosArray[5]
    document.getElementById("num5").innerText = numerosArray[4]
    document.getElementById("num6").innerText = numerosArray[3]
    document.getElementById("num7").innerText = numerosArray[2]
    document.getElementById("num8").innerText = numerosArray[1]
    document.getElementById("num9").innerText = numerosArray[0]


}