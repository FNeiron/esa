package org.book.esa.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.book.esa.dto.GenreDto;
import org.book.esa.mappers.EsaMapper;
import org.book.esa.repositories.GenreRepository;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class GenreService {
    @Inject
    private GenreRepository genreRepository;

    public GenreDto findById(Long id) {
        return EsaMapper.mapGenreToGenreDto(genreRepository.findById(id)
        );
    }

    public Long save(GenreDto genreDto) {
        return genreRepository.save(EsaMapper.mapGenreDtoToGenre(genreDto));
    }

    public void deleteById(Long id) {
        genreRepository.deleteById(id);
    }

    public List<GenreDto> findAll() {
        var genres = genreRepository.findAll();
        var genresDtoList = new ArrayList<GenreDto>();

        for (var genre : genres) {
            genresDtoList.add(EsaMapper.mapGenreToGenreDto(genre));
        }
        return genresDtoList;
    }
}
