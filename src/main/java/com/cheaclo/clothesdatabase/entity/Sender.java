package com.cheaclo.clothesdatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(name = "shop_id")
    private Long id;
    private String name;
    private String authenticationCode;
}
