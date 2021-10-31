package br.com.me.apileitura.summary;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

class NewChapterFormInputRequest {

    @NotBlank(message = "Title is required")
    private final String title;
    @Lob
    private final String text;
    @NotNull(message = "Order cannot be null")
    private final Integer sequence;

    public NewChapterFormInputRequest(String title, String text, Integer sequence) {
        this.title = title;
        this.text = text;
        this.sequence = sequence;
    }

    public Chapter toModel(){
        return new Chapter(this.title,this.text,this.sequence);
    }
}
