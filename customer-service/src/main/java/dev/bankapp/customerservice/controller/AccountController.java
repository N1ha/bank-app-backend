package dev.bankapp.customerservice.controller;

import dev.bankapp.customerservice.model.Customer;
import dev.bankapp.customerservice.repository.AccountRepo;
import dev.bankapp.customerservice.model.account;
import dev.bankapp.customerservice.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("Account/")
public class AccountController {
    private final AccountRepo Arepo;
    private final CustomerRepo Crepo;
    @PostMapping("Register")
    @ResponseStatus(HttpStatus.CREATED)
    public account createAccount(@RequestBody account acc)
    {
        return Arepo.save(acc);
    }

    @PostMapping("withdrawal/{wmoney}")
    public ResponseEntity<Object> withdraw(@PathVariable("wmoney") int wmoney, @RequestParam("Cid") int customerId)
    {
        Customer cId =Crepo.findById(customerId).get();
        int bal=cId.getCustomerAccount().getBalance();
        if(bal>500)
        {
            bal=bal-wmoney;
            cId.getCustomerAccount().setBalance(bal);
            return ResponseEntity.ok(Crepo.save(cId));

        }
        else
        {
            HashMap<String,String> message = new HashMap<>();

            message.put("error","Account balance Should be greater then 500");
            message.put("TimeStamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            return ResponseEntity.badRequest().body(message);

        }

    }

    @PostMapping("/deposit/{Dmoney}")
    public ResponseEntity<Object> Deposit(@PathVariable("Dmoney") int dMoney,@RequestParam("Cid") int CustomerId)
    {
        Customer cId = Crepo.findById(CustomerId).get();
        int bal=cId.getCustomerAccount().getBalance();
        cId.getCustomerAccount().setBalance(bal+dMoney);
        return ResponseEntity.ok(Crepo.save(cId));

    }
}
