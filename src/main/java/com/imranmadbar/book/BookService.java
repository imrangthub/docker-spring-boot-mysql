package com.imranmadbar.book;

import java.util.List;
import org.hibernate.PersistentObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public List<BookEntity> list() {
		return repository.list();
	}
	
	
	public BookEntity findById(Long id) {
		return repository.findById(id);
	}

	public BookEntity findByName(String userName) {
		return repository.findByName(userName);
	}

	public void saveOrUpdate(BookEntity obj) {
		try {
			if (obj.getId() == null) {
				repository.save(obj);
				return;
			}
			repository.update(obj);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}
	
	public String bookSave(String name,String  type) {
		BookEntity obj = new BookEntity();
		obj.setName(name);
		obj.setType(type);
		try {
			repository.save(obj);
			return "Book save successfully done !";
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new PersistentObjectException(ex.getCause().toString());
		}
	}



}
