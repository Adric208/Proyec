package org.example.Vista;

import org.example.Controlador.ControladorPrincesas;
import org.example.Vista.VentanaPrincesas;

public class Main {
    public static void main(String[] args) {

        VentanaPrincesas view = new VentanaPrincesas("Princesas Disney");
        ControladorPrincesas controller = new ControladorPrincesas(view);

    }
}