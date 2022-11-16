package com.academy.assetsproject.models;

import com.academy.assetsproject.enums.Roles;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column
    private Roles roles;
}
