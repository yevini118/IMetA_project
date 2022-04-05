package com.IMetA.IMetAwebservice.web.piece.dto;

import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.domain.enums.Exhibition;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PieceBoardResponseDto extends ImageLinkConverter {

    private Long id;

    private Exhibition exhibition;

    private String artist;

    private String title;

    private String content;

    private String[] image;

    private Long views;

    public PieceBoardResponseDto(PieceBoard entity) {
        this.id = entity.getId();
        this.exhibition = entity.getExhibition();
        this.artist = entity.getArtist();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.image = imageStringToList(entity.getImage());
        this.views = entity.getViews();
    }


}
