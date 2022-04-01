package com.IMetA.IMetAwebservice.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum State {

    WAIT("답변대기"),
    COMPLETE("답변완료");

    private final String title;
}
