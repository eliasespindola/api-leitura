package br.com.me.apileitura.summary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;

abstract class AboutChapter {
    public Optional<Chapter> aboutChapter(SortedSet<Chapter> chapters,Integer pageChapter){
        List<Chapter> currentChapters= new ArrayList<>(chapters);
        Chapter chapter = execute(currentChapters,pageChapter);
        return Optional.ofNullable(chapter);
    }

    abstract Chapter execute(List<Chapter> chapters,Integer pageChapter);
}
