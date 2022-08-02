package com.github.wesleyav.restspring;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.wesleyav.restspring.auth.entities.Role;
import com.github.wesleyav.restspring.auth.entities.User;
import com.github.wesleyav.restspring.auth.services.RoleService;
import com.github.wesleyav.restspring.auth.services.UserService;

@Service
public class Initializer {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostConstruct
	public void criaUsuariosEPermissoes() {
		Role roleAdmin = new Role();

		roleAdmin.setName("ADMIN");

		roleService.save(roleAdmin);

		User user = new User();
		user.setAtivo(true);
		user.setEmail("teste@teste.com");
		user.setNome("Kaique Arantes");
		user.setSenha(new BCryptPasswordEncoder().encode("123456"));
		user.setUsername("karantes");
		user.setRoles(Arrays.asList(roleAdmin));

		userService.save(user);

	}

}
