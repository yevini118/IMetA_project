package com.IMetA.IMetAwebservice.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ArtistBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull
    private PieceBoard pieceBoard;

    @NotNull
    private String name;

    private String note;

    @NotNull
    private String image;

    private String education;

    private String career;

    @Builder
    public ArtistBoard(PieceBoard pieceBoard, String name, String note, String image, String education, String career) {
        this.pieceBoard = pieceBoard;
        this.name = name;
        this.note = note;
        this.image = image;
        this.education = education;
        this.career = career;
    }

    public void update(PieceBoard pieceBoard, String name, String note, String image, String education, String career) {
        this.pieceBoard = pieceBoard;
        this.name = name;
        this.note = note;
        this.image = image;
        this.education = education;
        this.career = career;
    }
}
