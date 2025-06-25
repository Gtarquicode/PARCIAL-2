/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author juane
 */
import java.io.Serializable;
import java.time.LocalDate;

// Clase que representa una consulta médica
public class Consulta implements Serializable {
    private Paciente paciente;
    private Medico medico;
    private String sintomas;
    private String diagnostico;
    private String tratamiento;
    private LocalDate fecha;

    public Consulta(Paciente paciente, Medico medico, String sintomas, String diagnostico, String tratamiento) {
        this.paciente = paciente;
        this.medico = medico;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fecha = LocalDate.now(); // Para obtener fecha actual
    }

    // Getters
    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getResumen() {
        return fecha + " | Paciente: " + paciente.getNombre() + " | Diagnóstico: " + diagnostico;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha +
               "\nPaciente: " + paciente.getNombre() +
               "\nMédico: " + medico.getNombre() +
               "\nSíntomas: " + sintomas +
               "\nDiagnóstico: " + diagnostico +
               "\nTratamiento: " + tratamiento;
    }
}

