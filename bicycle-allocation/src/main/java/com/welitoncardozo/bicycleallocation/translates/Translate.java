package com.welitoncardozo.bicycleallocation.translates;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
@Getter
public enum Translate {
    BASE_NAME_MESSAGES("i18n/messages"),
    DELIMITER_KEY(",");

    private final String value;
}
