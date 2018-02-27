package com.shio.admin.error;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author afsilva
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    public RestResponseEntityExceptionHandler(){
        super();
    }

    // 400
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleBadRequest(final ConstraintViolationException ex, final WebRequest request) {
        ValidationResult resultBody = new ValidationResult();
        List<String> resultListBody = new ArrayList<String>();
        Set<ConstraintViolation<?>> cvs = ex.getConstraintViolations();
        for (ConstraintViolation<?> cv : cvs) {
            resultBody.addValidationError(cv.getPropertyPath().toString(), cv.getMessageTemplate());
            resultListBody.add(cv.getMessageTemplate());
        }

        return handleExceptionInternal(ex, resultListBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


}
