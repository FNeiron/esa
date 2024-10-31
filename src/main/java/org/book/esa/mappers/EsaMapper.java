package org.book.esa.mappers;

import org.book.esa.dto.AuthorDto;
import org.book.esa.dto.GenreDto;
import org.book.esa.dto.StoryDto;
import org.book.esa.models.Author;
import org.book.esa.models.Genre;
import org.book.esa.models.Story;

import java.util.LinkedList;

public class EsaMapper {

    public static AuthorDto mapAuthorToAuthorDto(Author author) {
        return new AuthorDto(author.getId(), author.getName(), author.getNickname());
    }

    public static Author mapAuthorDtoToAuthor(AuthorDto authorDto) {
        return new Author(authorDto.getId(), authorDto.getName(), authorDto.getNickname(), null);
    }

    public static GenreDto mapGenreToGenreDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

    public static Genre mapGenreDtoToGenre(GenreDto genreDto) {
        return new Genre(genreDto.getId(), genreDto.getName(), null);
    }

    public static StoryDto mapStoryToStoryDto(Story story) {
        var authors = story.getAuthors();
        var authorsDto = new LinkedList<AuthorDto>();
        for (Author author : authors) {
            authorsDto.add(mapAuthorToAuthorDto(author));
        }
        return new StoryDto(story.getId(), story.getName(), mapGenreToGenreDto(story.getGenre()), authorsDto);
    }

    public static Story mapStoryDtoToStory(StoryDto storyDto) {
        var authors = new LinkedList<Author>();
        for (AuthorDto authorDto : storyDto.getAuthors()) {
            authors.add(mapAuthorDtoToAuthor(authorDto));
        }
        return new Story(storyDto.getId(), storyDto.getName(), mapGenreDtoToGenre(storyDto.getGenre()), authors);
    }
}
