package com.IMetA.IMetAwebservice.web.contact.dto;

import com.IMetA.IMetAwebservice.domain.ContactBoard;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ContactBoardDetailResponseDto extends ImageLinkConverter {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String title;

    private String content;

    private String[] image;

    public ContactBoardDetailResponseDto(ContactBoard entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.image = imageStringToList(entity.getImage());
    }


}
