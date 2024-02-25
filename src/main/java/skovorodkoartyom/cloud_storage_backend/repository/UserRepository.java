package skovorodkoartyom.cloud_storage_backend.repository;

import skovorodkoartyom.cloud_storage_backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByLogin(String login);
}