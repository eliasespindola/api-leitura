package br.com.me.apileitura.summary;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Chapter implements Comparable<Chapter>{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank
    @Getter
    private String title;
    @Lob
    @Getter
    private String text;
    private Integer sequence;

    @Deprecated
    protected Chapter(){}

    public Chapter(@NotBlank(message = "Title is required") String title, String text, @NotNull(message = "Order cannot be null") Integer sequence){
        this.title = title;
        this.text = text;
        this.sequence = sequence;
    }

    @Override
    public int compareTo(Chapter chapter) {
        return sequence - chapter.sequence;
    }

    public String getFiftyCharactersToText(){
        if(this.text.length() < 50){
            return this.text.substring(0,text.length());
        }
        return this.text.substring(0, 50);
    }
}
