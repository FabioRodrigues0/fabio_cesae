// const word = "Stakeboard"
// console.log(word.length)
// let facialHair = word.slice(word.indexOf("board"));
// facialHair = facialHair.replace("o", "e");
// console.log(facialHair);

// let myName = prompt('Qual o seu nome?');
// console.log(myName);

// let diaSemana = prompt('Qual o dia da Semana?').toLocaleLowerCase();

// switch (diaSemana) {
//     case "sexta":
//         console.log("yay, sobrivevemos a mais uma semana")
//         break;
//     default:
//         console.log("Está quase...")
//         break;
// }

// let password = prompt('Indique a sua password?');

// if (password.length < 6) {
//     console.log("Password Invalida")
// }
// else {
//     console.log("Password Inserida")
// }

// let planets = ['Mercurio', 'Vénus', 'Terra', 'Mart', 'Jupiter', 'Saturno', 'Urano', 'Neptuno', 'Plutão']

// console.log(planets);

// planets[3] = 'Marte';

// console.log(planets);

// planets.pop()

// console.log(planets);

// newPlanet = prompt("Indique o nome do novo Planeta");

// planets.unshift(newPlanet)

// console.log(planets);

// const airplaneSeats = [
//     ['Ruth', 'Anthony', 'Stevie'],
//     ['Amelia', 'Pedro', 'Maya'],
//     ['Xavier', 'Ananya', 'Luis'],
//     ['Luke', null, 'Deniz'],
//     ['Rin', 'Sakura', 'Francisco']
// ];

// console.log(airplaneSeats);

// airplaneSeats[3][1] = "Fábio Rodrigues"

// console.log(airplaneSeats);

// let JS = {
//     avaliação : "Teste",
//     formador : "Sara monteiro",
//     sala : 6,
//     horas : 50,
//     ferias : true,
// }

// console.log("A avaliação é " + JS.avaliação);
// console.log("A formadora é " + JS.formador);

// let product = {
//     name: "morango",
//     quantity: 100,
//     price: 1.99,
//     colors: ["vermelho", "verde", "preto"]
// }

// console.log(product.price)

// console.log(product.colors[product.colors.indexOf("verde")])

// product.price = 2.55

// console.log(product)


const people = ["Scooby", "Velma", "Daphne", "Shaggy", "Fred"];
for (const element of people) {
    console.log(element.toUpperCase())
}