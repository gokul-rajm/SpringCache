package springCache.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	
    @Id
    private Long id;
    private String title;
    private String author;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(Long id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
}

