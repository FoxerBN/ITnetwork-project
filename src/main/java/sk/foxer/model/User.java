package sk.foxer.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 50)
    private String surename;

    @Column(nullable = false,length = 3)
    private Integer age;

    @Column(nullable = false, length = 20)
    private String telephone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
