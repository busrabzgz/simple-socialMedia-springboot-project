package com.socialMedia.simplesocialmedia.user;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


@Entity
// @Table ile databasedeki tablo adını istediğimiz şekilde belirleyebiliriz
@Table(name="users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String username;
    @NonNull
    private String displayName;
    @NonNull
    private  String password;




}
