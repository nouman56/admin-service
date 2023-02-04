package com.ascertia.adminservice.repository;

import com.ascertia.adminservice.entities.Operations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsRepository extends JpaRepository<Operations,Long> {
}
