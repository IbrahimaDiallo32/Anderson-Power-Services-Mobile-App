package com.aps.restfulbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM public.\"Customer \"", nativeQuery = true)
    List<Customer> findAll();
}
