package com.ms.email.models.entity;

import com.ms.email.models.entity.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_EMAIL")
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
            name = "PK_ID",
            unique = true,
            length = 35
    )
    @Comment("Id do registro de envio de email")
    private UUID id;

    @Column(
            name = "MAL_ST_USER_ID",
            nullable = false,
            length = 35
    )
    @Comment("Id do usuário que recebeu o email")
    private UUID userId;

    @Column(
            name = "MAL_ST_EMAIL_FROM",
            nullable = false
    )
    @Comment("Email da empresa")
    private String emailFrom;

    @Column(
            name = "MAL_ST_EMAIL_TO",
            nullable = false
    )
    @Comment("Email do usuário")
    private String emailTo;

    @Column(
            name = "MAL_ST_SUBJECT",
            nullable = false
    )
    @Comment("Resumo do email (intuito)")
    private String subject;

    @Column(
            name = "MAL_ST_TEXT",
            columnDefinition = "TEXT",
            nullable = false
    )
    @Comment("Conteúdo da mensagem do email")
    private String text;

    @Column(
            name = "MAL_DT_SEND_DATE_EMAIL",
            columnDefinition = "TIMESTAMP",
            nullable = false
    )
    @Comment("Data de envio do email")
    private LocalDateTime sendDateEmail;

    @Column(
            name = "MAL_ST_STATUS_EMAIL",
            length = 10,
            nullable = false
    )
    @Comment("Status do envio (se foi enviado ou não)")
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
