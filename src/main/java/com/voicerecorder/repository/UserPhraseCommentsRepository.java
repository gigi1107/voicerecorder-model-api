package com.voicerecorder.repository;

import com.voicerecorder.entity.UserPhraseComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhraseCommentsRepository extends JpaRepository<UserPhraseComments, Long> {
}
