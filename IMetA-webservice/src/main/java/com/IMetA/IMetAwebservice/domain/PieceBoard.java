package com.IMetA.IMetAwebservice.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PieceBoard extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private ArtistBoard artistBoard;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private String vrLink;

    private String image;

    @NotNull
    private Long views;
}
