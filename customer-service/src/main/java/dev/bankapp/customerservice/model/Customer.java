package dev.bankapp.customerservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Customer {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     private String name;
     private String last;
     private String email;
     private String password;
     private String address;
     private String contact;


     @OneToOne
    private account customerAccount ;



}
