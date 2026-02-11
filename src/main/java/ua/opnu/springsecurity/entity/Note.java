package ua.opnu.springsecurity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "note")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
}
