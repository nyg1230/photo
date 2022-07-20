import StyleUtil from "../../common/util/StyleUtil.js";

export default class BaseComponent extends HTMLElement {
	#root;

	constructor() {
		super();
		console.log(this.name);
	}

	static get name() {
		return "base-component";
	}

	get name() {
		return BaseComponent.name;
	}

	get style() {
		return {};
	}

	get template() {
		return ``;
	}

	get #template() {
		return `<template id=${this.name}>
					<style>
						${StyleUtil.obj2css(this.style)}
					</style>
					${this.template}
				</template>`
	}

	get root() {
		return this.#root;
	}

	#init() {}

	#beforeRender() {
		this.beforeRender();
	}

	beforeRender() {}

	#afterRender() {
		this.afterRender();
	}

	afterRender() {}

	#render() {
		this.#root = this.attachShadow({mode: "open"});
		this.innerHTML = this.#template;
		const tmpl = this.querySelector(`#${this.name}`);
		const node = document.importNode(tmpl.content, true);
		this.#root.appendChild(node);
		this.innerHTML = "";
	}

	mounted() {}

	connectedCallback() {
		this.#beforeRender();
		this.#render();
		this.#afterRender();
		this.mounted();
	}

	disconnectedCallback() {

	}

	attributeChangedCallback(name, oldVal, newVal) {

	}
}