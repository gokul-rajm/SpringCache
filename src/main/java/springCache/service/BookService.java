package springCache.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import springCache.Entity.Book;
import springCache.Repository.BookRepository;

@Service
public class BookService {
	
	Logger loggers = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;
    
    @CacheEvict(value = "books", allEntries = true)
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBookById(Long id) {
    	loggers.info("getting from DB");
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @CachePut(cacheNames = "books", key = "#book.id" )
    public Book updateBook(Long id, Book book) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            bookRepository.save(existingBook);
            return existingBook;
        }
        return null;
    }

    @CacheEvict(value = "books", allEntries = true)
    public void clearCache() {
    }
    
}

