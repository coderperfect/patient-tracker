package com.tracker.patienttracker.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String secretkey = "${jwt.secret}";

	/**
	 * Extracts user name by using the given token. If the token is a Bearer token
	 * it returns User name. Else returns null.
	 * 
	 * @param token
	 * @return User Name in String format
	 */
	public String extractUsername(String token) {
		try {
			
			String token1 = token;
			System.out.println(Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token1).getBody().getSubject());
			return Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token1).getBody().getSubject();
		} 
		catch (Exception e) {
			
			return null;
		}
	}
	
	public String extractRole(String token) throws Exception {
		//String jwt = <jwt passed in from above>
		Jws<Claims> claims = Jwts.parser()
		  .setSigningKey(secretkey.getBytes("UTF-8"))
		  .parseClaimsJws(token);
		String role = claims.getBody().get("role", String.class);
                return role;
	}

	/**
	 * Gets an authorized User Details and generated a JWT token with Expiration
	 * time for the particular token
	 * 
	 * @param userDetails - User ID,Password
	 * @return token in string format
	 */
	public String generateToken(UserDetails userDetails,String role) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("role",userDetails.getAuthorities());
		final String authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
		String compact = Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.claim("role", authorities)
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))// token for 60 min
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		return compact;
	}
	
	public String generateTokenForReset(UserDetails userDetails,String role) {
//		Map<String, Object> claims = new HashMap<>();
//		claims.put("role",userDetails.getAuthorities());
		final String authorities = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
		String compact = Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.claim("role", authorities)
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3))// token for 3 min
				.signWith(SignatureAlgorithm.HS256, secretkey).compact();
		return compact;
	}

	/**
	 * Validates the given JWT token. If valid, returns true. Else returns false
	 * 
	 * @param token JWT token to validate user
	 * @return If a valid token is passed, True is returned. Else false
	 */
	public Boolean validateToken(String token) {
		try {
			String token1 = token;
			Jwts.parser().setSigningKey(secretkey).parseClaimsJws(token1).getBody().getExpiration();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public UsernamePasswordAuthenticationToken getAuthenticationToken(String authToken,
			org.springframework.security.core.Authentication authentication, UserDetails userDetails) {
		final JwtParser jwtParser = Jwts.parser().setSigningKey(secretkey);

        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(authToken);

        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("role").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}
	
	
}