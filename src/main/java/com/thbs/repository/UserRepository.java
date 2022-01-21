package com.thbs.repository;

import com.thbs.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Priyanka_Ramesh Pavan Varun
 *
 */

public interface UserRepository extends JpaRepository<Users, String> {
}
