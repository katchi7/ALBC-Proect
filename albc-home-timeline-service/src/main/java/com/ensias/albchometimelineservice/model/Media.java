package com.ensias.albchometimelineservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    private Long mediaId;
    private String mediaUrl;
    private String medialName;
    private String mediaType;
}
