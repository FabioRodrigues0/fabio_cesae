
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

