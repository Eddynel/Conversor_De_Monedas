package com.alura.conversormonedas.modelos;

public record TasaDeCambio(String base_code,
                           String target_code,
                           double conversion_rate) {
}
