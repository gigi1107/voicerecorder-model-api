package com.voicerecorder.repository;

import com.voicerecorder.entity.PhraseSet;
import com.voicerecorder.entity.UserPhraseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Timestamp;

//@Id
//private Long id;
//
//@Column(name = "phrase_id")
//    Long phraseId;
//
//@Column(name = "comment")
//    String comment;
//
//@Column(name = "date_time")
//    Timestamp dateTime;
//
//@Column(name = "user_id")
//    Long userId;


public interface UserPhraseCommentsRepository extends JpaRepository<UserPhraseComment, Long> {


    @Query("UPDATE UserPhraseComment u SET u.phraseId = ?2, u.comment = ?3, u.dateTime = ?4, u.userId = ?5 where u.id= ?1")
    @Modifying
    void updateUserPhraseComment(Long id, Long phraseId, String comment, Date dateTime, Long userId);

    @Query("DELETE from UserPhraseComment u WHERE u.phraseId = ?1")
    @Modifying
    void deleteUserPhraseCommentsWithPhraseId(Long id);

    @Query("DELETE from UserPhraseComment u WHERE u.id = ?1")
    @Modifying
    void deleteUserPhraseCommentsWithUserPhraseId(Long id);
}
