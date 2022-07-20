import SignIn from "./component/sign/SignIn.js";

window.onload = () => {
	const body = document.querySelector("body")
	const signIn = new SignIn();
	body.append(signIn);
};