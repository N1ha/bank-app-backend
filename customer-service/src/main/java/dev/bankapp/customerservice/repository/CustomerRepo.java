package dev.bankapp.customerservice.repository;

import dev.bankapp.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer ,Integer> {
}
