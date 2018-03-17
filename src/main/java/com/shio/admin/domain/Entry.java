package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Entry")
@Data
public class Entry {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private int confirmed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiaryId")
    private Subsidiary subsidiary;

    @JsonIgnore
    @OneToMany(mappedBy = "entry")
    private Set<EntryItem> entryItems;
}
