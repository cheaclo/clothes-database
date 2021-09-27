package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sender {
    @Id
    @SequenceGenerator(
            name = "sender_seq",
            sequenceName = "sender_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sender_seq"
    )
    @NotNull
    @Column(name = "sender_id")
    private Long id;

    @NotNull
    @Size(min=2, max=100)
    private String name;

    @NotNull
    private String authenticationCode;
}
