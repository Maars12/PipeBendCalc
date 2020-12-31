// var btn = document.createElement("button");
// btn.innerHTML = "Setback(0) and Advance(Arc)";
// btn.setAttribute("class", "p-5 rounded bg-success font-weight-bold h1")
// const pew = new Audio();
// pew.src = "./sounds/pew.mp3";


document.getElementById("btn").addEventListener("click", function () {
    event.preventDefault();
    const bRadius = document.getElementById("bRadius").value;
    const angle = document.getElementById("angle").value;

    document.getElementById("btn2").innerHTML = ("Setback(0)= " + bRadius * Math.tan(angle / "2" * "0.0174532925199432973"))
    document.getElementById("btn3").innerHTML = ("Advance(Arc)= " + "0.01745" * angle * bRadius);
})

function addChar(input, character) {
    if (input.value == null || input.value == "0")
        input.value = character
    else
        input.value += character
}

function cos(form) {
    form.answer.value = Math.cos(form.answer.value);
}

function sin(form) {
    form.answer.value = Math.sin(form.answer.value);
}

function tan(form) {
    form.answer.value = Math.tan(form.answer.value);
}

function sqrt(form) {
    form.answer.value = Math.sqrt(form.answer.value);
}

function ln(form) {
    form.answer.value = Math.log(form.answer.value);
}

function exp(form) {
    form.answer.value = Math.exp(form.answer.value);
}

function deleteChar(input) {
    input.value = input.value.substring(0, input.value.length - 1)
}
var val = 0.0;
function percent(input) {
    val = input.value;
    input.value = input.value + "%";
}

function changeSign(input) {
    if (input.value.substring(0, 1) == "-")
        input.value = input.value.substring(1, input.value.length)
    else
        input.value = "-" + input.value
}

function compute(form) {
    //if (val !== 0.0) {
    // var percent = form.answer.value;  
    // percent = pcent.substring(percent.indexOf("%")+1);
    // form.answer.value = parseFloat(percent)/100 * val;
    //val = 0.0;
    // } else 
    form.answer.value = eval(form.answer.value);
}


function square(form) {
    form.answer.value = eval(form.answer.value) * eval(form.answer.value)
}

function checkNum(str) {
    for (var i = 0; i < str.length; i++) {
        var ch = str.charAt(i);
        if (ch < "0" || ch > "9") {
            if (ch != "/" && ch != "*" && ch != "+" && ch != "-" && ch != "."
                && ch != "(" && ch != ")" && ch != "%") {
                alert("invalid entry!")
                return false
            }
        }
    }
    return true
}