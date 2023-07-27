package com.example.facebookproj;

import com.example.facebookproj.model.*;
import com.example.facebookproj.repository.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakerData implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private LikeRepository likeRepository;
    private Faker faker=new Faker();
    private Timestamp getRandomTimestamp(){
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2023-12-31 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setProfilePicture(faker.internet().avatar());
            user.setBio(faker.lorem().sentence());
            user.setCreatedAt(getRandomTimestamp());
            user.setUpdatedAt(getRandomTimestamp());
            users.add(user);
        }
        userRepository.saveAll(users);
        // Generate posts
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Post post = new Post();
            post.setUser(users.get(faker.random().nextInt(0, 9)));
            post.setContent(faker.lorem().paragraph());
            post.setPostImage(faker.internet().image());
            post.setCreatedAt(getRandomTimestamp());
            post.setUpdatedAt(getRandomTimestamp());
            posts.add(post);
        }
        postRepository.saveAll(posts);

        // Generate comments
        List<Comment> comments = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Comment comment = new Comment();
            comment.setUser(users.get(faker.random().nextInt(0, 9)));
            comment.setPost(posts.get(faker.random().nextInt(0, 49)));
            comment.setComment(faker.lorem().sentence());
            comment.setCreatedAt(getRandomTimestamp());
            comment.setUpdatedAt(getRandomTimestamp());
            comments.add(comment);
        }
        commentRepository.saveAll(comments);

        // Generate likes
        List<Like> likes = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Like like = new Like();
            like.setUser(users.get(faker.random().nextInt(0, 9)));
            like.setPost(posts.get(faker.random().nextInt(0, 49)));
            like.setCreatedAt(getRandomTimestamp());
            likes.add(like);
        }
        likeRepository.saveAll(likes);

        // Generate friends
        List<Friend> friends = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Friend friend = new Friend();
            friend.setUser1(users.get(faker.random().nextInt(0, 9)));
            friend.setUser2(users.get(faker.random().nextInt(0, 9)));
            friend.setStatus(friendstatus.values()[faker.random().nextInt(0, 2)]);
            friend.setUser3(users.get(faker.random().nextInt(0, 9)));
            friend.setCreatedAt(getRandomTimestamp());
            friend.setUpdatedAt(getRandomTimestamp());
            friends.add(friend);
        }
        friendRepository.saveAll(friends);

        // Generate messages
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Message message = new Message();
            message.setUser1(users.get(faker.random().nextInt(0, 9)));
            message.setUser2(users.get(faker.random().nextInt(0, 9)));
            message.setMessage(faker.lorem().sentence());
            message.setCreatedAt(getRandomTimestamp());
            message.setUpdatedAt(getRandomTimestamp());
            messages.add(message);
        }
        messageRepository.saveAll(messages);
    }
}
