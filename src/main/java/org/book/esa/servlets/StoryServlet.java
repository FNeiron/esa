package org.book.esa.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.book.esa.dto.StoryDto;
import org.book.esa.mappers.EsaMapperFactory;
import org.book.esa.services.StoryService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "storyServlet", value = "/stories")
public class StoryServlet extends HttpServlet {

    private final ObjectMapper objectMapper = EsaMapperFactory.json();

    @Inject
    private StoryService storyService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(storyService.findAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            StoryDto storyDto = objectMapper.readValue(is, StoryDto.class);
            storyService.save(storyDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getPathInfo().substring(1));
        storyService.deleteById(id);
    }
}