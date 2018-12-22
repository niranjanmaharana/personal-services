/**
 * 
 */
package com.niranjan.personal.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranjan.personal.services.model.UserType;

/**
 * @author Niranjan
 *
 */

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
    Optional<UserType> findByType(String type);
    Boolean existsByType(String type);
}