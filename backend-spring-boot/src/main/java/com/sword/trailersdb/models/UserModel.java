package com.sword.trailersdb.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
public class UserModel {
    private @Id @GeneratedValue Long id;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    // Bidirectional relationship as best practice. List of comments ids
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<CommentModel> comments;

    public UserModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(ArrayList<CommentModel> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", comments=" + comments +
                '}';
    }

}
