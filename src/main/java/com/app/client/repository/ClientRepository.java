package com.app.client.repository;

import com.app.client.repository.entity.ClientEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    List<ClientEntity> findByCpf(String cpf);
}
