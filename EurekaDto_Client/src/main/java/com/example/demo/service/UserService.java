package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {
   @Autowired
	private UserRepository userRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   private UserDto udto=null;
	
	public UserDto insertUser(UserDto userdto) {
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user=mapper.map(userdto, UserEntity.class);
		user.setUser_id(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		userdto= mapper.map(user,UserDto.class);
		return userdto;
	}
	
	public UserDto findByEmail(UserDto userdto) {
		ModelMapper mapper=new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user=mapper.map(userdto,UserEntity.class);
		System.out.println(user.getEmail());
		List<UserEntity> ulist=userRepository.findByEmail(user.getEmail());
		System.out.println("inside email service");
		for(UserEntity s:ulist) {
			System.out.println(s);
			System.out.println(s.getFirstname());
			userdto=mapper.map(s,UserDto.class);
			return userdto;
		}
		 return null;
		}
}
