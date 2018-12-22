package com.niranjan.personal.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranjan.personal.services.enums.UserRoleEnum;
import com.niranjan.personal.services.model.UserAuthority;


@Repository
public interface RoleRepository extends JpaRepository<UserAuthority, Long> {
    Optional<UserAuthority> findByName(UserRoleEnum roleName);
}