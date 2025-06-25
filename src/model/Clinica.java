/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author juane
 */
import java.util.ArrayList;
import java.util.List;

// Clase que gestiona toda la clínica
public class Clinica {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Clinica() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    // Métodos para el registro de personas
    public void agregarPaciente(Paciente p) {
        pacientes.add(p);
    }

    public void agregarMedico(Medico m) {
        medicos.add(m);
    }

    public void agregarConsulta(Consulta c) {
        consultas.add(c);
        c.getMedico().agendarConsulta(c);
    }

    // Servicio de buscar
    public Paciente buscarPacientePorId(String id) {
        for (Paciente p : pacientes) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public Medico buscarMedicoPorId(String id) {
        for (Medico m : medicos) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    // Getters
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}

