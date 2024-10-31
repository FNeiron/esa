package org.book.esa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

@Data
@AllArgsConstructor
public class StoryDto {
    private Long id;
    private String name;
    private GenreDto genre;
    private LinkedList<AuthorDto> authors;
}
