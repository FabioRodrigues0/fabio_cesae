
// let bannerSelection = document.getElementById('banner');

// if(bannerSelection){
//     console.log(bannerSelection);
// }


// let image = document.getElementById('unicorn');
// let heading = document.getElementById('mainheading');


// console.log(image)
// console.log(heading)

// let doneTodos = document.querySelectorAll('.done');

// let checkbox = document.querySelector("input[type='checkbox']");


// console.log(doneTodos)
// console.log(checkbox)

// let myTextVar = document.querySelector('a');
//myTextVar.innerText = 'cucu vamos manipular coisas';
//myTextVar.innerHTML = 'cucu vamos manipular coisas e trocar elementos';

// myTextVar.href = 'www.cesaedigital.pt';

// let myVar = document.querySelector('span');
// myVar.innerText = 'yackk';
const colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];


function changeImage(){
    let myImage = document.querySelector('img');

    if(myImage.src === 'https://devsprouthosting.com/images/chicken.jpg'){
        myImage.setAttribute('src', 'https://devsprouthosting.com/images/egg.jpg');
    }else{
        myImage.setAttribute('src', 'https://devsprouthosting.com/images/chicken.jpg');
    }
}

function doRainbow() {
    let spans = document.querySelectorAll('span');
    spans.forEach((span, i) => {
        span.style.color = colors[i];
    })
}

function swapClass() {
    let order = document.querySelectorAll('li');
    order.forEach((element) => {
        element.classList.contains('highlight')
            ? element.classList.remove('highlight')
            : element.classList.add('highlight')
    })
}

function indexMain() {
    let myLiTest = document.querySelector('.tocsection-1');
    console.log(myLiTest.children.item(0));
}

function createButton() {
    let div = document.querySelector('#container');
    for (let i = 0; i < 101 ; i++) {
        let newbutton = document.createElement("button");
        newbutton.innerText = i;
        div.appendChild(newbutton);
    }
}