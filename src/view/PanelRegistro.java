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
import excepciones.CampoVacioException;

import javax.swing.*;
import java.awt.*;

// Panel para registrar pacientes o médicos
public class PanelRegistro extends JPanel {

    private ClinicaViewModel viewModel;

    public PanelRegistro(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;
        setLayout(new GridLayout(2, 1)); // Dividir en 2 secciones: paciente y médico

        // --- Panel de registro de paciente ---
        JPanel pacientePanel = new JPanel(new GridLayout(4, 2));
        pacientePanel.setBorder(BorderFactory.createTitledBorder("Registrar Paciente"));
        JTextField tfNombreP = new JTextField();
        JTextField tfIdP = new JTextField();
        JButton btnPaciente = new JButton("Guardar Paciente");

        pacientePanel.add(new JLabel("Nombre:"));
        pacientePanel.add(tfNombreP);
        pacientePanel.add(new JLabel("ID:"));
        pacientePanel.add(tfIdP);
        pacientePanel.add(new JLabel()); // Espacio vacío
        pacientePanel.add(btnPaciente);

        // --- Panel de registro de médico ---
        JPanel medicoPanel = new JPanel(new GridLayout(5, 2));
        medicoPanel.setBorder(BorderFactory.createTitledBorder("Registrar Médico"));
        JTextField tfNombreM = new JTextField();
        JTextField tfIdM = new JTextField();
        JTextField tfEsp = new JTextField();
        JButton btnMedico = new JButton("Guardar Médico");

        medicoPanel.add(new JLabel("Nombre:"));
        medicoPanel.add(tfNombreM);
        medicoPanel.add(new JLabel("ID:"));
        medicoPanel.add(tfIdM);
        medicoPanel.add(new JLabel("Especialidad:"));
        medicoPanel.add(tfEsp);
        medicoPanel.add(new JLabel()); // Espacio vacío
        medicoPanel.add(btnMedico);

        // Acción botón paciente
        btnPaciente.addActionListener(e -> {
            try {
                viewModel.registrarPaciente(tfNombreP.getText(), tfIdP.getText());
                JOptionPane.showMessageDialog(this, "Paciente registrado.");
            } catch (CampoVacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción botón médico
        btnMedico.addActionListener(e -> {
            try {
                viewModel.registrarMedico(tfNombreM.getText(), tfIdM.getText(), tfEsp.getText());
                JOptionPane.showMessageDialog(this, "Médico registrado.");
            } catch (CampoVacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(pacientePanel);
        add(medicoPanel);
    }
}