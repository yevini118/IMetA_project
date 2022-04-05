package com.IMetA.IMetAwebservice.web.contact.dto;

import com.IMetA.IMetAwebservice.domain.ContactBoard;
import com.IMetA.IMetAwebservice.domain.enums.State;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ContactBoardResponseDto {

    private Long id;

    private String name;

    private String title;

    private State state;

    private LocalDateTime createdDate;

    public ContactBoardResponseDto(ContactBoard entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.title = entity.getTitle();
        this.state = entity.getState();
        this.createdDate = entity.getCreatedDate();
    }

}
