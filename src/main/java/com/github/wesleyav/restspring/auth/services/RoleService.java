package com.github.wesleyav.restspring.auth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wesleyav.restspring.auth.entities.Role;
import com.github.wesleyav.restspring.auth.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role save(Role role) {
		return roleRepository.save(role);
	}

	public Role findById(Long id) {
		return roleRepository.findById(id).orElse(null);
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

}
