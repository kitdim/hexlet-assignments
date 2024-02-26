package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.model.Book;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository repository;
    @Autowired
    private BookMapper mapper;

    public List<BookDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::map)
                .toList();
    }
    public BookDTO findById(Long id) {
        Book book =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found."));
        return mapper.map(book);
    }
    public BookDTO create(BookCreateDTO dto) {
        Book book = mapper.map(dto);
        repository.save(book);
        return mapper.map(book);
    }
    public BookDTO update(Long id, BookUpdateDTO dto) {
        Book book =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id " + id + " not found."));
        mapper.update(dto, book);
        repository.save(book);
        return mapper.map(book);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
