let num1 = 5;
let num2 = '3';
console.log(num1 + num2)

let password = [1234, 'sara1986', 2023]
password.push("soupassword123")
console.log(password);

let userPassword = prompt("Qual é a password?");

if(password.find( p => p === userPassword || p === parseInt(userPassword) )){
    console.log("Password Correta");
}else {
    console.log("Password Incorreta");
}


let safePasses = password.filter(p =>p.length >= 6);
console.log(safePasses);

const studentGrades = [
    {
        'studentName': 'Rita',
        'grade': 16,
        nameAndGrade(){
            return `A ${this.studentName} tem nota ${this.grade}`;
        }
    },
    {
        'studentName': 'Luis',
        'grade': 20,
    },
    {
        'studentName': 'João',
        'grade': 18,
    },
    {
        'studentName': 'André',
        'grade': 15,
    },
    {
        'studentName': 'Luísa',
        'grade': 19,
    }
]

studentGrades.map( student => {
    console.log(`A nota de ${student.studentName} éS ${student.grade}`);
})

let archv = document.querySelector('.achievements')
archv.innerHTML = "Os meus ensinamentos para a vida";

let mylist = document.querySelector('#myList');
for (let mylistElement of mylist.children) {
    let temp_text = mylistElement.innerHTML
    mylistElement.innerHTML = temp_text + " - com sucesso!";
}

    let mybutton = document.querySelector('#button-submit');
    mybutton.addEventListener('click', function(e){
        e.preventDefault();
        let newLi = document.createElement('li');
        let newspan = document.createElement('span');
        newspan.innerHTML = document.querySelector('#myItem').value
        newLi.appendChild(newspan);
        mylist.appendChild(newLi);
    })

var data = {
    "name": "TIE bomber",
    "model": "TIE/sa bomber",
    "manufacturer": "Sienar Fleet Systems",
    "cost_in_credits": "unknown",
    "length": "7.8",
    "max_atmosphering_speed": "850",
    "crew": "1",
    "passengers": "0",
    "cargo_capacity": "none",
    "consumables": "2 days",
    "vehicle_class": "space/planetary bomber",
    "pilots": [],
    "films": [
        "https://swapi.dev/api/films/2/",
        "https://swapi.dev/api/films/3/"
    ],
    "created": "2014-12-15T12:33:15.838000Z",
    "edited": "2014-12-20T21:30:21.675000Z",
    "url": "https://swapi.dev/api/vehicles/16/"
}
document.getElementById("json").textContent = JSON.stringify(data, undefined, 2);