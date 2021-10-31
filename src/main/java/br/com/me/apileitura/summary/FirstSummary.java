package br.com.me.apileitura.summary;

import lombok.Getter;

@Getter
class FirstSummary {

    private final String title;
    private final String text;

    public FirstSummary(Chapter chapter) {
        this.title = chapter.getTitle();
        this.text = chapter.getText();
    }
}
