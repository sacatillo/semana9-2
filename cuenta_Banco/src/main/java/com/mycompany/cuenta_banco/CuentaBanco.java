/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuenta_banco;

import java.util.Scanner;

/**
 *
 * @author Martin Montes
 */
public class CuentaBanco {
    // Atributos
    private String cliente;
    private int numeroDeCuenta;
    private String telefono;
    private float limite;
    private float saldo;

    // Constructor
    public CuentaBanco() {
        // Inicializar los atributos con los valores predeterminados
        this.cliente = "";
        this.numeroDeCuenta = 0;
        this.telefono = "";
        this.limite = 999999;
        this.saldo = 0;
    }

    // Getters y Setters
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float getSaldo() {
        return saldo;
    }

    // Método para depositar dinero
    public void depositar(float monto) {
        if (monto > 0) {
            if (saldo + monto <= numeroDeCuenta) {
                saldo += monto;
                System.out.println("Depósito realizado exitosamente.");
                System.out.println("Nuevo saldo: " + saldo);
            } else {
                System.out.println("Error: El saldo no puede superar el número de cuenta.");
            }
        } else {
            System.out.println("Error: El monto a depositar debe ser un número positivo.");
        }
    }

    // Método para retirar dinero
    public void retirar(float monto) {
        if (monto > 0) {
            if (saldo - monto >= 0) {
                saldo -= monto;
                System.out.println("Retiro realizado exitosamente.");
                System.out.println ("Nuevo saldo: " + saldo);
            } else {
                System.out.println("Error: Saldo insuficiente para realizar el retiro.");
            }
        } else {
            System.out.println("Error: El monto a retirar debe ser un número positivo.");
        }
    }

    // Método principal para interactuar con el usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBanco cuenta = new CuentaBanco();

        System.out.println("Bienvenido a la cuenta bancaria.");
        System.out.print("Ingrese el nombre del cliente: ");
        cuenta.setCliente(scanner.nextLine());

        System.out.print("Ingrese el número de cuenta: ");
        cuenta.setNumeroDeCuenta(scanner.nextInt());

        System.out.print("Ingrese el teléfono del cliente: ");
        cuenta.setTelefono(scanner.next());

        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver saldo");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto a depositar: ");
                    float montoDeposito = scanner.nextFloat();
                    cuenta.depositar(montoDeposito);
                    break;
                case 2:
                    System.out.print("Ingrese el monto a retirar: ");
                    float montoRetiro = scanner.nextFloat();
                    cuenta.retirar(montoRetiro);
                    break;
                case 3:
                    System.out.println("Saldo actual: " + cuenta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. Gracias por usar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}