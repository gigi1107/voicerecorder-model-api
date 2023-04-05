package com.voicerecorder.model.response;

import lombok.*;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class BucketResponse {
    private byte[] fileContents;
    private HttpStatus httpStatus;

}
