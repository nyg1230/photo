package prv.toy.photo.common.jwt;

import io.jsonwebtoken.SignatureAlgorithm;

public enum JwtOption {

	EXPIRE_TIME(1000 * 60L * 30L),
	ALGO("HS256"),
	TOKEN_KEY("photo")
	;
	
	final Object value;

	JwtOption(Object value) {
		this.value = value;
	}

	public String getValue() {
		return String.valueOf(this.value);
	}

	public Long getNumberValue() {
		return Long.valueOf(this.getValue());
	}
	
	public SignatureAlgorithm getAlgorithm() {
		return SignatureAlgorithm.valueOf(this.getValue());
	}

	public byte[] getBytes() {
		return this.getValue().getBytes();
	}
}
