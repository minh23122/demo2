package com.example.facebookproj.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "likes")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeId;
    private Timestamp createdAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId",
            referencedColumnName = "userId"
    )
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "postId",
            referencedColumnName = "postId"
    )
    private Post post;
}
