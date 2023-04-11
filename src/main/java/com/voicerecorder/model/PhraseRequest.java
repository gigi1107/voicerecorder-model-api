package com.voicerecorder.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PhraseRequest {
    private Long userId;
    private Long phraseSetId;

}
