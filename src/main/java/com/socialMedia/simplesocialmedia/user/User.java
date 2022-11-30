package com.socialMedia.simplesocialmedia.user;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Entity
// @Table ile databasedeki tablo adını istediğimiz şekilde belirleyebiliriz
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message="Username can not null")
    @Size(min=1,max = 25)
    @UniqueUsername()
    private String username;

    @NotNull
    @Size(min=1,max = 25)
    private String displayName;

    @NotNull
    @Size(min = 6,max = 10)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private  String password;


    public User() {

    }
}
