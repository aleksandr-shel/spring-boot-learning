package com.todolist.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.models.ERole;
import com.todolist.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
