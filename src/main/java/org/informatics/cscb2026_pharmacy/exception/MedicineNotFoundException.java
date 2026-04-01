package org.informatics.cscb2026_pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MedicineNotFoundException extends ObjectNotFoundException {
    public MedicineNotFoundException(String message, long id) {
        super(message, id);
    }
}
