package dev.bankapp.customerservice.controller;

import dev.bankapp.customerservice.dto.LoginCredantial;
import dev.bankapp.customerservice.model.Customer;
import dev.bankapp.customerservice.repository.AccountRepo;
import dev.bankapp.customerservice.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer/")
public class CustomerController {
    private final CustomerRepo repo;
    private final AccountRepo repoAcc;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)

    public Customer Create(@RequestBody Customer customer)
    {
        repoAcc.save(customer.getCustomerAccount());
        return repo.save(customer);
    }

    public void login(@RequestBody LoginCredantial log)throws Exception
    {
        Customer chec= repo.findById(log.getId()).get();

        if(!(repo.findById(log.getId()).isPresent() &&
                chec.getPassword().equals(log.getPassword())))
        {
            throw new Exception("NOT FOUND");
        }

    }


}
