const fullNames = [
    {first: 'Albus', last: 'Dumbledore'},
    {first: 'Harry', last: 'Potter'},
    {first: 'Hermione', last: 'Granger'},
    {first: 'Ron', last: 'Weasley'},
    {first: 'Rubeus', last: 'Hagrid'},
    {first: 'Minerva', last: 'McGonagall'},
    {first: 'Severus', last: 'Snape'}
];

function shoppingList() {
    let cart = [];
    let text = '';

    while (text !== "codigo") {
        text = prompt("Indique um produto que deixa adicionar ao carrinho");
        cart.push(text);
    }
    cart.pop()
    console.log(cart);
}

function rant(text) {
    for (let i = 1; i < 4; i++) {
        console.log(i, text.toUpperCase());
    }
}

function greet() {
    console.log(fullNames)
    var name = prompt("Indique o Nome de quem quer apresentar").toLowerCase()
    var found = fullNames.find((element) => element.first.toLowerCase() === name);
    console.log(`O primeiro ${found.first} ${found.last}`);
}

function validUserName(arrayNames) {
    const validNames = arrayNames.filter(name => name.length < 10);
    console.log(validNames);
}

function allEvens(arrayNumbers) {
    const isValid = arrayNumbers.every(number => (number % 2) === 1);
    console.log(isValid);
}