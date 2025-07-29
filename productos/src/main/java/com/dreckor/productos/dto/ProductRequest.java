package com.dreckor.productos.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank String nombre,
        @NotNull @DecimalMin("0.0") BigDecimal precio,
        String descripcion
) {}