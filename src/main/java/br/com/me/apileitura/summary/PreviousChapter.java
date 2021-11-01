package br.com.me.apileitura.summary;

import java.util.List;

class PreviousChapter extends AboutChapter {

    @Override
    Chapter execute(List<Chapter> chapters, Integer pageChapter) {
        try{
            return chapters.get(pageChapter - 2);
        }
        catch (IndexOutOfBoundsException ex){
            throw new IllegalArgumentException("Could not find previous chapter");
        }
    }
}
