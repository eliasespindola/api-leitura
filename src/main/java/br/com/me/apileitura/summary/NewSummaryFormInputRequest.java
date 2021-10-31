package br.com.me.apileitura.summary;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class NewSummaryFormInputRequest {
    @NotBlank(message = "Title cannot be null or empty")
    private final String title;
    @Size(min = 1,message = "Min 1 chapter")
    @Valid
    private final Set<NewChapterFormInputRequest> newChapters;

    public NewSummaryFormInputRequest(String title, Set<NewChapterFormInputRequest> newChapters) {
        this.title = title;
        this.newChapters = newChapters;
    }

    Summary toModel(){
        TreeSet<Chapter> chapters = newChapters.
                stream()
                .map(NewChapterFormInputRequest::toModel)
                .collect(Collectors.toCollection(TreeSet::new));
        return new Summary(title,chapters);
    }
}
