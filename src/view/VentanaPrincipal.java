/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author juane
 */
import viewmodel.ClinicaViewModel;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private CardLayout layout;
    private JPanel paneles;
    private ClinicaViewModel viewModel; // Instancia única

    public VentanaPrincipal() {
        setTitle("Gestión de Consultas Médicas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        viewModel = new ClinicaViewModel(); // Se crea una sola vez

        // Panel superior de navegación
        JPanel menu = new JPanel();
        JButton btnRegistro = new JButton("Registrar");
        JButton btnConsulta = new JButton("Asignar Consulta");
        JButton btnHistorial = new JButton("Historial");

        menu.add(btnRegistro);
        menu.add(btnConsulta);
        menu.add(btnHistorial);

        // Panel principal con layout dinámico
        layout = new CardLayout();
        paneles = new JPanel(layout);

        // PASAMOS el mismo viewModel a todos los paneles
        paneles.add(new PanelRegistro(viewModel), "REGISTRO");
        paneles.add(new PanelConsulta(viewModel), "CONSULTA");
        paneles.add(new PanelHistorial(viewModel), "HISTORIAL");

        // Botones que cambian de panel
        btnRegistro.addActionListener(e -> layout.show(paneles, "REGISTRO"));
        btnConsulta.addActionListener(e -> layout.show(paneles, "CONSULTA"));
        btnHistorial.addActionListener(e -> layout.show(paneles, "HISTORIAL"));

        // Añadir todo al JFrame
        setLayout(new BorderLayout());
        add(menu, BorderLayout.NORTH);
        add(paneles, BorderLayout.CENTER);

        setVisible(true);
    }
}
