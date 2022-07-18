package prv.toy.photo.common;

import java.util.List;

import org.springframework.stereotype.Component;

@Component(value = "util")
public class Util {

	public boolean isNull(Object obj) {
		return obj == null;
	}

	public boolean isNotNull(Object obj) {
		return !this.isNull(obj);
	}

	public boolean isArray(Object obj) {
		return obj != null && obj instanceof List;
	}
}
