package prv.toy.photo.common.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import prv.toy.photo.common.Util;

@Component(value = "jwtUtil")
public class JwtUtil {

	@Autowired private Util util;

	public String create() {

		JwtBuilder jwt = Jwts.builder();
		this.setToekn(jwt);

		String token = jwt.compact();

		return token;
	}

	private void setToekn(JwtBuilder jwt) {
		if (util.isNull(jwt)) return;

		Map<String, Object> header = new HashMap<>();
		header.put("type", "jwt");
		header.put("algo", JwtOption.ALGO.getValue());

		Map<String, Object> claims = new HashMap<>();

		Date expireDate = new Date();
		expireDate.setTime(expireDate.getTime() + JwtOption.EXPIRE_TIME.getNumberValue());

		jwt
			.setHeader(header)
			.setClaims(claims)
			.setExpiration(expireDate)
			.signWith(JwtOption.ALGO.getAlgorithm(), JwtOption.TOKEN_KEY.getBytes());

	}

	public boolean validationCheck(String token) {
		boolean isValidation = false;

		try {
			JwtParser jwtParser = Jwts.parser().setSigningKey(JwtOption.TOKEN_KEY.getBytes());
			jwtParser.parseClaimsJws(token);

			isValidation = true;
		} catch (ExpiredJwtException e) {
			// 만료
		} catch (JwtException e) {
			// 변조
		} catch(Exception e) {
			// 그 외
		}

		return isValidation;
	}

}
