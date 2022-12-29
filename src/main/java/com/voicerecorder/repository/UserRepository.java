package com.voicerecorder.repository;



import com.voicerecorder.EntityModels.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
//     this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phone = phone;

    @Query("UPDATE UserEntity u SET firstName=$2, lastName=$3, email=$4, phoneNumber=$5 where u.id= ?1")
    void updateUser(Long id, String firstName, String lastName, String email, String phoneNumber);

}
