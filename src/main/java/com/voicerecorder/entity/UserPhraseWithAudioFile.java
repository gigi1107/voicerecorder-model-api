package com.voicerecorder.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class UserPhraseWithAudioFile implements Serializable {

    private UserPhrase userPhrase;

    private File audioFile;

    public UserPhraseWithAudioFile(UserPhrase userPhrase, File audioFile) {
        this.userPhrase = userPhrase;
        this.audioFile = audioFile;
    }

    public UserPhraseWithAudioFile() {
    }

    public UserPhrase getUserPhrase() {
        return userPhrase;
    }

    public void setUserPhrase(UserPhrase userPhrase) {
        this.userPhrase = userPhrase;
    }

    public File getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(File audioFile) {
        this.audioFile = audioFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPhraseWithAudioFile that)) return false;
        return Objects.equals(userPhrase, that.userPhrase) && Objects.equals(audioFile, that.audioFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userPhrase, audioFile);
    }

    @Override
    public String toString() {
        return "UserPhraseWithAudioFile{" +
                "userPhrase=" + userPhrase +
                ", audioFile=" + audioFile +
                '}';
    }
}
