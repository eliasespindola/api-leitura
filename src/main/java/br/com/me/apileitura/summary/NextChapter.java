package br.com.me.apileitura.summary;

import java.util.List;

class NextChapter extends AboutChapter {

    @Override
    Chapter execute(List<Chapter> chapters, Integer pageChapter) {
        return chapters.get(pageChapter);
    }
}
