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
public class Shop {
    @Id
    @SequenceGenerator(
            name = "shop_seq",
            sequenceName = "shop_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shop_seq"
    )
    @NotNull
    @Column(name = "shop_id")

    @NotNull
    private Long id;

    @NotNull
    @Size(min=2, max=50)
    private String name;
}
