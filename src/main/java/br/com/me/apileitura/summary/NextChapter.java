package br.com.me.apileitura.summary;

import java.util.List;

class NextChapter extends AboutChapter {

    @Override
    Chapter execute(List<Chapter> chapters, Integer pageChapter) {
        try{
            return chapters.get(pageChapter);
        }
        catch (IndexOutOfBoundsException ex){
            throw new IllegalArgumentException("Could not find next chapter");
        }

    }
}
