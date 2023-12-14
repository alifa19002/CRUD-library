package com.example.crudlibrary.controller;

import com.example.crudlibrary.model.Book;
import com.example.crudlibrary.model.Response;
import com.example.crudlibrary.repository.BookRepository;
import com.example.crudlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    @PostMapping /*Komunikasi API dengan jenis POST*/
    ResponseEntity<Response> create (@RequestBody @Validated Book book) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        Response response = new Response();
        response.setMessage("Berhasil Membuat Data");
        Long categoryId = book.getCategId();
        response.setData(bookService.create(book, categoryId));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    @PutMapping("/{id}")/*Komunikasi API dengan jenis PUT*/
    ResponseEntity<Response> update (@PathVariable ("id")Long id, @RequestBody @Validated Book book) /*Mengambil Request data dari Body dan melakukan Proses Validasi, diseleksi berdasarkan id*/
    {

        Response response = new Response();
        response.setMessage("Berhasil Update Data");
        response.setData(bookService.update(id, book));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> getById (@PathVariable ("id")Long id)/*Mengambil Request data dari Berdasarkan id*/
    {
        Response response = new Response();
        response.setMessage("Berhasil Mengambil Data Berdasarkan Id");

        /*Set Data Dari Database*/
        response.setData(bookService.findById(id));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> findAll ()
    {
        Response response = new Response();
        response.setMessage("Berhasil Menampilkan Seluruh Data");

        response.setData(bookService.findAll());

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> deleteById (@PathVariable ("id")Long id)/*Mengambil Request data dari Berdasarkan id*/
    {
        Response response = new Response();
        response.setMessage("Data Berhasil dihapus");
        response.setData(bookService.findById(id));

        bookService.delete(id);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
