package com.raphael.Reading.Management.indicator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ReadingStatus {

    LIDOS("lidos"),
    LENDO("lendo"),
    A_LER("a ler");

    private final String text;

    public static ReadingStatus fromText(String text) {
        for (ReadingStatus value : ReadingStatus.values()) {
            if (value.text.equalsIgnoreCase(text)) {
                return value;
            }
        }
        return null;
    }
}