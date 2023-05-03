package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name = "user_phrases")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPhrase   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_phrases_id_seq")
    @SequenceGenerator(name = "user_phrases_id_seq", sequenceName = "user_phrases_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_id")
    private Long phraseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "file_hash")
    private String fileHash;

    @Column(name = "file_is_valid")
    private Boolean fileIsValid;
    @Column(name = "delivered")
    private Boolean delivered;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "file_path")
    private String filePath;

    public UserPhrase(Long phraseId, Long userId, String fileHash, Boolean fileIsValid, Boolean delivered, Date dateTime, String filePath) {
        this.phraseId = phraseId;
        this.userId = userId;
        this.fileHash = fileHash;
        this.fileIsValid = fileIsValid;
        this.delivered = delivered;
        this.dateTime = dateTime;
        this.filePath = filePath;
    }


}
