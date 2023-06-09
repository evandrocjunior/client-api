package com.app.client.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ADDRESS")
@Immutable
public class AddressEntity {
    @Id
    UUID id;
    String street;
    String neighborhood;

    String city;
    String state;
    @Column(name = "house_number")
    Integer houseNumber;
    String complement;
    String cep;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    private AddressEntity() {
    }

    @Builder
    public AddressEntity(String street, String neighborhood, String city, String state, Integer houseNumber, String complement, String cep) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.houseNumber = houseNumber;
        this.complement = complement;
        this.cep = cep;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getComplement() {
        return complement;
    }

    public String getCep() {
        return cep;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
