package br.com.me.apileitura.summary;

import java.util.List;

class PreviousChapter extends AboutChapter {

    @Override
    Chapter execute(List<Chapter> chapters, Integer pageChapter) {
        return chapters.get(pageChapter - 2);
    }
}
