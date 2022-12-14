package com.academy.assetsproject.models;

import com.academy.assetsproject.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String userName;
    @Column
    private String password;

    @Enumerated(value = EnumType.STRING)
    private UserType role;

}
