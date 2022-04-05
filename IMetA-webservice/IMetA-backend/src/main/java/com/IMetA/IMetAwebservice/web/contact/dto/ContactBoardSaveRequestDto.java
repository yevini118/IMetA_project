package com.IMetA.IMetAwebservice.web.contact.dto;

import com.IMetA.IMetAwebservice.domain.ContactBoard;
import com.IMetA.IMetAwebservice.domain.enums.State;
import com.IMetA.IMetAwebservice.web.s3.ImageLinkConverter;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class ContactBoardSaveRequestDto extends ImageLinkConverter {

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "형식에 맞지 않는 이메일입니다.")
    private String email;

    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "형식에 맞지 않는 전화번호입니다.")
    private String phone;

    @NotBlank(message = "제목은 필수 입력 값입니다.")
    private String title;

    @NotBlank(message = "내용은 필수 입력 값입니다.")
    private String content;

    @NotNull
    private String image;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "[0-9]{4}", message = "형식에 맞지 않는 비밀번호입니다.")
    private String password;

    @NotNull
    private State state;

    @Builder
    public ContactBoardSaveRequestDto(String name, String email, String phone, String title, String content, String image, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.title = title;
        this.content = content;
        this.image = image;
        this.password = password;
        this.state = State.WAIT;
    }

    public void setImage(String[] imageList) {
        this.image = imageListToString(imageList);
    }

    public ContactBoard toEntity() {
        return ContactBoard.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .title(title)
                .content(content)
                .image(image)
                .password(password)
                .state(state).build();
    }
}
