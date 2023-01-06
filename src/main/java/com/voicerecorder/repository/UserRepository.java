package com.voicerecorder.repository;



import com.voicerecorder.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
//     this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phone = phone;

    @Query("UPDATE UserEntity as u SET u.firstName = ?2, u.lastName = ?3, u.email = ?4, u.project = ?5 where u.id = ?1")
    void updateUser(Long id, String firstName, String lastName, String email, String project);

}
