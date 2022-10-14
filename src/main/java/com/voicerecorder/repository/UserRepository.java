package com.voicerecorder.repository;



import com.voicerecorder.EntityModels.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
