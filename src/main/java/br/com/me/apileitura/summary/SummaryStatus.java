package br.com.me.apileitura.summary;

import java.util.Optional;
import java.util.SortedSet;

enum SummaryStatus {
    PREVIOUS(new PreviousChapter()),
    NEXT(new NextChapter());

    private final AboutChapter aboutChapter;

    SummaryStatus(AboutChapter aboutChapter) {
        this.aboutChapter = aboutChapter;
    }

    public Optional<Chapter> execute(SortedSet<Chapter> chapters, Integer currentPage){
        return aboutChapter.aboutChapter(chapters,currentPage);
    }
}
