function change1() {
	var element = document.querySelector("#" + id1.value);
	element.innerText = content1.value;
}
function change2() {
	var element = document.querySelector("#" + id2.value);
	element.className = style2.value;
}
var count = 0;
function change3() {
	var element = document.createElement(tag3.value);
	element.id = "new" + count.toString();
	count += 1;
	element.innerText = content3.value + " with ID " + element.id + ".";
	newdiv.appendChild(element);
}
function change4() {
	var element = document.querySelector("#" + id4.value);
	var body = document.querySelector("body");
	body.removeChild(element);
}
function change5() {
	var element = document.querySelector("#h5");
	element.style = "animation: animate 3s infinite;"
}

function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	ev.target.appendChild(document.getElementById(data));
}