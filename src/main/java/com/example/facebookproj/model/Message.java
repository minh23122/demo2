package com.example.facebookproj.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;
    private String message;
    private Timestamp createdAt, updatedAt;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "senderId",
            referencedColumnName = "userId"
    )
    private User user1;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "receiverId",
            referencedColumnName = "userId"
    )
    private User user2;
}
