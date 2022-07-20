import { constans } from "./constants/Constans.js";
import CommonUtil from "./util/CommonUtil.js";

const { config } = { ...constans };

export default class Ajax {
	#headers;
	#host
	#callback

	constructor(p) {
		const { protocol, host, port } = { ...config };
		this.#host = `${protocol}${host}:${port}`;
		this.init(p);
	}

	init(p) {
		const { callback = {} } = { ...p };
		// delete p.callback;
		
		this.#callback = callback;
	}

	get allowMethod() {
		return {
			get: "GET",
			post: "post",
			put: "PUT",
			delete: "DELETE"
		};
	}

	async get(p) {
		return await this.#request(p, this.allowMethod.get);
	}


	async #request(p, method = null) {
		this.#beforeSend();

		const { path = "", body = {}, headers = {} } = { ...p };

		let url = `${this.#host}${path}`;

		const options = {
			method: method,
			headers: {
				...this.#headers,
				...headers
			}
		}

		if (method === this.allowMethod.get) {
			url += this.#getQuerySelector(body);
		} else {
			options.body = JSON.stringify(body);
		}

		let res;
		let data;
		let result;
		try {
			res = await fetch(url, options);
			data = await res.json();

			if (res.ok) {
				result = this.#parseData(data);
			} else {
				result = Error(data);
			}
		} catch(e) {
			console.error(e);
			result = null;
		} finally {
			this.#complete();
		}

		return result;
	}

	#beforeSend() {
		const { beforeSend } = { ...this.beforeSend };

		if (CommonUtil.isFunction(beforeSend)) beforeSend();
	}

	#parseData(data) {
		const { parseData } = { ...this.#callback };

		if (CommonUtil.isFunction(parseData)) {
			data = parseData(data);
		}

		return data;
	}

	#complete() {
		const { complete } = { ...this.#callback };

		if (CommonUtil.isFunction(complete)) complete();
	}

	#getQuerySelector(obj) {
		const keys = Object.keys(obj);

		const qs = keys.map((k) => {
			const v = obj[k];

			return `${k}=${v}`;
		}).join("&");

		return `?${qs}`;
	}
}