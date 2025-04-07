/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.teatromoro2;

import java.util.Scanner;

public class TeatroMoro2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuarMenu = true;

            for (int i = 0; i < 2; i++) {
                System.out.println((i + 1) + ". " + (i == 0 ? "Comprar entrada" : "Salir"));
            }

            while (continuarMenu) {
                System.out.print("Selecciona una opción: ");
                if (scanner.hasNextInt()) {
                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1 -> {
                            boolean seguirComprando = true;
                            while (seguirComprando) {
                                comprarEntrada(scanner);
                                boolean respuestaValida = false;
                                while (!respuestaValida) {
                                    System.out.println("\n¿Deseas realizar otra compra?");
                                    System.out.println("1. Sí");
                                    System.out.println("2. No");
                                    System.out.print("Selecciona una opción: ");

                                    if (scanner.hasNextInt()) {
                                        int opcionOtraCompra = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (opcionOtraCompra) {
                                            case 1 -> {
                                                respuestaValida = true;
                                            }
                                            case 2 -> {
                                                respuestaValida = true;
                                                System.out.println("¡Gracias por su compra! Saliendo del sistema.");
                                                seguirComprando = false;
                                                continuarMenu = false;
                                            }
                                            default -> {
                                                System.out.println("Opción inválida. Por favor, elige 1 (Sí) o 2 (No).");
                                            }
                                        }
                                    } else {
                                        System.out.println("Entrada inválida. Por favor, ingresa un número.");
                                        scanner.nextLine();
                                    }
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("¡Gracias por usar el sistema!");
                            continuarMenu = false;
                        }
                        default -> System.out.println("Opción inválida.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingresa un número.");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void comprarEntrada(Scanner scanner) {
        boolean zonaValida = false;
        String zona = "";
        double precioBase = 0;
        int zonaSeleccionada = 0;

        while (!zonaValida) {
            System.out.println("\n===== Plano del Teatro =====");
            System.out.println("1. Zona A ($50) | 2. Zona B ($40) | 3. Zona C ($30)");
            System.out.print("Selecciona la zona (1, 2, o 3): ");
            if (scanner.hasNextInt()) {
                zonaSeleccionada = scanner.nextInt();
                scanner.nextLine();
                if (zonaSeleccionada >= 1 && zonaSeleccionada <= 3) {
                    zonaValida = true;
                    switch (zonaSeleccionada) {
                        case 1 -> {
                            zona = "A";
                            precioBase = 50;
                        }
                        case 2 -> {
                            zona = "B";
                            precioBase = 40;
                        }
                        case 3 -> {
                            zona = "C";
                            precioBase = 30;
                        }
                    }
                } else {
                    System.out.println("Zona inválida. Por favor, elige una opción entre 1 y 3.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                scanner.nextLine();
            }
        }

        boolean edadValida = false;
        int edad = 0;

        while (!edadValida) {
            System.out.print("Ingresa tu edad: ");
            if (scanner.hasNextInt()) {
                edad = scanner.nextInt();
                scanner.nextLine();
                if (edad > 0 && edad <= 100) { // Rango de edad razonable
                    edadValida = true;
                } else {
                    System.out.println("¡Edad ingresada no válida! Por favor, ingresa una edad válida.");
                }
            }
        }

        double descuento = 0;
        String detalleDescuento = "No se aplicó descuento.";
        double precioFinal = precioBase;

        if (edad >= 1 && edad <= 5) {
            precioFinal = 0;
            detalleDescuento = "Entrada gratuita para niños de 1 a 5 años.";
        } else if (edad >= 6 && edad <= 25) {
            descuento = 0.10;
            precioFinal = precioBase * (1 - descuento);
            detalleDescuento = "Descuento aplicado: 10% (Estudiante).";
        } else if (edad >= 65) {
            descuento = 0.15;
            precioFinal = precioBase * (1 - descuento);
            detalleDescuento = "Descuento aplicado: 15% (Adulto Mayor).";
        }

        System.out.println("\n===== Detalle de la Compra =====");
        System.out.println("Zona seleccionada: " + zona);
        System.out.println("Precio base: $" + precioBase);
        System.out.println(detalleDescuento);
        System.out.println("Precio final a pagar: $" + String.format("%.2f", precioFinal));
    }
}