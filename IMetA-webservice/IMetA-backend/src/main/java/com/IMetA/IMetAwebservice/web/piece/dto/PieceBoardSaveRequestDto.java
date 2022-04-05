package com.IMetA.IMetAwebservice.web.piece.dto;

import com.IMetA.IMetAwebservice.domain.ArtistBoard;
import com.IMetA.IMetAwebservice.domain.PieceBoard;
import com.IMetA.IMetAwebservice.domain.User;
import com.IMetA.IMetAwebservice.domain.enums.Exhibition;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PieceBoardSaveRequestDto extends ImageLinkConverter{

    @NotNull(message = "전시카테고리는 필수 입력 값입니다.")
    private Exhibition exhibition;

    @NotNull(message = "작성자는 필수 입력 값입니다.")
    private User user;

    @NotNull(message = "작가게시물은 필수 입력 값입니다.")
    private ArtistBoard artistBoard;

    @NotBlank(message = "작가명은 필수 입력 값입니다.")
    private String artist;

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;

    @NotNull(message = "내용은 필수 입력 값입니다.")
    private String content;

    private String vrLink;

    private String image;

    private Long views;

    @Builder
    public PieceBoardSaveRequestDto(Exhibition exhibition, User user, ArtistBoard artistBoard, String artist, String title, String content, String vrLink, String image) {
        this.exhibition = exhibition;
        this.user = user;
        this.artistBoard = artistBoard;
        this.artist = artist;
        this.title = title;
        this.content = content;
        this.vrLink = vrLink;
        this.image = image;
        this.views = Long.valueOf(0);
    }

    public void setImage(String[] imageList) {
        this.image = imageListToString(imageList);
    }

    public PieceBoard toEntity() {
        return PieceBoard.builder()
                .exhibition(exhibition)
                .user(user)
                .artistBoard(artistBoard)
                .artist(artist)
                .title(title)
                .content(content)
                .vrLink(vrLink)
                .image(image)
                .views(views)
                .build();
    }
}
