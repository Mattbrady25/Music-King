package com.musicking.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "users")  // Optional: name can be changed
public class UserAuthentication {

    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Setter
    @Column(nullable = true)
    private String password;

    @Setter
    @Column(name = "spotify_id", unique = true)
    private String spotifyId;

    @Setter
    @Column(name = "apple_id", unique = true)
    private String appleId;

    @Setter
    @Column(name = "soundcloud_id", unique = true)
    private String soundcloudId;

    // Constructors
    public UserAuthentication() {}

    public UserAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

