package com.eid.crm.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Document("contacts")
@Getter
@Setter
public class Contact {

    @Transient
    public static final String SEQUENCE_NAME = "contacts_sequence";

    @Id
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    private String role;
}
