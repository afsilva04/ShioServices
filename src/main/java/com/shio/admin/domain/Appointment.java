package com.shio.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "Appointment")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date", columnDefinition = "DATE")
    private OffsetDateTime date;
    private String note;
    private Boolean rescheduled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subsidiaryId")
    private Subsidiary subsidiary;

    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private Set<AppointmentItem> appointmentItems;

}
