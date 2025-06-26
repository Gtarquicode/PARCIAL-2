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
import excepciones.*;

import javax.swing.*;
import java.awt.*;

// Panel para asignar consultas médicas
public class PanelConsulta extends JPanel {

    private ClinicaViewModel viewModel;

    public PanelConsulta(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;
        setLayout(new GridLayout(6, 2));
        setBorder(BorderFactory.createTitledBorder("Asignar Consulta"));

        // Campos
        JTextField tfIdPaciente = new JTextField();
        JTextField tfIdMedico = new JTextField();
        JTextField tfSintomas = new JTextField();
        JTextField tfDiagnostico = new JTextField();
        JTextField tfTratamiento = new JTextField();
        JButton btnGuardar = new JButton("Guardar Consulta");

        add(new JLabel("ID Paciente:"));
        add(tfIdPaciente);
        add(new JLabel("ID Médico:"));
        add(tfIdMedico);
        add(new JLabel("Síntomas:"));
        add(tfSintomas);
        add(new JLabel("Diagnóstico:"));
        add(tfDiagnostico);
        add(new JLabel("Tratamiento:"));
        add(tfTratamiento);
        add(new JLabel()); // espacio vacío
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            try {
                viewModel.asignarConsulta(
                        tfIdPaciente.getText(),
                        tfIdMedico.getText(),
                        tfSintomas.getText(),
                        tfDiagnostico.getText(),
                        tfTratamiento.getText()
                );
                JOptionPane.showMessageDialog(this, "Consulta registrada.");
            } catch (CampoVacioException | UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
