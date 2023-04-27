package com.app.client.model;

import com.app.client.controller.request.ClientRequest;

import java.time.LocalDate;

public record Client(
        String name,
        String cpf,
        LocalDate birthdate
) {
}
