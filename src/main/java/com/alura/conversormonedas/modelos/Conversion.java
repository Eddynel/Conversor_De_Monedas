package com.alura.conversormonedas.modelos;

/**
 * Record que representa una operación de conversión realizada.
 * Ideal para el historial de la aplicación.
 */
public record Conversion(String monedaOrigen,
                         String monedaDestino,
                         double cantidadOriginal,
                         double resultado,
                         String fechaHora) {

    // Sobrescribimos
    @Override
    public String toString() {
        return String.format("[%s] %.2f %s =>> %.2f %s",
                fechaHora, cantidadOriginal, monedaOrigen, resultado, monedaDestino);
    }
}
