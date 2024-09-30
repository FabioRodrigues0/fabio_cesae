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