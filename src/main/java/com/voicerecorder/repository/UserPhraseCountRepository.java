package com.voicerecorder.repository;

import com.voicerecorder.entity.UserPhraseCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserPhraseCountRepository extends JpaRepository<UserPhraseCount, Long> {

    @Query("SELECT u from UserPhraseCount u where u.userId = ?1 and u.phraseSetId = ?2 and u.count < 2")
    List<UserPhraseCount> getRemainingPhrasesGivenUserIdAndPhraseSetId(Long userId, Long phraseSetId);
}
