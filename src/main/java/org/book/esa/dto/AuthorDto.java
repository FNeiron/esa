package org.book.esa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    private String name;
    private String nickname;
}
