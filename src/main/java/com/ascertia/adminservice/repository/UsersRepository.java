package com.ascertia.adminservice.repository;

import com.ascertia.adminservice.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByMobile(String mobile);
}
