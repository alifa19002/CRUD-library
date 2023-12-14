package com.example.crudlibrary.controller;

import com.example.crudlibrary.model.Category;
import com.example.crudlibrary.model.Response;
import com.example.crudlibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    ResponseEntity<Response> create (@RequestBody @Validated Category category)
    {
        Response response = new Response();
        response.setMessage("Berhasil Membuat Data");

        response.setData(categoryService.create(category));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    @PutMapping("/{id}")
    ResponseEntity<Response> update (@PathVariable ("id")Long id, @RequestBody @Validated Category category) /*Mengambil Request data dari Body dan melakukan Proses Validasi, diseleksi berdasarkan id*/
    {
        Response response = new Response();
        response.setMessage("Berhasil Update Data");

        response.setData(categoryService.update(id, category));

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<Response> getById (@PathVariable ("id")Long id)/*Mengambil Request data dari Berdasarkan id*/
    {

        Response response = new Response();
        try {
            response.setData(categoryService.findById(id));
            response.setMessage("Berhasil Mengambil Data Berdasarkan Id");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        } catch(Exception e){
            response.setMessage("Gagal mengambil Data Id");
            response.setData(null);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        }
    }

    @GetMapping
    ResponseEntity<Response> findAll ()
    {
        Response response = new Response();
        response.setMessage("Berhasil Menampilkan Seluruh Data");

        response.setData(categoryService.findAll());

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Response> deleteById (@PathVariable ("id")Long id)
    {
        Response response = new Response();
        response.setMessage("Data Berhasil dihapus");
        response.setData(categoryService.findById(id));

        categoryService.delete(id);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
