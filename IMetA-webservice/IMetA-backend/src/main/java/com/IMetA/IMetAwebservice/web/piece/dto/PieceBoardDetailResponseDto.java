package com.IMetA.IMetAwebservice.web.piece.dto;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.domain.User;
import com.IMetA.IMetAwebservice.domain.enums.Exhibition;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PieceBoardDetailResponseDto extends ImageLinkConverter {

    private Long id;

    private Exhibition exhibition;

    private User user;

    private ArtistBoard artistBoard;

    private String artist;

    private String title;

    private String content;

    private String vrLink;

    private String[] image;

    private Long views;

    public PieceBoardDetailResponseDto(PieceBoard entity) {
        this.id = entity.getId();
        this.exhibition = entity.getExhibition();
        this.user = entity.getUser();
        this.artistBoard = entity.getArtistBoard();
        this.artist = entity.getArtist();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.vrLink = entity.getVrLink();
        this.image = imageStringToList(entity.getImage());
        this.views = entity.getViews();
    }

}
