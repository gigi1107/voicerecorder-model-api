package com.voicerecorder.repository;

import com.voicerecorder.entity.UserPhraseComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhraseCommentsRepository extends JpaRepository<UserPhraseComment, Long> {
}
