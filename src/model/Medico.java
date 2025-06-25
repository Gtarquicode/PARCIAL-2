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

// Interfaz para clases que pueden agendar consultas
interface Agendable {
    void agendarConsulta(Consulta consulta);
}

// Clase Medico que hereda de Persona y puede agendar
public class Medico extends Persona implements Agendable {
    private String especialidad;
    private List<Consulta> consultas; // Consultas asociadas al médico

    public Medico(String nombre, String id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
        this.consultas = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // Implementación del método de Agendable
    @Override
    public void agendarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public String getInfo() {
        return "Médico: " + nombre + " (ID: " + id + ", Especialidad: " + especialidad + ")";
    }
}
