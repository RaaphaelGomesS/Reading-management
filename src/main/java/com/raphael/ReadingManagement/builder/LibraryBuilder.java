package com.raphael.ReadingManagement.builder;

import com.raphael.ReadingManagement.model.Library;
import com.raphael.ReadingManagement.model.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class LibraryBuilder {

    public static Library from(String name, Reader reader) {

        return Library.builder()
                .name(StringUtils.normalizeName(name))
                .reader(reader)
                .books(new ArrayList<>())
                .build();
    }
}
