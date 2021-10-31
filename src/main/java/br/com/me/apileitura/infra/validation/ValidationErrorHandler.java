package br.com.me.apileitura.infra.validation;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ValidationErrorsOutputDTO handleValidationErrorArgumentNotValid(MethodArgumentNotValidException exception) {

        List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        ValidationErrorsOutputDTO validationErrors = new ValidationErrorsOutputDTO();

        globalErrors.forEach(error -> validationErrors.addError(error.getDefaultMessage()));

        fieldErrors.forEach(error -> {
            validationErrors.addFieldError(error.getField(), error.getDefaultMessage());
        });

        return validationErrors;
    }

}
