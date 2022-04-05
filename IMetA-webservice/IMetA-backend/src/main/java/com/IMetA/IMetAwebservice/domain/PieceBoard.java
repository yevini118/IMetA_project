package com.IMetA.IMetAwebservice.domain;

import com.IMetA.IMetAwebservice.domain.enums.Exhibition;
import com.sun.istack.NotNull;
import lombok.Builder;
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

    @Enumerated(EnumType.STRING)
    @NotNull
    private Exhibition exhibition;

    @ManyToOne
    @NotNull
    private User user;

    @ManyToOne
    @NotNull
    private ArtistBoard artistBoard;

    @NotNull
    private String artist;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private String vrLink;

    private String image;

    @NotNull
    private Long views;

    @Builder
    public PieceBoard(Exhibition exhibition, User user, ArtistBoard artistBoard, String artist, String title, String content, String vrLink, String image, Long views) {
        this.exhibition = exhibition;
        this.user = user;
        this.artistBoard = artistBoard;
        this.artist = artist;
        this.title = title;
        this.content = content;
        this.vrLink = vrLink;
        this.image = image;
        this.views = views;
    }

    public void update(Exhibition exhibition, ArtistBoard artistBoard, String artist, String title, String content, String vrLink, String image) {
        this.exhibition = exhibition;
        this.artistBoard = artistBoard;
        this.artist = artist;
        this.title = title;
        this.content = content;
        this.vrLink = vrLink;
        this.image = image;
    }
}
