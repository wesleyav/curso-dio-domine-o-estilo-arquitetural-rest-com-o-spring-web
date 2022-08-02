package com.github.wesleyav.restspring.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.wesleyav.restspring.auth.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
