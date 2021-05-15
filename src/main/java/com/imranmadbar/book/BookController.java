package com.imranmadbar.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String index() {
		return "Message from Book API !";
	}

	@GetMapping("/list")
	public List<BookEntity> getList() {
		return bookService.list();
	}
	
	@GetMapping("/find-by-id")
	public BookEntity findById(@RequestParam(name="id") Long bookId) {
		return bookService.findById(bookId);
	}
	
	@GetMapping("/find-by-name")
	public BookEntity findByName(@RequestParam String name) {
		return bookService.findByName(name);
	}
	
	@GetMapping("/save")
	public String saveBook(@RequestParam String name, @RequestParam String type) {
		return bookService.bookSave(name, type);
	}

}
