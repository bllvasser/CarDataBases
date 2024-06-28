package com.pact.carDataBase.service;


import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.pact.carDataBase.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys; // this is for the return Keys on the getSigninKey method
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	@Service 
public class JwtService {
	
private static final String PREFIX = "Bearer";
private final String SECRET_KEY	= "efe1aa1cadaf85c7eec5c703d222defc419455916e7a8c3078ed1b022a0c4739";



public boolean isValid(String token, UserDetails user) {
	String username = extractUsername(token);
	return (username.equals(user.getUsername())) && !istokenExpired(token);
}

private boolean istokenExpired(String token) {
	return extractExpiration(token).before(new Date());
}

private Date extractExpiration(String token) {
	return extractClaim(token, Claims::getExpiration);
}

public String extractUsername(String token) {
	return extractClaim(token, Claims::getSubject);
}

public <T> T extractClaim(String token, Function<Claims, T> resolver) {
	
	Claims claims = extractAllClaims(token);
	return resolver.apply(claims);
	
}


private Claims extractAllClaims(String token) {
	
	return Jwts
			.parser()
			.verifyWith(getSigninKey())
			.build()
			.parseSignedClaims(token)
			.getPayload();
	
	
}


public String generateToken(User user)	{
	
	HttpServletRequest req = null;
	
	HttpServletResponse res = null;
	
	String token = Jwts
			.builder()
			.subject(user.getUsername())
			.issuedAt(new Date(System.currentTimeMillis()))
			.expiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
			.signWith(getSigninKey())
			.compact();
	
	res.addHeader("Authorization", PREFIX + " " + token);
	res.addHeader("Access-Control-Expose-Headers", "Authorization");
	

	
	
	
		
	
	return token;
			
}


private SecretKey getSigninKey() {

	byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
	
	return Keys.hmacShaKeyFor(keyBytes);
	
}

}
