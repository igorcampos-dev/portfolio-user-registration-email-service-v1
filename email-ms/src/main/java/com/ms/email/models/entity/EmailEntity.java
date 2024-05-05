package com.ms.email.models.entity;

import com.ms.email.models.entity.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_email")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "id",
            unique = true,
            length = 35
    )
    private UUID id;

    @Column(
            name = "userId",
            updatable = false,
            nullable = false,
            length = 35
    )
    private UUID userId;

    @Column(
            name = "email_from",
            updatable = false,
            nullable = false
    )
    private String emailFrom;

    @Column(
            name = "email_to",
            updatable = false,
            nullable = false
    )
    private String emailTo;

    @Column(
            name = "subject",
            updatable = false,
            nullable = false
    )
    private String subject;

    @Column(
            name = "text",
            updatable = false,
            columnDefinition = "TEXT",
            nullable = false
    )
    private String text;

    @Column(
            name = "send_date_email",
            updatable = false,
            columnDefinition = "TIMESTAMP",
            nullable = false
    )
    private LocalDateTime sendDateEmail;

    @Column(
            name = "status_email",
            updatable = false,
            length = 10,
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
