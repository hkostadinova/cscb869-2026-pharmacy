package org.informatics.cscb2026_pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends ObjectNotFoundException {
    public RecipeNotFoundException(String message, long id) {
        super(message, id);
    }
}
