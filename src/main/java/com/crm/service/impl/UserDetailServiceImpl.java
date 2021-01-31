package com.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crm.dto.UserDetailDto;
import com.crm.mapper.UserMapper;
import com.crm.model.User;


@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userMapper.findByEmail(email);
		if(user == null) throw new UsernameNotFoundException("Email không tồn tại");
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		UserDetailDto dto = new UserDetailDto(email, user.getPassword(), authorities);
		//System.err.println(user.toString());
		
		//Object principal = (UserDetailDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.err.println(principal);
		return dto;
	}

}
