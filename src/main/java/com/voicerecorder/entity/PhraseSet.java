package com.voicerecorder.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;



@Entity
@Table(name = "phrase_sets")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PhraseSet  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "collection_sets_id_seq")
    @SequenceGenerator(name = "collection_sets_id_seq", sequenceName = "collection_sets_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "phrase_set_name")
    private String phraseSetName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
