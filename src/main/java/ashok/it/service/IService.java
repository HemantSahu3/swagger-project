package ashok.it.service;

import java.util.List;
import java.util.Optional;

import ashok.it.repository.BookData;

public interface IService {

	public String upsertBook(BookData bookdata);

	public Optional<BookData> getBook(Integer bookId);
	
	public List<BookData> getAllBook();

	public String updateBook(BookData bookdata);

	public void deleteBook(Integer bookId);

}
