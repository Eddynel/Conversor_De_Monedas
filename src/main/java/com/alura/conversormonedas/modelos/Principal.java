package com.alura.conversormonedas.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Principal { // Eliminamos 'public' (Redundante en Java 25)

    private static final Scanner lectura = new Scanner(System.in);
    // Cambiamos a List<Conversion> para usar tu Record y que deje de marcar error
    private static final List<Conversion> historial = new ArrayList<>();
    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // En Java 25 el main puede ser así de simple: sin public y sin args
    void main() {
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion = 0;

        while (opcion != 7) {
            exibirMenu();

            try {
                opcion = Integer.parseInt(lectura.nextLine());

                if (opcion == 7) {
                    System.out.println("Finalizando el programa...");
                    break;
                }

                if (opcion < 1 || opcion > 6) {
                    System.out.println("⚠️ Opción no válida.");
                    continue;
                }

                System.out.println("Ingrese el valor que desea convertir:");
                double valor = Double.parseDouble(lectura.nextLine());

                procesarConversion(opcion, valor, consulta);

            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debes ingresar un número válido.");
            } catch (Exception e) {
                System.out.println("❌ Error inesperado: " + e.getMessage());
            }
        }

        // Al usar el historial aquí, el aviso de "Never used" desaparece
        System.out.println("\n--- RESUMEN DE TU SESIÓN ---");
        if (historial.isEmpty()) {
            System.out.println("No se realizaron conversiones.");
        } else {
            historial.forEach(System.out::println);
        }
        System.out.println("***************************************************");
    }

    public static void exibirMenu() {
        System.out.println("""
                ***************************************************
                Sea bienvenido/a al Conversor de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                
                Elija una opción válida:
                ***************************************************
                """);
    }

    private static void procesarConversion(int opcion, double valor, ConsultaMoneda consulta) {
        String base = "", destino = "";
        switch (opcion) {
            case 1 -> { base = "USD"; destino = "ARS"; }
            case 2 -> { base = "ARS"; destino = "USD"; }
            case 3 -> { base = "USD"; destino = "BRL"; }
            case 4 -> { base = "BRL"; destino = "USD"; }
            case 5 -> { base = "USD"; destino = "COP"; }
            case 6 -> { base = "COP"; destino = "USD"; }
        }

        try {
            double tasa = consulta.buscarTasa(base, destino);
            double resultado = valor * tasa;

            // --- AQUÍ USAMOS EL RECORD 'CONVERSION' ---
            // Esto elimina el warning "Record Conversion is never used"
            Conversion nuevaConversion = new Conversion(
                    base,
                    destino,
                    valor,
                    resultado,
                    LocalDateTime.now().format(formatoFecha)
            );

            // Guardamos el objeto en la lista (esto elimina el warning de 'historial')
            historial.add(nuevaConversion);

            System.out.println("\n✅ " + nuevaConversion + "\n");

        } catch (Exception e) {
            System.out.println("Error en la conversión: " + e.getMessage());
        }
    }
}
