package com.app.client.repository.entity;

import com.app.client.model.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "CLIENT")
@Value
public class ClientEntity {

    @Id
    UUID id;
    String name;
    String cpf;
    LocalDate birthdate;

    @OneToOne
    Address address;
}
