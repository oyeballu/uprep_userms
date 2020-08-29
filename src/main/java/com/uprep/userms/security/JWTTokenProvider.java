package com.uprep.userms.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.uprep.userms.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import static com.uprep.userms.security.SecurityConstants.EXPIRATION_TIME;
import static com.uprep.userms.security.SecurityConstants.SECRET;

@Component
public class JWTTokenProvider {

	public String generateToken(User user) {
		try {
		Date now = new Date(System.currentTimeMillis());
		
		Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);
		
		String userId = Long.toString(user.getId());
		
		Map<String, Object> claims = new HashMap<>();

		claims.put("id",(Long.toString(user.getId())));
		claims.put("loginid",user.getLogin_id());
		claims.put("email",user.getMail());
		claims.put("fullName",user.getFull_name());
		
		return Jwts.builder()
				.setSubject(userId)
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(expiryDate)
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//validate the token
	public boolean validateToken(String token) {
		
		try {
			Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
			return true;
		}catch (SignatureException e) {
			System.out.println("invalid JWT Signature");
		}catch (MalformedJwtException e) {
			System.out.println("invalid JWT token");
		}catch (ExpiredJwtException e) {
			System.out.println("Expired JWT token");
		}catch (UnsupportedJwtException e) {
			System.out.println("Unsupported JWT token");
		}catch (IllegalArgumentException e) {
			System.out.println("JWT claims string is empty");
		}
		
		return false;	
		
	}
	
	//get Userid from token
	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		String id = (String)claims.get("id");
		
		return Long.parseLong(id);
	}
	
	
	
	
	
}