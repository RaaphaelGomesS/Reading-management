package com.raphael.ReadingManagement.utils;

import lombok.experimental.UtilityClass;

import java.text.Normalizer;
import java.util.regex.Pattern;

@UtilityClass
public class StringUtils {

    public static String normalizeName(String name) {

        if (name == null) {
            return null;
        }

        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

        String withoutAccents = pattern.matcher(normalized).replaceAll("");

        return withoutAccents.toUpperCase();
    }
}
