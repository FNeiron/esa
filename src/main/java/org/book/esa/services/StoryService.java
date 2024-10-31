package org.book.esa.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.book.esa.dto.StoryDto;
import org.book.esa.mappers.EsaMapper;
import org.book.esa.repositories.StoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class StoryService {
    @Inject
    private StoryRepository storyRepository;

    public StoryDto findById(Long id) {
        return EsaMapper.mapStoryToStoryDto(storyRepository.findById(id));
    }

    public Long save(StoryDto storyDto) {
        return storyRepository.save(EsaMapper.mapStoryDtoToStory(storyDto));
    }

    public void deleteById(Long id) {
        storyRepository.deleteById(id);
    }

    public List<StoryDto> findAll() {
        return storyRepository.findAll().stream()
               .map(EsaMapper::mapStoryToStoryDto)
               .collect(Collectors.toList());
    }
}
