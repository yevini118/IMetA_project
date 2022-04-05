package com.IMetA.IMetAwebservice.web.artist.dto;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class ArtistBoardSaveRequestDto extends ImageLinkConverter{

    private PieceBoard pieceBoard;

    @NotBlank(message = "작가명은 필수 입력 값입니다.")
    private String name;

    private String note;

    private String image;

    private String education;

    private String career;

    @Builder
    public ArtistBoardSaveRequestDto(PieceBoard pieceBoard, String name, String note, String image, String education, String career) {
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

    public ArtistBoard toEntity() {
        return ArtistBoard.builder()
                .pieceBoard(pieceBoard)
                .name(name)
                .note(note)
                .image(image)
                .education(education)
                .career(career)
                .build();
    }
}
