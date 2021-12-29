package com.ensias.albcusertimelineservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @OneToMany(targetEntity = Media.class)
    private List<Media> media;
    private Long userId;
    private Date createdAt;
    @Transient
    private User user;
    @OneToMany(targetEntity = Likes.class)
    private List<Likes> likes;

    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comments;

    @OneToMany(targetEntity = Retweet.class)
    private List<Retweet> retweets;

}
