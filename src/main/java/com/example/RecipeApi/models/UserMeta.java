package com.example.RecipeApi.models;
import lombok.*;

import javax.persistence.*;

@Getter // note: on website, but not in example repo
@Setter // note: on website, but not in example repo
@Entity
@Table(name = "user_meta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;
}
