package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntryDTO {

    @Id
    @GeneratedValue
    private Long id;
    private OffsetDateTime date;
    private int confirmed;
    private String confirmedName;
    private Long subsidiaryId;
    private String subsidiaryName;

}
