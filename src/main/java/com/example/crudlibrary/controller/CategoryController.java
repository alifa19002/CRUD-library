package com.example.crudlibrary.controller;

import com.example.crudlibrary.model.Category;
import com.example.crudlibrary.model.Response;
import com.example.crudlibrary.repository.CategoryRepository;
import com.example.crudlibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryService categoryService;

    @PostMapping /*Komunikasi API dengan jenis POST*/
    ResponseEntity<Response> create (@RequestBody @Validated Category category) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
//        response.setService(this.getClass().getName());
        response.setMessage("Berhasil Membuat Data");

        /*Set Data Dari Database*/
        response.setData(categoryService.create(category));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    @PutMapping("/{id}")/*Komunikasi API dengan jenis PUT*/
    ResponseEntity<Response> update (@PathVariable ("id")Long id, @RequestBody @Validated Category category) /*Mengambil Request data dari Body dan melakukan Proses Validasi, diseleksi berdasarkan id*/
    {
        Response response = new Response();
//        response.setService(this.getClass().getName());
        response.setMessage("Berhasil Update Data");

        /*Set Data Dari Database*/
        response.setData(categoryService.update(id, category));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> getById (@PathVariable ("id")Long id)/*Mengambil Request data dari Berdasarkan id*/
    {
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
//        response.setService(this.getClass().getName());
        response.setMessage("Berhasil Mengambil Data Berdasarkan Id");

        /*Set Data Dari Database*/
        response.setData(categoryService.findById(id));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> findAll ()
    {
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
//        response.setService(this.getClass().getName());
        response.setMessage("Berhasil Menampilkan Seluruh Data");

        /*Set Data Dari Database*/
        response.setData(categoryService.findAll());

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")/*Komunikasi API dengan jenis GET*/
    ResponseEntity<Response> deleteById (@PathVariable ("id")Long id)/*Mengambil Request data dari Berdasarkan id*/
    {
        /*Memanggil Class Response yang telah dibuat*/
        Response response = new Response();
//        response.setService(this.getClass().getName());
        response.setMessage("Data Berhasil dihapus");
        response.setData(categoryService.findById(id));

        categoryService.delete(id);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

//    @GetMapping("/books")
//    public ResponseEntity<List<Category>> findByPublished() {
//        List<Category> tutorials = categoryRepository.findByPublished(true);
//
//        if (tutorials.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        return new ResponseEntity<>(tutorials, HttpStatus.OK);
//    }
}
