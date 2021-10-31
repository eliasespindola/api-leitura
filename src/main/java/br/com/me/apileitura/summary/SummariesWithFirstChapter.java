package br.com.me.apileitura.summary;

import lombok.Getter;

@Getter
class SummariesWithFirstChapter {

    private final String title;
    private final Integer numberChapters;
    private final String textChapterWithFifty;

    public SummariesWithFirstChapter(Summary summary) {
        this.title = summary.getTitle();
        this.numberChapters = summary.numberChapters();
        this.textChapterWithFifty = summary.getFiftyCharactersOfChapter();
    }
}
