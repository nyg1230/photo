import Ajax from "../../common/Aajx.js";
import BaseComponent from "../base/BaseComponent.js";

export default class SignIn extends BaseComponent {
	static get name() {
		return "sign-in"
	}

	get name() {
		return SignIn.name;
	}

	get template() {
		return `<div>
					test
				</div>`;
	}

	mounted() {
		const ajax = new Ajax();

		const p = {
			path: "/test"
		};
		ajax.get(p).then((d) => {
			console.log(d);
		});
	}
}

customElements.define(SignIn.name, SignIn);