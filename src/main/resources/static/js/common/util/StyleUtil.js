export default {
	obj2css(cssObject = {}) {
		const keys = Object.keys(cssObject);

		const css = keys.map((attr) => {
			const value = cssObject[attr];

			return `${attr}:{${value}};`;
		}).join("");

		return css;
	}
}