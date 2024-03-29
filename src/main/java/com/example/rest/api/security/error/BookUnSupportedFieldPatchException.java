package com.example.rest.api.security.error;

import java.util.Set;

public class BookUnSupportedFieldPatchException extends RuntimeException {
    public BookUnSupportedFieldPatchException(Set<String> keys) {
        super("Field ["+keys.toString()+"] update is not allowed.");
    }
}
