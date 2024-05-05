package com.ms.user.repositories;

import com.ms.user.models.entity.UserEntity;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);

    default void userExistsByNameOrEmail(String name, String email){
        if (this.existsByEmail(email) || this.existsByName(name)){
            throw new DuplicateKeyException("Já existe um usuário com alguma dessas informações");
        }
    }

    default UserEntity saveOrElseThrow(UserEntity entity){
        this.userExistsByNameOrEmail(entity.getName(), entity.getEmail());
        this.save(entity);
        return entity;
    }
}
