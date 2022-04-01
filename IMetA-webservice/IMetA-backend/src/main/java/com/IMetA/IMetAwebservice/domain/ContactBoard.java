package com.IMetA.IMetAwebservice.domain;

import com.IMetA.IMetAwebservice.domain.enums.State;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ContactBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private String image;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private State state;

    @Builder
    public ContactBoard(String name, String email, String phone, String title, String content, String image, String password, State state) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.content = content;
        this.image = image;
        this.password = password;
        this.state = state;
    }
}
