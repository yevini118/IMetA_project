package com.IMetA.IMetAwebservice.web.artist.dto;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArtistBoardDetailResponseDto extends ImageLinkConverter {

    private Long id;

    private PieceBoard pieceBoard;

    private String name;

    private String note;

    private String[] image;

    private String education;

    private String career;

    public ArtistBoardDetailResponseDto(ArtistBoard entity) {
        this.id = entity.getId();
        this.pieceBoard = entity.getPieceBoard();
        this.name = entity.getName();
        this.note = entity.getNote();
        this.image = imageStringToList(entity.getImage());
        this.education = entity.getEducation();
        this.career = entity.getCareer();
    }
}
