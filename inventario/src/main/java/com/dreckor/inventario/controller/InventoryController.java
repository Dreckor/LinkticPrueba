package com.dreckor.inventario.controller;

import com.dreckor.inventario.dto.PurchaseRequest;
import com.dreckor.inventario.service.InventoryService;
import com.dreckor.inventario.util.JsonApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<JsonApiResponse> getCantidad(@PathVariable UUID productoId) {
        int cantidad = service.getCantidad(productoId);
        return ResponseEntity.ok(new JsonApiResponse(Map.of("cantidad", cantidad)));
    }

    @PatchMapping("/{productoId}")
    public ResponseEntity<JsonApiResponse> updateCantidad(@PathVariable UUID productoId, @RequestBody Map<String, Integer> body) {
        int nuevaCantidad = body.getOrDefault("cantidad", 0);
        return ResponseEntity.ok(new JsonApiResponse(service.updateStock(productoId, nuevaCantidad)));
    }

    @PostMapping("/purchase")
    public ResponseEntity<JsonApiResponse> comprar(@RequestBody @Valid PurchaseRequest request) {
        Map<String, Object> resultado = service.purchase(request);
        return ResponseEntity.ok(new JsonApiResponse(resultado));
    }
}
