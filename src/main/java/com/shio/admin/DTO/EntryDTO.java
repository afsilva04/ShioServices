package com.shio.admin.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
public class EntryDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private Long subsidiaryId;
    private String subsidiaryName;

}
