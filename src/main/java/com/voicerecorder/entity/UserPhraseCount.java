package com.voicerecorder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user_phrase_count")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPhraseCount implements Serializable {

    @Id
    Long id;
    @Column(name = "user_id")
    Long userId;

    @Column(name = "phrase_id")
    Long phraseId;

    @Column(name = "phrase_set_id")
    Long phraseSetId;

    @Column(name = "c")
    Integer count;

}
