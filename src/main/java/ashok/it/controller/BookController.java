package ashok.it.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ashok.it.repository.BookData;
import ashok.it.service.impl.ServiceImpl;

@RestController
//@RequestMapping("book")
public class BookController {

	private ServiceImpl service;

	public BookController(ServiceImpl service) {
		super();
		this.service = service;
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody BookData bookdata) {

		service.upsertBook(bookdata);

		return new ResponseEntity<>("Book Data saved " + bookdata, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> findData(@PathVariable("id") Integer id) {

		Optional<BookData> data = service.getBook(id);

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> findData() {

		List<BookData> allBooks = service.getAllBook();

		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateData(@RequestBody BookData data){
		
		service.upsertBook(data);
		
		return new ResponseEntity<>("Book Data updated " + data, HttpStatus.CREATED);
		
	}

}
