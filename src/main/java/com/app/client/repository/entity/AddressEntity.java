package com.app.client.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
@Immutable
public class AddressEntity {
    @Id
    UUID id;
    String street;
    String neighborhood;
    String state;
    @Column(name = "house_number")
    Integer houseNumber;
    String complement;
    String cep;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    private AddressEntity() {
    }

    public AddressEntity(String street, String neighborhood, String state, Integer houseNumber, String complement, String cep) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.neighborhood = neighborhood;
        this.state = state;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.cep = cep;
    }
}

