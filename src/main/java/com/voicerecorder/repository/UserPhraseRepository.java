package com.voicerecorder.repository;

import com.voicerecorder.entity.UserPhrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPhraseRepository extends JpaRepository<UserPhrase, Long> {
}
