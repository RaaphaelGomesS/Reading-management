package com.raphael.Reading.Management.service.validator;

import com.raphael.Reading.Management.exception.BookException;
import com.raphael.Reading.Management.model.Reader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

@UtilityClass
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OwnerValidator {

    public static void verifyOwner(long bookId, Reader reader) {

        boolean book = reader.getBooks().stream().anyMatch(b -> b.getBookId() == bookId);

        if (!book) {
            throw new BookException("This book not has relation with your account." , HttpStatus.UNAUTHORIZED);
        }
    }
}
