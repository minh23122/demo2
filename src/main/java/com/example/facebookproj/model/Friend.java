package com.example.facebookproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "friends")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int friendId;
    @Enumerated(EnumType.STRING)
    private friendstatus status;
    private Timestamp createdAt, updatedAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId1",
            referencedColumnName = "userId"
    )
    private User user1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "userId2",
            referencedColumnName = "userId"
    )
    private User user2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "actionUserId",
            referencedColumnName = "userId"
    )
    private User user3;
}
