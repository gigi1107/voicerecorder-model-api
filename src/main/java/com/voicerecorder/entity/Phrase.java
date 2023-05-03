package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "phrases")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Phrase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phrases_SEQ")
    @SequenceGenerator(name = "phrases_SEQ", sequenceName = "phrases_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_set_id")
    private Long phraseSetId;

    @Column(name = "phrase")
    private String original;

    @Column(name = "english")
    private String translation;

    @Column(name = "example_path")
    private String exampleRecordingPath;

    @Column(name = "enabled")
    private Boolean enabled;


}
