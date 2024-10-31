package org.book.esa.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.book.esa.dto.AuthorDto;
import org.book.esa.mappers.EsaMapperFactory;
import org.book.esa.services.AuthorService;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(name = "authorServlet", value = "/authors")
public class AuthorServlet extends HttpServlet {

    private final ObjectMapper objectMapper = EsaMapperFactory.json();

    @Inject
    private AuthorService authorService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/json");

        try (PrintWriter out = response.getWriter()) {
            out.print(objectMapper.writeValueAsString(authorService.findAll()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try (InputStream is = req.getInputStream()) {
            AuthorDto authorDto = objectMapper.readValue(is, AuthorDto.class);
            authorService.save(authorDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.valueOf(req.getPathInfo().substring(1));
        authorService.deleteById(id);
    }
}