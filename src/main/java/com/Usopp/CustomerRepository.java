package com.Usopp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    void updateCustomer(Integer id, String name, Integer age, String email);
}
