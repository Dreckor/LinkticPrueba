package com.dreckor.inventario.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PurchaseRequest(
    @NotNull UUID productoId,
    @Min(1) int cantidad
) {}
