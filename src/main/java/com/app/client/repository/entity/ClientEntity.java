package com.app.client.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "CLIENT")
@Immutable
@Getter
public class ClientEntity {

    @Id
    UUID id;
    String name;
    String cpf;
    LocalDate birthdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    AddressEntity address;

    @CreatedDate
    @Column(name = "createdAt")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    LocalDateTime updatedAt;

    private ClientEntity() {
    }


    public ClientEntity(String name, String cpf, LocalDate birthdate, AddressEntity address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
        this.address = address;
    }
}
