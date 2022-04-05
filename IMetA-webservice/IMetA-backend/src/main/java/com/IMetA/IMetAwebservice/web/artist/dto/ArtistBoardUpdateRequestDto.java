package com.IMetA.IMetAwebservice.web.artist.dto;

import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArtistBoardUpdateRequestDto extends ImageLinkConverter {

    private PieceBoard pieceBoard;

    private String name;

    private String note;

    private String image;

    private String education;

    private String career;

    @Builder
    public ArtistBoardUpdateRequestDto(PieceBoard pieceBoard, String name, String note, String image, String education, String career) {
        this.pieceBoard = pieceBoard;
        this.name = name;
        this.note = note;
        this.image = image;
        this.education = education;
        this.career = career;
    }

    public void setImage(String[] imageList) {
        this.image = imageListToString(imageList);
    }
}
