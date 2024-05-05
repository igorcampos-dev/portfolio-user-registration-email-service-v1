package com.ms.email.repositories;

import com.ms.email.models.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {

}
