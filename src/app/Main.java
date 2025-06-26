/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author juane
 */
import view.VentanaPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Lanza la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal(); // Crea la ventana principal
        });
    }
}
