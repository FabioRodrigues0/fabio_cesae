function showBanner() {
    let bannerSelection = document.getElementById("banner");
    console.log(bannerSelection);
}

function getImageH1() {
    let image = document.getElementById("unicorn");
    let heading = document.getElementById("mainheading");

    console.log(image);
    console.log(heading);
}

function showDoneCheck() {
    let doneTodos = document.querySelectorAll(".done")
    let checkbox = document.querySelector("input[type='checkbox']:checked");

    doneTodos.forEach((dones) => console.log(dones))
    console.log(checkbox);
}

function doYack() {
    let span = document.querySelector("span");

    span.innerText = "Yack";
}

function changeImage() {
    let img = document.querySelector("img");
    img.src = `https://devsprouthosting.com/images/${(img.src.includes("egg")) ? "chicken.jpg" : "egg.jpg"}`;
}

function changeForest() {
    let container = document.querySelector("#container");
    container.style.textAlign = "center";
    let container_image = container.querySelector("img")
    container_image.style.width = "150px";
    container_image.style.borderRadius = "50%";
}

function createRainbow() {
    const colors = ["red", "orange", "yellow", "green", "blue", "indigo", "violet"];
    let spans = document.querySelectorAll("span");

    spans.forEach((span, index) => {
        span.style.color = colors[index];
    });
}

function randomNumber() {
    return Math.floor(Math.random() * 256);
}

function gerarCor() {
    return `rgb(${randomNumber()}, ${randomNumber()}, ${randomNumber()})`
}

function addEvents() {
    let btn_hello = document.querySelector("#hello");
    let btn_goodbye = document.querySelector("#goodbye");
    let btn_change_color = document.getElementById("change-color");

    let paragrafo = document.querySelector("#new-color");

    btn_hello.addEventListener('mouseover', function () {
        alert('Olá');
    });
    btn_goodbye.addEventListener('mouseover', function () {
        alert('Adeus!')
    });
    btn_change_color.addEventListener('click', function (event) {
        let container = document.querySelector("#container");
        let cor = gerarCor()
        paragrafo.innerText = cor
        container.style.backgroundColor = cor
    })

function formData() {
    let button = document.querySelector("#button-submit");
    button.addEventListener("click", (event) => {
        event.preventDefault();
        let product = document.querySelector("#text-product");
        let qnt = document.querySelector("#text-quantidadew");

        let li = document.createElement('li')
        let span = document.createElement('span')

        span.innerHTML = `${product.value}: ${qnt.value}`;
        li.appendChild(span);

        let ul = document.querySelector("#list-products");
        ul.appendChild(li);
        product.value = "";
        qnt.value = "";
    });
}