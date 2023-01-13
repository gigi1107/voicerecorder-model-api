package com.voicerecorder.repository;

import com.voicerecorder.entity.UserPhrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface UserPhraseRepository extends JpaRepository<UserPhrase, Long> {

//
//    @Id
//    private Long id;
//
//    @Column(name = "phrase_id")
//    private Long phraseId;
//
//    @Column(name = "user_id")
//    private Long userId;
//
//    @Column(name = "date_time")
//    private Timestamp dateTime;
//
//    @Column(name = "file_path")
//    private String filePath;

    @Query("UPDATE UserPhrase u SET u.phraseId= ?2, u.userId= ?3, u.dateTime= ?4, u.filePath= ?5 where u.id= ?1")
    UserPhrase updateUserPhrase(Long id, Long phraseId, Long userId, String dateTime, String filePath);
}
