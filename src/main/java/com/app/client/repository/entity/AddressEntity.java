package com.app.client.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Value;

import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
@Value
public class AddressEntity {
   @Id
   private final UUID id;
   private final String street;
   private final String neighborhood;
   private final String state;
   private final Integer houseNumber;
   private final String complement;
   private final String cep;
}

