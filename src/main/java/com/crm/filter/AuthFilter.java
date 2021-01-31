package com.crm.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import io.jsonwebtoken.Jwts;


public class AuthFilter extends BasicAuthenticationFilter{
	
	private UserDetailsService userDetailsService;

	public AuthFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		// cai nay la cheat chua tim ra dc solution
		if(request.getServletPath().startsWith("/api/auth/")) {
			chain.doFilter(request, response);
			return;
		}
		
		// B1. Lấy token request
		String tokenHeader = request.getHeader("Authorization");
		
		if(tokenHeader != null && !tokenHeader.isEmpty() && tokenHeader.startsWith("Bearer ")) {
			String token = tokenHeader.replace("Bearer ", "");
			// Gán mã token email
			String email = Jwts.parser()
			.setSigningKey("ABC_EGH")
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
			
			// Gá»ŒI PHÆ¯Æ NG THá»¨C Láº¤Y THÃ”NG TIN USER (UserDetailDTO)
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			// SET THÃ”NG TIN USER VÃ€O CONTEXT => Ä�á»‚ PHÃ‚N QUYá»€N
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		else {
			response.sendError(401, "Chưa đăng nhập!");
		}
		
	}
}
