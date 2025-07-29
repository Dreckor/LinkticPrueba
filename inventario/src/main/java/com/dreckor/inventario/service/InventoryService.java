package com.dreckor.inventario.service;

import com.dreckor.inventario.client.ProductClient;
import com.dreckor.inventario.dto.PurchaseRequest;
import com.dreckor.inventario.model.Inventory;
import com.dreckor.inventario.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class InventoryService {

    private final InventoryRepository repository;
    private final ProductClient productClient;

    public InventoryService(InventoryRepository repository, ProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    public Inventory updateStock(UUID productoId, int nuevaCantidad) {
        Inventory inv = repository.findByProductoId(productoId)
                .orElseGet(() -> Inventory.builder()
                        .productoId(productoId)
                        .cantidad(0)
                        .build());

        inv.setCantidad(nuevaCantidad);
        return repository.save(inv);
    }

    public int getCantidad(UUID productoId) {
        return repository.findByProductoId(productoId)
                .map(Inventory::getCantidad)
                .orElse(0);
    }

    public Map<String, Object> purchase(PurchaseRequest request) {
        
        productClient.getProductById(request.productoId());

        Inventory inv = repository.findByProductoId(request.productoId())
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        if (inv.getCantidad() < request.cantidad()) {
            throw new RuntimeException("Inventario insuficiente");
        }

        inv.setCantidad(inv.getCantidad() - request.cantidad());
        repository.save(inv);

        Map<String, Object> result = new HashMap<>();
        result.put("productoId", request.productoId());
        result.put("cantidadComprada", request.cantidad());
        return result;
    }
}
