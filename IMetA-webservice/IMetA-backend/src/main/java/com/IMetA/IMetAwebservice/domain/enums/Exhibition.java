package com.IMetA.IMetAwebservice.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Exhibition {

    OFFLINE("오프라인"),
    ONLINE("온라인");

    private final String title;
}
