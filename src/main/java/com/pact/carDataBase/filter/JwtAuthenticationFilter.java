package com.pact.carDataBase.filter;


import com.pact.carDataBase.service.JwtService;
import com.pact.carDataBase.service.UserDetailsServiceImplementation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;// I HAD TO MANUALLY PUNCH THIS IN
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;//I DID NOT HAVE TO MANUALLY INPUT THIS ONE; IS IT BECAUSE I DID NOT CREATE A NEW OBJECT?


import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;








@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private final JwtService jwtService;
	private final UserDetailsServiceImplementation userDetailsService;
	


	
	
	

	public JwtAuthenticationFilter(JwtService jwtService, UserDetailsServiceImplementation userDetailsService) {
		super();
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}







	@Override
	protected void doFilterInternal(
			HttpServletRequest request
			,HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String token = authHeader.substring(7);
		String username = jwtService.extractUsername(token);
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			if(jwtService.isValid(token, userDetails)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(// I HAD TO MANUALLY PUNCH IN THE IMPORT FOR THIS CLASS
						userDetails, null, userDetails.getAuthorities()
						);
				authToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request) // DID NOT MANUALLY PUNCH IN IMPORT FOR THE WEBAUTH...etc..CLASS
						);
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
