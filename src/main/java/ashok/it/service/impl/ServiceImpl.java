package ashok.it.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ashok.it.repository.BookData;
import ashok.it.repository.BookRepository;
import ashok.it.service.IService;

@Service
public class ServiceImpl implements IService {

	private BookRepository repo;

	public ServiceImpl(BookRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String upsertBook(BookData bookdata) {
		repo.save(bookdata);
		return "Book Data Saved";
	}

	@Override
	public Optional<BookData> getBook(Integer bookId) {
		Optional<BookData> data = repo.findById(bookId);
		if (data.isPresent()) {
			return data;
		}
		return null;
	}

	@Override
	public List<BookData> getAllBook() {
		List<BookData> data = repo.findAll();
		return data;
	}

	@Override
	public String updateBook(BookData bookdata) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBook(Integer bookId) {
		repo.deleteById(bookId);

	}

}
