package com.seleznov.liquibase.demo.repository;

import com.seleznov.liquibase.demo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Illia Seleznov
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
