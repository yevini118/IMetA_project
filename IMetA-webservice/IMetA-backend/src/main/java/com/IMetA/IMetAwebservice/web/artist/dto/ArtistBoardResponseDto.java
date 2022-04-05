package com.IMetA.IMetAwebservice.web.artist.dto;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArtistBoardResponseDto extends ImageLinkConverter {

    private Long id;

    private String name;

    private String note;

    private String[] image;

    public ArtistBoardResponseDto(ArtistBoard entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.note = entity.getNote();
        this.image = imageStringToList(entity.getImage());
    }

}
