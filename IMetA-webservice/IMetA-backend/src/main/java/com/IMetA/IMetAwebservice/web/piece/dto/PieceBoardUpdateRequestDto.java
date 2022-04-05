package com.IMetA.IMetAwebservice.web.piece.dto;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.enums.Exhibition;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PieceBoardUpdateRequestDto extends ImageLinkConverter {

    private Exhibition exhibition;

    private ArtistBoard artistBoard;

    private String artist;

    private String title;

    private String content;

    private String vrLink;

    private String image;

    @Builder
    public PieceBoardUpdateRequestDto(Exhibition exhibition, ArtistBoard artistBoard, String artist, String title, String content, String vrLink, String image) {
        this.exhibition = exhibition;
        this.artistBoard = artistBoard;
        this.artist = artist;
        this.title = title;
        this.content = content;
        this.vrLink = vrLink;
        this.image = image;
    }

    public void setImage(String[] imageList) {
        this.image = imageListToString(imageList);
    }
}
