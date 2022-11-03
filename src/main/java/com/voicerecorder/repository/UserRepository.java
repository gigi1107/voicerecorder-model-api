package com.voicerecorder.repository;



import com.voicerecorder.EntityModels.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
//     this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phone = phone;

    @Query("UPDATE UserEntity u SET firstName=$2, lastName=$3, email=$4, phoneNumber=$5 where p.id= ?1")
    void updateUser(Long id, String firstName, String lastName, String email, String phoneNumber);

}
