package br.com.me.apileitura.summary;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChapterTest {

    @Test
    void should_return_text_without_fifty_chars(){
        Chapter chapter = new Chapter("Titulo 1", "titulo pequeno", 1);
        assertThat(chapter.getFiftyCharactersToText()).isEqualTo("titulo pequeno");
    }

    @Test
    void should_return_text_with_fifty_chars(){
        String text = "Lorem ipsum dolor sit amet, consectetuer adipiscin";
        Chapter chapter = new Chapter("Titulo 1", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus", 1);
        assertThat(chapter.getFiftyCharactersToText()).isEqualTo(text);
    }
}