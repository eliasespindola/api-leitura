package br.com.me.apileitura.summary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PreviousChapterTest {

    private PreviousChapter previousChapter;

    @BeforeEach
    public void setUp(){
        this.previousChapter = new PreviousChapter();
    }

    @Test
    void should_return_previous_chapter_with_base_in_current_page(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        List<Chapter> chapters = List.of(firstChapter, secondChapter, threeChapter);

        Chapter chapter = previousChapter.execute(chapters, 2);
        assertThat(chapter).isEqualTo(firstChapter);

        chapter = previousChapter.execute(chapters,3);
        assertThat(chapter).isEqualTo(secondChapter);
    }

    @Test
    void should_return_illegal_argument_exception_when_dont_have_previous_chapter(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        List<Chapter> chapters = List.of(firstChapter, secondChapter, threeChapter);

        assertThatThrownBy(() -> previousChapter.execute(chapters,1))
                .isInstanceOf(IllegalArgumentException .class)
                .hasMessage("Could not find previous chapter");
    }
}