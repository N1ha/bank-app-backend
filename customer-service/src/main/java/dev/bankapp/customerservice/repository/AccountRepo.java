package dev.bankapp.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.bankapp.customerservice.model.account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<account,Integer> {
}
