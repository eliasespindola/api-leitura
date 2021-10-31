package br.com.me.apileitura.infra.validation;

class FieldErrorOutputDTO {

    private final String field;
    private final String message;

    public FieldErrorOutputDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
