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
public class InquiryBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private User user;

    @NotNull
    private String email;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private String image;

    @Enumerated(EnumType.STRING)
    @NotNull
    private State state;

    @Builder
    public InquiryBoard(User user, String email, String title, String content, String image, State state) {
        this.user = user;
        this.email = email;
        this.title = title;
        this.content = content;
        this.image = image;
        this.state = state;
    }
}
