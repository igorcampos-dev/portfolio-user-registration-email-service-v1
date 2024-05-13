package com.ms.user.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
            name = "PK_ID",
            unique = true,
            length = 35
    )
    @Comment("Id do usuário")
    private UUID id;

    @Column(
            name = "USR_ST_NAME",
            unique = true,
            updatable = false,
            nullable = false
    )
    @Comment("Nome do usuário")
    private String name;

    @Column(
            name = "USR_ST_EMAIL",
            unique = true,
            updatable = false,
            nullable = false
    )
    @Comment("Email do usuário")
    private String email;

}
