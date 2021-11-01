package br.com.me.apileitura.summary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NextChapterTest {
    private NextChapter nextChapter;

    @BeforeEach
    public void setUp(){
        this.nextChapter = new NextChapter();
    }

    @Test
    void should_return_next_chapter_with_base_in_current_page(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        List<Chapter> chapters = List.of(firstChapter, secondChapter, threeChapter);

        Chapter chapter = nextChapter.execute(chapters, 2);
        assertThat(chapter).isEqualTo(threeChapter);

        chapter = nextChapter.execute(chapters,1);
        assertThat(chapter).isEqualTo(secondChapter);
    }

    @Test
    void should_return_illegal_argument_exception_when_dont_have_next_chapter(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        List<Chapter> chapters = List.of(firstChapter, secondChapter, threeChapter);

        assertThatThrownBy(() -> nextChapter.execute(chapters,3))
                .isInstanceOf(IllegalArgumentException .class)
                .hasMessage("Could not find next chapter");
    }
}