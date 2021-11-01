package br.com.me.apileitura.summary;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class SummaryStatusTest {

    @Test
    public void should_return_next_chapter(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        TreeSet<Chapter> chapters = new TreeSet<Chapter>();
        chapters.add(firstChapter);
        chapters.add(secondChapter);
        chapters.add(threeChapter);

        Optional<Chapter> chapter = SummaryStatus.NEXT.execute(chapters, 1);
        Assertions.assertThat(chapter.get()).isEqualTo(secondChapter);
    }


    @Test
    public void should_return_previous_chapter(){
        Chapter firstChapter = new Chapter("Titulo 1", "Sou o texto do titulo 1", 1);
        Chapter secondChapter = new Chapter("Titulo 2", "Sou o texto do titulo 2", 2);
        Chapter threeChapter = new Chapter("Titulo 3", "Sou o texto do titulo 3", 3);

        TreeSet<Chapter> chapters = new TreeSet<Chapter>();
        chapters.add(firstChapter);
        chapters.add(secondChapter);
        chapters.add(threeChapter);

        Optional<Chapter> chapter = SummaryStatus.PREVIOUS.execute(chapters, 2);
        Assertions.assertThat(chapter.get()).isEqualTo(firstChapter);
    }

}