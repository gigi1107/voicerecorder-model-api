package com.voicerecorder.entity;

import lombok.*;

import java.io.File;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPhraseWithAudioFile implements Serializable {

    private UserPhrase userPhrase;

    private File audioFile;

}
