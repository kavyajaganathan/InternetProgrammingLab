function validate() {
	var name = document.querySelector("#name");
	var dob = document.querySelector("#dob");
	var addr = document.querySelector("#addr");
	var city = document.querySelector("#city");
	var email = document.querySelector("#email");
	var mobile = document.querySelector("#mobile");
	var rating = document.querySelector("#rating");
	var result = document.querySelector("#result");
	var submitbutton = document.getElementById("submitbutton");
	const citys = ["Delhi", "Chennai", "Kolkata", "Mumbai"];

	result.innerHTML = "";

	if(name.value.length > 15 || name.value.match(/[A-Z a-z]+/g)==null || name.value.match(/[A-Z a-z]+/g)[0] != name.value)
	{
		result.innerHTML = "Name should be alphabets/spaces and < 15 length.<br>"
	}

	let o = new Date(dob.value);
	diff = new Date() - o;
	const diffDays = Math.ceil(diff / (1000 * 60 * 60 * 24 * 365)) - 1;
	if(diffDays < 18)
	{
		result.innerHTML = result.innerHTML + "You must be over 18!<br>";
	}

	flag = 0
	citys.forEach((ele) => {
		if(ele === city.value) flag = 1;
	})
	if(flag === 0)
	{
		result.innerHTML = result.innerHTML + "City must be Delhi, Mumbai, Kolkata or Chennai!<br>";
	}

	if(mobile.value.match(/[(]\+91[)][0-9]{10}/g) == null || mobile.value.match(/[(]\+91[)][0-9]{10}/g)[0] != mobile.value)
	{
		result.innerHTML = result.innerHTML + "Follow mobile format (+91)xxxxxxxxxx<br>";
	}

	if(email.value.match(/[a-zA-Z\-_.0-9]+@[a-zA-Z\-_0-9]+[.]+[a-zA-Z\-_0-9.]+/g) == null || email.value.match(/[a-zA-Z\-_.0-9]+@[a-zA-Z\-_0-9]+[.]+[a-zA-Z\-_0-9.]+/g)[0] != email.value)
	{
		result.innerHTML = result.innerHTML + "Enter Valid email!<br>";
	}
	if(rating.value.match(/[1-5]{1}/g).length != 1 && rating.value.match(/[1-5]{1}/g) != rating.value)
	{
		result.innerHTML = result.innerHTML + "Must be 1-5 rating!";
	}
	if(result.innerHTML === "") result.innerHTML = "Success!";
}