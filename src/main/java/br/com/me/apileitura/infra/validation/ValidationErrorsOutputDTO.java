package br.com.me.apileitura.infra.validation;

import java.util.ArrayList;
import java.util.List;

class ValidationErrorsOutputDTO {
    private final List<String> globalErrorMessages = new ArrayList<>();
    private final List<FieldErrorOutputDTO> fieldErrors = new ArrayList<>();

    void addError(String message) {
        globalErrorMessages.add(message);
    }

    void addFieldError(String field, String message) {
        FieldErrorOutputDTO fieldError = new FieldErrorOutputDTO(field, message);
        fieldErrors.add(fieldError);
    }

    public List<String> getGlobalErrorMessages() {
        return globalErrorMessages;
    }

    public List<FieldErrorOutputDTO> getErrors() {
        return fieldErrors;
    }

    public int getNumberOfErrors() {
        return this.globalErrorMessages.size() + this.fieldErrors.size();
    }
}
