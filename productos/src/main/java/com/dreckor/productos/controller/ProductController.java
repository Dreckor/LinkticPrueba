package com.dreckor.productos.controller;

import com.dreckor.productos.api.JsonApiResponse;
import com.dreckor.productos.dto.ProductRequest;
import com.dreckor.productos.model.Product;
import com.dreckor.productos.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JsonApiResponse> create(@RequestBody @Valid ProductRequest request) {
        Product product = Product.builder()
                .nombre(request.nombre())
                .precio(request.precio())
                .descripcion(request.descripcion())
                .build();

        return ResponseEntity.ok(new JsonApiResponse(service.create(product)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonApiResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(new JsonApiResponse(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<JsonApiResponse> getAll() {
        return ResponseEntity.ok(new JsonApiResponse(service.findAll()));
    }
}