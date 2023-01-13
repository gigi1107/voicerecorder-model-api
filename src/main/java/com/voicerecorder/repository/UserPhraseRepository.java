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

    @Query("UPDATE UserPhrase up SET up.phraseId = ?2, up.userId = ?3, up.dateTime = ?4, " +
            "up.filePath = ?5, where up.id= ?1")
    void updateUserPhrase(Long id, Long phraseId, Long userId, Timestamp dateTime, String filePath);
}
