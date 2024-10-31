package org.book.esa.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.book.esa.dto.AuthorDto;
import org.book.esa.mappers.EsaMapper;
import org.book.esa.repositories.AuthorRepository;

import java.util.LinkedList;
import java.util.List;

@Stateless
public class AuthorService {
    @Inject
    private AuthorRepository authorRepository;

    public AuthorDto findById(Long id) {
        return EsaMapper.mapAuthorToAuthorDto(authorRepository.findById(id));
    }

    public Long save(AuthorDto author) {
        return authorRepository.save(EsaMapper.mapAuthorDtoToAuthor(author));
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<AuthorDto> findAll() {
        var authors = authorRepository.findAll();
        var authorDto = new LinkedList<AuthorDto>();
        for (var author : authors) {
            authorDto.add(EsaMapper.mapAuthorToAuthorDto(author));
        }
        return authorDto;
    }
}
