package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_phrase_comments")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPhraseComment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_phrase_comments_id_seq")
    @SequenceGenerator(name = "user_phrase_comments_id_seq", sequenceName = "user_phrase_comments_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_id")
    Long phraseId;

    @Column(name = "comment")
    String comment;

    @Column(name = "date_time")
    Date dateTime;

    @Column(name = "user_id")
    Long userId;

}
