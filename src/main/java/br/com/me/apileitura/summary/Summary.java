package br.com.me.apileitura.summary;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class Summary {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "summary_id")
    @Size(min = 1)
    @OrderBy("sequence ASC")
    private SortedSet<Chapter> chapters = new TreeSet<>();

    @Deprecated
    protected Summary(){}

    public Summary(String title, TreeSet<Chapter> chapters) {
        this.title = title;
        this.chapters = chapters;
    }

    public Integer numberChapters(){
        return chapters.size();
    }

    public String getFiftyCharactersOfChapter(){
        return this.getChapters().first().getFiftyCharactersToText();
    }

    public Chapter getFirstChapter(){
        return this.chapters.first();
    }
}
