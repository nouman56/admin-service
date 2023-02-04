package com.ascertia.adminservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="uuid")
    private String uuid;

    @Column(name = "name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name = "mobile")
    private String mobile;


}
