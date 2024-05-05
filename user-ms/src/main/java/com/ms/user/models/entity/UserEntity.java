package com.ms.user.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
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
            name = "id",
            unique = true,
            length = 35
    )
    private UUID id;

    @Column(
            name = "name",
            unique = true,
            updatable = false,
            nullable = false
    )
    private String name;

    @Column(
            name = "email",
            unique = true,
            updatable = false,
            nullable = false
    )
    private String email;

}
