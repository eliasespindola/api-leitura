package br.com.me.apileitura.summary;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryTest {

    @Test
    void should_return_properties_(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        TreeSet<Chapter> chapters = new TreeSet<Chapter>();
        chapters.add(firstChapter);
        chapters.add(secondChapter);
        chapters.add(threeChapter);

        Summary summary = new Summary("Resumo dos livros", chapters);

        assertThat(summary.numberChapters()).isEqualTo(3);
        assertThat(summary.getFirstChapter()).isEqualTo(firstChapter);
        assertThat(summary.getFiftyCharactersOfChapter()).isEqualTo(firstChapter.getFiftyCharactersToText());
    }

}