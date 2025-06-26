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
import excepciones.UsuarioNoEncontradoException;
import model.Consulta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// Panel para consultar historial de paciente o médico
public class PanelHistorial extends JPanel {

    private ClinicaViewModel viewModel;

    public PanelHistorial(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Historial Médico"));

        // Panel superior
        JPanel topPanel = new JPanel();
        JTextField tfId = new JTextField(10);
        JButton btnBuscarPaciente = new JButton("Buscar Paciente");
        JButton btnBuscarMedico = new JButton("Buscar Médico");
        topPanel.add(new JLabel("ID:"));
        topPanel.add(tfId);
        topPanel.add(btnBuscarPaciente);
        topPanel.add(btnBuscarMedico);

        // Área de texto
        JTextArea taResultados = new JTextArea();
        taResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(taResultados);

        // Botones
        btnBuscarPaciente.addActionListener(e -> {
            try {
                List<Consulta> historial = viewModel.obtenerHistorialPaciente(tfId.getText());
                taResultados.setText("");
                for (Consulta c : historial) {
                    taResultados.append(c.toString() + "\n\n");
                }
            } catch (UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBuscarMedico.addActionListener(e -> {
            try {
                List<Consulta> historial = viewModel.obtenerConsultasMedico(tfId.getText());
                taResultados.setText("");
                for (Consulta c : historial) {
                    taResultados.append(c.toString() + "\n\n");
                }
            } catch (UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(topPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}

